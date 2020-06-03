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

import btp.model.Action;
import btp.model.Facture;
import btp.model.Views;
import btp.persistence.IFactureRepository;

@RestController
@RequestMapping("/facture")
@CrossOrigin("*")
public class FactureRestController {

	@Autowired
	private IFactureRepository factureRepo;
	
	@GetMapping("")
	@JsonView(Views.ViewFacture.class)
	public List<Facture> findAll() {
		return factureRepo.findAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewFacture.class)
	public Facture find(@PathVariable Long id) {

		Optional<Facture> optFacture =factureRepo.findById(id);

		if (optFacture.isPresent()) {
			return optFacture.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@GetMapping("/par-projet/{id}")
	@JsonView(Views.ViewFacture.class)
	public List<Facture> findAllByFacture(@PathVariable Long id){
		return factureRepo.findAllByProjet(id);
	}
	
	@GetMapping("/by-projet-and-payee/{id}:{payee}:{nomPresta}")
	@JsonView(Views.ViewFacture.class)
	public List<Facture> findAllByProjetAndPayee(@PathVariable Long id, @PathVariable Boolean payee, @PathVariable("nomPresta") String nom){
		return factureRepo.findAllByProjetAndPayee(id, payee, nom);
	}
	
	@PostMapping("")
	public Facture create(@RequestBody Facture facture) {
		facture = factureRepo.save(facture);

		return facture;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewFacture.class)
	public Facture update(@RequestBody Facture facture, @PathVariable Long id) {
		if (!factureRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		facture = factureRepo.save(facture);

		return facture;
	}
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable Long id) {
		factureRepo.deleteById(id);
	}
}
