import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Projet} from "../model/projet";
import {Societe} from "../model/societe";

@Injectable({
  providedIn: 'root'
})
export class AccueilService {

  private societes: Array<Societe> = new Array<Societe>();

  constructor(private http: HttpClient) {
    this.load();
  }

  create(societe: Societe) {
    return this.http.post<Societe>("http://localhost:8080/societe", societe);
  }

  load() {
    this.http.get<Array<Societe>>("http://localhost:8080/societe").subscribe(resp => {
      this.societes = resp;
    }, error => console.log(error))
  }

}
