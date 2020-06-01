import {Action} from "./action";
import {Prestataire} from "./prestataire";
import {Prestation} from "./prestation";
import {PrestationSupplementaire} from "./prestationSupplementaire";
import {Adresse} from './adresse';

export class Salarie{
  id: number;
  version : number;
  nom: string;
  prenom: string;
  metier: string;
  adresse: Adresse;
  // actions: Array<Action>;
  prestataire: Prestataire;
  // prestations: Array<Prestation>;
  // prestationSupplementaires: Array<PrestationSupplementaire>;


  constructor(id?: number, version?: number, nom?: string, prenom?: string, metier?: string, adresse?: Adresse) {
    this.id = id;
    this.version = version;
    this.nom = nom;
    this.prenom = prenom;
    this.metier = metier;
    this.adresse = adresse;
  }

}
