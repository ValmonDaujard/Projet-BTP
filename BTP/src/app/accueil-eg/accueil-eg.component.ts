import { Component, OnInit } from '@angular/core';
import {Projet} from "../model/projet";
import {AccueilEGService} from "./accueil-eg.service";
import {Prestation} from "../model/prestation";
import {ActivatedRoute} from "@angular/router";
import {SessionService} from "../session.service";

@Component({
  selector: 'app-accueil-eg',
  templateUrl: './accueil-eg.component.html',
  styleUrls: ['./accueil-eg.component.scss']
})
export class AccueilEGComponent implements OnInit {

  projets: Array<Projet> = new Array<Projet>();
  prestations: Array<Prestation> = new Array<Prestation>();
  user: any = null;

  constructor(private accueilEGService: AccueilEGService, private route : ActivatedRoute, private sessionService : SessionService) {
    this.user = this.sessionService.getUser();
    this.list(this.user.societe.id);
  }


  list(id: number){
    this.accueilEGService.findAllByPrestataire(id).subscribe(resp => this.projets = resp, error => console.log(error));
    this.accueilEGService.findPrestationByPhaseByEG(id).subscribe(resp => this.prestations = resp, error => console.log(error));
  }

  ngOnInit(): void {
    this.user = JSON.parse(sessionStorage.getItem('user'));
    this.list(this.user.societe.id);
  }


  rechercheConsult() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("consultSearch");
    filter = input.value.toUpperCase();
    table = document.getElementById("consultTable");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
      td = tr[i].getElementsByTagName("td")[0];
      if (td) {
        txtValue = td.textContent || td.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
          tr[i].style.display = "";
        } else {
          tr[i].style.display = "none";
        }
      }
    }
  }


  rechercheProj() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("projetSearch");
    filter = input.value.toUpperCase();
    table = document.getElementById("projetTable");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
      td = tr[i].getElementsByTagName("td")[0];
      if (td) {
        txtValue = td.textContent || td.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
          tr[i].style.display = "";
        } else {
          tr[i].style.display = "none";
        }
      }
    }
  }
}
