package cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n02.model.services;

import cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n02.model.domain.Flower;
import cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n02.model.dto.FlowerDto;
import cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n02.model.repository.FlowerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlowerServiceImpl implements IFlowerService{

    @Autowired
    FlowerRepository repository;


    @Override
    public Flower createFlower(FlowerDto flowerDto) {
       Flower flower = dtoToEntity(flowerDto);
       return repository.save(flower);

    }


    @Override
    public Flower updateFlower(long id, Flower flower) {
        Optional<Flower> flowerData = repository.findById(id);

        if(flowerData.isPresent()) {
            Flower myFlower = flowerData.get  ();
            myFlower.setName(flower.getName());
            myFlower.setCountry(flower.getCountry());

            return repository.save(myFlower);
        } else {
            return null;
        }
    }


    @Override
    public void deleteFlower(long id) {
        repository.deleteById(id);
    }

    @Override
    public FlowerDto getFlowerById(long id) {
        Optional<Flower> flowerData = repository.findById(id);
        FlowerDto flowerDto;

        if(flowerData.isPresent()) {
            Flower flower = flowerData.get();
            flowerDto = entityToDto(flower);
        } else {
            flowerDto = null;
        }

        return flowerDto;
    }


    @Override
    public List<FlowerDto> getAllFlowers() {

    return repository.findAll().stream().map(this::entityToDto).collect(Collectors.toList());
    }


   /* public Flower dtoToEntity(FlowerDto flowerDto){
        return modelMapper.map(flowerDto, Flower.class);
    }

    public FlowerDto entityToDto(Flower flower) {
        FlowerDto flowerDto = modelMapper.map(flower, FlowerDto.class);
        flowerDto.setFlowerOrigin(flowerDto.checkCountry());
        return flowerDto;
    }
    */

    public Flower dtoToEntity (FlowerDto flowerDto){
        Flower flower = new Flower();
        flower.setId(flowerDto.getId());
        flower.setName(flowerDto.getName());
        flower.setCountry(flowerDto.getCountry());

        return flower;
    }

    public FlowerDto entityToDto(Flower flower){

        FlowerDto flowerDto = new FlowerDto();
        flowerDto.setId(flower.getId());
        flowerDto.setName(flower.getName());
        flowerDto.setCountry(flower.getCountry());
        flowerDto.setFlowerOrigin(flowerDto.checkCountry());

        return flowerDto;
    }
}
