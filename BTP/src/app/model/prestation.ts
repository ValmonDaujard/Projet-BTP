  import {PrestationSupplementaire} from "./prestationSupplementaire";
import {Materiel} from "./materiel";
import {Projet} from "./projet";
import {Offre} from "./offre";
import {Prestataire} from "./prestataire";
import {Salarie} from "./salarie";
import {Facture} from "./facture";

export class Prestation {
  id: number;
  version: number;
  categorie: string;
  nom: string;
  prix: number;
  dtDebut: Date;
  dtFin: Date;
  phasePresta: string;
  obsolete: boolean;
  prestationSupplementaire: PrestationSupplementaire;
  // materiels: Array<Materiel>;
  projet: Projet;
  offre: Offre;
  prestataire: Prestataire;
  salaries: Array<Salarie>;
  // facture: Facture;
  motif: string;


  constructor(id?: number,version?: number, categorie?: string, nom?: string, prix?: number, dtDebut?: Date,
              dtFin?: Date, phasePresta?: string, obsolete?: boolean, projet?: Projet, offre?: Offre, prestataire?: Prestataire, salaries?: Array<Salarie>, motif?: string) {

    this.id = id;
    this.categorie = categorie;
    this.nom = nom;
    this.prix = prix;
    this.dtDebut = dtDebut;
    this.dtFin = dtFin;
    this.phasePresta = phasePresta;
    this.obsolete = obsolete;
    this.projet = projet;
    this.offre = offre;
    this.prestataire = prestataire;
    this.salaries = salaries;
    this.motif = motif;
  }


}
