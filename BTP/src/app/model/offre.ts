import {Projet} from "./projet";
import {AppelOffre} from "./appelOffre";
import {Prestation} from "./prestation";

export class Offre{
  id:number;
  prix: number;
  numeroDevis: number;
  dtDebut: Date;
  dtFin: Date;
  // prestations: Array<Prestation>;
  // projet: Projet;
  appelOffre: AppelOffre;


  constructor(id?: number, prix?: number, numeroDevis?: number, dtDebut?: Date, dtFin?: Date) {
    this.id = id;
    this.prix = prix;
    this.numeroDevis = numeroDevis;
    this.dtDebut = dtDebut;
    this.dtFin = dtFin;
  }
}
