package cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.model.repository;

import cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.model.domain.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchOfficeRepository extends JpaRepository<Branch, Long> {

}
