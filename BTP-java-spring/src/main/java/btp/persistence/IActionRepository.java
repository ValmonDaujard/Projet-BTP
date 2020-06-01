package btp.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import btp.model.Action;

public interface IActionRepository extends JpaRepository<Action, Long> {

	// affichage des actions par projet et par etat
	@Query("select a from Action a where a.projet.id = :id and a.effectuee = :effectuee")
	List<Action> findAllByProjetAndEffectuee(@Param("id") Long id, @Param("effectuee") Boolean effectuee);

	// affichage des actions par projet et par etat par EG
	@Query("select a from Action a where a.projet.id = :id and a.effectuee = :effectuee and a.prestataire.id = :idPresta")
	List<Action> findAllByProjetByEGAndEffectuee(@Param("id") Long id, @Param("effectuee") Boolean effectuee, @Param("idPresta") Long idPresta);
	
	// Action par projet
		@Query("select a from Action a where a.projet.id = :id")
		List<Action> findAllByProjet(@Param("id") Long id);

}
