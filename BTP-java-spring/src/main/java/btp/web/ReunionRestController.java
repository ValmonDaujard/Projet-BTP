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

import btp.model.Reunion;
import btp.model.Views;
import btp.persistence.IReunionRepository;

@RestController
@RequestMapping("/reunion")
@CrossOrigin("*")
public class ReunionRestController {

	@Autowired
	private IReunionRepository reunionRepo;

	@GetMapping("")
	@JsonView(Views.ViewReunion.class)
	public List<Reunion> findAll() {
		return reunionRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewReunion.class)
	public Reunion find(@PathVariable Long id) {

		Optional<Reunion> optReunion = reunionRepo.findById(id);

		if (optReunion.isPresent()) {
			return optReunion.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@GetMapping("/effectuee/{id}")
	@JsonView(Views.ViewReunion.class)
	public List<Reunion> findAllEffectuee(@PathVariable Long id){
		return reunionRepo.findAllEffectuee(id);
	}
	
	@GetMapping("/planifiee/{id}")
	@JsonView(Views.ViewReunion.class)
	public List<Reunion> findAllPlanifiee(@PathVariable Long id){
		return reunionRepo.findAllPlanifiee(id);
	}
	
	@PostMapping("")
	public Reunion create(@RequestBody Reunion reunion) {
		reunion = reunionRepo.save(reunion);

		return reunion;
	}
	
	@PutMapping("/{id}")
	public Reunion update(@RequestBody Reunion reunion, @PathVariable Long id) {
		if (!reunionRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		reunion = reunionRepo.save(reunion);

		return reunion;
	}
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable Long id) {
		reunionRepo.deleteById(id);
	}
}

