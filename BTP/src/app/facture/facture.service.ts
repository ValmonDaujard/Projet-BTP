import { Injectable } from '@angular/core';

import {HttpClient} from "@angular/common/http";
import {Facture} from "../model/facture";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class FactureService {

  private factures: Array<Facture> = new Array<Facture>();

  constructor(private http: HttpClient) {
  }

  create(facture: Facture) {
    return this.http.post<Facture>("http://localhost:8080/facture/", facture);
  }


}
