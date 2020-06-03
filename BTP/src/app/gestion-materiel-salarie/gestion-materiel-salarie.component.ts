import {Component, OnInit} from '@angular/core';
import {Salarie} from '../model/salarie';
import {Materiel} from '../model/materiel';
import {GestionMaterielSalarieService} from './gestion-materiel-salarie.service';
import {Adresse} from '../model/adresse';
import {Prestataire} from '../model/prestataire';
import {SessionService} from "../session.service";

@Component({
  selector: 'app-gestion-materiel-salarie',
  templateUrl: './gestion-materiel-salarie.component.html',
  styleUrls: ['./gestion-materiel-salarie.component.scss']
})
export class GestionMaterielSalarieComponent implements OnInit {

  salarieForm: Salarie = null;
  salarieFormDetails: Salarie = null;
  materielForm: Materiel = null;
  salaries: Array<Salarie> = new Array<Salarie>();
  materiels: Array<Materiel> = new Array<Materiel>();
  idEntreprise: number;
  user: any = null ;

  constructor(private gestionMaterielSalarieService: GestionMaterielSalarieService, private sessionService: SessionService) {
    this.user = this.sessionService.getUser()
    this.list(this.user.societe.id);
  }

    ngOnInit(): void {
  }

  addSalarie() {
    this.salarieForm = new Salarie();
    this.salarieForm.adresse = new Adresse();
    this.salarieFormDetails = null;
  }

  addMateriel(){
    this.materielForm = new Materiel();
  }

  editSalarie(id: number) {
    this.salarieFormDetails = null;  // ferme le formulaire de détails s'il était ouvert
    this.gestionMaterielSalarieService.findByIdSalarie(id).subscribe(resp => {
      this.salarieForm = resp;
      if (this.salarieForm.adresse == null) {
        this.salarieForm.adresse = new Adresse();
      }
    }, error => console.log(error));
  }

  editMateriel(id: number){
    this.gestionMaterielSalarieService.findByIdMateriel(id).subscribe(resp=> {
      this.materielForm = resp;
      }, error => console.log(error));
    }

  detailsSalarie(id: number) {
    this.salarieForm = null;  // ferme le formulaire de modification s'il était ouvert
    this.gestionMaterielSalarieService.findByIdSalarie(id).subscribe(resp => {
      this.salarieFormDetails = resp;
      if(this.salarieFormDetails.adresse == null){
        this.salarieFormDetails.adresse = new Adresse();
      }
    }, error => console.log(error));
  }

  saveSalarie() {
    if (!this.salarieForm.id) {
      this.salarieForm.prestataire = new Prestataire();
      this.salarieForm.prestataire.id = this.idEntreprise;
      this.salarieForm.prestataire.type = 'Prestataire';

      this.gestionMaterielSalarieService.createSalarie(this.salarieForm).subscribe(resp => {
          this.gestionMaterielSalarieService.findSalarieByEntreprise(this.idEntreprise).subscribe(resp => this.salaries = resp, error => console.log(error));
        },
        error => console.log(error)
      );
    } else {
      this.gestionMaterielSalarieService.modifySalarie(this.salarieForm).subscribe(resp => {
        this.salarieForm = null;
        this.gestionMaterielSalarieService.findSalarieByEntreprise(this.idEntreprise).subscribe(resp => this.salaries = resp, error => console.log(error));
      }, error => console.log(error));
    }
    this.salarieForm = null;
  }

  saveMateriel() {
    if (!this.materielForm.id) {
      this.materielForm.prestataire = new Prestataire();
      this.materielForm.prestataire.id = this.idEntreprise;
      this.materielForm.prestataire.type = 'Prestataire';

      this.gestionMaterielSalarieService.createMateriel(this.materielForm).subscribe(resp => {
          this.gestionMaterielSalarieService.findMaterielByEntreprise(this.idEntreprise).subscribe(resp => this.materiels = resp, error => console.log(error));
        },
        error => console.log(error)
      );
    } else {
      this.gestionMaterielSalarieService.modifyMateriel(this.materielForm).subscribe(resp => {
        this.materielForm = null;
        this.gestionMaterielSalarieService.findMaterielByEntreprise(this.idEntreprise).subscribe(resp => this.materiels = resp, error => console.log(error));
      }, error => console.log(error));
    }
    this.materielForm = null;
  }

  list(id: number) {
    this.gestionMaterielSalarieService.findSalarieByEntreprise(id).subscribe(resp => this.salaries = resp, error => console.log(error));
    this.gestionMaterielSalarieService.findMaterielByEntreprise(id).subscribe(resp => this.materiels = resp, error => console.log(error));
  }

  cancelSalarie() {
    this.salarieForm = null;
  }

  cancelMateriel(){
    this.materielForm = null;
  }

  cancelSalarieDetails() {
    this.salarieFormDetails = null;
  }

  deleteSalarie(id: number) {
    this.gestionMaterielSalarieService.deleteSalarieById(id);
    this.salarieFormDetails = null;
    this.salarieForm = null;
    this.gestionMaterielSalarieService.load();
  }

  deleteMateriel(id: number){
    this.gestionMaterielSalarieService.deleteMaterielById(id);
    this.materielForm = null;
  }

  rechercheEmp() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("empSearch");
    filter = input.value.toUpperCase();
    table = document.getElementById("empTable");
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

  rechercheMat() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("matSearch");
    filter = input.value.toUpperCase();
    table = document.getElementById("matTable");
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
