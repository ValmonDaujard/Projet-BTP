import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Projet} from "../model/projet";
import {Offre} from "../model/offre";
import {Prestataire} from "../model/prestataire";
import {Prestation} from "../model/prestation";
import {Action} from "../model/action";
import {Reunion} from "../model/reunion";
import {Facture} from "../model/facture";

@Injectable({
  providedIn: 'root'
})
export class ProjetService {

  private projets: Array<Projet> = new Array<Projet>();
  private actions: Array<Action> = new Array<Action>();
  private factures: Array<Facture> = new Array<Facture>();

  constructor(private http: HttpClient) {

  }

  findAll(): Array<Projet> {
    return this.projets;
  }

  findById(id: number): Observable<Projet> {
    return this.http.get<Projet>("http://localhost:8080/projet/" + id);
  }

  findOffre(id: number): Observable<Offre> {
    let offreObservable = this.http.get<Offre>("http://localhost:8080/offre/" + id);
    return offreObservable;
  }

  findPrestations(id: number) : Observable<Array<Prestation>> {
    return this.http.get<Array<Prestation>>("http://localhost:8080/prestation/par-projet/" + id);
  }

  findActions(id:number) : Observable<Array<Action>> {
    return this.http.get<Array<Action>>("http://localhost:8080/action/par-projet/" + id);
  }

  findReunionsPlanifiees(id:number) : Observable<Array<Reunion>> {
    return this.http.get<Array<Reunion>>( "http://localhost:8080/reunion/planifiee/" + id)
  }

  findReunionsEffectuees(id:number) : Observable<Array<Reunion>> {
    return this.http.get<Array<Reunion>>( "http://localhost:8080/reunion/effectuee/" + id)
  }

  modifyAction(action: Action) {
    action.prestataire.type= "Prestataire";
    return this.http.put<Action>("http://localhost:8080/action/" + action.id, action);
  }

  loadAction() {
    this.http.get<Array<Action>>("http://localhost:8080/action").subscribe(resp => {
      this.actions = resp;
    }, error => console.log(error))
  }

  findAllPrestataire() : Observable<Array<Prestataire>> {
    return this.http.get<Array<Prestataire>>("http://localhost:8080/prestataire/")
  }

  findActionById(id: number): Observable<Action> {
    return this.http.get<Action>("http://localhost:8080/action/" + id);
  }

  deleteFactureById(id: number) {
   return this.http.delete("http://localhost:8080/facture/" + id);
  }

  load() {
    this.http.get<Array<Facture>>("http://localhost:8080/facture").subscribe(resp => {
      this.factures = resp;
    }, error => console.log(error))
  }



  findFactureById(id: number) : Observable<Facture> {
    return this.http.get<Facture>("http://localhost:8080/facture/" + id);
  }

  modifyFacture(facture: Facture) {

    return this.http.put<Facture>("http://localhost:8080/facture/" + facture.id, facture);
  }



  findFactures(id:number) : Observable<Array<Facture>> {
    return this.http.get<Array<Facture>>("http://localhost:8080/facture/par-projet/" + id )
  }


  deleteActionById(id: number) {
    return this.http.delete("http://localhost:8080/action/" + id);
  }


}

