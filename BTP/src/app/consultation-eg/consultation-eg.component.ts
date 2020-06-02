import { Component, OnInit } from '@angular/core';
import {ConsultationEGService} from './consultation-eg.service';
import {ActivatedRoute} from '@angular/router';
import {Prestation} from '../model/prestation';
import {errorObject} from 'rxjs/internal-compatibility';

@Component({
  selector: 'app-consultation-eg',
  templateUrl: './consultation-eg.component.html',
  styleUrls: ['./consultation-eg.component.scss']
})
export class ConsultationEGComponent implements OnInit {

  consultPresta: Prestation = new Prestation();

  constructor(private consultationEGService: ConsultationEGService, private route: ActivatedRoute) {
    this.route.params.subscribe(parameters => {
      this.consultationEGService.findById(parameters.id).subscribe(resp => this.consultPresta = resp, error => console.log(error));
    })
  }

  ngOnInit(): void {
  }
}
