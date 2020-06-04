import {Component, OnInit} from '@angular/core';
import {ProfilService} from "./profil.service";
import {Utilisateur} from "../model/utilisateur";
import {ActivatedRoute, Router} from "@angular/router";
import {CommonService} from "../common.service";
import {Adresse} from "../model/adresse";
import {SessionService} from "../session.service";

@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.scss']
})
export class ProfilComponent implements OnInit {

  inputType = 'password';
  showHideClass = 'fas fa-eye';
  displayInput = 'display: none';
  displayButton = '';
  buttonText = 'Modifier'
  user: any = null;

  constructor(private router: Router,private route: ActivatedRoute, private profilService: ProfilService,  private sessionService : SessionService) {
    this.user = sessionService.getUser();
    if (!this.user.societe.adresse){
      this.user.societe.adresse = new Adresse();
    }
    console.log(this.user);
  }

  ngOnInit(): void {

  }

  update() {
    console.log(this.user);
    this.profilService.modifyUser(this.user).subscribe(resp => {
      this.profilService.findById(resp.id).subscribe(resp =>{
        this.sessionService.setUser(resp);
        this.user = this.sessionService.getUser();
        console.log(this.user);
        this.hautDePage();
      },error => console.log(error))
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
    if (this.displayInput == 'display: none') {
      this.displayInput = '';
      this.displayButton = 'display: none';
    }
  }

  hautDePage() {
    document.getElementById("nom").focus({preventScroll:false})
  }

}
