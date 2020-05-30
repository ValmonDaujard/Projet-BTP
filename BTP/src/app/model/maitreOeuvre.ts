import {Societe} from "./societe";
import {Offre} from "./offre";
import {Facture} from "./facture";
import {Utilisateur} from "./utilisateur";
import {Adresse} from "./adresse";

export class MaitreOeuvre extends Societe{
  // offres: Array<Offre>;
  // factures: Array<Facture>;


  constructor(id?: number,version?: number,type?: string, nom?: string, siret?: string, telephone?: string, mail?: string, numeroTva?: string, utilisateur?: Utilisateur, adresse?: Adresse) {
    super(id,version, type, nom, siret, telephone, mail, numeroTva, utilisateur, adresse);
    // this.offres = offres;
    // this.factures = factures;
  }
}
