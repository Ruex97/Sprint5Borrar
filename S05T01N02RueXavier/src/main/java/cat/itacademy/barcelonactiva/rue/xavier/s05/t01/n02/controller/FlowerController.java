package cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n02.controller;

import cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n02.model.domain.Flower;
import cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n02.model.dto.FlowerDto;
import cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n02.model.services.IFlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flower")
public class FlowerController {

    @Autowired
    private IFlowerService flowerService;

    @PostMapping("/add")
    public ResponseEntity<FlowerDto> createFlower(@RequestBody FlowerDto flowerDto) {
        try {
            Flower myFlower = flowerService.createFlower(flowerDto);
            FlowerDto myFlowerDto = flowerService.entityToDto(myFlower);
            return new ResponseEntity<>(myFlowerDto, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<FlowerDto>> getAllFlowers() {
        try {
            List<FlowerDto> fruitList = flowerService.getAllFlowers();

            if (fruitList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(fruitList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<FlowerDto> updateFlower(@PathVariable("id") long id, @RequestBody Flower flower) {
        Flower myFlower = flowerService.updateFlower(id, flower);

        if (myFlower != null) {
            FlowerDto flowerDto = flowerService.entityToDto(myFlower);
            return new ResponseEntity<>(flowerDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteFlower(@PathVariable("id") long id) {
        try {
            flowerService.deleteFlower(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<FlowerDto> getFlowerById(@PathVariable("id") long id) {
        FlowerDto myFlower = flowerService.getFlowerById(id);

        if (myFlower != null) {
            return new ResponseEntity<>(myFlower, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}



/*


    @Autowired
    private IBranchService branchService;






    // *** Branch delete ***

    @GetMapping("/delete/{id}")
    public String deleteBranch(@PathVariable Long id) {
        branchService.deleteBranch(id);
        return "redirect:/branch/getAll";
    }













}
*/