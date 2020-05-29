import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Projet} from "../model/projet";
import {Offre} from "../model/offre";
import {Prestataire} from "../model/prestataire";
import {Prestation} from "../model/prestation";

@Injectable({
  providedIn: 'root'
})
export class ProjetService {

  private projets: Array<Projet> = new Array<Projet>();

  constructor(private http: HttpClient) {

  }

  findAll(): Array<Projet> {
    return this.projets;
  }

  findById(id: number): Observable<Projet> {
    return this.http.get<Projet>("http://localhost:8080/projet/" + id);
  }

  findOffre(id: number): Observable<Offre> {
    let offreObservable = this.http.get<Offre>("http://localhost:8080/offre/" + id);
    return offreObservable;
  }

  findPrestations(id: number) : Observable<Array<Prestation>> {
    return this.http.get<Array<Prestation>>("http://localhost:8080/prestation/par-projet/" + id);
  }




}

