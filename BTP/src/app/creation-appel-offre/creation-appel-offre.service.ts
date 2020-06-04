import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AppelOffre} from '../model/appelOffre';
import {MaitreOeuvre} from '../model/maitreOeuvre';
import {Observable} from 'rxjs';
import {Offre} from '../model/offre';

@Injectable({
  providedIn: 'root'
})
export class CreationAppelOffreService {

  private appelOffre : AppelOffre = new AppelOffre();

  constructor(private http:HttpClient) {
    this.load();
  }

  findById(id:number){
    return this.http.get<AppelOffre>('http://localhost:8080/appelOffre/' + id);
  }

  findAllMaitreOeuvre(){
    return this.http.get<Array<MaitreOeuvre>>('http://localhost:8080/maitreOeuvre');
  }

  findByIdMaitreOeuvre(id:number): Observable<MaitreOeuvre>{
    return this.http.get<MaitreOeuvre>('http://localhost:8080/maitreOeuvre/' + id);
  }

  create(appelOffre: AppelOffre){
    return this.http.post<AppelOffre>('http://localhost:8080/appelOffre', appelOffre);
  }

  createOffre(offre: Offre){
    return this.http.post<Offre>('http://localhost:8080/offre', offre);
  }

  load(){
    this.http.get<AppelOffre>('http://localhost:8080/appelOffre').subscribe(resp=> {
      this.appelOffre = resp;
    }, error => console.log(error))
  }
}
