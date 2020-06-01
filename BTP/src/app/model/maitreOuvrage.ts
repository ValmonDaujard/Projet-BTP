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


  constructor(id?: number, version?: number, type?: string, nom?: string, siret?: string, telephone?: string, mail?: string, numeroDeTva?: string, utilisateur?: Utilisateur, adresse?: Adresse) {
    super(id, version, type, nom, siret, telephone, mail, numeroDeTva, utilisateur, adresse);
      // this.appelOffres = appelOffres;
      // this.offres = offres;
      // this.factures = factures;
  }

}
