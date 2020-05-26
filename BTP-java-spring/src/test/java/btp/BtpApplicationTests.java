package btp;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import btp.model.Action;
import btp.model.Adresse;
import btp.model.AppelOffre;
import btp.model.Categorie;
import btp.model.Etat;
import btp.model.Facture;
import btp.model.MaitreOeuvre;
import btp.model.MaitreOuvrage;
import btp.model.Materiel;
import btp.model.Offre;
import btp.model.PhasePresta;
import btp.model.Prestataire;
import btp.model.Prestation;
import btp.model.PrestationSupplementaire;
import btp.model.Projet;
import btp.model.Reunion;
import btp.model.Salarie;
import btp.model.Unite;
import btp.model.Utilisateur;
import btp.persistence.IActionRepository;
import btp.persistence.IAppelOffreRepository;
import btp.persistence.IFactureRepository;
import btp.persistence.IMaitreOeuvreRepository;
import btp.persistence.IMaitreOuvrageRepository;
import btp.persistence.IMaterielRepository;
import btp.persistence.IOffreRepository;
import btp.persistence.IPrestataireRepository;
import btp.persistence.IPrestationRepository;
import btp.persistence.IPrestationSupplementaireRepository;
import btp.persistence.IProjetRepository;
import btp.persistence.IReunionRepository;
import btp.persistence.ISalarieRepository;
import btp.persistence.IUtilisateurRepository;

@SpringBootTest
class BtpApplicationTests {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Autowired
	private IActionRepository actionRepository;

	@Autowired
	private IAppelOffreRepository appelOffreRepository;

	@Autowired
	private IFactureRepository factureRepository;

	@Autowired
	private IMaitreOeuvreRepository maitreOeuvreRepository;

	@Autowired
	private IMaitreOuvrageRepository maitreOuvrageRepository;

	@Autowired
	private IMaterielRepository materielRepository;

	@Autowired
	private IOffreRepository offreRepository;

	@Autowired
	private IPrestataireRepository prestataireRepository;

	@Autowired
	private IPrestationRepository prestationRepository;

	@Autowired
	private IPrestationSupplementaireRepository prestationSupplementaireRepository;

	@Autowired
	private IProjetRepository projetRepository;

	@Autowired
	private IReunionRepository reunionRepository;

	@Autowired
	private ISalarieRepository salarieRepository;

	@Autowired
	private IUtilisateurRepository utilisateurRepository;

	@Test
	public void action() throws ParseException {
		// action
		Action isolation = new Action("Isolation", sdf.parse("12/04/2020"), sdf.parse("15/05/2020"),
				"Laine de verre charpente", false);
		Action cloture = new Action("Clôture", sdf.parse("15/07/2020"), sdf.parse("25/07/2020"), "Réparer clôture",
				true);

		// prestataire
		Prestataire colas = new Prestataire("COLAS", "448631348", "0593671425", "colas@groupecolas.fr",
				"153dff413sd21");
		colas.setAdresse(new Adresse("18 avenue des toto", null, "33700", "ColasVille"));
		Prestataire bouygues = new Prestataire("Bouygues", "133793512", "0534976125", "bouygues@bconstruction.fr",
				"f557d5142sd42");
		bouygues.setAdresse(new Adresse("18 avenue des toto", null, "33700", "BouyguesVille"));

		colas = prestataireRepository.save(colas);
		bouygues = prestataireRepository.save(bouygues);

		// projet
		Projet projet1 = new Projet(9371, sdf.parse("07/04/2020"), sdf.parse("07/04/2021"), 1, "nouveau");
		Projet projet2 = new Projet(1457, sdf.parse("08/05/2021"), sdf.parse("10/12/2022"), 0, "rapport");

		projet1 = projetRepository.save(projet1);
		projet2 = projetRepository.save(projet2);

		// liens actions - prestataire / projet
		isolation.setPrestataire(colas);
		cloture.setPrestataire(bouygues);
		isolation.setProjet(projet1);
		cloture.setProjet(projet2);

		isolation = actionRepository.save(isolation);
		cloture = actionRepository.save(cloture);
	}

