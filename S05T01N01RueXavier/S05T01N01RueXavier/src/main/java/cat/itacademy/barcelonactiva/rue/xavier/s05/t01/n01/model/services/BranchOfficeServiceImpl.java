package cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.model.domain.BranchOffice;
import cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.model.dto.BranchOfficeDTO;
import cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.model.repository.BranchOfficeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BranchOfficeServiceImpl implements IBranchOfficeService{

    @Autowired
    BranchOfficeRepository repository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<BranchOffice> getAllBranches() {
        return repository.findAll();
    }

    @Override
    public BranchOffice getBranchById(long id) {
        Optional<BranchOffice> branchData = repository.findById(id);

        if(branchData.isPresent()) {
            return repository.findById(id).get();
        }
        return null;

    }

    @Override
    public void deleteBranch(long id) {
        Optional<BranchOffice> branchData = repository.findById(id);

        if(branchData.isPresent()) {
            repository.deleteById(id);
        }

    }

    @Override
    public BranchOffice updateBranch(long id, BranchOffice branchOffice) {
        Optional<BranchOffice> branchData = repository.findById(id);

        if(branchData.isPresent()) {
            BranchOffice myBranch = branchData.get();
            myBranch.setCountry(branchOffice.getCountry());
            myBranch.setName(branchOffice.getName());

            return repository.save(myBranch);
        } else {
            return null;
        }
    }

    @Override
    public BranchOfficeDTO addBranch(BranchOfficeDTO branchDto) {
        BranchOffice branch1 = new BranchOffice();
        BranchOffice branch2 = new BranchOffice();
        BranchOfficeDTO branchDtoOut = new BranchOfficeDTO();

        // From Dto to entity
        branch1 = modelMapper.map(branchDto, BranchOffice.class);

        // Save to db
        branch2 = repository.save(branch1);

        // Transform from entity to Dto
        branchDtoOut = modelMapper.map(branch2, BranchOfficeDTO.class);

        return branchDtoOut;
    }

}
