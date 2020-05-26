package btp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("MOuvrage")
public class MaitreOuvrage extends Societe {
	@OneToMany(mappedBy = "maitreOuvrage")
	private List<AppelOffre> appeloffres = new ArrayList<AppelOffre>();

	@OneToMany(mappedBy = "maitreOuvrage")
	private List<Offre> offres = new ArrayList<Offre>();

	@OneToMany(mappedBy = "maitreOuvrage")
	private List<Facture> factures = new ArrayList<Facture>();

	// Constructeur
	
	public MaitreOuvrage() {
		super();
	}
	
	public MaitreOuvrage(String nom, String siret, String telephone, String mail, String numeroDeTva) {
	super(nom, siret, telephone, mail, numeroDeTva);
}
	
	// getters and setters

	public List<AppelOffre> getAppeloffres() {
		return appeloffres;
	}


	public void setAppeloffres(List<AppelOffre> appeloffres) {
		this.appeloffres = appeloffres;
	}

	public List<Offre> getOffres() {
		return offres;
	}

	public void setOffres(List<Offre> offres) {
		this.offres = offres;
	}

	public List<Facture> getFactures() {
		return factures;
	}

	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}

}
