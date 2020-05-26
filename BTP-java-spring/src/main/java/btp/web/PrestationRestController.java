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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import btp.model.Prestation;
import btp.persistence.IPrestationRepository;
import btp.model.Views;

@RestController
public class PrestationRestController {

	@Autowired
	private IPrestationRepository prestationRepo;

	@GetMapping("/prestation")
	@JsonView(Views.ViewPrestation.class)
	public List<Prestation> findAll() {
		return prestationRepo.findAll();
	}

	@GetMapping("/prestation/{id}")
	@JsonView(Views.ViewPrestation.class)
	public Prestation find(@PathVariable Long id) {

		Optional<Prestation> optPrestation = prestationRepo.findById(id);

		if (optPrestation.isPresent()) {
			return optPrestation.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@PostMapping("/prestation")
	public Prestation create(@RequestBody Prestation prestation) {
		prestation = prestationRepo.save(prestation);

		return prestation;
	}
	
	@PutMapping("/prestation/{id}")
	public Prestation update(@RequestBody Prestation prestation, @PathVariable Long id) {
		if (!prestationRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		prestation = prestationRepo.save(prestation);

		return prestation;
	}

// 	@Patch
//	{}
	
	@DeleteMapping("/prestation/{id}")
	public void delete (@PathVariable Long id) {
		prestationRepo.deleteById(id);
	}
}


