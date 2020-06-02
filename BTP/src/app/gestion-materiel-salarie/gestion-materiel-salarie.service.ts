import { Injectable } from '@angular/core';
import {Salarie} from "../model/salarie";
import {Materiel} from '../model/materiel';
import {HttpClient} from '@angular/common/http';
import {Projet} from '../model/projet';
import {Offre} from '../model/offre';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GestionMaterielSalarieService {

  private salaries: Array<Salarie> = new Array<Salarie>();
  private materiels: Array<Materiel> = new Array<Materiel>();

  constructor(private http: HttpClient) {
    this.load();
  }

  findByIdSalarie(id: number): Observable<Salarie> {
    return this.http.get<Salarie>('http://localhost:8080/salarie/' + id);
  }
  findByIdMateriel(id: number): Observable<Materiel> {
    return this.http.get<Materiel>('http://localhost:8080/materiel/' + id);
  }

  findSalarieByEntreprise(id: number): Observable<Array<Salarie>>{
    return this.http.get<Array<Salarie>>('http://localhost:8080/salarie/by-entreprise/' + id);
  }

  findMaterielByEntreprise(id:number): Observable<Array<Materiel>>{
    return this.http.get<Array<Materiel>>('http://localhost:8080/materiel/by-entreprise/' + id);
  }

  createSalarie(salarie: Salarie){
    return this.http.post<Salarie>('http://localhost:8080/salarie', salarie);
  }

  createMateriel(materiel : Materiel){
    return this.http.post<Materiel>('http://localhost:8080/materiel', materiel);
  }

  modifySalarie(salarie: Salarie){
    return this.http.put<Salarie>('http://localhost:8080/salarie/' + salarie.id, salarie);
  }

  modifyMateriel(materiel: Materiel){
    return this.http.put<Materiel>('http://localhost:8080/materiel/' + materiel.id, materiel);
  }

  deleteSalarieById(id: number){
    this.http.delete('http://localhost:8080/salarie/' + id).subscribe(resp => this.load(), error => console.log(error));
  }

  deleteMaterielById(id: number){
    this.http.delete('http://localhost:8080/materiel/' + id).subscribe(resp => this.load(), error => console.log(error));
  }

  load(){
    this.http.get<Array<Salarie>>('http://localhost:8080/salarie').subscribe(resp => {this.salaries = resp;
    }, error => console.log(error));
    this.http.get<Array<Materiel>>('http://localhost:8080/materiel').subscribe(resp => {this.materiels = resp;
    }, error => console.log(error));
  }
}
