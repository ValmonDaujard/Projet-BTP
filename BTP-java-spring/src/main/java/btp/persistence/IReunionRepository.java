package btp.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import btp.model.Reunion;

public interface IReunionRepository extends JpaRepository<Reunion, Long>{
	
	//Affichage des reunions effectuées par projet
	@Query("select r from Reunion r where r.dtReunion < current_date and r.projet.id = :id")
	List<Reunion> findAllEffectueeByProjet(@Param("id") Long id);
	
	//Affichage des reunions  planifiées par projet
	@Query("select r from Reunion r where r.dtReunion > current_date and r.projet.id = :id")
	List<Reunion> findAllPlanifieeByProjet(@Param("id") Long id);
	
}
