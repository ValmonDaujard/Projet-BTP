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

import btp.model.Offre;
import btp.model.Views;
import btp.persistence.IOffreRepository;

@RestController
@RequestMapping("/offre")
@CrossOrigin("*")
public class OffreRestController {

	@Autowired
	private IOffreRepository offreRepo;

	@GetMapping("")
	@JsonView(Views.ViewOffre.class)
	public List<Offre> findAll() {
		return offreRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewOffre.class)
	public Offre find(@PathVariable Long id) {

		Optional<Offre> optOffre = offreRepo.findById(id);

		if (optOffre.isPresent()) {
			return optOffre.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@GetMapping("/by-maitre-oeuvre-en-consult/{id}")
	@JsonView(Views.ViewOffre.class)
	public List<Offre> findAllByMaitreOeuvreEnConsult(@PathVariable Long id){
		return offreRepo.findAllByMaitreOeuvreEnConsult(id);
	}
	
	@PostMapping("")
	public Offre create(@RequestBody Offre offre) {
		offre = offreRepo.save(offre);

		return offre;
	}
	
	@PutMapping("/{id}")
	public Offre update(@RequestBody Offre offre, @PathVariable Long id) {
		if (!offreRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		offre = offreRepo.save(offre);

		return offre;
	}
	@DeleteMapping("/{id}")
	public void delete (@PathVariable Long id) {
		offreRepo.deleteById(id);
	}
}
