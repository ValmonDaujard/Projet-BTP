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
  user: any = null;

  constructor(private router: Router,private route: ActivatedRoute, private profilService: ProfilService, private commonService: CommonService) {
    // this.route.params.subscribe(parameters => {
    //   this.profilService.findById(parameters.id).subscribe(resp => {
    //     this.userForm = resp;
    //     console.log(resp);
    //   }, error => console.log(error));})
    this.commonService.findByIdentifiantAndMotDePasse(sessionStorage.getItem('identifiant'), sessionStorage.getItem('mdp')).subscribe(resp => {
      this.user = resp;
      console.log(this.user);
      if(!this.user.societe.adresse) {
        this.user.societe.adresse = new Adresse();
      }
    }, err => console.log(err));
  }

  ngOnInit(): void {

  }

  update() {
    this.profilService.modifyUser(this.user).subscribe(resp => {
        this.user = null;
        console.log(this.user);
        this.router.navigate(['']);
        this.router.navigate(['/profil']);
      },error => console.log(error)
    )
    ;
    // if (this.user.societe.type == 'MOuvrage') {
    //   this.profilService.modifyMO(this.user).subscribe(resp => {
    //       this.user = null;
    //     },
    //     error => console.log(error)
    //   )
    //   ;
    // } else if (this.user.societe.type == 'MOeuvre') {
    //   this.profilService.modifyMOE(this.user).subscribe(resp => {
    //       this.user = null;
    //     },
    //     error => console.log(error)
    //   )
    //   ;
    // } else if (this.user.societe.type == 'Prestataire') {
    //   this.profilService.modifyPrestataire(this.user).subscribe(resp => {
    //       this.user = null;
    //     },
    //     error => console.log(error)
    //   )
    //   ;
    // }
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
