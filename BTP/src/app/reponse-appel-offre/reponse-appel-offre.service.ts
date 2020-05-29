import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Prestataire} from "../model/prestataire";
import {Offre} from "../model/offre";
import {Prestation} from "../model/prestation";
import {Observable} from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class ReponseAppelOffreService {

  private egs: Array<Prestataire> = new Array<Prestataire>();
  private prestaValideeEG: Array<Prestation> = new Array<Prestation>();


  constructor(private http: HttpClient) {
    this.load();
  }

  findAll(): Array<Prestataire> {
    return this.egs
  }

  findPrestationByPhase(): Observable<Array<Prestation>> {
    // return this.prestaValideeEG;
    return this.http.get<Array<Prestation>>("http://localhost:8080/prestation/by-phase/enConsult");
  }

  createPrestations(prestations: Array<Prestation>) {
    return this.http.post<Array<Prestation>>("http://localhost:8080/prestation/multiple", prestations);
  }

  load() {
    this.http.get<Array<Prestataire>>("http://localhost:8080/prestataire/").subscribe(resp => {
      this.egs = resp;
    }, error => console.log(error))
  }
}
