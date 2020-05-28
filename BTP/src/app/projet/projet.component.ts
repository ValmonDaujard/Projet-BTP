import {Component, OnInit} from '@angular/core';
import {ProjetService} from "./projet.service";
import {Projet} from "../model/projet";
import {Observable} from "rxjs";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-projet',
  templateUrl: './projet.component.html',
  styleUrls: ['./projet.component.scss']
})
export class ProjetComponent implements OnInit {

  projet: Projet = new Projet();



  constructor(private projetService: ProjetService, private route: ActivatedRoute) {
    this.route.params.subscribe(parameters=> {
      this.projetService.findById(parameters.id).subscribe(resp => {
        this.projet = resp;
        console.log(resp);

        // call appel offre
      }, error => console.log(error))
    })
  }

  ngOnInit(): void {

  }


  }



