package btp.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import btp.model.Categorie;
import btp.model.Etat;
import btp.model.PhasePresta;
import btp.model.Unite;



@RestController
@RequestMapping ("/api")
@CrossOrigin("*")
public class CommonRestController {
	
	@GetMapping("/categories")
	public Categorie[] getCategories() {
		return Categorie.values();
	}
	
	@GetMapping("/etats")
	public Etat[] getEtats() {
		return Etat.values();
	}
	
	@GetMapping("/phasePrestas")
	public PhasePresta[] getPhasePrestas() {
		return PhasePresta.values();
	}
	
	@GetMapping("/unites")
	public Unite[] getUnites() {
		return Unite.values();
	}

}
