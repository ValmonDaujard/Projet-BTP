import {Prestation} from "./prestation";
import {Prestataire} from "./prestataire";
import {PrestationSupplementaire} from "./prestationSupplementaire";

export class Materiel {
  id: number;
  nom: string;
  quantite: number;
  unite: string;
  // prestationSupplementaires: Array<PrestationSupplementaire>
  // prestations: Array<Prestation>
  // prestataire: Prestataire;


  constructor(id?: number, nom?: string, quantite?: number, unite?: string) {
    this.id = id;
    this.nom = nom;
    this.quantite = quantite;
    this.unite = unite;
  }
}
