package btp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class PrestationSupplementaire {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@Enumerated(EnumType.STRING)
	@JsonView(Views.ViewCommon.class)
	private Categorie categorie;
	@JsonView(Views.ViewCommon.class)
	private String nom;
	@JsonView(Views.ViewCommon.class)
	private Float prix;
	@Temporal(TemporalType.DATE)
	@JsonView(Views.ViewCommon.class)
	private Date dtDebut ;
	@Temporal(TemporalType.DATE)
	@JsonView(Views.ViewCommon.class)
	private Date dtFin;
	@JsonView(Views.ViewCommon.class)
	private PhasePresta phasePresta;
	@OneToOne 
	@JoinColumn(name = "prestation_id")
	@JsonView(Views.ViewPrestationSupplementaire.class)
	private Prestation prestation;
	@ManyToMany
	@JoinTable(name ="matos_prestaSupp",
	joinColumns = @JoinColumn (name = "prestationSupplementaire_id ", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn (name = "materiel_id ", referencedColumnName = "id"))
	@JsonView(Views.ViewPrestationSupplementaire.class)
	private List<Materiel> materiels = new ArrayList<Materiel>();
	@ManyToOne
	@JoinColumn(name = "projet_id")
	@JsonView(Views.ViewPrestationSupplementaire.class)
	private Projet projet;
	@ManyToOne
	@JoinColumn(name = "prestataire_id")
	@JsonView(Views.ViewPrestationSupplementaire.class)
	private Prestataire prestataire;
	@ManyToMany
	@JoinTable(name ="salarie_presta_Supp", 
	joinColumns = @JoinColumn (name = "salarie_id ", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn (name = "prestationSupplementaire_id ", referencedColumnName = "id"))
	@JsonView(Views.ViewPrestationSupplementaire.class)
	private List<Salarie> salaries = new ArrayList<Salarie>();
	@OneToOne(mappedBy = "prestationSupplementaire") 
	@JsonView(Views.ViewPrestationSupplementaire.class)
	private Facture facture;
	
	
	
	public PrestationSupplementaire() {
		super();
	}
	
	public PrestationSupplementaire(Categorie categorie, String nom, Float prix, Date dtDebut, Date dtFin, PhasePresta phasePresta) {
		super();
		this.categorie = categorie;
		this.nom = nom;
		this.prix = prix;
		this.dtDebut = dtDebut;
		this.dtFin = dtFin;
		this.phasePresta = phasePresta;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Float getPrix() {
		return prix;
	}
	public void setPrix(Float prix) {
		this.prix = prix;
	}
	public Date getDtDebut() {
		return dtDebut;
	}
	public void setDtDebut(Date dtDebut) {
		this.dtDebut = dtDebut;
	}
	public Date getDtFin() {
		return dtFin;
	}
	public void setDtFin(Date dtFin) {
		this.dtFin = dtFin;
	}

	public PhasePresta getPhasePresta() {
		return phasePresta;
	}

	public void setPhasePresta(PhasePresta phasePresta) {
		this.phasePresta = phasePresta;
	}

	public Prestation getPrestation() {
		return prestation;
	}

	public void setPrestation(Prestation prestation) {
		this.prestation = prestation;
	}

	public List<Materiel> getMateriels() {
		return materiels;
	}

	public void setMateriels(List<Materiel> materiels) {
		this.materiels = materiels;
	}
	
	public void addMateriels(Materiel materiel) {
		this.materiels.add(materiel);
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Prestataire getPrestataire() {
		return prestataire;
	}

	public void setPrestataire(Prestataire prestataire) {
		this.prestataire = prestataire;
	}

	public List<Salarie> getSalaries() {
		return salaries;
	}

	public void setSalaries(List<Salarie> salaries) {
		this.salaries = salaries;
	}
	
	public void addSalaries(Salarie salarie) {
		this.salaries.add(salarie);
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	
	
	

}
