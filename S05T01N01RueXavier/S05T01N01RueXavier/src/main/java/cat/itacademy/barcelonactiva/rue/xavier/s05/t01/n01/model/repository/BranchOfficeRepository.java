package cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.model.repository;

import cat.itacademy.barcelonactiva.rue.xavier.s05.t01.n01.model.domain.BranchOffice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BranchOfficeRepository extends JpaRepository<BranchOffice, Long> {

    Optional<BranchOffice> findByNombreTorre(String branchName);
}
