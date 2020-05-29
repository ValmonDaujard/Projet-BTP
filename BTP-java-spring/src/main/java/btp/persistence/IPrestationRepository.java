package btp.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import btp.model.PhasePresta;
import btp.model.Prestation;

public interface IPrestationRepository extends JpaRepository<Prestation, Long> {

	// Prestation par projet
	@Query("select p from Prestation p where p.projet.id = :id")
	List<Prestation> findAllByProjet(@Param("id") Long id);

	// Prestation en cours par projet
	@Query("select p from Prestation p where p.projet.id = :id AND p.dtDebut >= CURRENT_DATE  AND p.dtFin <= CURRENT_DATE")
	List<Prestation> findPrestationEnCoursParProjet(@Param("id") Long id);

	// Prestation effectuee par projet
	@Query("select p from Prestation p where p.projet.id = :id AND p.dtFin <= CURRENT_DATE")
	List<Prestation> findPrestationEffectuéeParProjet(@Param("id") Long id);

	// Prestation planifiee par projet
	@Query("select p from Prestation p where p.projet.id = :id AND p.dtDebut >= CURRENT_DATE AND p.phasePresta = ValideMOeuvre")
	List<Prestation> findPrestationPlanifiéeParProjet(@Param("id") Long id);

	// Prestation en cours par projet par EG
	@Query("select p from Prestation p where p.projet.id = :id AND p.prestataire.id = :idPresta AND p.dtDebut >= CURRENT_DATE  AND p.dtFin <= CURRENT_DATE")
	List<Prestation> findPrestationEnCoursParProjetParEG(@Param("id") Long id, @Param("idPresta") Long idPresta);

	// Prestation effectuee par projet par EG
	@Query("select p from Prestation p where p.projet.id = :id AND p.prestataire.id = :idPresta AND p.dtFin <= CURRENT_DATE")
	List<Prestation> findPrestationEffectuéeParProjetParEG(@Param("id") Long id, @Param("idPresta") Long idPresta);

	// Prestation planifiee par projet par EG
	@Query("select p from Prestation p where p.projet.id = :id AND p.prestataire.id = :idPresta AND p.dtDebut >= CURRENT_DATE")
	List<Prestation> findPrestationPlanifiéeParProjetParEG(@Param("id") Long id,  @Param("idPresta") Long idPresta);

	// Find Prestation by ETAT
	@Query("select p from Prestation p where p.phasePresta = :phase")
	List<Prestation> findPrestationByPhase(@Param("phase") PhasePresta phase);
	
	// Find Prestation by ETAT et par projet
	@Query("select p from Prestation p where p.phasePresta = :phase and p.projet.id = :id")
	List<Prestation> findPrestationByPhaseAndProjet(@Param("phase") PhasePresta phase, @Param("id") Long id);
	
	// Find Prestation by ETAT et par offre
	@Query("select p from Prestation p where p.phasePresta = :phase and p.offre.id = :idOffre")
	List<Prestation> findPrestationByPhaseAndOffre(@Param("phase") PhasePresta phase, @Param("idOffre") Long idOffre);
	
	// Find Prestation by ETAT et par projet et par EG
	@Query("select p from Prestation p where p.phasePresta = :phase and p.prestataire.id = :id")
	List<Prestation> findPrestationByPhaseByEG(@Param("phase") PhasePresta phase, @Param("id") Long id);

}
