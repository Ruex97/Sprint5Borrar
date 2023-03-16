package cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.model.domain.BranchOffice;
import cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.model.dto.BranchOfficeDTO;

import java.util.List;

public interface IBranchOfficeService {

    public List<BranchOffice> getAllBranches();
    public BranchOffice getBranchById(long id);

    public void deleteBranch(long id);
    public BranchOffice updateBranch(long id, BranchOffice branchOffice);
    public BranchOfficeDTO addBranch (BranchOfficeDTO branchOffice);


}
