import { Component, OnInit } from '@angular/core';
import {ReponseAppelOffreService} from "./reponse-appel-offre.service";
import {Stagiaire} from "../../../../../covid-formation/formation-angular/src/app/model/stagiaire";
import {Prestataire} from "../model/prestataire";
import {Adresse} from "../../../../../covid-formation/formation-angular/src/app/model/adresse";
import {Societe} from "../model/societe";

@Component({
  selector: 'app-reponse-appel-offre',
  templateUrl: './reponse-appel-offre.component.html',
  styleUrls: ['./reponse-appel-offre.component.scss']
})
export class ReponseAppelOffreComponent implements OnInit {



  constructor(private reponseAppelOffreService: ReponseAppelOffreService) { }

  ngOnInit(): void {
  }

  list(): Array<Prestataire> {
    return this.reponseAppelOffreService.findAll();
  }

}