	@Test
	public void appelOffre() throws ParseException {
		// appel offre
		AppelOffre appelOffreMaison = new AppelOffre("maison", "construction d'une maison", 33000F, sdf.parse("07/04/2021"), sdf.parse("07/04/2022"),
				sdf.parse("15/12/2021"), false, null);
		appelOffreMaison.setAdresse(new Adresse("18 avenue des hirondelles", null, "33700", "Mérignac"));
		AppelOffre appelOffreImmeuble = new AppelOffre("immeuble", "construction d'un immeuble de 5 étages", 65000F, sdf.parse("07/04/2021"),
				sdf.parse("07/04/2023"), sdf.parse("15/12/2021"), true, 45000F);
		appelOffreImmeuble.setAdresse(new Adresse("18 avenue des tulipes", null, "33700", "Mérignac"));
		
		appelOffreImmeuble.setAdresse(new Adresse("18 Avenue JFK", null, "33700", "Mérignac"));
		appelOffreMaison.setAdresse(new Adresse("35 Boulevard JFK", null, "33000", "Bordeaux"));

		// maitre d'ouvrage
		MaitreOuvrage maitreOuvrageToto = new MaitreOuvrage("Toto", "4653413", "0618753492", "toto@maitredouvrage.fr",
				"f6534r31e");
		maitreOuvrageToto.setAdresse(new Adresse("18 avenue des toto", null, "33700", "TotoVille"));
		MaitreOuvrage maitreOuvrageBobby = new MaitreOuvrage("Bobby", "1675923", "0679315862",
				"bobby@maitredouvrage.fr", "f23s5642fq12s674");
		maitreOuvrageBobby.setAdresse(new Adresse("32 rue des bobby", null, "33700", "BobbyVille"));

		maitreOuvrageToto = maitreOuvrageRepository.save(maitreOuvrageToto);
		maitreOuvrageBobby = maitreOuvrageRepository.save(maitreOuvrageBobby);

		// lien appel d'offre - maitre d'ouvrage
		appelOffreMaison.setMaitreOuvrage(maitreOuvrageToto);
		appelOffreImmeuble.setMaitreOuvrage(maitreOuvrageBobby);

		appelOffreMaison = appelOffreRepository.save(appelOffreMaison);
		appelOffreImmeuble = appelOffreRepository.save(appelOffreImmeuble);
	}

