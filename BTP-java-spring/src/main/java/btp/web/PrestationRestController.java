package btp.web;

import java.util.ArrayList;
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

import btp.model.PhasePresta;
import btp.model.Prestation;
import btp.persistence.IPrestationRepository;
import btp.model.Views;

@RestController
@RequestMapping("/prestation")
@CrossOrigin("*")
public class PrestationRestController {

	@Autowired
	private IPrestationRepository prestationRepo;

	@GetMapping("")
	@JsonView(Views.ViewPrestation.class)
	public List<Prestation> findAll() {
		return prestationRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewPrestation.class)
	public Prestation find(@PathVariable Long id) {

		Optional<Prestation> optPrestation = prestationRepo.findById(id);

		if (optPrestation.isPresent()) {
			return optPrestation.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

	@GetMapping("/par-projet/{id}")
	@JsonView(Views.ViewPrestation.class)
	public List<Prestation> findAllByProjet(@PathVariable Long id) {
		return prestationRepo.findAllByProjet(id);
	}

	@GetMapping("/en-cours-par-projet/{id}")
	@JsonView(Views.ViewPrestation.class)
	public List<Prestation> findPrestationEnCoursParProjet(@PathVariable Long id) {
		return prestationRepo.findPrestationEnCoursParProjet(id);
	}

	@GetMapping("/effectuee-par-projet/{id}")
	@JsonView(Views.ViewPrestation.class)
	public List<Prestation> findPrestationEffectuéeParProjet(@PathVariable Long id) {
		return prestationRepo.findPrestationEffectuéeParProjet(id);
	}

	@GetMapping("/planifiee-par-projet/{id}")
	@JsonView(Views.ViewPrestation.class)
	public List<Prestation> findPrestationPlanifiéeParProjet(@PathVariable Long id) {
		return prestationRepo.findPrestationPlanifiéeParProjet(id);
	}

	@GetMapping("/en-cours-par-projet-par-EG/{id}:{idPresta}")
	@JsonView(Views.ViewPrestation.class)
	public List<Prestation> findPrestationEnCoursParProjetParEG(@PathVariable Long id, @PathVariable Long idPresta) {
		return prestationRepo.findPrestationEnCoursParProjetParEG(id, idPresta);
	}

	@GetMapping("/effectuee-par-projet-par-EG/{id}:{idPresta}")
	@JsonView(Views.ViewPrestation.class)
	public List<Prestation> findPrestationEffectuéeParProjetParEG(@PathVariable Long id, @PathVariable Long idPresta) {
		return prestationRepo.findPrestationEffectuéeParProjetParEG(id, idPresta);
	}

	@GetMapping("/planifiee-par-projet-par-EG/{id}:{idPresta}")
	@JsonView(Views.ViewPrestation.class)
	public List<Prestation> findPrestationPlanifiéeParProjetParEG(@PathVariable Long id, @PathVariable Long idPresta) {
		return prestationRepo.findPrestationPlanifiéeParProjetParEG(id, idPresta);
	}

	@GetMapping("/by-phase/{phase}")
	@JsonView(Views.ViewPrestation.class)
	public List<Prestation> findPrestationByPhase(@PathVariable PhasePresta phase) {
		return prestationRepo.findPrestationByPhase(phase);
	}
	
	@GetMapping("/by-phase-and-EG/{phase}:{id}")
	@JsonView(Views.ViewPrestation.class)
	public List<Prestation> findPrestationByPhaseAndProjet(@PathVariable PhasePresta phase, @PathVariable Long id) {
		return prestationRepo.findPrestationByPhaseAndProjet(phase, id);
	}
	
	@GetMapping("/by-phase-offre/{phase}:{idOffre}")
	@JsonView(Views.ViewPrestation.class)
	public List<Prestation> findPrestationByPhaseAndOffre(@PathVariable PhasePresta phase, @PathVariable Long idOffre) {
		return prestationRepo.findPrestationByPhaseAndOffre(phase, idOffre);
	}

	@PostMapping("")
	@JsonView(Views.ViewPrestation.class)
	public Prestation create(@RequestBody Prestation prestation) {
		prestation = prestationRepo.save(prestation);

		return prestation;
	}

	@PostMapping("/multiple")
	@JsonView(Views.ViewPrestation.class)
	public List<Prestation> create(@RequestBody List<Prestation> prestations) {
		List<Prestation> retour = new ArrayList<Prestation>();
		for (Prestation prestation : prestations) {
			prestation = prestationRepo.save(prestation);
			retour.add(prestation);
		}

		return retour;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewPrestation.class)
	public Prestation update(@RequestBody Prestation prestation, @PathVariable Long id) {
		if (!prestationRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		prestation = prestationRepo.save(prestation);

		return prestation;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		prestationRepo.deleteById(id);
	}
}
