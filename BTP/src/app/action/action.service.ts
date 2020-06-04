import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Projet} from "../model/projet";
import {Action} from "../model/action";
import {HttpClient} from "@angular/common/http";
import {Prestation} from "../model/prestation";
import {Salarie} from "../model/salarie";

@Injectable({
  providedIn: 'root'
})
export class ActionService {

  constructor(private http: HttpClient) { }

  findById(id: number): Observable<Action> {
    return this.http.get<Action>("http://localhost:8080/action/" + id);
  }

  findSalaries(id: number) : Observable<Array<Salarie>> {
    return this.http.get<Array<Salarie>>("http://localhost:8080/salarie/by-action/" + id);
  }

}
