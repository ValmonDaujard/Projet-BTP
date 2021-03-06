import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {MaitreOeuvre} from "../model/maitreOeuvre";
import {MaitreOuvrage} from "../model/maitreOuvrage";
import {Prestataire} from "../model/prestataire";
import {Utilisateur} from "../model/utilisateur";
import {Observable} from "rxjs";
import {CommonService} from "../common.service";

@Injectable({
  providedIn: 'root'
})
export class ProfilService {

  private utilisateurs: Array<Utilisateur> = new Array<Utilisateur>();
  private maitreOeuvres: Array<MaitreOeuvre> = new Array<MaitreOeuvre>();
  private maitreOuvrages: Array<MaitreOuvrage> = new Array<MaitreOuvrage>();
  private prestataires: Array<Prestataire> = new Array<Prestataire>();

  constructor(private http: HttpClient, private commonService: CommonService) {
    this.load()
  }

  findAll(): Array<Utilisateur>{
    return this.utilisateurs;
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

  modifyUser(utilisateur: Utilisateur) {
    return this.http.put<Utilisateur>("http://localhost:8080/utilisateur/" + utilisateur.id, utilisateur);
  }

  load() {
    this.http.get<Array<Utilisateur>>("http://localhost:8080/utilisateur").subscribe(resp => {
      this.utilisateurs = resp;
    }, error => console.log(error));
  }
}
