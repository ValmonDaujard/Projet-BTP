import { Component, OnInit } from '@angular/core';
import {ReponseAppelOffreService} from "./reponse-appel-offre.service";
import {Prestataire} from "../model/prestataire";
import {Prestation} from "../model/prestation";
import {Offre} from "../model/offre";
import {Observable} from "rxjs";
import {Projet} from "../model/projet";

@Component({
  selector: 'app-reponse-appel-offre',
  templateUrl: './reponse-appel-offre.component.html',
  styleUrls: ['./reponse-appel-offre.component.scss']
})
export class ReponseAppelOffreComponent implements OnInit {

  prestaEG: Prestation = new Prestation();
  prestaList: Array<Prestation> = new Array<Prestation>();
  offre: Offre = new Offre();
  projet84: Projet = new Projet();



  constructor(private reponseAppelOffreService: ReponseAppelOffreService) { }

  ngOnInit(): void {
  }
  
  listEG(): Array<Prestataire> {
    return this.reponseAppelOffreService.findAll();
  }

  addToPrestaList() {
    if(!this.prestaEG.prestataire) {

    } else {

      this.prestaList.push(this.prestaEG);
      this.prestaEG = new Prestation();
    }
  }

  suppPrestaList(index) {
    this.prestaList.splice(index, 1);
  }

  addToOffre() {
      this.offre.prestations = this.prestaList;
      // this.offre.projet.id = 84;
      for(let presta of this.offre.prestations) {
        presta.phasePresta= "enConsult";
      }
      console.log(this.offre.prestations)
      this.reponseAppelOffreService.createOffre(this.offre).subscribe(resp => {
          this.reponseAppelOffreService.load();
        },
        error => console.log(error)
      )
  }

  listPrestaEG(): Observable<Array<Prestation>> {
    return this.reponseAppelOffreService.findPrestationByPhase();
  }

}
