import { Component, OnInit } from '@angular/core';
import {ActionService} from "../action/action.service";
import {ActivatedRoute} from "@angular/router";
import {ReunionService} from "./reunion.service";
import {Reunion} from "../model/reunion";

@Component({
  selector: 'app-reunion',
  templateUrl: './reunion.component.html',
  styleUrls: ['./reunion.component.scss']
})
export class ReunionComponent implements OnInit {
  reunion: Reunion = null;

  constructor(private reunionService: ReunionService, private route: ActivatedRoute) {

    this.route.params.subscribe(parameters => {
      this.reunionService.findById(parameters.id).subscribe(resp => {
        this.reunion = resp;
        console.log(resp);

      }, error => console.log(error));
    })
    }

  ngOnInit(): void {
  }

}
