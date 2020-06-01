import { Component, OnInit } from '@angular/core';
import {Prestation} from "../model/prestation";
import {ProjetEGService} from "./projet-eg.service";
import {Salarie} from "../model/salarie";
import {ActivatedRoute} from "@angular/router";
import {Action} from "../model/action";

@Component({
  selector: 'app-projet-eg',
  templateUrl: './projet-eg.component.html',
  styleUrls: ['./projet-eg.component.scss']
})
export class ProjetEGComponent implements OnInit {

  prestaCours : Prestation = new Prestation();
  prestaPlanif : Prestation = new Prestation();
  prestaEffect : Prestation = new Prestation();
  prestationsEnCours: Array<Prestation> = new Array<Prestation>();
  prestationsPlanifies: Array<Prestation> = new Array<Prestation>();
  prestationsEffectuees: Array<Prestation> = new Array<Prestation>();
  actionTrait: Action = new Action();
  actionDem: Action = new Action();
  actionsTraiteesList: Array<Action> = new Array<Action>();
  actionsDemandeesList: Array<Action> = new Array<Action>();
  salariePrestaCours: Array<Salarie>= new Array<Salarie>();
  salariePrestaPlanif: Array<Salarie>= new Array<Salarie>();
  salariePrestaEffect: Array<Salarie>= new Array<Salarie>();
  salarieList: Array<Salarie>= new Array<Salarie>();
  salarie: Salarie = new Salarie();
  salariesActionDem : Array<Salarie> = new Array<Salarie>();
  salariesActionTrait : Array<Salarie> = new Array<Salarie>();

  constructor(private projetEGService:ProjetEGService , private route: ActivatedRoute) {
    this.route.params.subscribe(parameters => {
      this.prestationEnCoursFonction(parameters.id, 43);
      this.prestationPlanifieFonction(parameters.id, 43);
      this.prestationEffectueFonction(parameters.id, 43);
      this.actionTraiteesFonction(parameters.id,43);
      this.actionDemandeesFonction(parameters.id,43);
      this.salariesListFonction(43);
      console.log(this.salarieList);
    })
  }

  chargePrestaCours(idPresta: number) {
    this.projetEGService.findPrestaById(idPresta).subscribe(resp => this.prestaCours = resp, error => console.log(error));
    this.projetEGService.findSalariesByPrestation(idPresta).subscribe(resp => this.salariePrestaCours = resp, error => console.log(error));

  }
  chargePrestaPlanif(idPresta: number) {
    this.projetEGService.findPrestaById(idPresta).subscribe(resp => this.prestaPlanif = resp, error => console.log(error));
    this.projetEGService.findSalariesByPrestation(idPresta).subscribe(resp => this.salariePrestaPlanif = resp, error => console.log(error));
  }

  chargePrestaEffect(idPresta:number){
    this.projetEGService.findPrestaById(idPresta).subscribe(resp=> this.prestaEffect = resp, error => console.log(error));
    this.projetEGService.findSalariesByPrestation(idPresta).subscribe(resp=> this.salariePrestaEffect = resp, error => console.log(error));
  }

  chargeActionTraitees(idAction:number){
    this.projetEGService.findActionById(idAction).subscribe(resp=> this.actionTrait, error => console.log(error));
    this.projetEGService.findSalarieByAction(idAction).subscribe(resp=> this.salariesActionTrait = resp, error => console.log(error));

  }
  chargeActionDemandees(idAction:number){
    this.projetEGService.findActionById(idAction).subscribe(resp=> this.actionDem, error => console.log(error));
    this.projetEGService.findSalarieByAction(idAction).subscribe(resp=> this.salariesActionDem, error => console.log(error));
  }


  prestationEnCoursFonction(idProj:number, idEG:number){
    this.projetEGService.findPrestationEnCoursParProjetParEG(idProj,idEG).subscribe(resp => this.prestationsEnCours = resp, error => console.log(error));
  }

  prestationPlanifieFonction(idProj:number, idEG:number){
    this.projetEGService.findPrestationPlanifieesParProjetParEG(idProj,idEG).subscribe(resp => this.prestationsPlanifies = resp, error => console.log(error));
  }

  prestationEffectueFonction(idProj:number, idEG:number){
    this.projetEGService.findPrestationEffectueesParProjetParEG(idProj,idEG).subscribe(resp => this.prestationsEffectuees = resp, error => console.log(error));
  }

  actionTraiteesFonction(idProj:number, idEG:number){
    this.projetEGService.findActionsTraiteesParProjetParEG(idProj,idEG).subscribe(resp => this.actionsTraiteesList = resp, error => console.log(error));
  }

  actionDemandeesFonction(idProj:number, idEG:number){
    this.projetEGService.findActionsDemandeesParProjetParEG(idProj,idEG).subscribe(resp => this.actionsDemandeesList = resp, error => console.log(error));
  }

  salariesListFonction(idEG: number){
    this.projetEGService.findAllSalarieByEG(idEG).subscribe(resp=> this.salarieList = resp,error => console.log(error))
  }

  ngOnInit(): void {
  }

}
