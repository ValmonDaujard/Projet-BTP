import {Utilisateur} from "./utilisateur";
import {Adresse} from "./adresse";

export class Societe{
  id:number;
  nom:string;
  siret: string;
  telephone:string;
  mail: string;
  numeroTva: string;
  // utilisateur: Utilisateur;
  adresse: Adresse;


  constructor(id?: number, nom?: string, siret?: string, telephone?: string, mail?: string, numeroTva?: string, adresse?: Adresse) {
    this.id = id;
    this.nom = nom;
    this.siret = siret;
    this.telephone = telephone;
    this.mail = mail;
    this.numeroTva = numeroTva;
    // this.utilisateur = utilisateur;
    this.adresse = adresse;
  }
}