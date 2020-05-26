package btp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import btp.model.Utilisateur;

public interface IUtilisateurRepository extends JpaRepository<Utilisateur, Long>{

	// Page de connexion 
	Utilisateur findByIdentifiantAndMotDePasse(String identifiant, String motDePasse); //Connexion identifiant
	
}
