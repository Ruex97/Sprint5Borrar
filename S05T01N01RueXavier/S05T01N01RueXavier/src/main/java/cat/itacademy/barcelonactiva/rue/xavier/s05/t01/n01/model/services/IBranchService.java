package cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.model.domain.Branch;
import cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.model.dto.BranchDTO;

import java.util.List;

public interface IBranchService {

    public List<BranchDTO> getAllBranches();
    public BranchDTO getBranchById(long id);

    public void deleteBranch(long id);
    public Branch updateBranch(long id, Branch branch);
    public Branch addBranch (BranchDTO branchOffice);


}
