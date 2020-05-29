package btp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class AppelOffre {
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
	private String objectif;
	@JsonView(Views.ViewCommon.class)
	private Float budget;
	@Temporal(TemporalType.DATE)
	@JsonView(Views.ViewCommon.class)
	private Date dtDebut;
	@Temporal(TemporalType.DATE)
	@JsonView(Views.ViewCommon.class)
	private Date dtFin;
	@Temporal(TemporalType.DATE)
	@JsonView(Views.ViewCommon.class)
	private Date dtLimite;
	@JsonView(Views.ViewCommon.class)
	private Boolean bpu;
	@JsonView(Views.ViewCommon.class)
	private Float prixBpu;

	@Embedded
	@JsonView(Views.ViewCommon.class)
	private Adresse adresse;

	@ManyToOne
	private MaitreOuvrage maitreOuvrage;

	@OneToMany(mappedBy = "appelOffre")
	List<Offre> offres = new ArrayList<Offre>();

	// Constructeur

	public AppelOffre() {
		super();
	}

	public AppelOffre(String nom, String objectif, Float budget, Date dtDebut, Date dtFin, Date dtLimite, Boolean bpu,
			Float prixBpu) {
		super();
		this.nom = nom;
		this.objectif = objectif;
		this.budget = budget;
		this.dtDebut = dtDebut;
		this.dtFin = dtFin;
		this.dtLimite = dtLimite;
		this.bpu = bpu;
		this.prixBpu = prixBpu;
	}

	// Getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getObjectif() {
		return objectif;
	}

	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}

	public Float getBudget() {
		return budget;
	}

	public void setBudget(Float budget) {
		this.budget = budget;
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

	public Date getDtLimite() {
		return dtLimite;
	}

	public void setDtLimite(Date dtLimite) {
		this.dtLimite = dtLimite;
	}

	public Boolean getBpu() {
		return bpu;
	}

	public void setBpu(Boolean bpu) {
		this.bpu = bpu;
	}

	public Float getPrixBpu() {
		return prixBpu;
	}

	public void setPrixBpu(Float prixBpu) {
		this.prixBpu = prixBpu;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public MaitreOuvrage getMaitreOuvrage() {
		return maitreOuvrage;
	}

	public void setMaitreOuvrage(MaitreOuvrage maitreOuvrage) {
		this.maitreOuvrage = maitreOuvrage;
	}

	public List<Offre> getOffres() {
		return offres;
	}

	public void setOffres(List<Offre> offres) {
		this.offres = offres;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "AppelOffre [id=" + id + ", objectif=" + objectif + ", budget=" + budget + ", dtDebut=" + dtDebut
				+ ", dtFin=" + dtFin + ", dtLimite=" + dtLimite + ", bpu=" + bpu + ", prixBpu=" + prixBpu
				+ ", maitreOuvrage=" + maitreOuvrage + ", offres=" + offres + "]";
	}

	

}
