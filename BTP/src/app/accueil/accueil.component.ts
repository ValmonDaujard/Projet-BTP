import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {AccueilService} from "./accueil.service";
import {MaitreOuvrage} from "../model/maitreOuvrage";
import {MaitreOeuvre} from "../model/maitreOeuvre";
import {Prestataire} from "../model/prestataire";
import {Utilisateur} from "../model/utilisateur";
import {Societe} from "../model/societe";
import {Adresse} from "../model/adresse";

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.scss']
})
export class AccueilComponent implements OnInit {

  societeForm: Societe = new Societe();
  userForm: Utilisateur = null;
  selectedDisc = null;

  constructor(private accueilService: AccueilService) { }

  ngOnInit(): void {
  }

  // accueil(){
  //   this.router.navigate(['accueil']);
  // }
  type(indice: number){
    this.selectedDisc = indice;
    if (this.selectedDisc == 0) {
      this.societeForm = new MaitreOuvrage();
      this.societeForm.adresse = new Adresse();
      this.societeForm.utilisateur = new Utilisateur();
    }
    else if (this.selectedDisc == 1) {
      this.societeForm = new MaitreOeuvre();
      this.societeForm.adresse = new Adresse();
      this.societeForm.utilisateur = new Utilisateur();
    }
    else if (this.selectedDisc == 2) {
      this.societeForm = new Prestataire();
      this.societeForm.adresse = new Adresse();
      this.societeForm.utilisateur = new Utilisateur();
    }
  }

  add() {
    this.societeForm = new Societe();
    this.societeForm.adresse = new Adresse();
    this.societeForm.utilisateur = new Utilisateur();

  }

  connexion(identifiant: string, mdp: string){
    this.accueilService.findByIdentifiantAndMotDePasse(identifiant, mdp).subscribe(resp => {
      this.userForm = resp;
    }, err => console.log(err));
  }

  save() {
    if (this.selectedDisc == 0) {
      this.accueilService.newMO(this.societeForm).subscribe(resp => {
          this.accueilService.load();
          this.selectedDisc = null;
          this.societeForm = null;
        },
        error => console.log(error)
      )
      ;}
    else if (this.selectedDisc == 1) {
      this.accueilService.newMOE(this.societeForm).subscribe(resp => {
          this.accueilService.load();
          this.selectedDisc = null;
          this.societeForm = null;
        },
        error => console.log(error)
      )
      ;
    } else if (this.selectedDisc == 2) {
      this.accueilService.newPrestataire(this.societeForm).subscribe(resp => {
          this.accueilService.load();
          this.selectedDisc = null;
          this.societeForm = null;
        },
        error => console.log(error)
      )
      ;
    }
  }

}
