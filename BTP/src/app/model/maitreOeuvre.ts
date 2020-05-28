import {Societe} from "./societe";
import {Offre} from "./offre";
import {Facture} from "./facture";
import {Utilisateur} from "./utilisateur";
import {Adresse} from "./adresse";

export class MaitreOeuvre extends Societe{
  // offres: Array<Offre>;
  // factures: Array<Facture>;


  constructor(id?: number, nom?: string, siret?: string, telephone?: string, mail?: string, numeroTva?: string, adresse?: Adresse) {
    super(id, nom, siret, telephone, mail, numeroTva, adresse);
    // this.offres = offres;
    // this.factures = factures;
  }
}
