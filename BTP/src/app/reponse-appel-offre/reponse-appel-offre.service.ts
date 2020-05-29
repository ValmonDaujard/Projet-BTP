import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Prestataire} from "../model/prestataire";
import {Offre} from "../model/offre";
import {Prestation} from "../model/prestation";


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

  createOffre(offre: Offre) {
    return this.http.post<Offre>("http://localhost:8080/offre/", offre);
  }

  load() {
    this.http.get<Array<Prestataire>>("http://localhost:8080/prestataire/").subscribe(resp => {
      this.egs = resp;
    }, error => console.log(error))
  }
}
