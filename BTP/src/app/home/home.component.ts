import { Component, OnInit } from '@angular/core';
import {Projet} from '../model/projet';
import {HomeService} from './home.service';
import {Observable} from 'rxjs';
import {Offre} from '../model/offre';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  search : string;
  projets: Array<Projet> = new Array<Projet>();
  offres: Array<Offre> = new Array<Offre>();

  constructor(private homeService: HomeService) {
    this.list(8);
  }

  ngOnInit(): void {
  }


  list(id: number){
    this.homeService.findAllByMaitreOeuvre(id).subscribe(resp => this.projets = resp, error => console.log(error));
    this.homeService.findAllByMaitreOeuvreEnConsult(id).subscribe(resp => this.offres = resp, error => console.log(error));
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
}
