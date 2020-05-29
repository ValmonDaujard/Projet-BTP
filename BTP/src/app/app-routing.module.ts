import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AccueilComponent} from './accueil/accueil.component';
import {ProjetComponent} from './projet/projet.component';
import {FactureComponent} from './facture/facture.component';
import {HomeComponent} from './home/home.component';
import {GestionMaterielSalarieComponent} from './gestion-materiel-salarie/gestion-materiel-salarie.component';
import {ReponseAppelOffreComponent} from "./reponse-appel-offre/reponse-appel-offre.component";


const routes: Routes = [
  {path: "", component: AccueilComponent},
  {path: "projet/:id", component: ProjetComponent},
  {path: 'facture', component: FactureComponent},
  {path: 'home/:id', component: HomeComponent},
  {path: 'gestionMaterielSalarie', component: GestionMaterielSalarieComponent}
  {path: 'reponseAppelOffre/:id', component: ReponseAppelOffreComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
