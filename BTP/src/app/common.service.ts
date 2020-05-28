import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CommonService {

  constructor(private http: HttpClient) {}

  findAllUnites(): Observable<Array<string>> {
      return this.http.get<Array<string>>("http://localhost:8080/api/unites");
  }

  findAllCategories(): Observable<Array<string>> {
    return this.http.get<Array<string>>("http://localhost:8080/api/categories");
  }

  findAllPhasePrestas(): Observable<Array<string>> {
    return this.http.get<Array<string>>("http://localhost:8080/api/phasePrestas");
  }

  findAllEtats(): Observable<Array<string>> {
    return this.http.get<Array<string>>("http://localhost:8080/api/etats");
  }
}
