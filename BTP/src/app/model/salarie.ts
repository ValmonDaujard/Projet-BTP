import {Action} from "./action";
import {Prestataire} from "./prestataire";
import {Prestation} from "./prestation";
import {PrestationSupplementaire} from "./prestationSupplementaire";

export class Salarie{
  id: number;
  version: number;
  civilite: string;
  nom: string;
  prenom: string;
  metier: string;
  // actions: Array<Action>;
  // prestataire: Prestataire;
  // prestations: Array<Prestation>;
  // prestationSupplementaires: Array<PrestationSupplementaire>;


  constructor(id?: number, civilite?: string, nom?: string, prenom?: string, metier?: string, version?: number) {
    this.id = id;
    this.civilite = civilite;
    this.version = version;
    this.nom = nom;
    this.prenom = prenom;
    this.metier = metier;
    this.version = version;
  }
}
