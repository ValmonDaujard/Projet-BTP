import {Societe} from "./societe";
import {Offre} from "./offre";
import {Facture} from "./facture";
import {Utilisateur} from "./utilisateur";
import {Adresse} from "./adresse";

export class MaitreOeuvre extends Societe{
  // offres: Array<Offre>;
  // factures: Array<Facture>;


  constructor(id?: number, version?: number, nom?: string, siret?: string, telephone?: string, mail?: string, numeroDeTva?: string, utilisateur?: Utilisateur, adresse?: Adresse, type?: string) {
    super(id, version, nom, siret, telephone, mail, numeroDeTva, utilisateur, adresse, type);
  }
}
