import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AppelOffre} from '../model/appelOffre';

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

  load(){
    this.http.get<AppelOffre>('http://localhost:8080/appelOffre').subscribe(resp=> {
      this.appelOffre = resp;
    }, error => console.log(error))
  }
}
