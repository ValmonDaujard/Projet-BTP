package btp.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import btp.model.Salarie;

public interface ISalarieRepository extends JpaRepository<Salarie, Long>{

	@Query("select s from Salarie s where s.prestataire.nom = :nom")
	List<Salarie> findByEntreprise(@Param("nom") String nom);
	
	@Query("select s from Salarie s join s.prestations presta where presta.offre.appelOffre.nom = :nom")
	List<Salarie> findByProjet(@Param("nom") String nom);
	
}
