import {Component, OnInit} from '@angular/core';
import {ReponseAppelOffreService} from "./reponse-appel-offre.service";
import {Prestataire} from "../model/prestataire";
import {Prestation} from "../model/prestation";
import {Offre} from "../model/offre";
import {Observable} from "rxjs";
import {Projet} from "../model/projet";
import {ProjetService} from "../projet/projet.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-reponse-appel-offre',
  templateUrl: './reponse-appel-offre.component.html',
  styleUrls: ['./reponse-appel-offre.component.scss']
})
export class ReponseAppelOffreComponent implements OnInit {

  prestaEG: Prestation = new Prestation();
  prestaList: Array<Prestation> = new Array<Prestation>();
  prestations: Array<Prestation> = new Array<Prestation>();
  offre: Offre = new Offre();
  projet: Projet = new Projet();


  constructor(private reponseAppelOffreService: ReponseAppelOffreService, private route: ActivatedRoute) {

  }

  ngOnInit(): void {
  }

  listEG(): Array<Prestataire> {
    return this.reponseAppelOffreService.findAll();
  }

  addToPrestaList() {
    if (!this.prestaEG.prestataire) {

    } else {

      this.prestaList.push(this.prestaEG);
      this.prestaEG = new Prestation();
    }
  }

  suppPrestaList(index) {
    this.prestaList.splice(index, 1);
  }

  addToOffre() {
    // console.log(this.offre);
    this.offre.prestations = this.prestaList;
    this.offre.id = 88;
    for (let presta of this.offre.prestations) {
      presta.phasePresta = "enConsult";
      presta.offre = new Offre();
      presta.offre.id = this.offre.id;
      presta.offre.version = this.offre.version;
    }

    console.log(this.offre.prestations)


    this.reponseAppelOffreService.createPrestations(this.offre.prestations).subscribe(resp => {
        this.reponseAppelOffreService.load();
        this.prestations = resp;
      },
      error => console.log(error)
    )
  }

  listPrestaValideeEG(): Observable<Array<Prestation>>{

    return this.reponseAppelOffreService.findPrestationByPhase();
    // this.reponseAppelOffreService.findPrestationByPhase().subscribe(resp => {
    // },
    //   error => console.log(error)
    // )
    // })
  }

}
