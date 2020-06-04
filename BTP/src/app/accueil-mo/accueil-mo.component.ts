import {Component, OnInit} from '@angular/core';
import {Projet} from '../model/projet';
import {Offre} from '../model/offre';
import {AccueilMOService} from './accueil-mo.service';
import {ActivatedRoute} from "@angular/router";
import {SessionService} from "../session.service";
import {Prestation} from "../model/prestation";

@Component({
  selector: 'app-accueil-mo',
  templateUrl: './accueil-mo.component.html',
  styleUrls: ['./accueil-mo.component.scss']
})
export class AccueilMOComponent implements OnInit {

  projets: Array<Projet> = new Array<Projet>();
  offres: Array<Offre> = new Array<Offre>();
  prestations: Array<Prestation> = new Array<Prestation>();
  user: any = null;
  offre: Offre = new Offre();
  projet: Projet = new Projet();

  constructor(private accueilMOService: AccueilMOService, private route: ActivatedRoute, private sessionService: SessionService) {
    this.user = this.sessionService.getUser();
    this.list(this.user.societe.id)
  }

  ngOnInit(): void {
  }

  validerOffre(idOffre: number) {
    this.accueilMOService.findOffreById(idOffre).subscribe(resp => {
      this.offre = resp;
      this.offre.etat = "val";
      this.accueilMOService.changeEtatOffre(this.offre).subscribe(resp => {
        this.offre = resp;
        this.list(this.user.societe.id);
      }, err => console.log(err));
      this.projet.offre = this.offre;
      this.projet.arret = 0;
      this.projet.dtDebut = this.offre.dtDebut;
      this.projet.dtFin = this.offre.dtFin;
      this.projet.numeroDevis = this.offre.numeroDevis;
      this.accueilMOService.createProjet(this.projet).subscribe(resp => {
        this.projet = resp;
        this.list(this.user.societe.id);
        this.accueilMOService.findAllByOffre(idOffre).subscribe(resp =>{
          this.prestations = resp;
          this.list(this.user.societe.id);
          for (let presta of this.prestations){
            presta.projet = this.projet;
            this.accueilMOService.modifyPresta(presta).subscribe(resp => {
            presta = resp;
            this.list(this.user.societe.id);
            }, error => console.log(error));
          }
        }, err => console.log(err));
      }, err => console.log(err));
    }, error => console.log(error));


  }

  deleteOffre(idOffre: number) {
    this.accueilMOService.findOffreById(idOffre).subscribe(resp => {
        this.offre = resp;
        console.log(this.offre);
        this.offre.etat = "ref";
        this.accueilMOService.changeEtatOffre(this.offre).subscribe(resp => {
          this.offre = resp;

          this.list(this.user.societe.id)

        }, err => console.log(err));

      }
      , error => console.log(error));

  }

  list(id: number) {
    console.log(id);
    this.accueilMOService.findAllByMaitreOuvrage(id).subscribe(resp => this.projets = resp, error => console.log(error));
    this.accueilMOService.findAllByMaitreOuvrageEnConsult(id).subscribe(resp => this.offres = resp, error => console.log(error));
  }

  rechercheProj() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("projetSearch");
    filter = input.value.toUpperCase();
    table = document.getElementById("projetTable");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
      td = tr[i].getElementsByTagName("td")[0];
      if (td) {
        txtValue = td.textContent || td.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
          tr[i].style.display = "";
        } else {
          tr[i].style.display = "none";
        }
      }
    }
  }

  rechercheAppel() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("appelSearch");
    filter = input.value.toUpperCase();
    table = document.getElementById("appelTable");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
      td = tr[i].getElementsByTagName("td")[0];
      if (td) {
        txtValue = td.textContent || td.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
          tr[i].style.display = "";
        } else {
          tr[i].style.display = "none";
        }
      }
    }
  }

}
