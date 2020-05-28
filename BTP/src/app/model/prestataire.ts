import {Societe} from "./societe";
import {Offre} from "./offre";
import {Facture} from "./facture";
import {Action} from "./action";
import {Prestation} from "./prestation";
import {Materiel} from "./materiel";
import {PrestationSupplementaire} from "./prestationSupplementaire";
import {Salarie} from "./salarie";
import {Adresse} from "./adresse";

export class Prestataire extends Societe{
  // actions: Array<Action>;
  // factures: Array<Facture>;
  // salaries: Array<Salarie>;
  // prestationSupplementaires: Array<PrestationSupplementaire>;
  // prestations: Array<Prestation>;
  // materiels: Array<Materiel>;


  constructor(id?: number,version?: number, nom?: string, siret?: string, telephone?: string, mail?: string, numeroTva?: string, adresse?: Adresse) {
    super(id,version, nom, siret, telephone, mail, numeroTva, adresse);
  }
}
