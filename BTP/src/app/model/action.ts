import {Salarie} from "./salarie";
import {Prestataire} from "./prestataire";
import {Projet} from "./projet";

export class Action {
  id: number;
  version: number;
  nomAction: string;
  dtCreation: Date;
  dtLimite: Date;
  description: string;
  effectuee: boolean;
  salaries: Array<Salarie>;
  prestataire: Prestataire;
  projet: Projet;



  constructor(id?: number,version?: number, nomAction?: string, dtCreation?: Date, dtLimite?: Date, description?: string, effectuee?: boolean, prestataire?: Prestataire, projet? : Projet,  salaries?: Array<Salarie>) {
    this.id = id;
    this.version = version;
    this.nomAction = nomAction;
    this.dtCreation = dtCreation;
    this.dtLimite = dtLimite;
    this.description = description;
    this.effectuee = effectuee;
    this.prestataire = prestataire;
    this.projet=projet;
    this.salaries=salaries;
  }
}
