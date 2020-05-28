import { Component, OnInit } from '@angular/core';
import {Facture} from "../model/facture";
import {FactureService} from "./facture.service";

@Component({
  selector: 'app-facture',
  templateUrl: './facture.component.html',
  styleUrls: ['./facture.component.scss']
})
export class FactureComponent implements OnInit {

  factureForm: Facture = new Facture();

  constructor(private factureService : FactureService) { }

  ngOnInit(): void {
  }

  save() {
      this.factureService.create(this.factureForm).subscribe(resp => {
          this.factureForm = null;
        },
        error => console.log(error)
      )
      ;
    }

  // cancel() {
  //   this.factureForm = null;
  // }

}
