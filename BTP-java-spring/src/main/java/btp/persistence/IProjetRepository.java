package btp.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import btp.model.Projet;

public interface IProjetRepository extends JpaRepository<Projet, Long>{

	//Page accueil Maitre Ouvrage liste deroulante projets en cours
	@Query("select p from Projet p where p.offre.maitreOuvrage.id= :id and p.dtFin > current_date")
	List <Projet> findAllByMaitreOuvrage(@Param("id") Long id);
	
	//Page accueil Maitre Ouvrage liste deroulante projets en cours
	@Query("select p from Projet p where p.offre.maitreOeuvre.id= :id and p.dtFin > current_date")
	List <Projet> findAllByMaitreOeuvre(@Param("id") Long id);
	
	//Page accueil EG liste deroulante projets en cours
	@Query("select distinct p from Projet p join p.prestations presta join presta.prestataire pres where pres.id= :id and p.dtFin > current_date")
	List <Projet> findAllByPrestataire(@Param("id") Long id);
	
	
		
	
	
	
}

