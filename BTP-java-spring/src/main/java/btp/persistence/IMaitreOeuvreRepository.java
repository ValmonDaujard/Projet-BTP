package btp.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import btp.model.MaitreOeuvre;

public interface IMaitreOeuvreRepository extends JpaRepository<MaitreOeuvre, Long>{

	//affichage du maitre d'oeuvre par projet
		@Query("select moe from MaitreOeuvre moe join moe.offres off where off.projet.id = :id")
		List<MaitreOeuvre> findByProjet(@Param("id") Long id);
	
}
