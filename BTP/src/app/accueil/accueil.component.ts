import {Component, forwardRef, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {AccueilService} from "./accueil.service";
import {MaitreOuvrage} from "../model/maitreOuvrage";
import {MaitreOeuvre} from "../model/maitreOeuvre";
import {Prestataire} from "../model/prestataire";
import {Utilisateur} from "../model/utilisateur";
import {Societe} from "../model/societe";
import {Adresse} from "../model/adresse";
import {NG_VALUE_ACCESSOR} from "@angular/forms";
import {SessionService} from "../session.service";

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.scss']
})
export class AccueilComponent implements OnInit {

  societeForm: any = new Societe();
  userForm: Utilisateur = new Utilisateur();
  inputType = 'password';
  showHideClass = 'fas fa-eye';

  constructor(public router : Router, private accueilService: AccueilService, private sessionService: SessionService) {
    this.societeForm.adresse = new Adresse();
    this.societeForm.utilisateur = new Utilisateur();
  }

  ngOnInit(): void {
  }

  showPassword(){
    if(this.userForm.motDePasse != null || this.societeForm.utilisateur.motDePasse != null)
    {
      if(this.inputType == 'password')
      {
        this.inputType = 'text';
        this.showHideClass = 'fas fa-eye-slash';
      }
      else
      {
        this.inputType = 'password';
        this.showHideClass = 'fas fa-eye';
      }
    }
  };

  type(){
    if (this.societeForm.type == "MOuvrage") {
      this.societeForm = new MaitreOuvrage(null, null, this.societeForm.type);
      this.societeForm.adresse = new Adresse();
      this.societeForm.utilisateur = new Utilisateur();
      console.log(this.societeForm)
      console.log(this.societeForm.type)
    }
    else if (this.societeForm.type == "MOeuvre") {
      this.societeForm = new MaitreOeuvre(null,null,this.societeForm.type);
      this.societeForm.adresse = new Adresse();
      this.societeForm.utilisateur = new Utilisateur();
      console.log(this.societeForm.type)
    }
    else if (this.societeForm.type == "Prestataire") {
      this.societeForm = new Prestataire(null,null,this.societeForm.type);
      this.societeForm.adresse = new Adresse();
      this.societeForm.utilisateur = new Utilisateur();
      console.log(this.societeForm.type)
    }
  }

  add() {
    this.societeForm = new Societe();
    this.societeForm.adresse = new Adresse();
    this.societeForm.utilisateur = new Utilisateur();

  }

  show(){
    console.log(this.userForm);
  }

  connexion(){
    console.log(this.userForm);
    this.accueilService.authentification(this.userForm).subscribe(resp => {
      console.log(resp);
      if(resp) {
        this.userForm = resp;
        this.sessionService.setUser(this.userForm);
        // sessionStorage.setItem('user', JSON.stringify(this.userForm))
        if (this.userForm.societe.type == 'MOuvrage') {
          [this.router.navigate(['accueilMO'])]
        } else if (this.userForm.societe.type == 'MOeuvre') {
          [this.router.navigate(['accueilMOE'])]
        } else if (this.userForm.societe.type == 'Prestataire') {
          [this.router.navigate(['accueilEG'])]
        }
        console.log(this.sessionService.getUser())
      } else {
        this.userForm = new Utilisateur();
      }
      // console.log(sessionStorage.getItem('user'))
      // console.log(JSON.parse(sessionStorage.getItem('user')))
    }, err => console.log(err));
  }

  save() {
    if (this.societeForm.type == 'MOuvrage') {
      this.accueilService.newMO(this.societeForm).subscribe(resp => {
          this.accueilService.load();
          this.societeForm = null;
        },
        error => console.log(error)
      )
      ;}
    else if (this.societeForm.type == 'MOeuvre') {
      this.accueilService.newMOE(this.societeForm).subscribe(resp => {
          this.accueilService.load();
          this.societeForm = null;
        },
        error => console.log(error)
      )
      ;
    } else if (this.societeForm.type == 'Prestataire') {
      this.accueilService.newPrestataire(this.societeForm).subscribe(resp => {
          this.accueilService.load();
          this.societeForm = null;
        },
        error => console.log(error)
      )
      ;
    }
  }

}
