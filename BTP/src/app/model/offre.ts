import {Projet} from "./projet";
import {AppelOffre} from "./appelOffre";
import {Prestation} from "./prestation";
import {MaitreOeuvre} from "./maitreOeuvre";
import {MaitreOuvrage} from "./maitreOuvrage";

export class Offre{
  id:number;
  version: number;
  prix: number;
  numeroDevis: number;
  dtDebut: Date;
  dtFin: Date;
  etat: string;
  prestations: Array<Prestation>;
  projet: Projet;
  appelOffre: AppelOffre;
  maitreOeuvre : MaitreOeuvre;
  maitreOuvrage: MaitreOuvrage;


  constructor(id?: number,version?: number, prix?: number, numeroDevis?: number, dtDebut?: Date, dtFin?: Date, etat?: string, prestations?: Array<Prestation>, projet?:Projet, maitreOeuvre?:MaitreOeuvre) {
    this.id = id;
    this.prix = prix;
    this.numeroDevis = numeroDevis;
    this.dtDebut = dtDebut;
    this.dtFin = dtFin;
    this.etat = etat;
    this.prestations = prestations;
    this.projet = projet
    this.maitreOeuvre = maitreOeuvre;
  }
}
