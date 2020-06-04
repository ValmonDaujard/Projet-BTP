import { Component, OnInit } from '@angular/core';
import {ProjetService} from "../projet-moe/projet.service";
import {ActivatedRoute} from "@angular/router";
import {ActionService} from "./action.service";
import {Action} from "../model/action";
import {Salarie} from "../model/salarie";
import {Projet} from "../model/projet";

@Component({
  selector: 'app-action',
  templateUrl: './action.component.html',
  styleUrls: ['./action.component.scss']
})
export class ActionComponent implements OnInit {

  action : Action = null;
  salariesref : Array<Salarie> = new Array();
  projet: Projet = new Projet();


  constructor(private actionService: ActionService, private route: ActivatedRoute) {

    this.route.params.subscribe(parameters => {
      this.actionService.findById(parameters.id).subscribe(resp => {
        this.action = resp;
        console.log(resp);
        this.actionService.findSalaries(parameters.id).subscribe(resp => {
          this.salariesref = resp;
        }, error => console.log(error));
      }, error => console.log(error));
    })
  }


  ngOnInit(): void {
  }

}
