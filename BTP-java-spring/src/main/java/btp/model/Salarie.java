package btp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Salarie {
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
	private String prenom;
	@JsonView(Views.ViewCommon.class)
	private String metier;
	
	@Embedded
	@JsonView(Views.ViewCommon.class)
	private Adresse adresse;
	
	@ManyToMany
	@JoinTable(name = "action_salarie", 
			uniqueConstraints = @UniqueConstraint(columnNames = { "salarie_id", "action_id" }),
			joinColumns = @JoinColumn(name="salarie_id", referencedColumnName = "id"), 
			inverseJoinColumns = @JoinColumn(name="action_id", referencedColumnName = "id"))
//	@JsonView(Views.ViewSalarie.class)
	private List<Action> actions = new ArrayList<Action>();
	
	@ManyToOne
	@JoinColumn(name = "prestataire_id")
	@JsonView(Views.ViewSalarie.class)
	private Prestataire prestataire;

	@ManyToMany
	@JoinTable(name = "prestation_salarie", 
			uniqueConstraints = @UniqueConstraint(columnNames = { "salarie_id", "prestation_id" }),
			joinColumns = @JoinColumn(name="salarie_id", referencedColumnName = "id"), 
			inverseJoinColumns = @JoinColumn(name="prestation_id", referencedColumnName = "id"))
	@JsonView(Views.ViewSalarie.class)
	private List<Prestation> prestations = new ArrayList<Prestation>();
	
	@ManyToMany
	@JoinTable(name = "prestationsup_salarie", 
			uniqueConstraints = @UniqueConstraint(columnNames = { "salarie_id", "prestationsup_id" }),
			joinColumns = @JoinColumn(name="salarie_id", referencedColumnName = "id"), 
			inverseJoinColumns = @JoinColumn(name="prestationsup_id", referencedColumnName = "id"))
	@JsonView(Views.ViewSalarie.class)
	private List<PrestationSupplementaire> prestationSupplementaires = new ArrayList<PrestationSupplementaire>();

	
	public Salarie() {
		super();
	}
	
	public Salarie(String nom, String prenom, String metier) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.metier = metier;
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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMetier() {
		return metier;
	}

	public void setMetier(String metier) {
		this.metier = metier;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}
	
	public void addActions(Action action) {
		this.actions.add(action);
	}

	public Prestataire getPrestataire() {
		return prestataire;
	}

	public void setPrestataire(Prestataire prestataire) {
		this.prestataire = prestataire;
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

	public List<PrestationSupplementaire> getPrestationSupplementaires() {
		return prestationSupplementaires;
	}

	public void setPrestationSupplementaires(List<PrestationSupplementaire> prestationSupplementaires) {
		this.prestationSupplementaires = prestationSupplementaires;
	}
	
	public void addPrestationSupplementaires(PrestationSupplementaire prestationSupplementaire) {
		this.prestationSupplementaires.add(prestationSupplementaire);
	}

	@Override
	public String toString() {
		return "Salarie [id=" + id + ", version=" + version + ", nom=" + nom + ", prenom=" + prenom + ", metier="
				+ metier + "]";
	}
	
	
}
