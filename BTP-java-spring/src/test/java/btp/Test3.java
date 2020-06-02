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
class Test3 {

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
	public void test() throws ParseException {
		
				// action pour bouygues sur projet 4
				Action isolation = new Action("Isolation", sdf.parse("12/04/2020"), sdf.parse("15/05/2020"),
						"Laine de verre charpente", true);
				Action cloture = new Action("Clôture", sdf.parse("15/07/2020"), sdf.parse("25/07/2020"), "Réparer clôture",
						true);
				Action action1 = new Action("Tranchée", sdf.parse("12/04/2020"), sdf.parse("15/05/2020"),
						"Creuser tranchée canalisations", true);
				Action action2 = new Action("Vider fosse", sdf.parse("15/07/2020"), sdf.parse("25/07/2020"), "Vider fosse",
						true);
				Action action3 = new Action("Préparation outils", sdf.parse("12/04/2020"), sdf.parse("15/05/2020"),
						"Préparer chantier suivant", false);
				Action action4 = new Action("Tomber/Remonter cloison", sdf.parse("15/07/2020"), sdf.parse("25/07/2020"), "Cloison non conforme au plans, refaire",
						false);
				Action action5 = new Action("Vérifier Install Elec", sdf.parse("12/04/2020"), sdf.parse("15/05/2020"),
						"Verification des installations electriques", false);
				Action action6 = new Action("Nettoyage", sdf.parse("15/07/2020"), sdf.parse("25/07/2020"), "Nettoyer pour presta suivante",
						false);
				
				
				// appel offre
				AppelOffre appelOffreMaison = new AppelOffre("Maison", "construction d'une maison", 150000F, sdf.parse("07/04/2020"), sdf.parse("07/04/2021"),
						sdf.parse("15/03/2020"), false, null);
				appelOffreMaison.setAdresse(new Adresse("18 avenue des hirondelles", null, "33700", "Mérignac"));
				AppelOffre appelOffreImmeuble = new AppelOffre("Immeuble", "construction d'un immeuble de 5 étages", 3000000F, sdf.parse("07/04/2021"),
						sdf.parse("07/04/2023"), sdf.parse("15/12/2020"), false, null);
				appelOffreImmeuble.setAdresse(new Adresse("18 avenue des tulipes", null, "33700", "Mérignac"));
				
				//Appels offres pour projets en cours 
				AppelOffre appelOffre3 = new AppelOffre("Mairie Pessac", "Reconstruction de toute la mairie", 600000F, sdf.parse("10/03/2020"),
						sdf.parse("25/07/2020"), sdf.parse("06/01/2020"), false, null);
				appelOffre3.setAdresse(new Adresse("15 rue des Lilas", null, "33600", "Pessac"));
				
				AppelOffre appelOffre4 = new AppelOffre("Maison", "construction d'une maison", 1000000F, sdf.parse("25/02/2020"),
						sdf.parse("07/04/2021"), sdf.parse("15/12/2019"), false, null);
				appelOffre4.setAdresse(new Adresse("2 avenue du Général de Gaulle", null, "33400", "Talence"));
				
				AppelOffre appelOffre5 = new AppelOffre("Intermarché St Médard", "construction du supermarché", 2500000F, sdf.parse("07/04/2021"),
						sdf.parse("07/04/2023"), sdf.parse("15/12/2020"), false, null);
				appelOffre5.setAdresse(new Adresse("18 rue Jean Jaures", null, "33160", "St Médard en Jalles"));
				
				AppelOffre appelOffre6 = new AppelOffre("Gare Mérignac", "Travaux gare Mérignac Arlac", 570000F, sdf.parse("15/05/2020"),
						sdf.parse("16/02/2022"), sdf.parse("15/01/2020"), false, null);
				appelOffre6.setAdresse(new Adresse("54 rue Frédéric Chopin", null, "33700", "Mérignac"));
				
				//save Appel offre
				appelOffre3 = appelOffreRepository.save(appelOffre3);
				appelOffre4 = appelOffreRepository.save(appelOffre4);
				appelOffre5 = appelOffreRepository.save(appelOffre5);
				appelOffre6 = appelOffreRepository.save(appelOffre6);
				
				//Appel offres en attente
				
				AppelOffre appelOffre7 = new AppelOffre("Lidl Talence", "Construction du supermarché", 600000F, sdf.parse("10/08/2020"),
						sdf.parse("25/11/2020"), sdf.parse("06/05/2020"), false, null);
				appelOffre7.setAdresse(new Adresse("15 rue François Bordes", null, "33400", "Talence"));
				
				AppelOffre appelOffre8 = new AppelOffre("Immeuble", "construction d'un immeuble de 8 étages", 1500000F, sdf.parse("12/01/2021"),
						sdf.parse("21/05/2024"), sdf.parse("08/10/2020"), false, null);
				appelOffre8.setAdresse(new Adresse("2 avenue du Général de Gaulle", null, "33000", "Bordeaux"));
				
				AppelOffre appelOffre9 = new AppelOffre("Parc Panneau Solaire", "construction d'un champ solaire", 3000000F, sdf.parse("02/10/2020"),
						sdf.parse("10/06/2022"), sdf.parse("19/08/2020"), false, null);
				appelOffre9.setAdresse(new Adresse("Route de Bayonne", null, "33610", "Cestas"));
				
				AppelOffre appelOffre10 = new AppelOffre("Résidence Universitaire", "Construction d'un résidence", 1600000F, sdf.parse("11/09/2020"),
						sdf.parse("16/02/2022"), sdf.parse("16/05/2020"), false, null);
				appelOffre10.setAdresse(new Adresse("25 avenue des Martyrs", null, "33150", "Cenon"));
				
				//save appel offres attente
				
				appelOffre7 = appelOffreRepository.save(appelOffre7);
				appelOffre8 = appelOffreRepository.save(appelOffre8);
				appelOffre9 = appelOffreRepository.save(appelOffre9);
				appelOffre10 = appelOffreRepository.save(appelOffre10);
				

				// offre 
				Offre offre3 = new Offre(650000F, 48, sdf.parse("10/03/2020"), sdf.parse("25/07/2020"), Etat.val);
				Offre offre4 = new Offre(900000F, 49, sdf.parse("25/02/2020"), sdf.parse("07/04/2021"), Etat.val);
				Offre offre5 = new Offre(2300000F, 50, sdf.parse("07/04/2021"), sdf.parse("07/04/2023"), Etat.val);
				Offre offre6 = new Offre(500000F, 51, sdf.parse("15/05/2020"), sdf.parse("16/02/2022"), Etat.val);
				
				//save offre
				offre3 = offreRepository.save(offre3);
				offre4 = offreRepository.save(offre4);
				offre5 = offreRepository.save(offre5);
				offre6 = offreRepository.save(offre6);
				
				
				Offre offre7 = new Offre(60000F, 52, sdf.parse("10/08/2020"), sdf.parse("25/11/2020"), Etat.consult);
				Offre offre8 = new Offre(32000F, 53, sdf.parse("12/01/2021"), sdf.parse("21/05/2024"), Etat.consult);
				Offre offre9 = new Offre(60000F, 54, sdf.parse("02/10/2020"), sdf.parse("10/06/2022"), Etat.consult);
				Offre offre10 = new Offre(32000F, 55, sdf.parse("11/09/2020"), sdf.parse("16/02/2022"), Etat.consult);
				
				//save offre
				offre7 = offreRepository.save(offre7);
				offre8 = offreRepository.save(offre8);
				offre9 = offreRepository.save(offre9);
				offre10 = offreRepository.save(offre10);
				
				Offre offreToto = new Offre(60000F, 45, sdf.parse("07/04/2021"), sdf.parse("07/04/2023"), Etat.consult);
				Offre offreBobby = new Offre(32000F, 12, sdf.parse("08/08/2020"), sdf.parse("09/12/2024"), Etat.val);
				
				//projet
				Projet projet3 = new Projet(9371, sdf.parse("10/03/2020"), sdf.parse("25/07/2020"), 0, null);
				Projet projet4 = new Projet(1457, sdf.parse("25/02/2020"), sdf.parse("07/04/2021"), 0, null);
				Projet projet5 = new Projet(4589, sdf.parse("07/04/2021"), sdf.parse("07/04/2023"), 0, null);
				Projet projet6 = new Projet(6514, sdf.parse("15/05/2020"), sdf.parse("16/02/2022"), 0, null);
				
				//save projet
				projet3 = projetRepository.save(projet3);
				projet4 = projetRepository.save(projet4);
				projet5 = projetRepository.save(projet5);
				projet6 = projetRepository.save(projet6);
				
				// facture
				Facture factureIsolation = new Facture(111, sdf.parse("15/05/2020"), 5000F, 0F, sdf.parse("15/06/2020"), 0F,
						true,false);
				Facture factureCloture = new Facture(45, sdf.parse("18/01/2021"), 5000F, 15F, sdf.parse("21/02/2022"), 52F,
						false,false);
				
				Facture factureProjetMoisSeptembre = new Facture(153453, sdf.parse("16/06/2020"), 5000F, 0F, sdf.parse("15/08/2020"), 0F,
						true,true);
				Facture factureMoisNovembre = new Facture(83843, sdf.parse("18/06/2021"), 5000F, 15F, sdf.parse("21/08/2022"), 52F,
						false,true);
				
				
				
				
				
				
				// maitre d'oeuvre
				MaitreOeuvre maitreOeuvreBob = new MaitreOeuvre("Philippe LeBras", "14521256431", "0649753159", "philippe.lebras@moeuvre.fr",
						"354f435f41f");
				maitreOeuvreBob.setAdresse(new Adresse("16 rue JFK", "3e étage", "33700", "Mérignac"));
				MaitreOeuvre maitreOeuvreGeorges = new MaitreOeuvre("Georges Henri", "16793458", "0734159382",
						"georges@maitredoeuvre.fr", "531p5v7q26846s");
				maitreOeuvreGeorges.setAdresse(new Adresse("35 boulevard JFK", null, "33700", "Mérignac"));
				
				
				// maitre d'ouvrage
				MaitreOuvrage maitreOuvrageToto = new MaitreOuvrage("Didier Marty", "4653413", "0618753492", "didier.marty@mouvrage.fr",
						"f6534r31e");
				maitreOuvrageToto.setAdresse(new Adresse("18 avenue des toto", null, "33700", "TotoVille"));
				MaitreOuvrage maitreOuvrageBobby = new MaitreOuvrage("Benoit Proust", "1675923", "0679315862",
						"benoit.proust@maitredouvrage.fr", "f23s5642fq12s674");
				maitreOuvrageBobby.setAdresse(new Adresse("32 rue du bourg", null, "33000", "Bordeaux"));
				
				
				// matériel
				Materiel sable = new Materiel("Sac de Sable", 5, Unite.unite);
				Materiel grillage = new Materiel("Grillage", 18, Unite.metreLineaire);
				Materiel rouleauCompresseur = new Materiel("Rouleau Compresseur", 1, Unite.unite);
				
				
				
				
				// prestataire
				Prestataire colas = new Prestataire("COLAS", "448631348", "0593671425", "colas@groupecolas.fr",
						"153dff413sd21");
				colas.setAdresse(new Adresse("18 avenue des tournesols", null, "47000", "Agen"));
				Prestataire bouygues = new Prestataire("Bouygues", "133793512", "0534976125", "bouygues@bconstruction.fr",
						"f557d5142sd42");
				bouygues.setAdresse(new Adresse("18 avenue des champs", null, "33500", "Libourne"));
				
				
				// prestation
				Prestation presta1 = new Prestation(Categorie.grosOeuvre, "Fondation", 25000F, sdf.parse("25/02/2020"),
						sdf.parse("10/03/2020"), false, PhasePresta.ValideMOeuvre);
				Prestation presta2 = new Prestation(Categorie.grosOeuvre, "Maçonerie", 30000F, sdf.parse("11/03/2020"),
						sdf.parse("25/04/2020"), false, PhasePresta.ValideMOeuvre);
				Prestation presta3 = new Prestation(Categorie.grosOeuvre, "Charpente", 20000F, sdf.parse("25/04/2020"),
						sdf.parse("25/05/2020"), false, PhasePresta.ValideMOeuvre);
				Prestation presta4 = new Prestation(Categorie.secondOeuvre, "Placo", 9000F, sdf.parse("25/05/2020"),
						sdf.parse("25/06/2020"), false, PhasePresta.ValideMOeuvre);
				Prestation presta5 = new Prestation(Categorie.secondOeuvre, "Elec", 6000F, sdf.parse("15/05/2020"),
						sdf.parse("25/06/2020"), false, PhasePresta.ValideMOeuvre);
				Prestation presta6 = new Prestation(Categorie.secondOeuvre, "Plomberie", 6000F, sdf.parse("28/05/2020"),
						sdf.parse("12/06/2020"), false, PhasePresta.ValideMOeuvre);
				Prestation presta7 = new Prestation(Categorie.secondOeuvre, "CVC", 10000F, sdf.parse("15/06/2020"),
						sdf.parse("25/07/2020"), false, PhasePresta.ValideMOeuvre);
				Prestation presta8 = new Prestation(Categorie.secondOeuvre, "Toiture", 15000F, sdf.parse("27/07/2020"),
						sdf.parse("25/09/2020"), false, PhasePresta.ValideMOeuvre);
				Prestation presta9 = new Prestation(Categorie.secondOeuvre, "Finitions", 9000F, sdf.parse("15/09/2020"),
						sdf.parse("02/01/2021"), false, PhasePresta.ValideMOeuvre);
				Prestation presta10 = new Prestation(Categorie.secondOeuvre, "Cloisons", 8000F, sdf.parse("15/01/2021"),
						sdf.parse("25/05/2021"), false, PhasePresta.ValideMOeuvre);
				
				
				
				
				// prestation supplémentaire
				PrestationSupplementaire prestaSupp1 = new PrestationSupplementaire(Categorie.grosOeuvre, "Applanissement",
						2000F, sdf.parse("10/04/2020"), sdf.parse("12/04/2020"), PhasePresta.enConsult);
				PrestationSupplementaire prestaSupp2 = new PrestationSupplementaire(Categorie.secondOeuvre, "Enduit", 950F,
						sdf.parse("20/04/2021"), sdf.parse("22/04/2021"), PhasePresta.ValideEG);
				
				
				// projet
				Projet projet1 = new Projet(9371, sdf.parse("07/04/2020"), sdf.parse("07/04/2021"), 1, "nouveau");
				Projet projet2 = new Projet(1457, sdf.parse("08/05/2021"), sdf.parse("10/12/2022"), 0, "rapport");
				
				// réunion
				Reunion reunion1 = new Reunion("mise en place", 1, sdf.parse("08/04/2020"));
				Reunion reunion2 = new Reunion("avancement", 2, sdf.parse("18/05/2020"));
				
				
				// salariés
				Salarie jeanLouis = new Salarie( "DUCHMON", "Jean-Louis", "Manoeuvre");
				Salarie jeanJacques = new Salarie( "TRUC", "Jean-Jacques", "Manoeuvre");
				Salarie salarie1 = new Salarie( "DUPONT", "Jean", "Electricien");
				Salarie salarie2 = new Salarie( "BLANC", "Gilles", "Plombier");
				Salarie salarie3 = new Salarie( "DUTEIL", "Michel", "Plaquiste");
				Salarie salarie4 = new Salarie("MARCEAU", "Yves", "Plaquiste");
				Salarie salarie5 = new Salarie( "PRADEL", "Sylvain", "Maçon");
				Salarie salarie6 = new Salarie( "HINAULT", "François", "Charpentier");
				
				
				// utilisateurs
				Utilisateur utilisateurmaitreOeuvreBob = new Utilisateur("Bob", "123456789");
				Utilisateur utilisateurmaitreOeuvreGeorges = new Utilisateur("Georges", "987654321");
				Utilisateur utilisateurmaitreOuvrageToto = new Utilisateur("Toto", "aertyuiop");
				Utilisateur utilisateurmaitreOuvrageBobby = new Utilisateur("Bobby", "poiuytreza");
				Utilisateur utilisateurprestaColas = new Utilisateur("COLAS", "motDePasse");
				Utilisateur utilisateurprestaBouygues = new Utilisateur("Bouygues", "essaPeDtoM");
				
				
				//save action
				isolation = actionRepository.save(isolation);
				cloture = actionRepository.save(cloture);
				action1 = actionRepository.save(action1);
				action2 = actionRepository.save(action2);
				action3 = actionRepository.save(action3);
				action4 = actionRepository.save(action4);
				action5 = actionRepository.save(action5);
				action6 = actionRepository.save(action6);
				
				
				
				appelOffreMaison = appelOffreRepository.save(appelOffreMaison);
				appelOffreImmeuble = appelOffreRepository.save(appelOffreImmeuble);
				
				factureIsolation = factureRepository.save(factureIsolation);
				factureCloture = factureRepository.save(factureCloture);
				factureMoisNovembre = factureRepository.save(factureMoisNovembre);
				factureProjetMoisSeptembre = factureRepository.save(factureProjetMoisSeptembre);
				
				maitreOeuvreBob = maitreOeuvreRepository.save(maitreOeuvreBob);
				maitreOeuvreGeorges = maitreOeuvreRepository.save(maitreOeuvreGeorges);
				
				maitreOuvrageToto = maitreOuvrageRepository.save(maitreOuvrageToto);
				maitreOuvrageBobby = maitreOuvrageRepository.save(maitreOuvrageBobby);
				
				sable = materielRepository.save(sable);
				grillage = materielRepository.save(grillage);
				rouleauCompresseur = materielRepository.save(rouleauCompresseur);
				
				offreToto = offreRepository.save(offreToto);
				offreBobby = offreRepository.save(offreBobby);
				
				colas = prestataireRepository.save(colas);
				bouygues = prestataireRepository.save(bouygues);
				
				//save presta
				
				presta1 = prestationRepository.save(presta1);
				presta2 = prestationRepository.save(presta2);
				presta3 = prestationRepository.save(presta3);
				presta4 = prestationRepository.save(presta4);
				presta5 = prestationRepository.save(presta5);
				presta6 = prestationRepository.save(presta6);
				presta7 = prestationRepository.save(presta7);
				presta8 = prestationRepository.save(presta8);
				presta9 = prestationRepository.save(presta9);
				presta10 = prestationRepository.save(presta10);
				
				
				prestaSupp1 = prestationSupplementaireRepository.save(prestaSupp1);
				prestaSupp2 = prestationSupplementaireRepository.save(prestaSupp2);
				
				projet1 = projetRepository.save(projet1);
				projet2 = projetRepository.save(projet2);
				
				reunion1 = reunionRepository.save(reunion1);
				reunion2 = reunionRepository.save(reunion2);
				
				
				// save salarie
				jeanLouis = salarieRepository.save(jeanLouis);
				jeanJacques = salarieRepository.save(jeanJacques);
				salarie1 = salarieRepository.save(salarie1);
				salarie2 = salarieRepository.save(salarie2);
				salarie3 = salarieRepository.save(salarie3);
				salarie4 = salarieRepository.save(salarie4);
				salarie5 = salarieRepository.save(salarie5);
				salarie6 = salarieRepository.save(salarie6);
				
				
				utilisateurmaitreOeuvreBob = utilisateurRepository.save(utilisateurmaitreOeuvreBob);
				utilisateurmaitreOeuvreGeorges = utilisateurRepository.save(utilisateurmaitreOeuvreGeorges);
				
				utilisateurmaitreOuvrageToto = utilisateurRepository.save(utilisateurmaitreOuvrageToto);
				utilisateurmaitreOuvrageBobby = utilisateurRepository.save(utilisateurmaitreOuvrageBobby);
				
				utilisateurprestaColas = utilisateurRepository.save(utilisateurprestaColas);
				utilisateurprestaBouygues = utilisateurRepository.save(utilisateurprestaBouygues);


				// liens actions / prestataire - projet
				isolation.setPrestataire(colas);
				cloture.setPrestataire(bouygues);
				isolation.setProjet(projet1);
				cloture.setProjet(projet2);
				
				action1.setPrestataire(bouygues);
				action2.setPrestataire(bouygues);
				action3.setPrestataire(bouygues);
				action4.setPrestataire(bouygues);
				action5.setPrestataire(bouygues);
				action6.setPrestataire(bouygues);
				
				action1.setProjet(projet4);
				action2.setProjet(projet4);
				action3.setProjet(projet4);
				action4.setProjet(projet4);
				action5.setProjet(projet4);
				action6.setProjet(projet4);
				
				
				// lien appel d'offre - maitre d'ouvrage
				appelOffreMaison.setMaitreOuvrage(maitreOuvrageToto);
				appelOffreImmeuble.setMaitreOuvrage(maitreOuvrageBobby);
				appelOffre3.setMaitreOuvrage(maitreOuvrageBobby);
				appelOffre4.setMaitreOuvrage(maitreOuvrageBobby);
				appelOffre5.setMaitreOuvrage(maitreOuvrageBobby);
				appelOffre6.setMaitreOuvrage(maitreOuvrageBobby);
				appelOffre7.setMaitreOuvrage(maitreOuvrageBobby);
				appelOffre8.setMaitreOuvrage(maitreOuvrageBobby);
				appelOffre9.setMaitreOuvrage(maitreOuvrageBobby);
				appelOffre10.setMaitreOuvrage(maitreOuvrageBobby);
				
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
				
				factureProjetMoisSeptembre.setMaitreOeuvre(maitreOeuvreBob);
				factureProjetMoisSeptembre.setMaitreOuvrage(maitreOuvrageBobby);
				factureMoisNovembre.setMaitreOeuvre(maitreOeuvreGeorges);
				factureMoisNovembre.setMaitreOuvrage(maitreOuvrageToto);
				factureProjetMoisSeptembre.setProjet(projet1);
				factureMoisNovembre.setProjet(projet1);

				// lien maitre d'oeuvre - utilisateur
				maitreOeuvreBob.setUtilisateur(utilisateurmaitreOeuvreBob);
				maitreOeuvreGeorges.setUtilisateur(utilisateurmaitreOeuvreGeorges);

				// lien maitre d'ouvrage - utilisateur
				maitreOuvrageBobby.setUtilisateur(utilisateurmaitreOuvrageBobby);
				maitreOuvrageToto.setUtilisateur(utilisateurmaitreOuvrageToto);
				
				// lien matériel - prestataire
				sable.setPrestataire(colas);
				grillage.setPrestataire(bouygues);
				rouleauCompresseur.setPrestataire(colas);

				// liens offre - maitre d'oeuvre / maitre d'ouvrage / appel d'offre
				offreToto.setMaitreOeuvre(maitreOeuvreGeorges);
				offreBobby.setMaitreOeuvre(maitreOeuvreBob);
				offreToto.setMaitreOuvrage(maitreOuvrageToto);
				offreBobby.setMaitreOuvrage(maitreOuvrageBobby);
				offreToto.setAppelOffre(appelOffreMaison);
				offreBobby.setAppelOffre(appelOffreImmeuble);
				
				offre3.setMaitreOeuvre(maitreOeuvreGeorges);
				offre3.setMaitreOuvrage(maitreOuvrageBobby);
				offre4.setMaitreOeuvre(maitreOeuvreGeorges);
				offre4.setMaitreOuvrage(maitreOuvrageBobby);
				offre5.setMaitreOeuvre(maitreOeuvreGeorges);
				offre5.setMaitreOuvrage(maitreOuvrageBobby);
				offre6.setMaitreOeuvre(maitreOeuvreGeorges);
				offre6.setMaitreOuvrage(maitreOuvrageBobby);
				offre7.setMaitreOeuvre(maitreOeuvreGeorges);
				offre7.setMaitreOuvrage(maitreOuvrageBobby);
				offre8.setMaitreOeuvre(maitreOeuvreGeorges);
				offre8.setMaitreOuvrage(maitreOuvrageBobby);
				offre9.setMaitreOeuvre(maitreOeuvreGeorges);
				offre9.setMaitreOuvrage(maitreOuvrageBobby);
				offre10.setMaitreOeuvre(maitreOeuvreGeorges);
				offre10.setMaitreOuvrage(maitreOuvrageBobby);
				
				
				//lien appel offre / offre
				offre3.setAppelOffre(appelOffre3);
				offre4.setAppelOffre(appelOffre4);
				offre5.setAppelOffre(appelOffre4);
				offre6.setAppelOffre(appelOffre5);
				offre7.setAppelOffre(appelOffre6);
				offre8.setAppelOffre(appelOffre7);
				offre9.setAppelOffre(appelOffre8);
				offre10.setAppelOffre(appelOffre10);

				// lien prestataire - utilisateur
				colas.setUtilisateur(utilisateurprestaColas);
				bouygues.setUtilisateur(utilisateurprestaBouygues);

				// liens prestation - projet / métériels / offre / prestataire / salarié
				presta1.setProjet(projet4);
				presta2.setProjet(projet4);
				presta3.setProjet(projet4);
				presta4.setProjet(projet4);
				presta5.setProjet(projet4);
				presta6.setProjet(projet4);
				presta7.setProjet(projet4);
				presta8.setProjet(projet4);
				presta9.setProjet(projet4);
				presta10.setProjet(projet4);
				
				
				presta1.addMateriels(sable);
				presta1.addMateriels(rouleauCompresseur);
				presta2.addMateriels(grillage);
				
				presta1.setOffre(offre4);
				presta2.setOffre(offre4);
				presta3.setOffre(offre4);
				presta4.setOffre(offre4);
				presta5.setOffre(offre4);
				presta6.setOffre(offre4);
				presta7.setOffre(offre4);
				presta8.setOffre(offre4);
				presta9.setOffre(offre4);
				presta10.setOffre(offre4);
				
				presta1.setPrestataire(bouygues);
				presta2.setPrestataire(bouygues);
				presta3.setPrestataire(bouygues);
				presta4.setPrestataire(bouygues);
				presta5.setPrestataire(bouygues);
				presta6.setPrestataire(bouygues);
				presta7.setPrestataire(bouygues);
				presta8.setPrestataire(bouygues);
				presta9.setPrestataire(bouygues);
				presta10.setPrestataire(bouygues);
				
				
				presta1.addSalaries(jeanLouis);
				presta1.addSalaries(jeanJacques);
				presta1.addSalaries(salarie5);
				
				presta2.addSalaries(jeanLouis);
				presta2.addSalaries(jeanJacques);
				presta2.addSalaries(salarie5);
				
				presta3.addSalaries(salarie6);
				presta3.addSalaries(jeanLouis);
				
				presta4.addSalaries(salarie3);
				presta4.addSalaries(salarie4);
				
				presta5.addSalaries(salarie1);
				presta5.addSalaries(jeanLouis);
				
				presta6.addSalaries(salarie2);
				presta6.addSalaries(jeanJacques);
				
				//lien action salarie
			
				action1.addSalaries(jeanLouis);
				action1.addSalaries(jeanJacques);
				
				action2.addSalaries(jeanLouis);
				action2.addSalaries(jeanJacques);
				
				

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

				// lien projet - offre / appel offre ( en cours )
				projet1.setOffre(offreToto);
				projet2.setOffre(offreBobby);
				
				projet4.setOffre(offre4);
				offre4.setAppelOffre(appelOffre4);
				
				projet5.setOffre(offre5);
				offre5.setAppelOffre(appelOffre5);
				
				projet6.setOffre(offre6);
				offre6.setAppelOffre(appelOffre6);
				

				//lien offre appel offre (en attente)
				offre7.setAppelOffre(appelOffre7);
				
				offre8.setAppelOffre(appelOffre8);
				
				offre9.setAppelOffre(appelOffre9);
				
				offre10.setAppelOffre(appelOffre10);

				// lien réunion - projet
				reunion1.setProjet(projet4);
				reunion2.setProjet(projet4);

				// liens salarié - prestataire / prestation / prestation supplémentaire / action
				jeanLouis.setPrestataire(bouygues);
				jeanJacques.setPrestataire(bouygues);
				salarie1.setPrestataire(bouygues);
				salarie2.setPrestataire(bouygues);
				salarie3.setPrestataire(bouygues);
				salarie4.setPrestataire(bouygues);
				salarie5.setPrestataire(bouygues);
				salarie6.setPrestataire(bouygues);
				
				
				//save actions

				isolation = actionRepository.save(isolation);
				cloture = actionRepository.save(cloture);
				action1 = actionRepository.save(action1);
				action2 = actionRepository.save(action2);
				action3 = actionRepository.save(action3);
				action4 = actionRepository.save(action4);
				action5 = actionRepository.save(action5);
				action6 = actionRepository.save(action6);
				
				
				//save appel offre
				appelOffreMaison = appelOffreRepository.save(appelOffreMaison);
				appelOffreImmeuble = appelOffreRepository.save(appelOffreImmeuble);
				appelOffre4 = appelOffreRepository.save(appelOffre4);
				appelOffre5 = appelOffreRepository.save(appelOffre5);
				appelOffre6 = appelOffreRepository.save(appelOffre6);
				appelOffre7 = appelOffreRepository.save(appelOffre7);
				appelOffre8 = appelOffreRepository.save(appelOffre8);
				appelOffre9 = appelOffreRepository.save(appelOffre9);
				appelOffre10 = appelOffreRepository.save(appelOffre10);
				
				//save offre
				offre3 = offreRepository.save(offre3);
				offre4 = offreRepository.save(offre4);
				offre5 = offreRepository.save(offre5);
				offre6 = offreRepository.save(offre6);
				offre7 = offreRepository.save(offre7);
				offre8 = offreRepository.save(offre8);
				offre9 = offreRepository.save(offre9);
				offre10 = offreRepository.save(offre10);
				
				
				factureIsolation = factureRepository.save(factureIsolation);
				factureCloture = factureRepository.save(factureCloture);
				factureMoisNovembre = factureRepository.save(factureMoisNovembre);
				factureProjetMoisSeptembre = factureRepository.save(factureProjetMoisSeptembre);
				
				
				maitreOeuvreBob = maitreOeuvreRepository.save(maitreOeuvreBob);
				maitreOeuvreGeorges = maitreOeuvreRepository.save(maitreOeuvreGeorges);
				
				maitreOuvrageToto = maitreOuvrageRepository.save(maitreOuvrageToto);
				maitreOuvrageBobby = maitreOuvrageRepository.save(maitreOuvrageBobby);
				
				sable = materielRepository.save(sable);
				grillage = materielRepository.save(grillage);
				rouleauCompresseur = materielRepository.save(rouleauCompresseur);
				
				offreToto = offreRepository.save(offreToto);
				offreBobby = offreRepository.save(offreBobby);
				
				colas = prestataireRepository.save(colas);
				bouygues = prestataireRepository.save(bouygues);
				
				presta1 = prestationRepository.save(presta1);
				presta2 = prestationRepository.save(presta2);
				presta3 = prestationRepository.save(presta3);
				presta4 = prestationRepository.save(presta4);
				presta5 = prestationRepository.save(presta5);
				presta6 = prestationRepository.save(presta6);
				presta7 = prestationRepository.save(presta7);
				presta8 = prestationRepository.save(presta8);
				presta9 = prestationRepository.save(presta9);
				presta10 = prestationRepository.save(presta10);
				
				prestaSupp1 = prestationSupplementaireRepository.save(prestaSupp1);
				prestaSupp2 = prestationSupplementaireRepository.save(prestaSupp2);
				
				
				//save projets
				projet1 = projetRepository.save(projet1);
				projet2 = projetRepository.save(projet2);
				projet3 = projetRepository.save(projet3);
				projet4 = projetRepository.save(projet4);
				projet5 = projetRepository.save(projet5);
				projet6 = projetRepository.save(projet6);
				
				reunion1 = reunionRepository.save(reunion1);
				reunion2 = reunionRepository.save(reunion2);
				
				jeanLouis = salarieRepository.save(jeanLouis);
				jeanJacques = salarieRepository.save(jeanJacques);
				salarie1 = salarieRepository.save(salarie1);
				salarie2 = salarieRepository.save(salarie2);
				salarie3 = salarieRepository.save(salarie3);
				salarie4 = salarieRepository.save(salarie4);
				salarie5 = salarieRepository.save(salarie5);
				salarie6 = salarieRepository.save(salarie6);
				
				
				utilisateurmaitreOeuvreBob = utilisateurRepository.save(utilisateurmaitreOeuvreBob);
				utilisateurmaitreOeuvreGeorges = utilisateurRepository.save(utilisateurmaitreOeuvreGeorges);
				
				utilisateurmaitreOuvrageToto = utilisateurRepository.save(utilisateurmaitreOuvrageToto);
				utilisateurmaitreOuvrageBobby = utilisateurRepository.save(utilisateurmaitreOuvrageBobby);
				
				utilisateurprestaColas = utilisateurRepository.save(utilisateurprestaColas);
				utilisateurprestaBouygues = utilisateurRepository.save(utilisateurprestaBouygues);
	}


}