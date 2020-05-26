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
  // prestataire: Prestataire;
  // maitreOeuvre: MaitreOeuvre;
  // maitreOuvrage: MaitreOuvrage;
  // projet: Projet;
  // prestation: Prestation;
  // prestationSupplementaire: PrestationSupplementaire;


  constructor(id?: number, version?: number, numeroFacture?: number, dtFacturation?: Date, prixHT?: number, remise?: number, dtEcheance?: Date, penaliteRetard?: number, payee?: boolean) {
    this.id = id;
    this.version = version;
    this.numeroFacture = numeroFacture;
    this.dtFacturation = dtFacturation;
    this.prixHT = prixHT;
    this.remise = remise;
    this.dtEcheance = dtEcheance;
    this.penaliteRetard = penaliteRetard;
    this.payee = payee;
  }
}
