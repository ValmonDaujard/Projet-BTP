package btp.web;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import btp.model.Societe;
import btp.model.Utilisateur;
import btp.model.Views;
import btp.persistence.ISocieteRepository;
import btp.persistence.IUtilisateurRepository;
import btp.web.dto.UserForm;

@RestController
@RequestMapping("/utilisateur")
@CrossOrigin("*")
public class UtilisateurRestController {

	@Autowired
	private IUtilisateurRepository utilisateurRepo;
	
	@Autowired
	private ISocieteRepository societeRepo;

	@GetMapping("")
	@JsonView(Views.ViewUtilisateur.class)
	public List<Utilisateur> findAll() {
		return utilisateurRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewUtilisateur.class)
	public Utilisateur find(@PathVariable Long id) {

		Optional<Utilisateur> optUtilisateur = utilisateurRepo.findById(id);

		if (optUtilisateur.isPresent()) {
			return optUtilisateur.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@GetMapping("/by-identifiant-and-mot-de-passe/{identifiant}:{motDePasse}")
	@JsonView(Views.ViewUtilisateur.class)
	public Utilisateur findByIdentifiantAndMotDePasse(@PathVariable String identifiant, @PathVariable String motDePasse){
		return utilisateurRepo.findByIdentifiantAndMotDePasse(identifiant, motDePasse);
	}
	
	@GetMapping("/by-identifiant/{identifiant}")
	@JsonView(Views.ViewUtilisateur.class)
	public Utilisateur findByIdentifiant(@PathVariable String identifiant){
		return utilisateurRepo.findByIdentifiant(identifiant);
	}
	
	@PostMapping("")
	@JsonView(Views.ViewUtilisateur.class)
	public Utilisateur create(@RequestBody Utilisateur utilisateur) {
		utilisateur = utilisateurRepo.save(utilisateur);

		return utilisateur;
	}
	
	@PostMapping("/authentification")
	@JsonView(Views.ViewUtilisateur.class)
	public Utilisateur create(@RequestBody UserForm user) {
		return utilisateurRepo.findByIdentifiantAndMotDePasse(user.getIdentifiant(), user.getMotDePasse());

	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewUtilisateur.class)
	public Utilisateur update(@RequestBody Utilisateur utilisateur, @PathVariable Long id) {
		if (!utilisateurRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		Societe societe = utilisateur.getSociete();
		societe.setUtilisateur(utilisateur);
		
		societeRepo.save(societe);
		
		utilisateur.setSociete(null);
		
		utilisateur = utilisateurRepo.save(utilisateur);
		
		utilisateur.setSociete(societe);

		return utilisateur;
	}
}
