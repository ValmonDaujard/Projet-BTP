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

  infoPrestation : Prestation = new Prestation();

  constructor(private reponseConsultationService: ReponseConsultationService, private route: ActivatedRoute) {
    this.route.params.subscribe(parameters => {
      this.reponseConsultationService.findByIdPrestation(parameters.id).subscribe(resp => this.infoPrestation = resp, error => console.log(error));
    })
  }
  ngOnInit(): void {
  }

}
