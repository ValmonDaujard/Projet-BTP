import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AccueilComponent} from './accueil/accueil.component';
import {ProjetComponent} from './projet/projet.component';
import {FactureComponent} from './facture/facture.component';
import {GestionMaterielSalarieComponent} from './gestion-materiel-salarie/gestion-materiel-salarie.component';
import {ReponseAppelOffreComponent} from './reponse-appel-offre/reponse-appel-offre.component';
import {AccueilMOEComponent} from "./accueil-moe/accueil-moe.component";
import {AccueilEGComponent} from "./accueil-eg/accueil-eg.component";
import {AccueilMOComponent} from "./accueil-mo/accueil-mo.component";
import {ProjetEGComponent} from "./projet-eg/projet-eg.component";
import {ConsultationEGComponent} from './consultation-eg/consultation-eg.component';
import {ProfilComponent} from "./profil/profil.component";
import {ReponseConsultationComponent} from './reponse-consultation/reponse-consultation.component';


const routes: Routes = [
  {path: '', component: AccueilComponent},
  {path: 'projet/:id', component: ProjetComponent},
  {path: 'facture', component: FactureComponent},
  {path: 'gestionMaterielSalarie', component: GestionMaterielSalarieComponent},
  {path: 'reponseAppelOffre/:id', component: ReponseAppelOffreComponent},
  {path: 'accueilMOE/:id', component: AccueilMOEComponent},
  {path: 'accueilEG/:id', component: AccueilEGComponent},
  {path: 'accueilMO/:id', component: AccueilMOComponent},
  {path: 'projetEG/:id', component: ProjetEGComponent},
  {path: 'consultationEG/:id', component: ConsultationEGComponent},
  {path: 'profil', component: ProfilComponent},
  {path: 'reponseConsultation/:id', component: ReponseConsultationComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
