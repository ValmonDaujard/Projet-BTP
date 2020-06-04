import { Component, OnInit } from '@angular/core';
import {ConsultationEGService} from './consultation-eg.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Prestation} from '../model/prestation';

@Component({
  selector: 'app-consultation-eg',
  templateUrl: './consultation-eg.component.html',
  styleUrls: ['./consultation-eg.component.scss']
})
export class ConsultationEGComponent implements OnInit {

  consultPresta: Prestation = new Prestation();

  constructor(private consultationEGService: ConsultationEGService, private route: ActivatedRoute, public router : Router) {
    this.route.params.subscribe(parameters => {
      this.consultationEGService.findById(parameters.id).subscribe(resp => this.consultPresta = resp, error => console.log(error));
    })
  }

  ngOnInit(): void {
  }

  refusConsult(id:number){
    this.consultationEGService.findById(id).subscribe(resp=>{ this.consultPresta = resp;
      this.consultPresta.phasePresta = "RefuseEG";
      this.consultationEGService.refusConsult(this.consultPresta).subscribe(resp => {this.consultPresta = resp;
      this.router.navigate(['accueilEG'])
      }, error => console.log(error))
    }, error => console.log(error))

    console.log(this.consultPresta);
  }
}
