import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Projet} from "../model/projet";
import {HttpClient} from "@angular/common/http";
import {Prestation} from "../model/prestation";
import {Action} from "../model/action";
import {Salarie} from "../model/salarie";

@Injectable({
  providedIn: 'root'
})
export class ProjetEGService {

  constructor(private http : HttpClient) { }

  findAllSalarieByEG(idEG): Observable<Array<Salarie>>{
    return this.http.get<Array<Salarie>>('http://localhost:8080/salarie/by-entreprise/' + idEG)
  }

  findSalarieById(idSalarie:number): Observable<Salarie>{
    return this.http.get<Salarie>('http://localhost:8080/salarie/' + idSalarie)
  }

  findSalariesByPrestation(idPresta:number):Observable<Array<Salarie>>{
    return this.http.get<Array<Salarie>>('http://localhost:8080/salarie/by-prestation/' + idPresta)
  }

  findSalarieByAction(idAction:number):Observable<Array<Salarie>>{
    return this.http.get<Array<Salarie>>('http://localhost:8080/salarie/by-action/' + idAction)
  }

  findActionById(idAction: number): Observable<Action>{
    return this.http.get<Action>('http://localhost:8080/action/' +idAction)
  }

  findPrestaById(idPresta:number):Observable<Prestation>{
    return this.http.get<Prestation>('http://localhost:8080/prestation/' +idPresta)
  }

  findPrestationEnCoursParProjetParEG(idProj: number, idEG:number): Observable<Array<Prestation>>{
    return this.http.get<Array<Prestation>>('http://localhost:8080/prestation/en-cours-par-projet-par-EG/' + idProj +':'+ idEG );
  }

  findPrestationPlanifieesParProjetParEG(idProj: number, idEG:number): Observable<Array<Prestation>>{
    return this.http.get<Array<Prestation>>('http://localhost:8080/prestation/planifiee-par-projet-par-EG/' + idProj +':'+ idEG );
  }

  findPrestationEffectueesParProjetParEG(idProj: number, idEG:number): Observable<Array<Prestation>>{
    return this.http.get<Array<Prestation>>('http://localhost:8080/prestation/effectuee-par-projet-par-EG/' + idProj +':'+ idEG );
  }


  findActionsTraiteesParProjetParEG(idProj: number, idEG:number): Observable<Array<Action>>{
    return this.http.get<Array<Action>>('http://localhost:8080/action/by-project-and-effectuee-and-EG/' +idProj +':true:'+ idEG );
  }
  findActionsDemandeesParProjetParEG(idProj: number, idEG:number): Observable<Array<Action>>{
    return this.http.get<Array<Action>>('http://localhost:8080/action/by-project-and-effectuee-and-EG/' +idProj +':false:'+ idEG );
  }

  affectSalariePrestaPlanif(presta:Prestation){
    return this.http.put<Prestation>('http://localhost:8080/prestation/' + presta.id, presta )
  }

  affectSalarieActionDem(action:Action){
    return this.http.put<Action>('http://localhost:8080/action/' + action.id, action )
  }

}
