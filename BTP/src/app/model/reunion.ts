import {Projet} from "./projet";

export class Reunion {
  id:number;
  version: number;
  sujet: string;
  numeroCompteRendu: number;
  dtReunion: Date;
  // projet: Projet;


  constructor(id?: number,version?: number, sujet?: string, numeroCompteRendu?: number, dtReunion?: Date) {
    this.id = id;
    this.version = version;
    this.sujet = sujet;
    this.numeroCompteRendu = numeroCompteRendu;
    this.dtReunion = dtReunion;
    // this.projet = projet;
  }
}
