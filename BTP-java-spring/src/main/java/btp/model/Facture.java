package btp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Facture {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	
	@JsonView(Views.ViewCommon.class)
	private String nomFacture;
	
	@JsonView(Views.ViewCommon.class)
	private int numeroFacture;
	
	@Temporal(TemporalType.DATE)
	@JsonView(Views.ViewCommon.class)
	private Date dtFacturation;
	
	@JsonView(Views.ViewCommon.class)
	private Float prixHT;
	
	@JsonView(Views.ViewCommon.class)
	private Float remise;
	
	@Temporal(TemporalType.DATE)
	@JsonView(Views.ViewCommon.class)
	private Date dtEcheance;
	
	@JsonView(Views.ViewCommon.class)
	private Float penaliteRetard;
	
	@JsonView(Views.ViewCommon.class)
	private Boolean payee;
	
	@JsonView(Views.ViewCommon.class)
	private Boolean factureMOEMO;
	
	@ManyToOne
	@JoinColumn(name = "prestataire_id")
//	@JsonView(Views.ViewCommon.class)
	private Prestataire prestataire;
	
	@ManyToOne
	private MaitreOeuvre maitreOeuvre;
	
	@ManyToOne
	private MaitreOuvrage maitreOuvrage;
	
	@ManyToOne
	@JsonView(Views.ViewCommon.class)
	private Projet projet;
	
	@OneToOne
	private PrestationSupplementaire prestationSupplementaire;
	
	@OneToOne
	private Prestation prestation;
	
	
	public Facture() {
		super();
	}

	public Facture(String nomFacture, int numeroFacture, Date dtFacturation, Float prixHT, Float remise,
			Date dtEcheance, Float penaliteRetard, Boolean payee, Boolean factureMOEMO) {
		super();
		this.nomFacture = nomFacture;
		this.numeroFacture = numeroFacture;
		this.dtFacturation = dtFacturation;
		this.prixHT = prixHT;
		this.remise = remise;
		this.dtEcheance = dtEcheance;
		this.penaliteRetard = penaliteRetard;
		this.payee = payee;
		this.factureMOEMO = factureMOEMO;
	}
	
	public Facture(int numeroFacture) {
		super();
		this.numeroFacture = numeroFacture;
	}



	public String getNomFacture() {
		return nomFacture;
	}

	public void setNomFacture(String nomFacture) {
		this.nomFacture = nomFacture;
	}

	public MaitreOeuvre getMaitreOeuvre() {
		return maitreOeuvre;
	}

	public void setMaitreOeuvre(MaitreOeuvre maitreOeuvre) {
		this.maitreOeuvre = maitreOeuvre;
	}

	public MaitreOuvrage getMaitreOuvrage() {
		return maitreOuvrage;
	}

	public void setMaitreOuvrage(MaitreOuvrage maitreOuvrage) {
		this.maitreOuvrage = maitreOuvrage;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public PrestationSupplementaire getPrestationSupplementaire() {
		return prestationSupplementaire;
	}

	public void setPrestationSupplementaire(PrestationSupplementaire prestationSupplementaire) {
		this.prestationSupplementaire = prestationSupplementaire;
	}

	public Prestation getPrestation() {
		return prestation;
	}

	public void setPrestation(Prestation prestation) {
		this.prestation = prestation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getNumeroFacture() {
		return numeroFacture;
	}

	public void setNumeroFacture(int numeroFacture) {
		this.numeroFacture = numeroFacture;
	}

	public Date getDtFacturation() {
		return dtFacturation;
	}

	public void setDtFacturation(Date dtFacturation) {
		this.dtFacturation = dtFacturation;
	}

	public Float getPrixHT() {
		return prixHT;
	}

	public void setPrixHT(Float prixHT) {
		this.prixHT = prixHT;
	}

	public Float getRemise() {
		return remise;
	}

	public void setRemise(Float remise) {
		this.remise = remise;
	}

	public Date getDtEcheance() {
		return dtEcheance;
	}

	public void setDtEcheance(Date dtEcheance) {
		this.dtEcheance = dtEcheance;
	}

	public Float getPenaliteRetard() {
		return penaliteRetard;
	}

	public void setPenaliteRetard(Float penaliteRetard) {
		this.penaliteRetard = penaliteRetard;
	}

	public Prestataire getPrestataire() {
		return prestataire;
	}

	public void setPrestataire(Prestataire prestataire) {
		this.prestataire = prestataire;
	}
	
	public Boolean getPayee() {
		return payee;
	}

	public void setPayee(Boolean payee) {
		this.payee = payee;
	}
	
	public Boolean getFactureMOEMO() {
		return factureMOEMO;
	}

	public void setFactureMOEMO(Boolean factureMOEMO) {
		this.factureMOEMO = factureMOEMO;
	}

	@Override
	public String toString() {
		return "Facture [id=" + id + ", version=" + version + ", nomFacture=" + nomFacture + ", numeroFacture=" + numeroFacture + ", dtFacturation="
				+ dtFacturation + ", prixHT=" + prixHT + ", remise=" + remise + ", dtEcheance=" + dtEcheance
				+ ", penaliteRetard=" + penaliteRetard + "]";
	}

	
	
}
