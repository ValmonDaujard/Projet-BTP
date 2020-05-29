import {Component, OnInit} from '@angular/core';
import {ProjetService} from "./projet.service";
import {Projet} from "../model/projet";
import {Observable} from "rxjs";
import {ActivatedRoute} from "@angular/router";
import {Offre} from "../model/offre";

@Component({
  selector: 'app-projet',
  templateUrl: './projet.component.html',
  styleUrls: ['./projet.component.scss']
})
export class ProjetComponent implements OnInit {

  projet: Projet = null;
  offreref: Offre = new Offre();



  constructor(private projetService: ProjetService, private route: ActivatedRoute) {
    this.route.params.subscribe(parameters=> {
      this.projetService.findById(parameters.id).subscribe(resp => {
        this.projet = resp;


        // call appel offre
        this.projetService.findOffre(this.projet.offre.id).subscribe(resp => {
          this.offreref = resp;});
        console.log(resp);
        })
      })
    }


  ngOnInit(): void {

  }


  }



