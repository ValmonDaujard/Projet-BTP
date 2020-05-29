import {Projet} from "./projet";
import {AppelOffre} from "./appelOffre";
import {Prestation} from "./prestation";

export class Offre{
  id:number;
  version: number;
  prix: number;
  numeroDevis: number;
  dtDebut: Date;
  dtFin: Date;
  appelOffre: AppelOffre;
  // prestations: Array<Prestation>;
  // projet: Projet;


  constructor(id?: number,version?: number, prix?: number, numeroDevis?: number, dtDebut?: Date, dtFin?: Date, appelOffre? : AppelOffre) {
    this.id = id;
    this.prix = prix;
    this.numeroDevis = numeroDevis;
    this.dtDebut = dtDebut;
    this.dtFin = dtFin;
    this.appelOffre = appelOffre;
  }
}
