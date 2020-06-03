import { Component, OnInit } from '@angular/core';
import {ReponseConsultationService} from './reponse-consultation.service';
import {ActivatedRoute} from '@angular/router';
import {Prestataire} from '../model/prestataire';
import {MaitreOeuvre} from '../model/maitreOeuvre';
import {Prestation} from '../model/prestation';

@Component({
  selector: 'app-reponse-consultation',
  templateUrl: './reponse-consultation.component.html',
  styleUrls: ['./reponse-consultation.component.scss']
})
export class ReponseConsultationComponent implements OnInit {

  infoPresta : Prestataire = new Prestataire();
  infoMOE : MaitreOeuvre = new MaitreOeuvre();
  infoPrestation : Prestation = new Prestation();

  constructor(private reponseConsultationService: ReponseConsultationService, private route: ActivatedRoute) {
    this.route.params.subscribe(parameters => {
      this.reponseConsultationService.findByIdPrestataire(646).subscribe(resp => {this.infoPresta = resp; console.log(resp);
      }, error => console.log(error));
      this.reponseConsultationService.findByIdMOE(637).subscribe(resp => {this.infoMOE = resp; console.log(resp);
      }, error => console.log(error));
    })
  }

  ngOnInit(): void {
  }

}
