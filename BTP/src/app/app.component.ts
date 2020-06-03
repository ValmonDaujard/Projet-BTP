import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {AccueilComponent} from "./accueil/accueil.component";
import {CommonService} from "./common.service";
import {Adresse} from "./model/adresse";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'BTP';
  user: any = null;
  constructor(public router: Router){
    this.user = JSON.parse(sessionStorage.getItem('user'));
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

  deconnexion(){
    sessionStorage.clear()
  }

  edit(id: number){

  }
}





