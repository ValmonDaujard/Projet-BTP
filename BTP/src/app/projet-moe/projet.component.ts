import {Component, OnInit} from '@angular/core';
import {ProjetService} from "./projet.service";
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
  templateUrl: './projet.component.html',
  styleUrls: ['./projet.component.scss']
})
export class ProjetComponent implements OnInit {

  projet: Projet = null;
  prestationref: Array<Prestation> = new Array<Prestation>();
  actionref: Array<Action> = new Array<Action>();
  reunionrefplanifie: Array<Reunion> = new Array<Reunion>();
  reunionrefeffectue: Array<Reunion> = new Array<Reunion>();
  factureref: Array<Facture> = new Array<Facture>();
  prestataires: Array<Prestataire> = new Array<Prestataire>();
  currentAction: Action = null;
  currentFacture: Facture = null;
  projets: Array<Projet> = new Array<Projet>();



  constructor(private projetService: ProjetService, private route: ActivatedRoute) {

    this.route.params.subscribe(parameters => {
      this.projetService.findById(parameters.id).subscribe(resp => {
        this.projet = resp;
        console.log(resp);
      }, error => console.log(error));
      this.projetService.findPrestations(parameters.id).subscribe(resp => {
        this.prestationref = resp;
      }, error => console.log(error));
      this.projetService.findActions(parameters.id).subscribe(resp => {
        this.actionref = resp;
      }, error => console.log(error));
      this.projetService.findReunionsPlanifiees(parameters.id).subscribe(resp => {
        this.reunionrefplanifie = resp;
      }, error => console.log(error));
      this.projetService.findReunionsEffectuees(parameters.id).subscribe(resp => {
        this.reunionrefeffectue = resp;
      }, error => console.log(error));
      this.projetService.findFactures(parameters.id).subscribe(resp => {
        this.factureref = resp;
      }, error => console.log(error));

    })
  }

  editAction(id: number) {
    this.projetService.findActionById(id).subscribe(resp => {
      this.currentAction = resp;

      if (this.currentAction.prestataire == null) {
        this.currentAction.prestataire = new Prestataire();
      }
    }, error => console.log(error));

    this.projetService.findAllPrestataire().subscribe(resp => {
      this.prestataires = resp;
    }, err => console.log(err));
  }


  saveAction() {
    this.projetService.modifyAction(this.currentAction).subscribe(resp => {
      this.currentAction = null;
      this.projetService.findActions(this.projet.id).subscribe(resp => {
        this.actionref = resp;
      }, error => console.log(error));
    })
  }

  ngOnInit(): void {

  }


  validerFacture(id: number) {
    this.projetService.findFactureById(id).subscribe(resp => {
      this.currentFacture = resp;
      this.currentFacture.payee = true;
    this.projetService.modifyFacture(this.currentFacture).subscribe(resp => {
      this.currentFacture = null;
      this.projetService.findFactures(this.projet.id).subscribe(resp => {
        this.factureref = resp;
      }, error => console.log(error));
    }, error => console.log(error));
    })
  }

  deleteFacture(id: number) {
      this.projetService.deleteFactureById(id).subscribe(resp => {;
      this.projetService.findFactures(this.projet.id).subscribe(resp => {
        this.factureref = resp;
      }, error => console.log(error));
      })

    }

  deleteAction(id: number) {
    this.projetService.deleteActionById(id).subscribe(resp => {;
      this.projetService.findActions(this.projet.id).subscribe(resp => {
        this.actionref = resp;
      }, error => console.log(error));
    })
  }



}



