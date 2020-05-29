import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Projet} from "../model/projet";
import {Societe} from "../model/societe";
import {MaitreOuvrage} from "../model/maitreOuvrage";
import {MaitreOeuvre} from "../model/maitreOeuvre";
import {Prestataire} from "../model/prestataire";
import {Utilisateur} from "../model/utilisateur";
import {Observable} from "rxjs";
import {AccueilComponent} from "./accueil.component";
import {Adresse} from "../model/adresse";

@Injectable({
  providedIn: 'root'
})
export class AccueilService {

  private maitreOeuvres: Array<MaitreOeuvre> = new Array<MaitreOeuvre>();
  private maitreOuvrages: Array<MaitreOuvrage> = new Array<MaitreOuvrage>();
  private prestataires: Array<Prestataire> = new Array<Prestataire>();

  constructor(private http: HttpClient) {
    this.load();
  }

  newMO(maitreOuvrage: MaitreOuvrage) {
    return this.http.post<MaitreOuvrage>("http://localhost:8080/maitreOuvrage", maitreOuvrage);
  }

  newMOE(maitreOeuvre: MaitreOeuvre) {
    return this.http.post<MaitreOeuvre>("http://localhost:8080/maitreOeuvre", maitreOeuvre);
  }

  newPrestataire(prestataire: Prestataire) {
    return this.http.post<Prestataire>("http://localhost:8080/prestataire", prestataire);
  }

  findByIdentifiantAndMotDePasse(identifiant: string, mdp: string): Observable<Utilisateur>{
    return this.http.get<Utilisateur>("http://localhost:8080/utililisateur/by-identifiant-and-mot-de-passe/" + identifiant + ":" + mdp);
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
