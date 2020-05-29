import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Projet} from "../model/projet";
import {Offre} from "../model/offre";

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
    return this.http.get<Offre>("http://localhost:8080/offre/" + id);
  }






}

