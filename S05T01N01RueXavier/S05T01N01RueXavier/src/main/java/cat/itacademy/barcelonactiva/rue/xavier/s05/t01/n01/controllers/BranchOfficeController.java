package cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.controllers;

import cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.model.domain.BranchOffice;
import cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.model.services.IBranchOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/branchoffice")
public class BranchOfficeController {


    @Autowired
    IBranchOfficeService branchService;

    @GetMapping("/getAll")
    public ResponseEntity<List<BranchOffice>> listBranches(){

        List<BranchOffice> branches = branchService.getAllBranches();
        return new ResponseEntity<List<BranchOffice>>(branches, HttpStatus.OK);

    }
}
