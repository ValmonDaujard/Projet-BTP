import {Societe} from "./societe";

export class Utilisateur{
  id: number;
  identifiant: string;
  motDePasse: string;
  // societe: Societe;


  constructor(id?: number, identifiant?: string, motDePasse?: string) {
    this.id = id;
    this.identifiant = identifiant;
    this.motDePasse = motDePasse;
    // this.societe = societe;
  }
}
