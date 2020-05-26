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

import btp.model.Salarie;
import btp.persistence.ISalarieRepository;
import btp.model.Views;

@RestController
public class SalarieRestController {

	@Autowired
	private ISalarieRepository salarieRepo;

	@GetMapping("/salarie")
	@JsonView(Views.ViewSalarie.class)
	public List<Salarie> findAll() {
		return salarieRepo.findAll();
	}

	@GetMapping("/salarie/{id}")
	@JsonView(Views.ViewSalarie.class)
	public Salarie find(@PathVariable Long id) {

		Optional<Salarie> optSalarie = salarieRepo.findById(id);

		if (optSalarie.isPresent()) {
			return optSalarie.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@PostMapping("/salarie")
	public Salarie create(@RequestBody Salarie salarie) {
		salarie = salarieRepo.save(salarie);

		return salarie;
	}
	
	@PutMapping("/salarie/{id}")
	public Salarie update(@RequestBody Salarie salarie, @PathVariable Long id) {
		if (!salarieRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		salarie = salarieRepo.save(salarie);

		return salarie;
	}

// 	@Patch
//	{}
	
	@DeleteMapping("/salarie/{id}")
	public void delete (@PathVariable Long id) {
		salarieRepo.deleteById(id);
	}
}
