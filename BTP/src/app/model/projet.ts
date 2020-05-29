import {Offre} from "./offre";
import {Prestation} from "./prestation";

export class Projet {

  id: number;
  version: number;
  numeroDevis: number;
  dtDebut: Date;
  dtFin: Date;
  arret: number;
  rapport: string;
  offre: Offre;
  prestations: Array<Prestation>;

  constructor(id?: number,version?: number, numeroDevis?: number, dtDebut?: Date, dtFin?: Date, arret?: number, rapport?: string, offre?:Offre, prestations?:Array<Prestation>) {
    this.id = id;
    this.version = version;
    this.numeroDevis = numeroDevis;
    this.dtDebut = dtDebut;
    this.dtFin = dtFin;
    this.arret = arret;
    this.rapport = rapport;
    this.offre = offre;
    this.prestations = prestations;
  }
}
