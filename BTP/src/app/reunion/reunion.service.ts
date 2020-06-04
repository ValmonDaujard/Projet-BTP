import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Action} from "../model/action";
import {Reunion} from "../model/reunion";

@Injectable({
  providedIn: 'root'
})
export class ReunionService {

  constructor(private http: HttpClient) { }

  findById(id: number): Observable<Reunion> {
    return this.http.get<Reunion>("http://localhost:8080/reunion/" + id);
  }
}
