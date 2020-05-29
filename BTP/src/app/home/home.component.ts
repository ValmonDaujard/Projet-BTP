import { Component, OnInit } from '@angular/core';
import {Projet} from '../model/projet';
import {HomeService} from './home.service';
import {Observable} from "rxjs";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  projetList: Projet = null;

  constructor(private homeService: HomeService) { }

  ngOnInit(): void {
  }

  // list(): Array<Projet>{
  //   return  this.homeService.findAll();
  // }

  list(id: number): Observable<Projet>{
    return this.homeService.findAllByMaitreOeuvre(id);
  }

}
