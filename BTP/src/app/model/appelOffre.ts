import {Adresse} from "./adresse";
import {Offre} from "./offre";
import {MaitreOuvrage} from "./maitreOuvrage";

export class AppelOffre{
  id: number;
  version: number;
  nom: string;
  objectif: string;
  budget: number;
  dtDebut: Date;
  dtFin: Date;
  dtLimite: Date;
  bpu: boolean;
  prixBpu: number;
  adresse: Adresse;
  maitreOuvrage: MaitreOuvrage;
  // offres: Array<Offre>;


  constructor(id?: number, version?: number, nom?: string, objectif?: string, budget?: number, dtDebut?: Date, dtFin?: Date, dtLimite?: Date, bpu?: boolean, prixBpu?: number, adresse?: Adresse, maitreOuvrage?: MaitreOuvrage) {
    this.id = id;
    this.version = version;
    this.nom = nom;
    this.objectif = objectif;
    this.budget = budget;
    this.dtDebut = dtDebut;
    this.dtFin = dtFin;
    this.dtLimite = dtLimite;
    this.bpu = bpu;
    this.prixBpu = prixBpu;
    this.adresse = adresse;
    this.maitreOuvrage = maitreOuvrage;
  }
}
