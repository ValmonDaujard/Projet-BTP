package btp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("MOeuvre")
public class MaitreOeuvre extends Societe {
	
	@OneToMany(mappedBy = "maitreOeuvre")
	private List<Offre> offres = new ArrayList<Offre>();

	@OneToMany(mappedBy = "maitreOeuvre")
	private List<Facture> facture = new ArrayList<Facture>();

	// Constructeur
	
	public MaitreOeuvre() {
		super();
	}
	
	public MaitreOeuvre(String nom, String siret, String telephone, String mail, String numeroDeTva) {
		super(nom, siret, telephone, mail, numeroDeTva);
	}

	// Getters and Setters

	public List<Offre> getOffres() {
		return offres;
	}

	public void setOffres(List<Offre> offres) {
		this.offres = offres;
	}

	public List<Facture> getFacture() {
		return facture;
	}

	public void setFacture(List<Facture> facture) {
		this.facture = facture;
	}
}