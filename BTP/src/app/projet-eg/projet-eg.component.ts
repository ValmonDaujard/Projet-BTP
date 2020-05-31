import { Component, OnInit } from '@angular/core';
import {Prestation} from "../model/prestation";
import {ProjetEGService} from "./projet-eg.service";
import {Salarie} from "../model/salarie";

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
  salariePrestaCours: Array<Salarie>= new Array<Salarie>();

  constructor(private projetEGService:ProjetEGService) {
    this.prestationEnCoursFonction(94,86);
    this.prestationPlanifieFonction(94,86);
    this.prestationEffectueFonction(94,86);

  }


  prestationEnCoursFonction(idProj:number, idPresta:number){
    this.projetEGService.findPrestationEnCoursParProjetParEG(idProj,idPresta).subscribe(resp => this.prestationsEnCours = resp, error => console.log(error));
    console.log(this.prestaCours.id);
  }

  prestationPlanifieFonction(idProj:number, idPresta:number){
    this.projetEGService.findPrestationPlanifieesParProjetParEG(idProj,idPresta).subscribe(resp => this.prestationsPlanifies = resp, error => console.log(error));
  }

  prestationEffectueFonction(idProj:number, idPresta:number){
    this.projetEGService.findPrestationEffectueesParProjetParEG(idProj,idPresta).subscribe(resp => this.prestationsEffectuees = resp, error => console.log(error));
  }



  ngOnInit(): void {
  }

}
