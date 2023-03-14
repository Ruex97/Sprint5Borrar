package cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.model.domain.BranchOffice;
import cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.model.repository.BranchOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BranchOfficeServiceImp implements IBranchOfficeService{

    @Autowired
    BranchOfficeRepository repository;



    @Override
    public List<BranchOffice> getAllBranches() {
        return repository.findAll();
    }
}
