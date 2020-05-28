import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Projet} from "../model/projet";

@Injectable({
  providedIn: 'root'
})
export class ProjetService {

  private projets: Array<Projet> = new Array<Projet>();

  constructor(private http: HttpClient) {
    this.load();
  }

  findAll(): Array<Projet> {
    return this.projets;
  }

  findAllOrphan(): Observable<Array<Projet>> {
    return this.http.get<Array<Projet>>("http://localhost:8080/api/projet/orphans");
  }


  findById(id: number): Observable<Projet> {
    return this.http.get<Projet>("http://localhost:8080/api/projet/" + id);
  }

  create(projet: Projet) {
    return this.http.post<Projet>("http://localhost:8080/api/projet", projet);
  }

  modify(projet: Projet) {
    return this.http.put<Projet>("http://localhost:8080/api/projet/" + projet.id, projet);
  }

  deleteById(id: number) {
    this.http.delete("http://localhost:8080/api/projet/" + id).subscribe(resp => this.load(), error => console.log(error))
  }

  load() {
    this.http.get<Array<Projet>>("http://localhost:8080/api/projet").subscribe(resp => {
      this.projets = resp;
    }, error => console.log(error))
  }
}
