package fr.istic.app.repository;

import fr.istic.app.domain.Generate;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Generate entity.
 */
@SuppressWarnings("unused")
public interface GenerateRepository extends JpaRepository<Generate,Long> {

}
