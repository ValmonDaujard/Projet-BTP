import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AccueilComponent} from './accueil/accueil.component';
import {ProjetComponent} from './projet-moe/projet.component';
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
import {ProjetMOComponent} from "./projet-mo/projet-mo.component";
import {ActionComponent} from "./action/action.component";
import {ReunionComponent} from "./reunion/reunion.component";
import {CreationAppelOffreComponent} from './creation-appel-offre/creation-appel-offre.component';


const routes: Routes = [
  {path: '', component: AccueilComponent},
  {path: 'projet-moe/:id', component: ProjetComponent},
  {path: 'projet-mo/:id', component: ProjetMOComponent},
  {path: 'facture', component: FactureComponent},
  {path: 'gestionMaterielSalarie', component: GestionMaterielSalarieComponent},
  {path: 'reponseAppelOffre/:id', component: ReponseAppelOffreComponent},
  {path: 'accueilMOE', component: AccueilMOEComponent},
  {path: 'accueilEG', component: AccueilEGComponent},
  {path: 'accueilMO', component: AccueilMOComponent},
  {path: 'projetEG/:id', component: ProjetEGComponent},
  {path: 'consultationEG/:id', component: ConsultationEGComponent},
  {path: 'profil', component: ProfilComponent},
  {path: 'action/:id', component: ActionComponent},
  {path: 'reunion/:id', component: ReunionComponent},
  {path: 'reponseConsultation/:id', component: ReponseConsultationComponent}
  {path: 'reponseConsultation/:id', component: ReponseConsultationComponent},
  {path: 'creationAppelOffre/:id', component: CreationAppelOffreComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
