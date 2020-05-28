import {Societe} from "./societe";
import {AppelOffre} from "./appelOffre";
import {Facture} from "./facture";
import {Offre} from "./offre";
import {Utilisateur} from "./utilisateur";
import {Adresse} from "./adresse";

export class MaitreOuvrage extends Societe{
  // appelOffres: Array<AppelOffre>;
  // offres: Array<Offre>;
  // factures: Array<Facture>;


  constructor(id?: number,version?: number, nom?: string, siret?: string, telephone?: string, mail?: string, numeroTva?: string, adresse?: Adresse) {
    super(id, version, nom, siret, telephone, mail, numeroTva, adresse);
    // this.appelOffres = appelOffres;
    // this.offres = offres;
    // this.factures = factures;
  }
}
