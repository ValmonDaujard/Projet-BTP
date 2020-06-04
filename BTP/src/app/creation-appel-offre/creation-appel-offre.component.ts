import { Component, OnInit } from '@angular/core';
import {AppelOffre} from '../model/appelOffre';
import {CreationAppelOffreService} from './creation-appel-offre.service';
import {errorObject} from 'rxjs/internal-compatibility';
import {SessionService} from '../session.service';

@Component({
  selector: 'app-creation-appel-offre',
  templateUrl: './creation-appel-offre.component.html',
  styleUrls: ['./creation-appel-offre.component.scss']
})
export class CreationAppelOffreComponent implements OnInit {

  appelOffreForm: AppelOffre = null;
  appelOffre : AppelOffre = new AppelOffre();
  user: any = null;

  constructor(private creationAppelOffreService: CreationAppelOffreService, private sessionService: SessionService) {
    this.user = this.sessionService.getUser();
    this.list(this.user.societe.id);
  }

  list(id:number){
    this.creationAppelOffreService.findById(id).subscribe(resp => this.appelOffre = resp, error => console.log(error));
  }

  ngOnInit(): void {
  }

}
