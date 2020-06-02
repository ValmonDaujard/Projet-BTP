import {Utilisateur} from "./utilisateur";
import {Adresse} from "./adresse";

export class Societe{
  id:number;
  version: number;
  nom:string;
  siret: string;
  telephone:string;
  mail: string;
  numeroDeTva: string;
  utilisateur: Utilisateur;
  adresse: Adresse;
  type: any;


  constructor(id?: number,version?: number, nom?: string, siret?: string, telephone?: string, mail?: string, numeroDeTva?: string, utilisateur?: Utilisateur, adresse?: Adresse, type?:any) {
    this.id = id;
    this.version = version;
    this.nom = nom;
    this.siret = siret;
    this.telephone = telephone;
    this.mail = mail;
    this.numeroDeTva = numeroDeTva;
    this.utilisateur = utilisateur;
    this.adresse = adresse;
    this.type = type;
  }
}
