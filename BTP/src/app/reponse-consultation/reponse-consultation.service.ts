import { Injectable } from '@angular/core';
import {Prestataire} from '../model/prestataire';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {MaitreOeuvre} from '../model/maitreOeuvre';
import {Prestation} from '../model/prestation';

@Injectable({
  providedIn: 'root'
})
export class ReponseConsultationService {

  private prestataires: Array<Prestataire> = new Array<Prestataire>();
  private maitreOeuvres : Array<MaitreOeuvre> = new Array<MaitreOeuvre>();
  private prestations : Array<Prestation> = new Array<Prestation>();

  constructor(private http: HttpClient) {
    this.load();
  }

  findByIdPrestataire(id: number): Observable<Prestataire>{
    return this.http.get<Prestataire>('http://localhost:8080/prestataire/' + id);
  }

  findByIdMOE(id: number): Observable<MaitreOeuvre>{
    return this.http.get<MaitreOeuvre>('http://localhost:8080/maitreOeuvre/' + id);
  }

  findByIdPrestation(id:number): Observable<Prestation>{
    return this.http.get<Prestation>('http://localhost:8080/prestation/' + id);
  }

  load(){
    this.http.get<Array<Prestataire>>('http://localhost:8080/prestataire').subscribe(resp => {
      this.prestataires = resp;
    }, error => console.log(error));
    this.http.get<Array<MaitreOeuvre>>('http://localhost:8080/maitreOeuvre').subscribe(resp => {
      this.maitreOeuvres = resp;
    }, error => console.log(error))
    this.http.get<Array<Prestation>>('http://localhost:8080/prestation').subscribe(resp => {
      this.prestations = resp;
    }, error => console.log(error));
  }
}
