import {Materiel} from "./materiel";
import {Projet} from "./projet";
import {Offre} from "./offre";
import {Prestataire} from "./prestataire";
import {Salarie} from "./salarie";
import {Facture} from "./facture";
import {Prestation} from "./prestation";

export class PrestationSupplementaire {
  id: number;
  version: number;
  categorie: string;
  nom: string;
  prix: number;
  dtDebut: Date;
  dtFin: Date;
  phasePresta: string;
  obsolete: boolean;
  // prestation: Prestation;
  // materiels: Array<Materiel>;
  // projet: Projet;
  // offre: Offre;
  // prestataire: Prestataire;
  // salaries: Array<Salarie>;
  // facture: Facture;


  constructor(id?: number,version?: number, categorie?: string, nom?: string, prix?: number, dtDebut?: Date, dtFin?: Date, phasePresta?: string, obsolete?: boolean) {
    this.id = id;
    this.version = version;
    this.categorie = categorie;
    this.nom = nom;
    this.prix = prix;
    this.dtDebut = dtDebut;
    this.dtFin = dtFin;
    this.phasePresta = phasePresta;
    this.obsolete = obsolete;
  }
}
