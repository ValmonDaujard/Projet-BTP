import {Projet} from "./projet";
import {AppelOffre} from "./appelOffre";
import {Prestation} from "./prestation";
import {MaitreOeuvre} from "./maitreOeuvre";

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
  maitreOeuvre : MaitreOeuvre;


  constructor(id?: number,version?: number, prix?: number, numeroDevis?: number, dtDebut?: Date, dtFin?: Date, prestations?: Array<Prestation>, projet?:Projet, maitreOeuvre?:MaitreOeuvre) {
    this.id = id;
    this.prix = prix;
    this.numeroDevis = numeroDevis;
    this.dtDebut = dtDebut;
    this.dtFin = dtFin;
    this.prestations = prestations;
    this.projet = projet
    this.maitreOeuvre = maitreOeuvre;
  }
}
