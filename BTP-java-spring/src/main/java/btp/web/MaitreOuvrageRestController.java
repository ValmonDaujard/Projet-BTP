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

import btp.model.MaitreOuvrage;
import btp.model.Utilisateur;
import btp.model.Views;
import btp.persistence.IMaitreOuvrageRepository;
import btp.persistence.IUtilisateurRepository;


@RestController
@RequestMapping("/maitreOuvrage")
@CrossOrigin("*")
public class MaitreOuvrageRestController {
	
	@Autowired
	private IMaitreOuvrageRepository maitreOuvrageRepo;
	
	@Autowired
	private IUtilisateurRepository utilisateurRepo;
	
	@GetMapping("")
	@JsonView(Views.ViewMaitreOuvrage.class)
	public List<MaitreOuvrage> findAll() {
		return maitreOuvrageRepo.findAll();
	}
	
	@GetMapping("/par-projet/{id}")
	@JsonView(Views.ViewMaitreOeuvre.class)
	public List<MaitreOuvrage> findByProjet(@PathVariable Long id){
		return maitreOuvrageRepo.findByProjet(id);
	}
	
	@GetMapping("/par-appel-offre/{id}")
	@JsonView(Views.ViewMaitreOuvrage.class)
	public MaitreOuvrage findbyAppelOffre(@PathVariable Long id) {

		Optional<MaitreOuvrage> optMaitreOuvrage = maitreOuvrageRepo.findByAppelOffre(id);

		if (optMaitreOuvrage.isPresent()) {
			return optMaitreOuvrage.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewMaitreOuvrage.class)
	public MaitreOuvrage find(@PathVariable Long id) {

		Optional<MaitreOuvrage> optMaitreOuvrage = maitreOuvrageRepo.findById(id);

		if (optMaitreOuvrage.isPresent()) {
			return optMaitreOuvrage.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@PostMapping("")
	public MaitreOuvrage create(@RequestBody MaitreOuvrage maitreOuvrage) {
		Utilisateur utilisateur = utilisateurRepo.save(maitreOuvrage.getUtilisateur());
		
		maitreOuvrage.setUtilisateur(utilisateur);
		maitreOuvrage = maitreOuvrageRepo.save(maitreOuvrage);

		return maitreOuvrage;
	}

	@PutMapping("/{id}")
	public MaitreOuvrage update(@RequestBody MaitreOuvrage maitreOuvrage, @PathVariable Long id) {
		if (!maitreOuvrageRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		maitreOuvrage = maitreOuvrageRepo.save(maitreOuvrage);

		return maitreOuvrage;
	}
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable Long id) {
		maitreOuvrageRepo.deleteById(id);
	}
}

