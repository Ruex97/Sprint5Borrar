package cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.controllers;

import cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.model.dto.BranchDTO;
import cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.model.services.IBranchOfficeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
//@RequestMapping("/branch")
public class BranchOfficeController {

    @Autowired
    IBranchOfficeService branchService;

    @GetMapping("/branches")
    public String getAllBranches(Model model){
        model.addAttribute("branches", branchService.getAllBranches());
        return "branches";  //  Returns html file branches.html located templates folder.

    }


    @PostMapping("/branches")
    public String createBranch (@ModelAttribute("branchDto") BranchDTO branchDTO){
        branchService.addBranch(branchDTO);
        return "redirect:/branches";

    }

    @GetMapping("/branches/new")
    public String displayBranchCreationForm (Model model){
        BranchDTO branchDTO = new BranchDTO();
        model.addAttribute("branch", branchDTO); //We are passing an object branch, to assign the attributes.
        return "create_branch";
    }


}
