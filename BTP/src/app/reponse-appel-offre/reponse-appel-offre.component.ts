import {Component, OnInit} from '@angular/core';
import {ReponseAppelOffreService} from "./reponse-appel-offre.service";
import {Prestataire} from "../model/prestataire";
import {Prestation} from "../model/prestation";
import {Offre} from "../model/offre";
import {Observable} from "rxjs";
import {Projet} from "../model/projet";
import {ProjetService} from "../projet-moe/projet.service";
import {ActivatedRoute} from "@angular/router";
import {MaitreOuvrage} from "../model/maitreOuvrage";
import {SessionService} from "../session.service";


@Component({
  selector: 'app-reponse-appel-offre',
  templateUrl: './reponse-appel-offre.component.html',
  styleUrls: ['./reponse-appel-offre.component.scss']
})
export class ReponseAppelOffreComponent implements OnInit {

  prestaEG: Prestation = new Prestation();
  prestaList: Array<Prestation> = new Array<Prestation>();
  prestations: Array<Prestation> = new Array<Prestation>();
  prestaValideesEG: Array<Prestation> = new Array<Prestation>();
  offre: Offre = new Offre();
  projet: Projet = new Projet();
  currentPresta: Prestation = null;
  marge: number;
  prixTTC: number;


  constructor(private reponseAppelOffreService: ReponseAppelOffreService, private route: ActivatedRoute, private sessionService : SessionService) {
    this.sessionService.getUser()
    this.route.params.subscribe(parameters => {
      this.getMOuvrage(parameters.id);
    });
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
    this.offre.prestations = this.prestaList;
    // this.offre.id = 40;
    for (let presta of this.offre.prestations) {
      presta.phasePresta = "enConsult";
      presta.offre = new Offre();
      presta.offre.id = this.offre.id;
      presta.offre.version = this.offre.version;
      this.prestaList = new Array<Prestation>();
    }

    this.reponseAppelOffreService.createPrestations(this.offre.prestations).subscribe(resp => {
        this.reponseAppelOffreService.load();
        this.prestations = resp;
      },
      error => console.log(error)
    )
  }

  listPrestaValideeEG(): Array<Prestation> {

    return this.reponseAppelOffreService.findPrestationByPhaseValideEG();
    // return this.reponseAppelOffreService.findPrestationByPhaseConsult();
    }

    calculTotalHT(): number {
      let total:number = 0;

      for(let presta of this.reponseAppelOffreService.findPrestationByPhaseValideeMO()) {
        total+=presta.prix;
      }
      return total;
    }

  calculTotalTTC(): number {
    let total:number = 0;

    for(let presta of this.reponseAppelOffreService.findPrestationByPhaseValideeMO()) {
      total+=presta.prix;
    }
      total = total*((this.marge/100)+1);
      this.prixTTC = total;

    return total;
  }

  suppPrestaValideeEG(id) {
    this.reponseAppelOffreService.deleteById(id);
  }

  listPrestaValideeMO() {
    return this.reponseAppelOffreService.findPrestationByPhaseValideeMO();
  }

  validerPresta(id: number) {
    this.reponseAppelOffreService.findPrestaById(id).subscribe(resp => {
      this.currentPresta = resp;
      this.currentPresta.phasePresta = "ValideMOeuvre";
      this.reponseAppelOffreService.modifyPresta(this.currentPresta).subscribe(resp => {
        this.reponseAppelOffreService.load();
        this.currentPresta = null;
      }, error => console.log(error));
    })
  }

  annulerPresta(id: number) {
    this.reponseAppelOffreService.findPrestaById(id).subscribe(resp => {
      this.currentPresta = resp;
      // this.currentPresta.phasePresta = "enConsult";
      this.currentPresta.phasePresta = "ValideEG";
      this.reponseAppelOffreService.modifyPresta(this.currentPresta).subscribe(resp => {
        this.reponseAppelOffreService.load();
        this.currentPresta = null;
      }, error => console.log(error));
    })
  }

  offreConsultable() {
      this.offre.prix = this.prixTTC;
      this.offre.numeroDevis = 55555;
      this.offre.dtDebut = new Date(2020, 0O5, 0O5);
      this.offre.dtFin = new Date(2020, 0O7, 0O5);
      this.offre.etat = "consult";

      this.reponseAppelOffreService.createOffre(this.offre).subscribe(resp => {
    }, error => console.log(error));

      this.offre = new Offre();
  }

  getMOuvrage(id: number) {
    this.reponseAppelOffreService.findMOuvrageByAppelOffre(id).subscribe(resp => {
      this.offre.maitreOuvrage = resp;
    }, error => console.log(error));
  }


}
