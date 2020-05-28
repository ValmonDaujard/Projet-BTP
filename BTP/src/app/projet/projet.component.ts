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
  id: number;


  constructor(private projetService: ProjetService) {
  }

  ngOnInit():  {

  });



    }

  }



