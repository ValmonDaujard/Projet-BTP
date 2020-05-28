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

import btp.model.MaitreOeuvre;
import btp.model.Views;
import btp.persistence.IMaitreOeuvreRepository;

@RestController
@RequestMapping("/maitreOeuvre")
public class MaitreOeuvreRestController {
	
	@Autowired
	private IMaitreOeuvreRepository maitreOeuvreRepo;
	
	@GetMapping("")
	@JsonView(Views.ViewMaitreOeuvre.class)
	public List<MaitreOeuvre> findAll() {
		return maitreOeuvreRepo.findAll();
	}
	
	@GetMapping("/par-projet/{id}")
	@JsonView(Views.ViewMaitreOeuvre.class)
	public List<MaitreOeuvre> findByProjet(@PathVariable Long id){
		return maitreOeuvreRepo.findByProjet(id);
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewMaitreOeuvre.class)
	public MaitreOeuvre find(@PathVariable Long id) {

		Optional<MaitreOeuvre> optMaitreOeuvre = maitreOeuvreRepo.findById(id);

		if (optMaitreOeuvre.isPresent()) {
			return optMaitreOeuvre.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@PostMapping("")
	@JsonView(Views.ViewMaitreOeuvre.class)
	public MaitreOeuvre create(@RequestBody MaitreOeuvre maitreOeuvre) {
		maitreOeuvre = maitreOeuvreRepo.save(maitreOeuvre);

		return maitreOeuvre;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewMaitreOeuvre.class)
	public MaitreOeuvre update(@RequestBody MaitreOeuvre maitreOeuvre, @PathVariable Long id) {
		if (!maitreOeuvreRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		maitreOeuvre = maitreOeuvreRepo.save(maitreOeuvre);

		return maitreOeuvre;
	}
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable Long id) {
		maitreOeuvreRepo.deleteById(id);
	}
}
