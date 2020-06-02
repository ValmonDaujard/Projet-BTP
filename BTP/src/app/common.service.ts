import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {MaitreOuvrage} from "./model/maitreOuvrage";
import {MaitreOeuvre} from "./model/maitreOeuvre";
import {Prestataire} from "./model/prestataire";
import {Utilisateur} from "./model/utilisateur";

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

  findMOById(id: number): Observable<MaitreOuvrage>{
    return this.http.get<MaitreOuvrage>("http://localhost:8080/maitreOuvrage/" + id);
  }

  findMOEById(id: number): Observable<MaitreOeuvre>{
    return this.http.get<MaitreOeuvre>("http://localhost:8080/maitreOeuvre/" + id);
  }

  findPrestataireById(id: number): Observable<Prestataire>{
    return this.http.get<Prestataire>("http://localhost:8080/prestataire/" + id);
  }

  findByIdentifiantAndMotDePasse(identifiant: string, mdp: string): Observable<Utilisateur>{
    return this.http.get<Utilisateur>("http://localhost:8080/utilisateur/by-identifiant-and-mot-de-passe/" + identifiant + ":" + mdp);
  }
}
