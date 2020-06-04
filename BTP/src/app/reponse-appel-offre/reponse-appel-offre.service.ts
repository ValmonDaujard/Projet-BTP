import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Prestataire} from "../model/prestataire";
import {Prestation} from "../model/prestation";
import {Observable} from "rxjs";
import {Offre} from "../model/offre";
import {MaitreOuvrage} from "../model/maitreOuvrage";
import {AppelOffre} from "../model/appelOffre";



@Injectable({
  providedIn: 'root'
})
export class ReponseAppelOffreService {

  private egs: Array<Prestataire> = new Array<Prestataire>();
  private prestaValideesEG: Array<Prestation> = new Array<Prestation>();
  private prestaValideesMO: Array<Prestation> = new Array<Prestation>();


  constructor(private http: HttpClient) {
    this.load();
  }

  findAll(): Array<Prestataire> {
    return this.egs
  }

  findAppelOffreById(id: number): Observable<AppelOffre> {
    return this.http.get<AppelOffre>("http://localhost:8080/appelOffre/" + id);
  }

  findPrestationByPhaseConsult(): Array<Prestation> {
    return this.prestaValideesEG;
  }

  findPrestationByPhaseValideEG(): Array<Prestation>{
  return this.prestaValideesEG;
  }

  findPrestationByPhaseValideeMO(): Array<Prestation> {
    return this.prestaValideesMO;
  }

  createPrestations(prestations: Array<Prestation>) {
    return this.http.post<Array<Prestation>>("http://localhost:8080/prestation/multiple", prestations);
  }

  load() {
    this.http.get<Array<Prestataire>>("http://localhost:8080/prestataire/").subscribe(resp => {
      this.egs = resp;
    }, error => console.log(error)),
      // this.http.get<Array<Prestation>>("http://localhost:8080/prestation/by-phase/enConsult").subscribe(resp => {
      //   this.prestaValideesEG = resp;
      // }, error => console.log(error))
    this.http.get<Array<Prestation>>("http://localhost:8080/prestation/by-phase/ValideEG").subscribe(resp => {
      this.prestaValideesEG = resp;
    }, error => console.log(error))
      this.http.get<Array<Prestation>>("http://localhost:8080/prestation/by-phase/ValideMOeuvre").subscribe(resp => {
      this.prestaValideesMO = resp;
    }, error => console.log(error))
  }

  deleteById(id: number) {
    this.http.delete("http://localhost:8080/prestation/" + id).subscribe(resp => this.load(), error => console.log(error))
  }

  findPrestaById(id: number): Observable<Prestation> {
    return this.http.get<Prestation>("http://localhost:8080/prestation/" + id);
  }

  modifyPresta(presta: Prestation) {
    return this.http.put<Prestation>("http://localhost:8080/prestation/" + presta.id, presta);
  }

  findOffreById(id: number): Observable<Offre> {
    return this.http.get<Offre>("http://localhost:8080/offre/" + id);
  }

  createOffre(offre: Offre) {
    return this.http.post<Offre>("http://localhost:8080/offre", offre);
  }

  createPresta(prestation: Prestation) {
    return this.http.post<Prestation>("http://localhost:8080/prestation", prestation);
  }

}
