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

  private prestations : Array<Prestation> = new Array<Prestation>();

  constructor(private http: HttpClient) {
    this.load();
  }

  findByIdPrestation(id:number): Observable<Prestation>{
    return this.http.get<Prestation>('http://localhost:8080/prestation/' + id);
  }

  load(){
    this.http.get<Array<Prestation>>('http://localhost:8080/prestation').subscribe(resp => {
      this.prestations = resp;
    }, error => console.log(error));
  }
}
