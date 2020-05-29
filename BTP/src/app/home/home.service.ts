import { Injectable } from '@angular/core';
import {Projet} from '../model/projet';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  private projets: Array<Projet> = new Array<Projet>();

  constructor(private http: HttpClient) {
    this.load();
  }

  // findAll(): Array<Projet>{
  //   return this.projets;
  // }

  findAllByMaitreOeuvre(id: number): Observable<Array<Projet>>{
    return this.http.get<Array<Projet>>('http://localhost:8080/projet/by-maitre-oeuvre/' + id);
  }

  load(){
    this.http.get<Array<Projet>>('http://localhost:8080/projet').subscribe(resp => {this.projets = resp;
    }, error => console.log(error));
  }
}
