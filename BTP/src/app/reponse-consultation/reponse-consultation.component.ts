import { Component, OnInit } from '@angular/core';
import {ReponseConsultationService} from './reponse-consultation.service';
import {ActivatedRoute, Router} from '@angular/router';
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
  prixTTC : number;
  prixHT : number;
  TVA: number = 20;
  prix1 : number = null;
  prix2 : number = null;
  prix3 : number = null;
  quantite1 : number = null;
  quantite2 : number = null;
  quantite3 : number = null;

  constructor(private router: Router, private reponseConsultationService: ReponseConsultationService, private route: ActivatedRoute) {
    this.route.params.subscribe(parameters => {
      this.reponseConsultationService.findByIdPrestation(parameters.id).subscribe(resp => this.infoPrestation = resp, error => console.log(error));
    })
  }
  ngOnInit(): void {
  }

  // calculTotalLigneHT(): number {
  //   let total:number = 0;
  //   if(this.prix1 != 0 && this.quantite1 != null){
  //     total = this.prix1*this.quantite1;
  //     return total
  //   }
  //   else if(this.prix2 != 0 && this.quantite2 != null){
  //     total = this.prix2*this.quantite2;
  //     return total
  //   }
  //   else if(this.prix3 != 0 && this.quantite3 != null){
  //     total = this.prix3*this.quantite3;
  //     return total
  //   }
  //
  // }

  calculTotalHT(): number {
      this.prixHT = this.prix1 + this.prix2 + this.prix3;
      console.log(this.prix1,this.prix2,this.prix3,this.prixHT)
      return this.prixHT;
    }

  calculTotalTTC(): number {
    this.prixTTC = this.prixHT * (1 + (this.TVA/100));
    return this.prixTTC
  }

  validerEnvoyer(){
    this.infoPrestation.prix = this.prixTTC;
    this.infoPrestation.phasePresta = 'ValideEG';
    console.log(this.infoPrestation);
    this.reponseConsultationService.modifyPrestation(this.infoPrestation).subscribe(resp=> {
      this.infoPrestation = resp;
      this.router.navigate(['accueilEG']);
    }, error => console.log(error));
  }

}
