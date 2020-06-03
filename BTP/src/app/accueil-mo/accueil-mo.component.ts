import { Component, OnInit } from '@angular/core';
import {Projet} from '../model/projet';
import {Offre} from '../model/offre';
import {AccueilMOService} from './accueil-mo.service';
import {ActivatedRoute} from "@angular/router";
import {SessionService} from "../session.service";

@Component({
  selector: 'app-accueil-mo',
  templateUrl: './accueil-mo.component.html',
  styleUrls: ['./accueil-mo.component.scss']
})
export class AccueilMOComponent implements OnInit {

  projets: Array<Projet> = new Array<Projet>();
  offres: Array<Offre> = new Array<Offre>();
  user: any = null;

  constructor(private accueilMOService: AccueilMOService, private route: ActivatedRoute, private sessionService : SessionService) {
    this.user = this.sessionService.getUser();
    this.list(this.user.societe.id)
  }

  ngOnInit(): void {
  }

  list(id: number){
    this.accueilMOService.findAllByMaitreOuvrage(id).subscribe(resp => this.projets = resp, error => console.log(error));
    this.accueilMOService.findAllByMaitreOuvrageEnConsult(id).subscribe(resp => this.offres = resp, error => console.log(error));
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
  rechercheAppel() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("appelSearch");
    filter = input.value.toUpperCase();
    table = document.getElementById("appelTable");
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
