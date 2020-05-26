import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AccueilComponent} from "./accueil/accueil.component";
import {ProjetComponent} from "./projet/projet.component";


const routes: Routes = [
  {path: "", component: AccueilComponent},
  {path: "projet", component: ProjetComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
