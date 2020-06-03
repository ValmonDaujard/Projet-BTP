import {Projet} from "./projet";
import {Prestataire} from "./prestataire";
import {MaitreOuvrage} from "./maitreOuvrage";
import {MaitreOeuvre} from "./maitreOeuvre";

export class Facture {
  id: number;
  version: number;
  numeroFacture: number;
  dtFacturation: Date;
  prixHT: number;
  remise: number;
  dtEcheance: Date;
  penaliteRetard: number;
  payee: boolean;
  quantite: number;
  prestataire: Prestataire;
  maitreOeuvre: MaitreOeuvre;
  maitreOuvrage: MaitreOuvrage;
  projet: Projet;
/*  prestation: Prestation;
  prestationSupplementaire: PrestationSupplementaire;*/
  factureMOEMO : boolean;


  constructor(id?: number, version?: number, numeroFacture?: number, dtFacturation?: Date, prixHT?: number,
              remise?: number, dtEcheance?: Date, penaliteRetard?: number, payee?: boolean, projet?: Projet, factureMOEMO?: boolean, prestataire?:Prestataire, maitreOeuvre?: MaitreOeuvre, maitreOuvrage?: MaitreOuvrage) {
    this.id = id;
    this.version = version;
    this.numeroFacture = numeroFacture;
    this.dtFacturation = dtFacturation;
    this.prixHT = prixHT;
    this.remise = remise;
    this.dtEcheance = dtEcheance;
    this.penaliteRetard = penaliteRetard;
    this.payee = payee;
    this.projet = projet
    this.factureMOEMO=factureMOEMO;
    this.maitreOeuvre=maitreOeuvre;
    this.maitreOuvrage=maitreOuvrage;
    this.prestataire=prestataire;
  }
}
