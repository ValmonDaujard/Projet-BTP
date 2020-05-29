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

}
