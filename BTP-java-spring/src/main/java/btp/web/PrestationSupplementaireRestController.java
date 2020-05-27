package btp.web;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import btp.model.PrestationSupplementaire;
import btp.persistence.IPrestationSupplementaireRepository;
import btp.model.Views;

@RestController
@RequestMapping("/prestationSupplementaire")
public class PrestationSupplementaireRestController {

	@Autowired
	private IPrestationSupplementaireRepository prestationSupplementaireRepo;

	@GetMapping("")
	@JsonView(Views.ViewPrestationSupplementaire.class)
	public List<PrestationSupplementaire> findAll() {
		return prestationSupplementaireRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewPrestationSupplementaire.class)
	public PrestationSupplementaire find(@PathVariable Long id) {

		Optional<PrestationSupplementaire> optPrestationSupplementaire = prestationSupplementaireRepo.findById(id);

		if (optPrestationSupplementaire.isPresent()) {
			return optPrestationSupplementaire.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@PostMapping("")
	public PrestationSupplementaire create(@RequestBody PrestationSupplementaire prestationSupplementaire) {
		prestationSupplementaire = prestationSupplementaireRepo.save(prestationSupplementaire);

		return prestationSupplementaire;
	}
	
	@PutMapping("/{id}")
	public PrestationSupplementaire update(@RequestBody PrestationSupplementaire prestationSupplementaire, @PathVariable Long id) {
		if (!prestationSupplementaireRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		prestationSupplementaire = prestationSupplementaireRepo.save(prestationSupplementaire);

		return prestationSupplementaire;
	}
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable Long id) {
		prestationSupplementaireRepo.deleteById(id);
	}
}

