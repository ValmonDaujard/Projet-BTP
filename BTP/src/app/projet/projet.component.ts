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

  projetForm: Projet = null;

  constructor(private projetService: ProjetService) {
  }

  ngOnInit(): void {
  }

  list(): Array<Projet> {
    return this.projetService.findAll();
  }

  add() {
    this.projetForm = new Projet();
  }

  edit(id: number) {
    this.projetService.findById(id).subscribe(resp => this.projetForm = resp, error => console.log(error));
  }

  save() {
    if (!this.projetForm.id) {
      this.projetService.create(this.projetForm).subscribe(resp => {
          this.projetForm = null;
          this.projetService.load();
        },
        error => console.log(error)
      )
      ;
    } else {
      this.projetService.modify(this.projetForm).subscribe(resp => {
        this.projetForm = null;
        this.projetService.load();
      }, error => console.log(error));
    }
  }

  cancel() {
    this.projetForm = null;
  }

  delete(id: number) {
    this.projetService.deleteById(id);
  }
}

