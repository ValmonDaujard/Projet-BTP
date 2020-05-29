import { Component, OnInit } from '@angular/core';
import {Projet} from '../model/projet';
import {HomeService} from './home.service';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  projets: Array<Projet> = new Array<Projet>();

  constructor(private homeService: HomeService) {
    this.list(7);
  }

  ngOnInit(): void {
  }

  // list(): Array<Projet>{
  //   return  this.homeService.findAll();
  // }

  list(id: number){
    this.homeService.findAllByMaitreOeuvre(id).subscribe(resp => this.projets = resp, error => console.log(error));
  }

}
