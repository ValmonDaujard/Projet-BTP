import { Injectable } from '@angular/core';
import {Projet} from '../model/projet';
import {Offre} from '../model/offre';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AccueilMOService {

  private projets: Array<Projet> = new Array<Projet>();
  private offres: Array<Offre> = new Array<Offre>();

  constructor(private http: HttpClient) {
    this.load();
  }

  findAllByMaitreOuvrage(id: number): Observable<Array<Projet>>{
    return this.http.get<Array<Projet>>('http://localhost:8080/projet/by-maitre-ouvrage/' + id);
  }

  findAllByMaitreOuvrageEnConsult(id: number): Observable<Array<Offre>>{
    return this.http.get<Array<Offre>>('http://localhost:8080/offre/by-maitre-ouvrage-en-consult/' + id);
  }
  createProjet(newProjet : Projet){
    return this.http.post<Projet>('http://localhost:8080/projet/', newProjet);
}

  load(){
    this.http.get<Array<Projet>>('http://localhost:8080/projet').subscribe(resp => {this.projets = resp;
    }, error => console.log(error));
    this.http.get<Array<Offre>>('http://localhost:8080/offre').subscribe(resp => {this.offres = resp;
    }, error => console.log(error));
  }

}
