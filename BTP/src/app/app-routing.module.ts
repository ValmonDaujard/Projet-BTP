import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AccueilComponent} from './accueil/accueil.component';
import {ProjetComponent} from './projet/projet.component';
import {FactureComponent} from './facture/facture.component';
import {HomeComponent} from './home/home.component';
import {GestionMaterielSalarieComponent} from './gestion-materiel-salarie/gestion-materiel-salarie.component';
import {ReponseAppelOffreComponent} from './reponse-appel-offre/reponse-appel-offre.component';
import {AccueilMOEComponent} from "./accueil-moe/accueil-moe.component";


const routes: Routes = [
  {path: '', component: AccueilComponent},
  {path: 'projet/:id', component: ProjetComponent},
  {path: 'facture', component: FactureComponent},
  {path: 'home', component: HomeComponent},
  {path: 'gestionMaterielSalarie', component: GestionMaterielSalarieComponent},
  {path: 'reponseAppelOffre/:id', component: ReponseAppelOffreComponent},
  {path: 'accueilMOE', component: AccueilMOEComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
