import { Injectable } from '@angular/core';
import {Projet} from "../model/projet";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Prestation} from "../model/prestation";

@Injectable({
  providedIn: 'root'
})
export class AccueilEGService {


  private projets: Array<Projet> = new Array<Projet>();

  constructor(private http: HttpClient) {
    this.load();
  }

  findAllByPrestataire(id: number): Observable<Array<Projet>>{
    return this.http.get<Array<Projet>>('http://localhost:8080/projet/by-prestataire/' + id);
  }

  findPrestationByPhaseByEG(id: number): Observable<Array<Prestation>>{
    return this.http.get<Array<Prestation>>('http://localhost:8080/prestation/by-phase-and-EG/enConsult:' + id);
  }

  load(){
    this.http.get<Array<Projet>>('http://localhost:8080/projet').subscribe(resp => {this.projets = resp;
    }, error => console.log(error));
  }
}
