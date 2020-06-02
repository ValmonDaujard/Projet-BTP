import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {MaitreOeuvre} from "../model/maitreOeuvre";
import {MaitreOuvrage} from "../model/maitreOuvrage";
import {Prestataire} from "../model/prestataire";
import {Utilisateur} from "../model/utilisateur";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProfilService {

  private maitreOeuvres: Array<MaitreOeuvre> = new Array<MaitreOeuvre>();
  private maitreOuvrages: Array<MaitreOuvrage> = new Array<MaitreOuvrage>();
  private prestataires: Array<Prestataire> = new Array<Prestataire>();

  constructor(private http: HttpClient) {
    this.load()
  }

  findById(id: number): Observable<Utilisateur>{
      return this.http.get<Utilisateur>("http://localhost:8080/utilisateur/" + id);
  }

  modifyMO(maitreOuvrage: MaitreOuvrage) {
    return this.http.put<MaitreOuvrage>("http://localhost:8080/maitreOuvrage/" + maitreOuvrage.id, maitreOuvrage);
  }

  modifyMOE(maitreOeuvre: MaitreOeuvre) {
    return this.http.put<MaitreOeuvre>("http://localhost:8080/maitreOeuvre/" + maitreOeuvre.id, maitreOeuvre);
  }

  modifyPrestataire(prestataire: Prestataire) {
    return this.http.put<Prestataire>("http://localhost:8080/prestataire/" + prestataire.id, prestataire);
  }

  load() {
    this.http.get<Array<MaitreOeuvre>>("http://localhost:8080/maitreOeuvre").subscribe(resp => {
      this.maitreOeuvres = resp;
    }, error => console.log(error))
    this.http.get<Array<MaitreOuvrage>>("http://localhost:8080/maitreOuvrage").subscribe(resp => {
      this.maitreOuvrages = resp;
    }, error => console.log(error))
    this.http.get<Array<Prestataire>>("http://localhost:8080/prestataire").subscribe(resp => {
      this.prestataires = resp;
    }, error => console.log(error))
  }
}
