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

import btp.model.AppelOffre;
import btp.model.Views;
import btp.persistence.IAppelOffreRepository;

@RestController
@RequestMapping("/appelOffre")
public class AppelOffreRestController {

	@Autowired
	private IAppelOffreRepository appelOffreRepo;
	
	@GetMapping("")
	@JsonView(Views.ViewAppelOffre.class)
	public List<AppelOffre> findAll() {
		return appelOffreRepo.findAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewAppelOffre.class)
	public AppelOffre find(@PathVariable Long id) {

		Optional<AppelOffre> optAppelOffre =appelOffreRepo.findById(id);

		if (optAppelOffre.isPresent()) {
			return optAppelOffre.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@PostMapping("")
	public AppelOffre create(@RequestBody AppelOffre appelOffre) {
		appelOffre = appelOffreRepo.save(appelOffre);

		return appelOffre;
	}

	@PutMapping("/{id}")
	public AppelOffre update(@RequestBody AppelOffre appelOffre, @PathVariable Long id) {
		if (!appelOffreRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		appelOffre = appelOffreRepo.save(appelOffre);

		return appelOffre;
	}
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable Long id) {
		appelOffreRepo.deleteById(id);
	}
}