	@Test
	public void facture() throws ParseException {
		// facture
		Facture factureIsolation = new Facture(111, sdf.parse("15/05/2020"), 5000F, 0F, sdf.parse("15/06/2020"), 0F,
				true);
		Facture factureCloture = new Facture(45, sdf.parse("18/01/2021"), 5000F, 15F, sdf.parse("21/02/2022"), 52F,
				false);

		// maitre d'oeuvre
		MaitreOeuvre maitreOeuvreBob = new MaitreOeuvre("Bob", "14521256431", "0649753159", "boblebricoleur@gmail.fr",
				"354f435f41f");
		maitreOeuvreBob.setAdresse(new Adresse("16 rue JFK", null, "33700", "Mérignac"));
		MaitreOeuvre maitreOeuvreGeorges = new MaitreOeuvre("Georges", "16793458", "0734159382",
				"georges@maitredoeuvre.fr", "531p5v7q26846s");
		maitreOeuvreGeorges.setAdresse(new Adresse("35 boulevard JFK", null, "33700", "Mérignac"));

		maitreOeuvreBob = maitreOeuvreRepository.save(maitreOeuvreBob);
		maitreOeuvreGeorges = maitreOeuvreRepository.save(maitreOeuvreGeorges);

		// maitre d'ouvrage
		MaitreOuvrage maitreOuvrageToto = new MaitreOuvrage("Toto", "4653413", "0618753492", "toto@maitredouvrage.fr",
				"f6534r31e");
		maitreOuvrageToto.setAdresse(new Adresse("18 avenue des toto", null, "33700", "TotoVille"));
		MaitreOuvrage maitreOuvrageBobby = new MaitreOuvrage("Bobby", "1675923", "0679315862",
				"bobby@maitredouvrage.fr", "f23s5642fq12s674");
		maitreOuvrageBobby.setAdresse(new Adresse("32 rue des bobby", null, "33700", "BobbyVille"));

		maitreOuvrageToto = maitreOuvrageRepository.save(maitreOuvrageToto);
		maitreOuvrageBobby = maitreOuvrageRepository.save(maitreOuvrageBobby);

		// prestataire
		Prestataire colas = new Prestataire("COLAS", "448631348", "0593671425", "colas@groupecolas.fr",
				"153dff413sd21");
		colas.setAdresse(new Adresse("18 avenue des toto", null, "33700", "ColasVille"));
		Prestataire bouygues = new Prestataire("Bouygues", "133793512", "0534976125", "bouygues@bconstruction.fr",
				"f557d5142sd42");
		bouygues.setAdresse(new Adresse("18 avenue des toto", null, "33700", "BouyguesVille"));

		colas = prestataireRepository.save(colas);
		bouygues = prestataireRepository.save(bouygues);

		// prestation
		Prestation presta1 = new Prestation(Categorie.grosOeuvre, "Fondation", 10000F, sdf.parse("10/04/2020"),
				sdf.parse("10/05/2020"), false, PhasePresta.ValideEG);
		Prestation presta2 = new Prestation(Categorie.secondOeuvre, "Plomberie", 9000F, sdf.parse("15/09/2020"),
				sdf.parse("25/09/2020"), false, PhasePresta.ValideMOeuvre);

		presta1 = prestationRepository.save(presta1);
		presta2 = prestationRepository.save(presta2);

		// prestation supplémentaire
		PrestationSupplementaire prestaSupp1 = new PrestationSupplementaire(Categorie.grosOeuvre, "Applanissement",
				2000F, sdf.parse("10/04/2020"), sdf.parse("12/04/2020"), PhasePresta.enConsult);
		PrestationSupplementaire prestaSupp2 = new PrestationSupplementaire(Categorie.secondOeuvre, "Enduit", 950F,
				sdf.parse("20/04/2021"), sdf.parse("22/04/2021"), PhasePresta.ValideEG);

		prestaSupp1 = prestationSupplementaireRepository.save(prestaSupp1);
		prestaSupp2 = prestationSupplementaireRepository.save(prestaSupp2);

		// projet
		Projet projet1 = new Projet(9371, sdf.parse("07/04/2020"), sdf.parse("07/04/2021"), 1, "nouveau");
		Projet projet2 = new Projet(1457, sdf.parse("08/05/2021"), sdf.parse("10/12/2022"), 0, "rapport");

		projet1 = projetRepository.save(projet1);
		projet2 = projetRepository.save(projet2);

		// liens facture - maitre d'oeuvre / maitre d'ouvrage / prestataire / prestation
		// / prestation supplémentaire / projet
		factureIsolation.setMaitreOeuvre(maitreOeuvreBob);
		factureIsolation.setMaitreOuvrage(maitreOuvrageBobby);
		factureCloture.setMaitreOeuvre(maitreOeuvreGeorges);
		factureCloture.setMaitreOuvrage(maitreOuvrageToto);
		factureIsolation.setPrestataire(colas);
		factureCloture.setPrestataire(bouygues);
		factureIsolation.setPrestation(presta1);
		factureCloture.setPrestation(presta2);
		factureIsolation.setPrestationSupplementaire(prestaSupp1);
		factureCloture.setPrestationSupplementaire(prestaSupp2);
		factureIsolation.setProjet(projet1);
		factureCloture.setProjet(projet2);

		factureIsolation = factureRepository.save(factureIsolation);
		factureCloture = factureRepository.save(factureCloture);
	}

	@Test
	public void maitreOeuvre() {
		// maitre d'oeuvre
		MaitreOeuvre maitreOeuvreBob = new MaitreOeuvre("Bob", "14521256431", "0649753159", "boblebricoleur@gmail.fr",
				"354f435f41f");
		maitreOeuvreBob.setAdresse(new Adresse("16 rue JFK", "3e étage", "33700", "Mérignac"));
		MaitreOeuvre maitreOeuvreGeorges = new MaitreOeuvre("Georges", "16793458", "0734159382",
				"georges@maitredoeuvre.fr", "531p5v7q26846s");
		maitreOeuvreGeorges.setAdresse(new Adresse("35 boulevard JFK", null, "33700", "Mérignac"));

		// utilisateur
		Utilisateur utilisateurmaitreOeuvreBob = new Utilisateur("Bob", "123456789");
		Utilisateur utilisateurmaitreOeuvreGeorges = new Utilisateur("Georges", "987654321");

		utilisateurmaitreOeuvreBob = utilisateurRepository.save(utilisateurmaitreOeuvreBob);
		utilisateurmaitreOeuvreGeorges = utilisateurRepository.save(utilisateurmaitreOeuvreGeorges);

		// lien maitre d'oeuvre - utilisateur
		maitreOeuvreBob.setUtilisateur(utilisateurmaitreOeuvreBob);
		maitreOeuvreGeorges.setUtilisateur(utilisateurmaitreOeuvreGeorges);

		maitreOeuvreBob = maitreOeuvreRepository.save(maitreOeuvreBob);
		maitreOeuvreGeorges = maitreOeuvreRepository.save(maitreOeuvreGeorges);
	}

