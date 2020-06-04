import { Component, OnInit } from '@angular/core';
import {AppelOffre} from '../model/appelOffre';
import {CreationAppelOffreService} from './creation-appel-offre.service';
import {MaitreOeuvre} from '../model/maitreOeuvre';
import {Adresse} from '../model/adresse';
import {Offre} from '../model/offre';
import {subscribeOn} from 'rxjs/operators';
import {SessionService} from '../session.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-creation-appel-offre',
  templateUrl: './creation-appel-offre.component.html',
  styleUrls: ['./creation-appel-offre.component.scss']
})
export class CreationAppelOffreComponent implements OnInit {

  appelOffre : AppelOffre = new AppelOffre();
  user: any = null;
  maitreOeuvres : Array<MaitreOeuvre> = new Array<MaitreOeuvre>();
  adresse: Adresse = new Adresse();
  offre: Offre = new Offre();
  maitreOeuvre: MaitreOeuvre = new MaitreOeuvre();

  constructor(private creationAppelOffreService: CreationAppelOffreService, private sessionService: SessionService, public router: Router) {
    this.user = this.sessionService.getUser();
    this.appelOffre.adresse = this.adresse;
    this.list();
  }

  list(){
    this.creationAppelOffreService.findAllMaitreOeuvre().subscribe(resp => {this.maitreOeuvres = resp; console.log(this.maitreOeuvres)}, error => console.log(error));
  }

  ngOnInit(): void {
  }

  save(){
    this.appelOffre.maitreOuvrage = this.user.societe;
    this.creationAppelOffreService.create(this.appelOffre).subscribe(resp => {
      this.appelOffre = resp;
      console.log(this.appelOffre);
      this.creationAppelOffreService.load();
      this.offre.dtDebut = this.appelOffre.dtDebut;
      this.offre.dtFin = this.appelOffre.dtFin;
      this.offre.maitreOeuvre = this.maitreOeuvre;
      this.offre.appelOffre = this.appelOffre;
      this.offre.maitreOuvrage = this.user.societe;
      this.offre.etat = "consult";
      this.creationAppelOffreService.createOffre(this.offre).subscribe(resp => {this.offre = resp, this.router.navigate(['accueilMO'])}, error => console.log(error));
    })
  }

  chargeMaitreOeuvre(id:number){
    this.creationAppelOffreService.findByIdMaitreOeuvre(id).subscribe(resp => {this.maitreOeuvre = resp; console.log(this.maitreOeuvre)}, error => console.log(error));
  }

}
