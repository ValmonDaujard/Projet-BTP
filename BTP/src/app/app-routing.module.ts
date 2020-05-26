import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {FactureComponent} from "./facture/facture.component";


const routes: Routes = [
  {path: 'facture', component: FactureComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
