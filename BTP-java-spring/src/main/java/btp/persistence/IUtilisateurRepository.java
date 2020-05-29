package btp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import btp.model.Utilisateur;

public interface IUtilisateurRepository extends JpaRepository<Utilisateur, Long>{

	// Page de connexion 
	@Query("select u from Utilisateur u where u.identifiant = :identifiant and u.motDePasse = :motDePasse")
	Utilisateur findByIdentifiantAndMotDePasse(@Param("identifiant") String identifiant, @Param("motDePasse") String motDePasse); //Connexion identifiant
	
}
