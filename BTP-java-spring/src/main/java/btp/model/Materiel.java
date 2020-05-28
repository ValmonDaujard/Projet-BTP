package btp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Materiel {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@JsonView(Views.ViewCommon.class)
	private String nom;
	@JsonView(Views.ViewCommon.class)
	private Float quantite;
	@Enumerated(EnumType.STRING)
	@JsonView(Views.ViewCommon.class)
	private Unite unite;
	@ManyToMany (mappedBy = "materiels")
	private List<PrestationSupplementaire> prestationSupplementaires = new ArrayList<PrestationSupplementaire>();
	@ManyToMany (mappedBy = "materiels")
	private List<Prestation> prestations = new ArrayList<Prestation>();
	@ManyToOne
	@JoinColumn(name = "prestataire_id")
	private Prestataire prestataire;
	
	public Materiel() {
		super();
	}
	
	
	public Materiel(String nom, Float quantite, Unite unite) {
		super();
		this.nom = nom;
		this.quantite = quantite;
		this.unite = unite;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Float getQuantite() {
		return quantite;
	}
	public void setQuantite(Float quantite) {
		this.quantite = quantite;
	}
	public Unite getUnite() {
		return unite;
	}
	public void setUnite(Unite unite) {
		this.unite = unite;
	}


	public List<PrestationSupplementaire> getPrestationSupplementaires() {
		return prestationSupplementaires;
	}


	public void setPrestationSupplementaires(List<PrestationSupplementaire> prestationSupplementaires) {
		this.prestationSupplementaires = prestationSupplementaires;
	}
	
	public void addPrestationSupplementaires(PrestationSupplementaire prestationSupplementaire) {
		this.prestationSupplementaires.add(prestationSupplementaire);
	}

	public List<Prestation> getPrestations() {
		return prestations;
	}


	public void setPrestations(List<Prestation> prestations) {
		this.prestations = prestations;
	}
	
	public void addPrestation(Prestation prestation) {
		this.prestations.add(prestation);
	}


	public Prestataire getPrestataire() {
		return prestataire;
	}


	public void setPrestataire(Prestataire prestataire) {
		this.prestataire = prestataire;
	}

	
}