	@Test
	public void maitreOuvrage() {
		// maitre d'ouvrage
		MaitreOuvrage maitreOuvrageToto = new MaitreOuvrage("Toto", "4653413", "0618753492", "toto@maitredouvrage.fr",
				"f6534r31e");
		maitreOuvrageToto.setAdresse(new Adresse("18 avenue des toto", null, "33700", "TotoVille"));
		MaitreOuvrage maitreOuvrageBobby = new MaitreOuvrage("Bobby", "1675923", "0679315862",
				"bobby@maitredouvrage.fr", "f23s5642fq12s674");
		maitreOuvrageBobby.setAdresse(new Adresse("32 rue des bobby", null, "33700", "BobbyVille"));

		// utilisateur
		Utilisateur utilisateurmaitreOuvrageToto = new Utilisateur("Toto", "aertyuiop");
		Utilisateur utilisateurmaitreOuvrageBobby = new Utilisateur("Bobby", "poiuytreza");

		utilisateurmaitreOuvrageToto = utilisateurRepository.save(utilisateurmaitreOuvrageToto);
		utilisateurmaitreOuvrageBobby = utilisateurRepository.save(utilisateurmaitreOuvrageBobby);

		// lien maitre d'ouvrage - utilisateur
		maitreOuvrageBobby.setUtilisateur(utilisateurmaitreOuvrageBobby);
		maitreOuvrageToto.setUtilisateur(utilisateurmaitreOuvrageToto);

		maitreOuvrageToto = maitreOuvrageRepository.save(maitreOuvrageToto);
		maitreOuvrageBobby = maitreOuvrageRepository.save(maitreOuvrageBobby);
	}

//
	@Test
	public void materiel() {
		// matériel
		Materiel sable = new Materiel("Sac de Sable", 5f, Unite.unite);
		Materiel grillage = new Materiel("Grillage", 18F, Unite.metreLineaire);
		Materiel rouleauCompresseur = new Materiel("Rouleau Compresseur", 1f, Unite.unite);

		// prestataire
		Prestataire colas = new Prestataire("COLAS", "448631348", "0593671425", "colas@groupecolas.fr",
				"153dff413sd21");
		colas.setAdresse(new Adresse("18 avenue des toto", null, "33700", "ColasVille"));
		Prestataire bouygues = new Prestataire("Bouygues", "133793512", "0534976125", "bouygues@bconstruction.fr",
				"f557d5142sd42");
		bouygues.setAdresse(new Adresse("18 avenue des toto", null, "33700", "BouyguesVille"));

		colas = prestataireRepository.save(colas);
		bouygues = prestataireRepository.save(bouygues);

		// lien matériel - prestataire
		sable.setPrestataire(colas);
		grillage.setPrestataire(bouygues);
		rouleauCompresseur.setPrestataire(colas);

		sable = materielRepository.save(sable);
		grillage = materielRepository.save(grillage);
		rouleauCompresseur = materielRepository.save(rouleauCompresseur);
	}

