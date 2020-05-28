import {Action} from "./action";
import {Prestataire} from "./prestataire";
import {Prestation} from "./prestation";
import {PrestationSupplementaire} from "./prestationSupplementaire";

export class Salarie{
  id: number;
  nom: string;
  prenom: string;
  metier: string;
  // actions: Array<Action>;
  // prestataire: Prestataire;
  // prestations: Array<Prestation>;
  // prestationSupplementaires: Array<PrestationSupplementaire>;


  constructor(id?: number, nom?: string, prenom?: string, metier?: string) {
    this.id = id;
    this.nom = nom;
    this.prenom = prenom;
    this.metier = metier;
  }
}
