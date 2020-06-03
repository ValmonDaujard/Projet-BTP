import {Component, OnInit} from '@angular/core';
import {ProjetMOService} from "./projet-mo.service";
import {Projet} from "../model/projet";
import {Observable} from "rxjs";
import {ActivatedRoute} from "@angular/router";
import {Offre} from "../model/offre";
import {Prestataire} from "../model/prestataire";
import {Prestation} from "../model/prestation";
import {Action} from "../model/action";
import {Reunion} from "../model/reunion";
import {Facture} from "../model/facture";

@Component({
  selector: 'app-projet',
  templateUrl: './projet-mo.component.html',
  styleUrls: ['./projet-mo.component.scss']
})
export class ProjetMOComponent implements OnInit {

  projet: Projet = null;
  prestationref: Array<Prestation> = new Array<Prestation>();
  actionref: Array<Action> = new Array<Action>();
  reunionrefplanifie: Array<Reunion> = new Array<Reunion>();
  reunionrefeffectue: Array<Reunion> = new Array<Reunion>();
  factureref: Array<Facture> = new Array<Facture>();
  prestataires: Array<Prestataire> = new Array<Prestataire>();
  currentAction: Action = null;
  currentFacture: Facture = null;
  currentReunion: Reunion = null;


  constructor(private projetMOService: ProjetMOService, private route: ActivatedRoute) {
    this.route.params.subscribe(parameters => {
      this.projetMOService.findById(parameters.id).subscribe(resp => {
        this.projet = resp;
        console.log(resp);
      }, error => console.log(error));
      this.projetMOService.findPrestations(parameters.id).subscribe(resp => {
        this.prestationref = resp;
      }, error => console.log(error));
      this.projetMOService.findActions(parameters.id).subscribe(resp => {
        this.actionref = resp;
      }, error => console.log(error));
      this.projetMOService.findReunionsPlanifiees(parameters.id).subscribe(resp => {
        this.reunionrefplanifie = resp;
      }, error => console.log(error));
      this.projetMOService.findReunionsEffectuees(parameters.id).subscribe(resp => {
        this.reunionrefeffectue = resp;
      }, error => console.log(error));
      this.projetMOService.findFactures(parameters.id).subscribe(resp => {
        this.factureref = resp;
      }, error => console.log(error));
    })
  }

  editAction(id: number) {
    this.projetMOService.findActionById(id).subscribe(resp => {
      this.currentAction = resp;

      if (this.currentAction.prestataire == null) {
        this.currentAction.prestataire = new Prestataire();
      }
    }, error => console.log(error));

    this.projetMOService.findAllPrestataire().subscribe(resp => {
      this.prestataires = resp;
    }, err => console.log(err));
  }


  saveAction() {
    if (!this.currentAction.id) {
      this.projetMOService.createAction(this.currentAction).subscribe(resp => {
          this.currentAction = null;
          this.projetMOService.findActions(this.projet.id).subscribe(resp => {
            this.actionref = resp;
          }, error => console.log(error));
        },
        error => console.log(error)
      )
      ;
    } else {
      this.projetMOService.modifyAction(this.currentAction).subscribe(resp => {
        this.currentAction = null;
        this.projetMOService.findActions(this.projet.id).subscribe(resp => {
          this.actionref = resp;
        }, error => console.log(error));
      })
    }
  }

  ngOnInit(): void {

  }


  validerFacture(id: number) {
    this.projetMOService.findFactureById(id).subscribe(resp => {
      this.currentFacture = resp;
      this.currentFacture.payee = true;
      this.projetMOService.modifyFacture(this.currentFacture).subscribe(resp => {
        this.currentFacture = null;
        this.projetMOService.findFactures(this.projet.id).subscribe(resp => {
          this.factureref = resp;
        }, error => console.log(error));
      }, error => console.log(error));
    })
  }

  deleteFacture(id: number) {
    this.projetMOService.deleteFactureById(id).subscribe(resp => {;
      this.projetMOService.findFactures(this.projet.id).subscribe(resp => {
        this.factureref = resp;
      }, error => console.log(error));
    })

  }

  deleteAction(id: number) {
    this.projetMOService.deleteActionById(id).subscribe(resp => {;
      this.projetMOService.findActions(this.projet.id).subscribe(resp => {
        this.actionref = resp;
      }, error => console.log(error));
    })
  }


  validerAction(id: number) {
    this.projetMOService.findActionById(id).subscribe(resp => {
      this.currentAction = resp;
      this.currentAction.effectuee = true;
      this.projetMOService.modifyActionWithoutType(this.currentAction).subscribe(resp => {
        this.currentAction = null;
        this.projetMOService.findActions(this.projet.id).subscribe(resp => {
          this.actionref = resp;
        }, error => console.log(error));
      }, error => console.log(error));
    })
  }


  addAction() {
    this.currentAction = new Action();
    this.currentAction.projet = this.projet;
    this.currentAction.effectuee = false;
  }

  deleteReunionEffectues(id: number) {
    this.projetMOService.deleteReunionById(id).subscribe(resp => {;
      this.projetMOService.findReunionsEffectuees(this.projet.id).subscribe(resp => {
        this.reunionrefeffectue = resp;
      }, error => console.log(error));
    })
  }

  deleteReunionPlanifiees(id: number) {
    this.projetMOService.deleteReunionById(id).subscribe(resp => {;
      this.projetMOService.findReunionsPlanifiees(this.projet.id).subscribe(resp => {
        this.reunionrefplanifie = resp;
      }, error => console.log(error));
    })
  }

  addReunion() {
    this.currentReunion = new Reunion();
    this.currentReunion.projet = this.projet;

  }

  saveReunion() {
    if (!this.currentReunion.id) {
      this.projetMOService.createReunion(this.currentReunion).subscribe(resp => {
          this.currentReunion = null;
          this.projetMOService.findReunionsPlanifiees(this.projet.id).subscribe(resp => {
            this.reunionrefplanifie = resp;
          }, error => console.log(error));
          this.projetMOService.findReunionsEffectuees(this.projet.id).subscribe(resp => {
            this.reunionrefeffectue = resp;
          }, error => console.log(error));
        },
        error => console.log(error)
      )
      ;
    }
  }
}