	@Test
	public void offre() throws ParseException {
		// offre
		Offre offreToto = new Offre(60000F, 45, sdf.parse("07/04/2021"), sdf.parse("07/04/2023"), Etat.consult);
		Offre offreBobby = new Offre(32000F, 12, sdf.parse("08/08/2020"), sdf.parse("09/12/2024"), Etat.val);

		// maitre d'oeuvre
		MaitreOeuvre maitreOeuvreBob = new MaitreOeuvre("Bob", "14521256431", "0649753159", "boblebricoleur@gmail.fr",
				"354f435f41f");
		maitreOeuvreBob.setAdresse(new Adresse("16 rue JFK", "3e étage", "33700", "Mérignac"));
		MaitreOeuvre maitreOeuvreGeorges = new MaitreOeuvre("Georges", "16793458", "0734159382",
				"georges@maitredoeuvre.fr", "531p5v7q26846s");
		maitreOeuvreGeorges.setAdresse(new Adresse("35 boulevard JFK", null, "33700", "Mérignac"));

		maitreOeuvreBob = maitreOeuvreRepository.save(maitreOeuvreBob);
		maitreOeuvreGeorges = maitreOeuvreRepository.save(maitreOeuvreGeorges);

		// maitre d'ouvrage
		MaitreOuvrage maitreOuvrageToto = new MaitreOuvrage("Toto", "4653413", "0618753492", "toto@maitredouvrage.fr",
				"f6534r31e");
		maitreOuvrageToto.setAdresse(new Adresse("18 avenue des toto", null, "33700", "TotoVille"));
		MaitreOuvrage maitreOuvrageBobby = new MaitreOuvrage("Bobby", "1675923", "0679315862",
				"bobby@maitredouvrage.fr", "f23s5642fq12s674");
		maitreOuvrageBobby.setAdresse(new Adresse("32 rue des bobby", null, "33700", "BobbyVille"));

		maitreOuvrageToto = maitreOuvrageRepository.save(maitreOuvrageToto);
		maitreOuvrageBobby = maitreOuvrageRepository.save(maitreOuvrageBobby);

		// appel offre
		AppelOffre appelOffreMaison = new AppelOffre("maison", "construction d'une maison", 33000F, sdf.parse("07/04/2021"), sdf.parse("07/04/2022"),
				sdf.parse("15/12/2021"), false, null);
		appelOffreMaison.setAdresse(new Adresse("18 avenue des hirondelles", null, "33700", "Mérignac"));
		AppelOffre appelOffreImmeuble = new AppelOffre("immeuble", "construction d'un immeuble de 5 étages", 65000F, sdf.parse("07/04/2021"),
				sdf.parse("07/04/2023"), sdf.parse("15/12/2021"), true, 45000F);
		appelOffreImmeuble.setAdresse(new Adresse("18 avenue des tulipes", null, "33700", "Mérignac"));
		appelOffreImmeuble.setAdresse(new Adresse("18 Avenue JFK", null, "33700", "Mérignac"));
		appelOffreMaison.setAdresse(new Adresse("35 Boulevard JFK", null, "33000", "Bordeaux"));

		appelOffreMaison = appelOffreRepository.save(appelOffreMaison);
		appelOffreImmeuble = appelOffreRepository.save(appelOffreImmeuble);

		// liens offre - maitre d'oeuvre / maitre d'ouvrage / appel d'offre
		offreToto.setMaitreOeuvre(maitreOeuvreGeorges);
		offreBobby.setMaitreOeuvre(maitreOeuvreBob);
		offreToto.setMaitreOuvrage(maitreOuvrageToto);
		offreBobby.setMaitreOuvrage(maitreOuvrageBobby);
		offreToto.setAppelOffre(appelOffreMaison);
		offreBobby.setAppelOffre(appelOffreImmeuble);

		offreToto = offreRepository.save(offreToto);
		offreBobby = offreRepository.save(offreBobby);
	}

	@Test
	public void prestataire() throws ParseException {
		// prestataire
		Prestataire colas = new Prestataire("COLAS", "448631348", "0593671425", "colas@groupecolas.fr",
				"153dff413sd21");
		colas.setAdresse(new Adresse("18 avenue des toto", null, "33700", "ColasVille"));
		Prestataire bouygues = new Prestataire("Bouygues", "133793512", "0534976125", "bouygues@bconstruction.fr",
				"f557d5142sd42");
		bouygues.setAdresse(new Adresse("18 avenue des toto", null, "33700", "BouyguesVille"));

		// utilisateur
		Utilisateur utilisateurprestaColas = new Utilisateur("COLAS", "motDePasse");
		Utilisateur utilisateurprestaBouygues = new Utilisateur("Bouygues", "essaPeDtoM");

		utilisateurprestaColas = utilisateurRepository.save(utilisateurprestaColas);
		utilisateurprestaBouygues = utilisateurRepository.save(utilisateurprestaBouygues);

		// lien prestataire - utilisateur
		colas.setUtilisateur(utilisateurprestaColas);
		bouygues.setUtilisateur(utilisateurprestaBouygues);

		colas = prestataireRepository.save(colas);
		bouygues = prestataireRepository.save(bouygues);
	}

