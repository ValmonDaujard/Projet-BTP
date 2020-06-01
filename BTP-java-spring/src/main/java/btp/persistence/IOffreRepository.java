package btp.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import btp.model.Offre;

public interface IOffreRepository extends JpaRepository<Offre, Long> {

	//Liste des appels offre en consultation pour le maitre oeuvre 
	@Query("select o from Offre o where o.etat = 'consult' and o.maitreOeuvre.id = :id")
	List<Offre> findAllByMaitreOeuvreEnConsult(@Param("id") Long id);

	//Liste des appels offre en consultation pour le maitre oeuvre 
	@Query("select o from Offre o where o.etat = 'consult' and o.maitreOuvrage.id = :id")
	List<Offre> findAllByMaitreOuvrageEnConsult(@Param("id") Long id);
}
