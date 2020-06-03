import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {AccueilComponent} from "./accueil/accueil.component";
import {CommonService} from "./common.service";
import {Adresse} from "./model/adresse";
import {SessionService} from "./session.service";
import {Utilisateur} from "./model/utilisateur";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'BTP';
  user: any = null;
  constructor(public router: Router, private sessionService: SessionService){

  }


  w3_open() {
    document.getElementById('main').style.marginLeft = '20%';
    document.getElementById('mySidebar').style.width = '20%';
    document.getElementById('mySidebar').style.display = 'block';
    document.getElementById('openNav').style.display = 'none';
    document.getElementById('titre').style.marginLeft = '5%';
    document.getElementById('myOverlay').style.display = 'block';
  }
  w3_close() {
    document.getElementById('main').style.marginLeft = '0%';
    document.getElementById('mySidebar').style.display = 'none';
    document.getElementById('openNav').style.display = 'inline-block';
    document.getElementById('titre').style.marginLeft = '0%';
    document.getElementById('myOverlay').style.display = 'none';
  }

  accueil(){
    if(this.sessionUser().societe.type == 'MOuvrage'){
      [this.router.navigate(['accueilMO'])]
    }
    else if(this.sessionUser().societe.type == 'MOeuvre'){
      [this.router.navigate(['accueilMOE'])]
    }
    else if(this.sessionUser().societe.type == 'Prestataire'){
      [this.router.navigate(['accueilEG'])]
    }
    this.w3_close()
  }

  deconnexion(){
    sessionStorage.clear()

  }

  sessionUser(): Utilisateur {
    return this.sessionService.getUser();
  }

  edit(id: number){

  }
}





