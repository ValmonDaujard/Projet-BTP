import { Component, OnInit } from '@angular/core';
import {Projet} from "../model/projet";
import {Offre} from "../model/offre";
import {AccueilMOEService} from "./accueil-moe.service";

@Component({
  selector: 'app-accueil-moe',
  templateUrl: './accueil-moe.component.html',
  styleUrls: ['./accueil-moe.component.scss']
})
export class AccueilMOEComponent implements OnInit {

  projets: Array<Projet> = new Array<Projet>();
  offres: Array<Offre> = new Array<Offre>();

  constructor(private accueilMOEService: AccueilMOEService) {
    this.list(41);
  }

  ngOnInit(): void {
  }


  list(id: number){
    this.accueilMOEService.findAllByMaitreOeuvre(id).subscribe(resp => this.projets = resp, error => console.log(error));
    this.accueilMOEService.findAllByMaitreOeuvreEnConsult(id).subscribe(resp => this.offres = resp, error => console.log(error));
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
