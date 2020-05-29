import { Component, OnInit } from '@angular/core';
import {ReponseAppelOffreService} from "./reponse-appel-offre.service";
import {Prestataire} from "../model/prestataire";
import {Prestation} from "../model/prestation";
import {Offre} from "../model/offre";

@Component({
  selector: 'app-reponse-appel-offre',
  templateUrl: './reponse-appel-offre.component.html',
  styleUrls: ['./reponse-appel-offre.component.scss']
})
export class ReponseAppelOffreComponent implements OnInit {

  prestaEG: Prestation = new Prestation();
  prestaList: Array<Prestation> = new Array<Prestation>();
  offre: Offre = new Offre();

  constructor(private reponseAppelOffreService: ReponseAppelOffreService) { }

  ngOnInit(): void {
  }

  list(): Array<Prestataire> {
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

  addToOffre(prestations: Array<Prestation>) {
      // this.prestaEG.phasePresta = "En Consultation";
      this.offre.prestations = this.prestaList;
      console.log(this.offre.prestations)
      this.reponseAppelOffreService.createOffre(this.offre).subscribe(resp => {
          this.prestaEG= null;
          this.reponseAppelOffreService.load();
        },
        error => console.log(error)
      )
  }
}
