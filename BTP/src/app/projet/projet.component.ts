import {Component, OnInit} from '@angular/core';
import {ProjetService} from "./projet.service";
import {Projet} from "../model/projet";
import {Observable} from "rxjs";
import {ActivatedRoute} from "@angular/router";
import {Offre} from "../model/offre";
import {Prestataire} from "../model/prestataire";
import {Prestation} from "../model/prestation";

@Component({
  selector: 'app-projet',
  templateUrl: './projet.component.html',
  styleUrls: ['./projet.component.scss']
})
export class ProjetComponent implements OnInit {

  projet: Projet = null;
  offreref: Offre = new Offre();
 prestationref: Array<Prestation> = new Array<Prestation>();



  constructor(private projetService: ProjetService, private route: ActivatedRoute) {
    this.route.params.subscribe(parameters=> {
      this.projetService.findById(parameters.id).subscribe(resp => {
        this.projet = resp;


        // call appel offre
        this.projetService.findOffre(this.projet.offre.id).subscribe(resp => {
          this.offreref =resp;}) ;
        this.projetService.findPrestations(this.projet.id).subscribe(resp => {
          this.prestationref =resp;}) ;
        console.log(resp);
        })
      })
    }


  ngOnInit(): void {

  }


  }



