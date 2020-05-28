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

import btp.model.Salarie;
import btp.persistence.ISalarieRepository;
import btp.model.Views;

@RestController
@RequestMapping("/salarie")
@CrossOrigin("*")
public class SalarieRestController {

	@Autowired
	private ISalarieRepository salarieRepo;

	@GetMapping("")
	@JsonView(Views.ViewSalarie.class)
	public List<Salarie> findAll() {
		return salarieRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewSalarie.class)
	public Salarie find(@PathVariable Long id) {

		Optional<Salarie> optSalarie = salarieRepo.findById(id);

		if (optSalarie.isPresent()) {
			return optSalarie.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@GetMapping("/by-entreprise/{nom}")
	@JsonView(Views.ViewSalarie.class)
	public List<Salarie> findByEntreprise(@PathVariable String nom){
		return salarieRepo.findByEntreprise(nom);
	}
	
	@GetMapping("/by-prestation/{id}")
	@JsonView(Views.ViewSalarie.class)
	public List<Salarie> findByPrestation(@PathVariable Long id){
		return salarieRepo.findByPrestation(id);
	}
	
	@GetMapping("/by-action/{id}")
	@JsonView(Views.ViewSalarie.class)
	public List<Salarie> findByAction(@PathVariable Long id){
		return salarieRepo.findByPrestation(id);
	}
	
	@PostMapping("")
	public Salarie create(@RequestBody Salarie salarie) {
		salarie = salarieRepo.save(salarie);

		return salarie;
	}
	
	@PutMapping("/{id}")
	public Salarie update(@RequestBody Salarie salarie, @PathVariable Long id) {
		if (!salarieRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		salarie = salarieRepo.save(salarie);

		return salarie;
	}

	@DeleteMapping("/{id}")
	public void delete (@PathVariable Long id) {
		salarieRepo.deleteById(id);
	}
}
