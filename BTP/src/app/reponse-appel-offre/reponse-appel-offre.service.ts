import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Prestataire} from "../model/prestataire";
import {Stagiaire} from "../../../../../covid-formation/formation-angular/src/app/model/stagiaire";


@Injectable({
  providedIn: 'root'
})
export class ReponseAppelOffreService {

  private egs: Array<Prestataire> = new Array<Prestataire>();


  constructor(private http: HttpClient) {
    this.load();
  }

  findAll(): Array<Prestataire> {
    return this.egs
  }

  load() {
    this.http.get<Array<Prestataire>>("http://localhost:8080/prestataire/").subscribe(resp => {
      this.egs = resp;
    }, error => console.log(error))
  }
}
