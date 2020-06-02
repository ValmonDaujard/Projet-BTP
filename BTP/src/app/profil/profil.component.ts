import { Component, OnInit } from '@angular/core';
import {ProfilService} from "./profil.service";
import {Utilisateur} from "../model/utilisateur";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.scss']
})
export class ProfilComponent implements OnInit {

  inputType = 'password';
  showHideClass = 'fas fa-eye';
  display = 'display: none';
  buttonText = 'Modifier'
  userForm: Utilisateur = new Utilisateur();

  constructor(private route: ActivatedRoute, private profilService: ProfilService) {
    this.route.params.subscribe(parameters => {
      this.profilService.findById(parameters.id).subscribe(resp => {
        this.userForm = resp;
        console.log(resp);
      }, error => console.log(error));})
  }

  ngOnInit(): void {
  }

  update(){
    // if (this.userForm.societe.type == 'MOuvrage') {
    //   this.profilService.modifyMO(this.userForm.societe).subscribe(resp => {
    //       this.profilService.load();
    //       this.userForm = null;
    //     },
    //     error => console.log(error)
    //   )
    //   ;}
    // else if (this.userForm.societe.type == 'MOeuvre') {
    //   this.profilService.modifyMOE(this.userForm.societe).subscribe(resp => {
    //       this.accueilService.load();
    //       this.userForm = null;
    //     },
    //     error => console.log(error)
    //   )
    //   ;
    // } else if (this.userForm.societe.type == 'Prestataire') {
    //   this.profilService.modifyPrestataire(this.userForm.societe).subscribe(resp => {
    //       this.profilService.load();
    //       this.userForm = null;
    //     },
    //     error => console.log(error)
    //   )
    //   ;
    // }
  };

  showPassword(){
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
  };

  showInput(){
    if(this.display == 'display: none')
    {
      this.display = '';
      this.buttonText = 'Garder';
    }
    else
    {
      this.display = 'display: none';
      this.buttonText = 'Modifier';
    }
  }

}
