import { Component, OnInit } from '@angular/core';
import {ReponseAppelOffreService} from "./reponse-appel-offre.service";

@Component({
  selector: 'app-reponse-appel-offre',
  templateUrl: './reponse-appel-offre.component.html',
  styleUrls: ['./reponse-appel-offre.component.scss']
})
export class ReponseAppelOffreComponent implements OnInit {

  constructor(private reponseAppelOffreService: ReponseAppelOffreService) { }

  ngOnInit(): void {
  }

}
