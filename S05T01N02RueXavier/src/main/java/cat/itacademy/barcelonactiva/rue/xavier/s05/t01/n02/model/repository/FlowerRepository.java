package cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n02.model.repository;

import cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n02.model.domain.Flower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlowerRepository extends JpaRepository<Flower, Long> {

}
