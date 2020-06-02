import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Prestation} from '../model/prestation';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ConsultationEGService {

  private prestations: Array<Prestation> = new Array<Prestation>();

  constructor(private http: HttpClient) {
    this.load();
  }

  findById(id: number): Observable<Prestation>{
    return this.http.get<Prestation>('http://localhost:8080/prestation/' + id);
  }

  load(){
    this.http.get<Array<Prestation>>('http://localhost:8080/prestation').subscribe(resp => {
      this.prestations = resp;
    }, error => console.log(error))
  }

}
