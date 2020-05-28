import {Projet} from "./projet";

export class Reunion {
  id:number;
  sujet: string;
  numeroCompteRendu: number;
  dtReunion: Date;
  // projet: Projet;


  constructor(id?: number, sujet?: string, numeroCompteRendu?: number, dtReunion?: Date) {
    this.id = id;
    this.sujet = sujet;
    this.numeroCompteRendu = numeroCompteRendu;
    this.dtReunion = dtReunion;
    // this.projet = projet;
  }
}
