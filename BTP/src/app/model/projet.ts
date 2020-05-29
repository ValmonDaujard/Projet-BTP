import {Offre} from "./offre";

export class Projet {

  id: number;
  version: number;
  numeroDevis: number;
  dtDebut: Date;
  dtFin: Date;
  arret: number;
  rapport: string;
  offre: Offre;


  constructor(id?: number, version?: number, numeroDevis?: number, dtDebut?: Date, dtFin?: Date, arret?: number, rapport?: string, offre?:Offre) {
    this.id = id;
    this.version = version;
    this.numeroDevis = numeroDevis;
    this.dtDebut = dtDebut;
    this.dtFin = dtFin;
    this.arret = arret;
    this.rapport = rapport;
    this.offre = offre;
  }
}
