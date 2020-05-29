import { Injectable } from '@angular/core';
import {Projet} from "../model/projet";
import {Offre} from "../model/offre";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AccueilMOEService {

  private projets: Array<Projet> = new Array<Projet>();
  private offres : Array<Offre> = new Array<Offre>();

  constructor(private http: HttpClient) {
    this.load();
  }

  findAllByMaitreOeuvre(id: number): Observable<Array<Projet>>{
    return this.http.get<Array<Projet>>('http://localhost:8080/projet/by-maitre-oeuvre/' + id);
  }

  findAllByMaitreOeuvreEnConsult(id: number): Observable<Array<Offre>>{
    return this.http.get<Array<Offre>>('http://localhost:8080/offre/by-maitre-oeuvre-en-consult/' + id);
  }

  load(){
    this.http.get<Array<Projet>>('http://localhost:8080/projet').subscribe(resp => {this.projets = resp;
    }, error => console.log(error));
    this.http.get<Array<Offre>>('http://localhost:8080/offre').subscribe(resp => {this.offres = resp;
    }, error => console.log(error));
  }
}
