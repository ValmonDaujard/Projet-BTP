package btp.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import btp.model.MaitreOuvrage;

public interface IMaitreOuvrageRepository extends JpaRepository<MaitreOuvrage, Long>{

	//affichage du maitre d'ouvrage par projet
			@Query("select mo from MaitreOuvrage mo join mo.offres ofs where ofs.projet.id = :id")
			List<MaitreOuvrage> findByProjet(@Param("id") Long id);
}
