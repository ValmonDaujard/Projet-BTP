import {Component, OnInit} from '@angular/core';
import {ProjetService} from "./projet.service";
import {Projet} from "../model/projet";
import {Observable} from "rxjs";

@Component({
  selector: 'app-projet',
  templateUrl: './projet.component.html',
  styleUrls: ['./projet.component.scss']
})
export class ProjetComponent implements OnInit {

  projet: Projet = new Projet();

  constructor(private projetService: ProjetService) {
  }

  ngOnInit(): void {
  }

  list(): Array<Projet> {
    return this.projetService.findAll();
  }

  add() {
    this.projet = new Projet();
  }

  edit(id: number) {
    this.projetService.findById(id).subscribe(resp => this.projet = resp, error => console.log(error));
  }

  save() {
    if (!this.projet.id) {
      this.projetService.create(this.projet).subscribe(resp => {
          this.projet = null;
          this.projetService.load();
        },
        error => console.log(error)
      )
      ;
    } else {
      this.projetService.modify(this.projet).subscribe(resp => {
        this.projet = null;
        this.projetService.load();
      }, error => console.log(error));
    }
  }

  cancel() {
    this.projet = null;
  }

  delete(id: number) {
    this.projetService.deleteById(id);
  }
}

