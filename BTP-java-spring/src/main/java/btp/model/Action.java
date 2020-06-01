package btp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Action {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@Column
	@JsonView(Views.ViewCommon.class)
	private String nomAction;
	@Temporal(TemporalType.DATE)
	@Column
	@JsonView(Views.ViewCommon.class)
	private Date dtCreation;
	@Temporal(TemporalType.DATE)
	@Column
	@JsonView(Views.ViewCommon.class)
	private Date dtLimite;
	@Column
	@JsonView(Views.ViewCommon.class)
	private String description;
	@Column
	@JsonView(Views.ViewCommon.class)
	private Boolean effectuee;
	
	@ManyToMany(mappedBy = "actions")
	@JsonView(Views.ViewAction.class)
	private List<Salarie> salaries = new ArrayList<Salarie>();

	@ManyToOne
	@JoinColumn(name = "prestataire_id")
	@JsonView(Views.ViewAction.class)
	private Prestataire prestataire;

	@ManyToOne
	@JoinColumn(name = "projet_id")
	@JsonView(Views.ViewAction.class)
	private Projet projet;

	
	public Action() {
		super();
	}

	public Action(String nomAction, Date dtCreation, Date dtLimite, String description, Boolean effectuee) {
		super();
		this.nomAction = nomAction;
		this.dtCreation = dtCreation;
		this.dtLimite = dtLimite;
		this.description = description;
		this.effectuee = effectuee;
	}

	public Action(String nomAction) {
		super();
		this.nomAction = nomAction;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomAction() {
		return nomAction;
	}

	public void setNomAction(String nomAction) {
		this.nomAction = nomAction;
	}

	public Date getDtCreation() {
		return dtCreation;
	}

	public void setDtCreation(Date dtCreation) {
		this.dtCreation = dtCreation;
	}

	public Date getDtLimite() {
		return dtLimite;
	}

	public void setDtLimite(Date dtLimite) {
		this.dtLimite = dtLimite;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getEffectuee() {
		return effectuee;
	}

	public void setEffectuee(Boolean effectuee) {
		this.effectuee = effectuee;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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

	public Prestataire getPrestataire() {
		return prestataire;
	}

	public void setPrestataire(Prestataire prestataire) {
		this.prestataire = prestataire;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	@Override
	public String toString() {
		return "Action [id=" + id + ", nomAction=" + nomAction + ", dtCreation=" + dtCreation + ", dtLimite=" + dtLimite
				+ ", description=" + description + ", effectuee=" + effectuee + "]";
	}

}
