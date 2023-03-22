package cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.model.domain.Branch;
import cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.model.dto.BranchDTO;
import cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.model.repository.BranchOfficeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BranchServiceImpl implements IBranchService {

    @Autowired
    BranchOfficeRepository repository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<BranchDTO> getAllBranches() {
        return repository.findAll().stream().map(x -> entityToDto2(x)).collect(Collectors.toList());
    }

    @Override
    public BranchDTO getBranchById(long id) {
        Optional<Branch> branchData = repository.findById(id);
        BranchDTO branchDTO;

        if(branchData.isPresent()) {
            Branch branch = branchData.get();
            branchDTO = entityToDto2(branch);
        } else {
            branchDTO = null;
        }

        return branchDTO;
    }

    @Override
    public void deleteBranch(long id) {
        repository.deleteById(id);
    }

    @Override
    public Branch updateBranch(long id, Branch branch) {

        Optional<Branch> branchData = repository.findById(id);

        if(branchData.isPresent()) {
            Branch myBranch = branchData.get();
            myBranch.setCountry(branch.getCountry());
            myBranch.setName(branch.getName());

            return repository.save(myBranch);
        } else {
            return null;
        }
    }


    @Override
    public Branch addBranch(BranchDTO branchDto) {
        Branch branch = dtoToEntity2(branchDto);
        return repository.save(branch);
    }

    public BranchDTO entityToDto(Branch branch){

        BranchDTO branchdto = new BranchDTO();
        branchdto.setId(branch.getId());
        branchdto.setName(branch.getName());
        branchdto.setCountry(branch.getCountry());
        branchdto.setTypeBranch(branchdto.checkCountry());

        return branchdto;
    }

    public BranchDTO entityToDto2(Branch branch) {
        BranchDTO myBranchDTO = modelMapper.map(branch, BranchDTO.class);
        myBranchDTO.setTypeBranch(myBranchDTO.checkCountry());
        return myBranchDTO;
    }

    public Branch dtoToEntity2(BranchDTO branchDTO){
        Branch myBranch = modelMapper.map(branchDTO, Branch.class);
        return myBranch;

    }


    public Branch dtoToEntity (BranchDTO branchdto){
        Branch branch = new Branch();
        branch.setId(branchdto.getId());
        branch.setName(branchdto.getName());
        branch.setCountry(branchdto.getCountry());

        return branch;
    }

}



