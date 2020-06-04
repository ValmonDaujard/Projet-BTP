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

import btp.model.Projet;
import btp.persistence.IProjetRepository;
import btp.model.Views;

@RestController
@RequestMapping("/projet")
@CrossOrigin("*")
public class ProjetRestController {

	@Autowired
	private IProjetRepository projetRepo;

	@GetMapping("")
	@JsonView(Views.ViewProjet.class)
	public List<Projet> findAll() {
		return projetRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewProjet.class)
	public Projet find(@PathVariable Long id) {

		Optional<Projet> optProjet = projetRepo.findById(id);

		if (optProjet.isPresent()) {
			return optProjet.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@GetMapping("/by-maitre-ouvrage/{id}")
	@JsonView(Views.ViewProjet.class)
	public List<Projet> findAllByMaitreOuvrage(@PathVariable Long id) {
		return projetRepo.findAllByMaitreOuvrage(id);
	}
	
	@GetMapping("/by-maitre-oeuvre/{id}")
	@JsonView(Views.ViewProjet.class)
	public List<Projet> findAllByMaitreOeuvre(@PathVariable Long id){
		return projetRepo.findAllByMaitreOeuvre(id);
	}
	@GetMapping("/by-prestataire/{id}")
	@JsonView(Views.ViewProjet.class)
	public List<Projet> findAllByPrestataire(@PathVariable Long id){
		return projetRepo.findAllByPrestataire(id);
	}
	
	@GetMapping("/by-offre/{id}")
	@JsonView(Views.ViewProjet.class)
	public Projet findProjetByOffreId(@PathVariable Long id){
		return projetRepo.findProjetByOffreId(id);
	}
	
	@PostMapping("")
	public Projet create(@RequestBody Projet projet) {
		projet = projetRepo.save(projet);

		return projet;
	}
	
	@PutMapping("/{id}")
	public Projet update(@RequestBody Projet projet, @PathVariable Long id) {
		if (!projetRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		projet = projetRepo.save(projet);

		return projet;
	}

	@DeleteMapping("/{id}")
	public void delete (@PathVariable Long id) {
		projetRepo.deleteById(id);
	}
}

