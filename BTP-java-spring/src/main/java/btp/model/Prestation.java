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

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Prestation {
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
	@DateTimeFormat(pattern ="dd/MM/yyy")
	@JsonView(Views.ViewCommon.class)
	private Date dtFin;
	@JsonView(Views.ViewCommon.class)
	private PhasePresta phasePresta;
	@JsonView(Views.ViewCommon.class)
	private Boolean obsolete;
	@OneToOne (mappedBy = "prestation")
//	@JsonView(Views.ViewPrestation.class)
	private PrestationSupplementaire prestationSupplementaire;
	@ManyToMany
	@JoinTable(name ="matos_presta",
	joinColumns = @JoinColumn (name = "prestation_id ", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn (name = "materiel_id ", referencedColumnName = "id"))
	@JsonView(Views.ViewPrestation.class)
	private List<Materiel> materiels = new ArrayList<Materiel>();
	@ManyToOne
	@JoinColumn(name = "projet_id")
	@JsonView(Views.ViewCommon.class)
	private Projet projet;
	@ManyToOne
	@JoinColumn(name = "offre_id")
	@JsonView(Views.ViewCommon.class)
	private Offre offre;
	@ManyToOne
	@JoinColumn(name = "prestataire_id")
	@JsonView(Views.ViewPrestation.class)
	private Prestataire prestataire;
	@ManyToMany
	@JoinTable(name ="salarie_presta", 
	joinColumns = @JoinColumn (name = "prestation_id", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn (name = "salarie_id", referencedColumnName = "id")) 
	@JsonView(Views.ViewPrestation.class)
	private List<Salarie> salaries = new ArrayList<Salarie>();
	@OneToOne(mappedBy = "prestation")
//	@JsonView(Views.ViewPrestation.class)
	private Facture facture;
	@JsonView(Views.ViewCommon.class)
	private String motif;
	
	public Prestation() {
		super();
	}
	
	public Prestation(Categorie categorie, String nom, Float prix, Date dtDebut, Date dtFin, Boolean obsolete, PhasePresta phasePresta, String motif) {
		super();
		this.categorie = categorie;
		this.nom = nom;
		this.prix = prix;
		this.dtDebut = dtDebut;
		this.dtFin = dtFin;
		this.obsolete = obsolete;
		this.phasePresta = phasePresta;
		this.motif = motif;
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
	public Boolean getObsolete() {
		return obsolete;
	}
	public void setObsolete(Boolean obsolete) {
		this.obsolete = obsolete;
	}

	public PrestationSupplementaire getPrestationSupplementaire() {
		return prestationSupplementaire;
	}

	public void setPrestationSupplementaire(PrestationSupplementaire prestationSupplementaire) {
		this.prestationSupplementaire = prestationSupplementaire;
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

	public Offre getOffre() {
		return offre;
	}

	public void setOffre(Offre offre) {
		this.offre = offre;
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

	public PhasePresta getPhasePresta() {
		return phasePresta;
	}

	public void setPhasePresta(PhasePresta phasePresta) {
		this.phasePresta = phasePresta;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}
	
	


}
