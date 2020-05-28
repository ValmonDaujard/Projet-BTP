package btp.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import btp.model.Salarie;

public interface ISalarieRepository extends JpaRepository<Salarie, Long> {

	// Salariés par entreprise
	@Query("select s from Salarie s where s.prestataire.id = :id")
	List<Salarie> findByEntreprise(@Param("id") String id);

	// Salariés sur une prestation (vue entreprise)
	@Query("select s from Salarie s join s.prestations presta where presta.id = :id")
	List<Salarie> findByPrestation(@Param("id") Long id);

	// Salariés sur une action (vue entreprise)
	@Query("select s from Salarie s join s.actions acts where acts.id = :id")
	List<Salarie> findByAction(@Param("id") Long id);

}
