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


  ngOnInit(): void {

  }


}



