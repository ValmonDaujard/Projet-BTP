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

import btp.model.Action;
import btp.model.Views;
import btp.persistence.IActionRepository;

@RestController
@RequestMapping("/action")
public class ActionRestController {
	
	@Autowired
	private IActionRepository actionRepo;
	
	@GetMapping("")
	@JsonView(Views.ViewAction.class)
	public List<Action> findAll() {
		return actionRepo.findAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewAction.class)
	public Action find(@PathVariable Long id) {

		Optional<Action> optAction =actionRepo.findById(id);

		if (optAction.isPresent()) {
			return optAction.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@GetMapping("/by-project-and-effectuee/{nom}:{effectuee}")
	@JsonView(Views.ViewAction.class)
	public List<Action> findAllByProjetAndEffectuee(@PathVariable String nom, @PathVariable Boolean effectuee) {
		return actionRepo.findAllByProjetAndEffectuee(nom, effectuee);
	}
	
	@PostMapping("")
	public Action create(@RequestBody Action action) {
		action = actionRepo.save(action);

		return action;
	}

	@PutMapping("/{id}")
	public Action update(@RequestBody Action action, @PathVariable Long id) {
		if (!actionRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		action = actionRepo.save(action);

		return action;
	}
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable Long id) {
		actionRepo.deleteById(id);
	}
}
