package cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n02.model.services;

import cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n02.model.domain.Flower;
import cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n02.model.dto.FlowerDto;

import java.util.List;

public interface IFlowerService {

    public Flower createFlower(FlowerDto flowerDto);
    public Flower updateFlower(long id, Flower flower);
    public void deleteFlower(long id);
    public FlowerDto getFlowerById(long id);
    public List<FlowerDto> getAllFlowers();
    public Flower dtoToEntity (FlowerDto flowerDto);
    public FlowerDto entityToDto(Flower flower);



}





