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
  prestations: Array<Prestation>;
  projet: Projet;
  appelOffre: AppelOffre;


  constructor(id?: number,version?: number, prix?: number, numeroDevis?: number, dtDebut?: Date, dtFin?: Date, prestations?: Array<Prestation>, projet?:Projet) {
    this.id = id;
    this.prix = prix;
    this.numeroDevis = numeroDevis;
    this.dtDebut = dtDebut;
    this.dtFin = dtFin;
    this.prestations = prestations;
    this.projet = projet
  }
}