	@Test
	public void prestation() throws ParseException {
		// prestation
		Prestation presta1 = new Prestation(Categorie.grosOeuvre, "Fondation", 10000F, sdf.parse("10/04/2020"),
				sdf.parse("10/05/2020"), false, PhasePresta.ValideEG);
		Prestation presta2 = new Prestation(Categorie.secondOeuvre, "Plomberie", 9000F, sdf.parse("15/09/2020"),
				sdf.parse("25/09/2020"), false, PhasePresta.ValideMOeuvre);

		// projet
		Projet projet1 = new Projet(9371, sdf.parse("07/04/2020"), sdf.parse("07/04/2021"), 1, "nouveau");
		Projet projet2 = new Projet(1457, sdf.parse("08/05/2021"), sdf.parse("10/12/2022"), 0, "rapport");

		projet1 = projetRepository.save(projet1);
		projet2 = projetRepository.save(projet2);

		// matériel
		Materiel sable = new Materiel("Sac de Sable", 5f, Unite.unite);
		Materiel grillage = new Materiel("Grillage", 18F, Unite.metreLineaire);
		Materiel rouleauCompresseur = new Materiel("Rouleau Compresseur", 1f, Unite.unite);

		sable = materielRepository.save(sable);
		grillage = materielRepository.save(grillage);
		rouleauCompresseur = materielRepository.save(rouleauCompresseur);

		// offre
		Offre offreToto = new Offre(60000F, 45, sdf.parse("07/04/2021"), sdf.parse("07/04/2023"), Etat.consult);
		Offre offreBobby = new Offre(32000F, 12, sdf.parse("08/08/2020"), sdf.parse("09/12/2024"), Etat.val);

		offreToto = offreRepository.save(offreToto);
		offreBobby = offreRepository.save(offreBobby);

		// prestataire
		Prestataire colas = new Prestataire("COLAS", "448631348", "0593671425", "colas@groupecolas.fr",
				"153dff413sd21");
		colas.setAdresse(new Adresse("18 avenue des toto", null, "33700", "ColasVille"));
		Prestataire bouygues = new Prestataire("Bouygues", "133793512", "0534976125", "bouygues@bconstruction.fr",
				"f557d5142sd42");
		bouygues.setAdresse(new Adresse("18 avenue des toto", null, "33700", "BouyguesVille"));

		colas = prestataireRepository.save(colas);
		bouygues = prestataireRepository.save(bouygues);

		// salarié
		Salarie jeanLouis = new Salarie("DUCHMON", "Jean-Louis", "Cariste");
		Salarie jeanJacques = new Salarie("TRUC", "Jean-Jacques", "Carreleur");

		jeanLouis = salarieRepository.save(jeanLouis);
		jeanJacques = salarieRepository.save(jeanJacques);

		// liens prestation - projet / métériels / offre / prestataire / salarié
		presta1.setProjet(projet1);
		presta2.setProjet(projet2);
		presta1.addMateriels(sable);
		presta1.addMateriels(rouleauCompresseur);
		presta2.addMateriels(grillage);
		presta1.setOffre(offreToto);
		presta2.setOffre(offreBobby);
		presta1.setPrestataire(colas);
		presta2.setPrestataire(bouygues);
		presta1.addSalaries(jeanLouis);
		presta2.addSalaries(jeanJacques);

		presta1 = prestationRepository.save(presta1);
		presta2 = prestationRepository.save(presta2);
	}

