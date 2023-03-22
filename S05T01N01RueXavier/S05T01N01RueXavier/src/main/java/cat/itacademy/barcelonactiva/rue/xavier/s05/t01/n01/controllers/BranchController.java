package cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.controllers;

import cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.model.domain.Branch;
import cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.model.dto.BranchDTO;
import cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.model.services.IBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    private IBranchService branchService;

    // *** Display forms ***

    @GetMapping("/create")
    public String displayBranchCreationForm (Model model){
        BranchDTO branchDTO = new BranchDTO();
        model.addAttribute("branch", branchDTO); //We are passing an object branch, to assign the attributes.
        return "/create_branch";
    }

    @GetMapping("/update/{id}")
    public String displayBranchUpdateForm (@PathVariable Long id, Model model) {
        model.addAttribute("branch", branchService.getBranchById(id));
        return "/update_branch";

    }

    // *** Branch creation ***

    @PostMapping("/add")
    public String createBranch (@ModelAttribute("branchDto") BranchDTO branchDTO){
        branchService.addBranch(branchDTO);
        return "redirect:/branch/getAll";

    }

    // *** Branch update ***

    @PostMapping("/{id}")
    public String updateBranch(@PathVariable Long id, @ModelAttribute("branch") Branch branch) {
        Branch myBranch = branchService.updateBranch(id, branch);
        return "redirect:/branch/getAll";
    }

    // *** Display branch ***

    @GetMapping("/getAll")
    public String getAllBranches(Model model){
        model.addAttribute("branches", branchService.getAllBranches());
        return "/branchesView";  //  Returns html file branchesView.html located templates folder.

    }

    // *** Branch delete ***

    @GetMapping("/delete/{id}")
    public String deleteBranch(@PathVariable Long id) {
        branchService.deleteBranch(id);
        return "redirect:/branch/getAll";
    }













}
