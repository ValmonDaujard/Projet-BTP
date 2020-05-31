import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Projet} from "../model/projet";
import {HttpClient} from "@angular/common/http";
import {Prestation} from "../model/prestation";

@Injectable({
  providedIn: 'root'
})
export class ProjetEGService {

  constructor(private http : HttpClient) { }

  findPrestationEnCoursParProjetParEG(idProj: number, idPresta:number): Observable<Array<Prestation>>{
    return this.http.get<Array<Prestation>>('http://localhost:8080/prestation/en-cours-par-projet-par-EG/' + idProj +':'+ idPresta );
  }

  findPrestationPlanifieesParProjetParEG(idProj: number, idPresta:number): Observable<Array<Prestation>>{
    return this.http.get<Array<Prestation>>('http://localhost:8080/prestation/planifiee-par-projet-par-EG/' + idProj +':'+ idPresta );
  }

  findPrestationEffectueesParProjetParEG(idProj: number, idPresta:number): Observable<Array<Prestation>>{
    return this.http.get<Array<Prestation>>('http://localhost:8080/prestation/effectuee-par-projet-par-EG/' + idProj +':'+ idPresta );
  }
}
