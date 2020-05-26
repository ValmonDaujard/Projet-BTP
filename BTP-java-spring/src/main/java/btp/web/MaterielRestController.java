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
import btp.model.Materiel;
import btp.model.Views;
import btp.persistence.IMaterielRepository;


@RestController
@RequestMapping("/materiel")
public class MaterielRestController {
	
	@Autowired
	private IMaterielRepository materielRepo;
	
	@GetMapping("")
	@JsonView(Views.ViewMateriel.class)
	public List<Materiel> findAll() {
		return materielRepo.findAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewMateriel.class)
	public Materiel find(@PathVariable Long id) {

		Optional<Materiel> optMateriel = materielRepo.findById(id);

		if (optMateriel.isPresent()) {
			return optMateriel.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@PostMapping("")
	public Materiel create(@RequestBody Materiel materiel) {
		materiel = materielRepo.save(materiel);

		return materiel;
	}

	@PutMapping("/{id}")
	public Materiel update(@RequestBody Materiel materiel, @PathVariable Long id) {
		if (!materielRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		materiel = materielRepo.save(materiel);

		return materiel;
	}
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable Long id) {
		materielRepo.deleteById(id);
	}


}

