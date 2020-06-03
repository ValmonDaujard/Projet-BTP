import {Societe} from "./societe";
import {Offre} from "./offre";
import {Facture} from "./facture";
import {Utilisateur} from "./utilisateur";
import {Adresse} from "./adresse";

export class MaitreOeuvre extends Societe{
  offres: Array<Offre>;
  factures: Array<Facture>;


  constructor(id?: number, version?: number, type?: string, nom?: string, siret?: string, telephone?: string, mail?: string, numeroDeTva?: string, utilisateur?: Utilisateur, adresse?: Adresse, offres?: Array<Offre>, factures?: Array<Facture>) {
    super(id, version,type, nom, siret, telephone, mail, numeroDeTva, utilisateur, adresse);
    this.offres = offres;
    this.factures = factures;
  }

}
