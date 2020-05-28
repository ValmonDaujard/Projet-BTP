import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AccueilComponent} from "./accueil/accueil.component";
import {ProjetComponent} from "./projet/projet.component";
import {FactureComponent} from "./facture/facture.component";
import {HomeComponent} from "./home/home.component";


const routes: Routes = [
  {path: "", component: AccueilComponent},
  {path: "projet", component: ProjetComponent},
  {path: 'facture', component: FactureComponent},
  {path: 'accueil', component: HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
