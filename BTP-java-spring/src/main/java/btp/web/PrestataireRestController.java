package btp.web;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import btp.model.Prestataire;
import btp.model.Utilisateur;
import btp.persistence.IPrestataireRepository;
import btp.persistence.IUtilisateurRepository;
import btp.model.Views;

@RestController
@RequestMapping("/prestataire")
@CrossOrigin("*")
public class PrestataireRestController {

	@Autowired
	private IPrestataireRepository prestataireRepo;
	
	@Autowired
	private IUtilisateurRepository utilisateurRepo;

	@GetMapping("")
	@JsonView(Views.ViewPrestataire.class)
	public List<Prestataire> findAll() {
		return prestataireRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewPrestataire.class)
	public Prestataire find(@PathVariable Long id) {

		Optional<Prestataire> optPrestataire = prestataireRepo.findById(id);

		if (optPrestataire.isPresent()) {
			return optPrestataire.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@PostMapping("")
	public Prestataire create(@RequestBody Prestataire prestataire) {
		Utilisateur utilisateur = utilisateurRepo.save(prestataire.getUtilisateur());
		
		prestataire.setUtilisateur(utilisateur);
		
		prestataire = prestataireRepo.save(prestataire);

		return prestataire;
	}
	
	@PutMapping("/{id}")
	public Prestataire update(@RequestBody Prestataire prestataire, @PathVariable Long id) {
		if (!prestataireRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		prestataire = prestataireRepo.save(prestataire);

		return prestataire;
	}
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable Long id) {
		prestataireRepo.deleteById(id);
	}
}
