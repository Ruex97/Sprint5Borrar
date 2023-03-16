package cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.controllers;

import cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.model.domain.BranchOffice;
import cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.model.dto.BranchOfficeDTO;
import cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.model.services.IBranchOfficeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/branchoffice")
public class BranchOfficeController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    IBranchOfficeService branchService;

    @GetMapping("/getAll")
    public ResponseEntity<List<cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.model.dto.BranchOfficeDTO>> getAllBranches(){

        List<cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.model.dto.BranchOfficeDTO> branches = branchService.getAllBranches().stream().map(post -> modelMapper.map(post, cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.model.dto.BranchOfficeDTO.class))
                .collect(Collectors.toList());

        return new ResponseEntity<List<cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.model.dto.BranchOfficeDTO>>(branches, HttpStatus.OK);

    }


  /*  @PostMapping("/add")
    public ResponseEntity<BranchOfficeDTO> createBranch(@RequestBody branchOfficeDTO) {

        // convert DTO to entity
        BranchOffice myBranch = modelMapper.map(branchOfficeDTO, BranchOffice.class);

       //  BranchOffice branch = branchService.addBranch(myBranch);

        // convert entity to DTO
        branchResponse = modelMapper.map(branch,BranchOfficeDTO.class);

        return new ResponseEntity<BranchOfficeDTO>(branchResponse, HttpStatus.CREATED);
    } */

    @PostMapping("/add")
    public ResponseEntity<BranchOfficeDTO> createBranch (@ModelAttribute BranchOfficeDTO branchOfficeDTO){
        BranchOfficeDTO branchResponse = branchService.addBranch(branchOfficeDTO);

        // OUT
        System.out.println("Sucursal saved!");
        return new ResponseEntity<BranchOfficeDTO>(branchResponse, HttpStatus.CREATED);

    }


}
