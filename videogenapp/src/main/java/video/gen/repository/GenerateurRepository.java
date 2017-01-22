package video.gen.repository;

import video.gen.domain.Generateur;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Generateur entity.
 */
@SuppressWarnings("unused")
public interface GenerateurRepository extends JpaRepository<Generateur,Long> {

}
