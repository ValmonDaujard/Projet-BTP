import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Projet} from "../model/projet";

@Injectable({
  providedIn: 'root'
})
export class ProjetService {

  private projets: Array<Projet> = new Array<Projet>();

  constructor(private http: HttpClient) {
    this.load();
  }

  findAll(): Array<Projet> {
    return this.projets;
  }

  findById(id: number): Observable<Projet> {
    return this.http.get<Projet>("http://localhost:8080/api/projet/" + id);
  }








  }

