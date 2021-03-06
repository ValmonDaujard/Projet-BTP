import {Component, OnInit} from '@angular/core';
import {ReponseAppelOffreService} from "./reponse-appel-offre.service";
import {Prestataire} from "../model/prestataire";
import {Prestation} from "../model/prestation";
import {Offre} from "../model/offre";
import {Projet} from "../model/projet";
import {ActivatedRoute, Router} from "@angular/router";
import {MaitreOuvrage} from "../model/maitreOuvrage";
import {SessionService} from "../session.service";
import {AppelOffre} from "../model/appelOffre";


@Component({
  selector: 'app-reponse-appel-offre',
  templateUrl: './reponse-appel-offre.component.html',
  styleUrls: ['./reponse-appel-offre.component.scss']
})
export class ReponseAppelOffreComponent implements OnInit {

  appelOffre: AppelOffre = new AppelOffre();
  prestaEG: Prestation = new Prestation();
  prestaList: Array<Prestation> = new Array<Prestation>();
  prestations: Array<Prestation> = new Array<Prestation>();
  prestaValideesEG: Array<Prestation> = new Array<Prestation>();
  prestaValideesMO: Array<Prestation> = new Array<Prestation>();
  offre: Offre = new Offre();
  projet: Projet = new Projet();
  currentPresta: Prestation = null;
  marge: number;
  prixTTC: number;
  prestaForm: Prestation = null;
  user: any = null;


  constructor(public router: Router, private reponseAppelOffreService: ReponseAppelOffreService, private route: ActivatedRoute, private sessionService : SessionService) {
    this.user = this.sessionService.getUser();
    this.route.params.subscribe(parameters => {
      this.reponseAppelOffreService.findOffreById(parameters.id).subscribe(resp=> {
        this.offre = resp;
        console.log(this.offre);
        this.reponseAppelOffreService.findPrestationByPhaseValideMOAndOffre(this.offre.id).subscribe(resp => {
          console.log(resp);
          this.prestaValideesMO = resp;
          console.log(this.prestaValideesMO);
        }, error => console.log(error));
      }, error => console.log(error));
    }, error => console.log(error));
    // this.offre.maitreOuvrage = this.appelOffre.maitreOuvrage;
    // this.offre.maitreOeuvre = this.user.societe;
    // this.offre.id = 88;
  }

  ngOnInit(): void {
  }

  // findAppelOffre(id: number) {
  //   this.reponseAppelOffreService.findAppelOffreById(id).subscribe(resp=> {
  //     this.appelOffre = resp;
  //   }, error => console.log(error));
  // }

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
    // this.offre.prestations = this.prestaList;
    // this.offre.id = 40;
    // this.offre.version = 1
    for (let presta of this.prestaList) {
      presta.phasePresta = "enConsult";
      presta.offre = this.offre;
      presta.categorie = "grosOeuvre";
      // presta.offre = new Offre();
      // presta.offre = this.offre;
      // presta.offre.version = this.offre.version;
    }


    this.reponseAppelOffreService.createPrestations(this.prestaList).subscribe(resp => {
        this.reponseAppelOffreService.load();
        this.prestaList = resp;
        console.log(this.prestaList);
        this.prestaList = new Array<Prestation>();
      },
      error => console.log(error)
    )
  }

  listPrestaValideeEG(id:number) {

    return this.reponseAppelOffreService.findPrestationByPhaseValideEG();

    // this.reponseAppelOffreService.findPrestationByOffreEtPhaseValideEG(id).subscribe(resp => {
    //   this.prestaValideesEG = resp;
    //   }, error => console.log(error));
    }

    calculTotalHT(): number {
      let total:number = 0;

      // for(let presta of this.reponseAppelOffreService.findPrestationByPhaseValideeMO()) {
      for(let presta of this.prestaValideesMO) {
        total+=presta.prix;
      }
      return total;
  }

  calculTotalTTC(): number {
    let total:number = 0;

    // for(let presta of this.reponseAppelOffreService.findPrestationByPhaseValideeMO()) {
    for(let presta of this.prestaValideesMO) {
      total+=presta.prix;
    }
    if(!this.marge) {
      this.prixTTC = total;
    } else {
      total = total * ((this.marge / 100) + 1);
      this.prixTTC = total;
    }

    return total;
  }

  suppPrestaValideeEG(id) {
    this.reponseAppelOffreService.deleteById(id);
  }

  // listPrestaValideeMO(id: number) {
  //   return this.reponseAppelOffreService.findPrestationByPhaseValideeMOAndProjet(id).subscribe(resp => {
  //     this.prestaValideesMO = resp;
  //
  //   }, error => console.log(error));
  //
  //   // this.reponseAppelOffreService.findPrestationByOffreEtPhaseValideMO(id).subscribe(resp => {
  //   //   this.prestaValideesMO = resp;
  //   // }, error => console.log(error));
  // }

  validerPresta(id: number) {
    this.reponseAppelOffreService.findPrestaById(id).subscribe(resp => {
      this.currentPresta = resp;
      this.currentPresta.phasePresta = "ValideMOeuvre";
      this.reponseAppelOffreService.modifyPresta(this.currentPresta).subscribe(resp => {
        this.currentPresta = resp;
        this.reponseAppelOffreService.load();
        this.reponseAppelOffreService.findPrestationByPhaseValideMOAndOffre(this.offre.id).subscribe(resp => {
          console.log(resp);
          this.prestaValideesMO = resp;
          console.log(this.prestaValideesMO)}, error => console.log(error));
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
        this.currentPresta = resp;
        this.reponseAppelOffreService.load();
        this.reponseAppelOffreService.findPrestationByPhaseValideMOAndOffre(this.offre.id).subscribe(resp => {
          console.log(resp);
          this.prestaValideesMO = resp;
          console.log(this.prestaValideesMO)}, error => console.log(error));
        this.currentPresta = null;
      }, error => console.log(error));
    })
  }

  offreConsultable() {
      this.offre.prix = this.prixTTC;
        this.offre.etat = "consult";


        this.reponseAppelOffreService.createOffre(this.offre).subscribe(resp => {
          this.offre = resp;
          this.router.navigate(['accueilMOE']);
        }, error => console.log(error));

        this.offre = new Offre();

  }

  addLigne() {
    this.prestaForm= new Prestation();
  }

  addPresta() {
    this.prestaForm.phasePresta = "ValideMOeuvre";
    this.prestaForm.offre = this.offre;
    this.prestaForm.categorie = "autre";
    // this.prestaForm.prestataire = this.user.societe;
      // new Prestataire(null,null,null, this.user.societe.nom)
    // console.log(this.user)
    this.reponseAppelOffreService.createPresta(this.prestaForm).subscribe(resp => {
        this.prestaForm = resp;
        this.prestaForm = null;
        this.reponseAppelOffreService.load();
        this.reponseAppelOffreService.findPrestationByPhaseValideMOAndOffre(this.offre.id).subscribe(resp => {
          console.log(resp);
          this.prestaValideesMO = resp;
          console.log(this.prestaValideesMO)}, error => console.log(error));
      },
      error => console.log(error)
    )
    ;
  }

  annulPresta() {
    this.prestaForm = null;
  }

}
