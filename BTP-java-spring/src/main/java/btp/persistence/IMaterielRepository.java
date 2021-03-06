package btp.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import btp.model.Materiel;

public interface IMaterielRepository extends JpaRepository<Materiel, Long>{

	// Matériel par entreprise
	@Query("select m from Materiel m where m.prestataire.id = :id")
	List<Materiel> findMaterielByEntreprise(@Param("id") Long id);
	
	
}

