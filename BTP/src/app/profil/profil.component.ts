import {Component, OnInit} from '@angular/core';
import {ProfilService} from "./profil.service";
import {Utilisateur} from "../model/utilisateur";
import {ActivatedRoute, Router} from "@angular/router";
import {CommonService} from "../common.service";
import {Adresse} from "../model/adresse";

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
  user: Utilisateur = null;

  constructor(private router: Router,private route: ActivatedRoute, private profilService: ProfilService) {
    this.user = JSON.parse(sessionStorage.getItem('user'));
  }

  ngOnInit(): void {

  }

  update() {
    console.log(this.user);
    this.profilService.modifyUser(this.user).subscribe(resp => {
      this.user = resp;
      sessionStorage.setItem('user', JSON.stringify(this.user));
      console.log(this.user);
      },error => console.log(error)
    ) ;
  };

  showPassword() {
    if (this.inputType == 'password') {
      this.inputType = 'text';
      this.showHideClass = 'fas fa-eye-slash';
    } else {
      this.inputType = 'password';
      this.showHideClass = 'fas fa-eye';
    }
  };

  showInput() {
    if (this.display == 'display: none') {
      this.display = '';
      this.buttonText = 'En fait non';
    } else {
      this.display = 'display: none';
      this.buttonText = 'Modifier';
    }
  }

}