	@Test
	public void prestationSupplementaire() throws ParseException {
		// prestation supplémentaire
		PrestationSupplementaire prestaSupp1 = new PrestationSupplementaire(Categorie.grosOeuvre, "Applanissement",
				2000F, sdf.parse("10/04/2020"), sdf.parse("12/04/2020"), PhasePresta.enConsult);
		PrestationSupplementaire prestaSupp2 = new PrestationSupplementaire(Categorie.secondOeuvre, "Enduit", 950F,
				sdf.parse("20/04/2021"), sdf.parse("22/04/2021"), PhasePresta.ValideEG);

		// projet
		Projet projet1 = new Projet(9371, sdf.parse("07/04/2020"), sdf.parse("07/04/2021"), 1, "nouveau");
		Projet projet2 = new Projet(1457, sdf.parse("08/05/2021"), sdf.parse("10/12/2022"), 0, "rapport");

		projet1 = projetRepository.save(projet1);
		projet2 = projetRepository.save(projet2);

		// matériel
		Materiel sable = new Materiel("Sac de Sable", 5f, Unite.unite);
		Materiel grillage = new Materiel("Grillage", 18F, Unite.metreLineaire);
		Materiel rouleauCompresseur = new Materiel("Rouleau Compresseur", 1f, Unite.unite);

		sable = materielRepository.save(sable);
		grillage = materielRepository.save(grillage);
		rouleauCompresseur = materielRepository.save(rouleauCompresseur);

		// prestataire
		Prestataire colas = new Prestataire("COLAS", "448631348", "0593671425", "colas@groupecolas.fr",
				"153dff413sd21");
		colas.setAdresse(new Adresse("18 avenue des toto", null, "33700", "ColasVille"));
		Prestataire bouygues = new Prestataire("Bouygues", "133793512", "0534976125", "bouygues@bconstruction.fr",
				"f557d5142sd42");
		bouygues.setAdresse(new Adresse("18 avenue des toto", null, "33700", "BouyguesVille"));

		colas = prestataireRepository.save(colas);
		bouygues = prestataireRepository.save(bouygues);

		// prestation
		Prestation presta1 = new Prestation(Categorie.grosOeuvre, "Fondation", 10000F, sdf.parse("10/04/2020"),
				sdf.parse("10/05/2020"), false, PhasePresta.ValideEG);
		Prestation presta2 = new Prestation(Categorie.secondOeuvre, "Plomberie", 9000F, sdf.parse("15/09/2020"),
				sdf.parse("25/09/2020"), false, PhasePresta.ValideMOeuvre);

		presta1 = prestationRepository.save(presta1);
		presta2 = prestationRepository.save(presta2);

		// salarié
		Salarie jeanLouis = new Salarie("DUCHMON", "Jean-Louis", "Cariste");
		Salarie jeanJacques = new Salarie("TRUC", "Jean-Jacques", "Carreleur");

		jeanLouis = salarieRepository.save(jeanLouis);
		jeanJacques = salarieRepository.save(jeanJacques);

		// liens prestation supplémentaire - projet / matériels / offre / prestataire /
		// salarié
		prestaSupp1.setProjet(projet1);
		prestaSupp2.setProjet(projet2);
		prestaSupp1.addMateriels(sable);
		prestaSupp1.addMateriels(rouleauCompresseur);
		prestaSupp2.addMateriels(grillage);
		prestaSupp1.setPrestataire(colas);
		prestaSupp2.setPrestataire(bouygues);
		prestaSupp1.setPrestation(presta1);
		prestaSupp2.setPrestation(presta2);
		prestaSupp1.addSalaries(jeanLouis);
		prestaSupp2.addSalaries(jeanJacques);

		prestaSupp1 = prestationSupplementaireRepository.save(prestaSupp1);
		prestaSupp2 = prestationSupplementaireRepository.save(prestaSupp2);
	}

	@Test
	public void projet() throws ParseException {
		// projet
		Projet projet1 = new Projet(9371, sdf.parse("07/04/2020"), sdf.parse("07/04/2021"), 1, "nouveau");
		Projet projet2 = new Projet(1457, sdf.parse("08/05/2021"), sdf.parse("10/12/2022"), 0, "rapport");

		// offre
		Offre offreToto = new Offre(60000F, 45, sdf.parse("07/04/2021"), sdf.parse("07/04/2023"), Etat.consult);
		Offre offreBobby = new Offre(32000F, 12, sdf.parse("08/08/2020"), sdf.parse("09/12/2024"), Etat.val);

		offreToto = offreRepository.save(offreToto);
		offreBobby = offreRepository.save(offreBobby);

		// lien projet - offre
		projet1.setOffre(offreToto);
		projet2.setOffre(offreBobby);

		projet1 = projetRepository.save(projet1);
		projet2 = projetRepository.save(projet2);
	}

	@Test
	public void reunion() throws ParseException {
		// réunion
		Reunion reunion1 = new Reunion("mise en place", 1, sdf.parse("08/04/2020"));
		Reunion reunion2 = new Reunion("avancement", 2, sdf.parse("18/05/2020"));

		// projet
		Projet projet1 = new Projet(9371, sdf.parse("07/04/2020"), sdf.parse("07/04/2021"), 1, "nouveau");
		Projet projet2 = new Projet(1457, sdf.parse("08/05/2021"), sdf.parse("10/12/2022"), 0, "rapport");

		projet1 = projetRepository.save(projet1);
		projet2 = projetRepository.save(projet2);

		// lien réunion - projet
		reunion1.setProjet(projet1);
		reunion2.setProjet(projet2);

		reunion1 = reunionRepository.save(reunion1);
		reunion2 = reunionRepository.save(reunion2);
	}

