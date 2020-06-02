package btp.model;

import java.util.ArrayList;
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
import javax.persistence.OneToMany;
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
	@Enumerated(EnumType.STRING)
	@JsonView(Views.ViewCommon.class)
	private Civilite civilite;
	@JsonView(Views.ViewCommon.class)
	private String nom;
	@JsonView(Views.ViewCommon.class)
	private String prenom;
	@JsonView(Views.ViewCommon.class)
	private String metier;
	
	@OneToMany(mappedBy = "salarie")
	@JsonView(Views.ViewSalarie.class)
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
	
	public Salarie(Civilite civilite, String nom, String prenom, String metier) {
		super();
		this.civilite = civilite;
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
	
	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
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
