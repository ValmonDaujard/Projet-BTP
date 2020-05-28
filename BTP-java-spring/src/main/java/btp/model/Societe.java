package btp.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING, length = 15)
public class Societe {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@JsonView(Views.ViewCommon.class)
	private String nom;
//	@Column(unique=true)
	@JsonView(Views.ViewCommon.class)
	private String siret;
	@JsonView(Views.ViewCommon.class)
	private String telephone;
//	@Column(unique=true)
	@JsonView(Views.ViewCommon.class)
	private String mail;
//	@Column(unique=true)
	@JsonView(Views.ViewCommon.class)
	private String numeroDeTva;
	
	@OneToOne
	@JsonView(Views.ViewSociete.class)
	private Utilisateur utilisateur;
	
	@Embedded
	@JsonView(Views.ViewSociete.class)
	private Adresse adresse;

// Constructeur
	public Societe() {
		super();
	}

	public Societe(String nom, String siret, String telephone, String mail, String numeroDeTva) {
		super();
		this.nom = nom;
		this.siret = siret;
		this.telephone = telephone;
		this.mail = mail;
		this.numeroDeTva = numeroDeTva;
	}

//Getters and setters

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

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNumeroDeTva() {
		return numeroDeTva;
	}

	public void setNumeroDeTva(String numeroDeTva) {
		this.numeroDeTva = numeroDeTva;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	// toString

	@Override
	public String toString() {
		return "Societe [nom=" + nom + ", siret=" + siret + ", telephone=" + telephone + ", mail=" + mail + ", numeroDeTva=" + numeroDeTva + ", utilisateur=" + utilisateur +"]";
	}

}