	@Test
	public void salarie() throws ParseException {
		// salarié
		Salarie jeanLouis = new Salarie("DUCHMON", "Jean-Louis", "Cariste");
		Salarie jeanJacques = new Salarie("TRUC", "Jean-Jacques", "Carreleur");

		// prestataire
		Prestataire colas = new Prestataire("COLAS", "448631348", "0593671425", "colas@groupecolas.fr",
				"153dff413sd21");
		colas.setAdresse(new Adresse("18 avenue des toto", null, "33700", "ColasVille"));
		Prestataire bouygues = new Prestataire("Bouygues", "133793512", "0534976125", "bouygues@bconstruction.fr",
				"f557d5142sd42");
		bouygues.setAdresse(new Adresse("18 avenue des toto", null, "33700", "BouyguesVille"));

		colas = prestataireRepository.save(colas);
		bouygues = prestataireRepository.save(bouygues);

		// prestation
		Prestation presta1 = new Prestation(Categorie.grosOeuvre, "Fondation", 10000F, sdf.parse("10/04/2020"),
				sdf.parse("10/05/2020"), false, PhasePresta.ValideEG);
		Prestation presta2 = new Prestation(Categorie.secondOeuvre, "Plomberie", 9000F, sdf.parse("15/09/2020"),
				sdf.parse("25/09/2020"), false, PhasePresta.ValideMOeuvre);

		presta1 = prestationRepository.save(presta1);
		presta2 = prestationRepository.save(presta2);

		// prestation supplémentaire
		PrestationSupplementaire prestaSupp1 = new PrestationSupplementaire(Categorie.grosOeuvre, "Applanissement",
				2000F, sdf.parse("10/04/2020"), sdf.parse("12/04/2020"), PhasePresta.enConsult);
		PrestationSupplementaire prestaSupp2 = new PrestationSupplementaire(Categorie.secondOeuvre, "Enduit", 950F,
				sdf.parse("20/04/2021"), sdf.parse("22/04/2021"), PhasePresta.ValideEG);

		prestaSupp1 = prestationSupplementaireRepository.save(prestaSupp1);
		prestaSupp2 = prestationSupplementaireRepository.save(prestaSupp2);

		// action
		Action isolation = new Action("Isolation", sdf.parse("12/04/2020"), sdf.parse("15/05/2020"),
				"Laine de verre charpente", false);
		Action cloture = new Action("Clôture", sdf.parse("15/07/2020"), sdf.parse("25/07/2020"), "Réparer clôture",
				true);

		isolation = actionRepository.save(isolation);
		cloture = actionRepository.save(cloture);

		// liens salarié - prestataire / prestation / prestation supplémentaire / action
		jeanLouis.setPrestataire(colas);
		jeanJacques.setPrestataire(bouygues);
		jeanLouis.addPrestation(presta1);
		jeanJacques.addPrestation(presta2);
		jeanLouis.addPrestationSupplementaires(prestaSupp1);
		jeanJacques.addPrestationSupplementaires(prestaSupp2);
		jeanLouis.addActions(isolation);
		jeanJacques.addActions(cloture);

		jeanLouis = salarieRepository.save(jeanLouis);
		jeanJacques = salarieRepository.save(jeanJacques);
	}

	@Test
	public void utilisateur() throws ParseException {
		// utilisateurs
		Utilisateur utilisateurmaitreOeuvreBob = new Utilisateur("Bob", "123456789");
		Utilisateur utilisateurmaitreOeuvreGeorges = new Utilisateur("Georges", "987654321");
		Utilisateur utilisateurmaitreOuvrageToto = new Utilisateur("Toto", "aertyuiop");
		Utilisateur utilisateurmaitreOuvrageBobby = new Utilisateur("Bobby", "poiuytreza");
		Utilisateur utilisateurprestaColas = new Utilisateur("COLAS", "motDePasse");
		Utilisateur utilisateurprestaBouygues = new Utilisateur("Bouygues", "essaPeDtoM");

		utilisateurmaitreOeuvreBob = utilisateurRepository.save(utilisateurmaitreOeuvreBob);
		utilisateurmaitreOeuvreGeorges = utilisateurRepository.save(utilisateurmaitreOeuvreGeorges);
		utilisateurmaitreOuvrageToto = utilisateurRepository.save(utilisateurmaitreOuvrageToto);
		utilisateurmaitreOuvrageBobby = utilisateurRepository.save(utilisateurmaitreOuvrageBobby);
		utilisateurprestaColas = utilisateurRepository.save(utilisateurprestaColas);
		utilisateurprestaBouygues = utilisateurRepository.save(utilisateurprestaBouygues);
	}

}
