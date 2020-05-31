import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FactureComponent } from './facture/facture.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import { AccueilComponent } from './accueil/accueil.component';
import { ProjetComponent } from './projet/projet.component';
import { GestionMaterielSalarieComponent } from './gestion-materiel-salarie/gestion-materiel-salarie.component';
import { ReponseAppelOffreComponent } from './reponse-appel-offre/reponse-appel-offre.component';
import { AccueilMOComponent } from './accueil-mo/accueil-mo.component';
import { AccueilMOEComponent } from './accueil-moe/accueil-moe.component';
import { AccueilEGComponent } from './accueil-eg/accueil-eg.component';
import { ProjetEGComponent } from './projet-eg/projet-eg.component';

@NgModule({
  declarations: [
    AppComponent,
    FactureComponent,
    AppComponent,
    AccueilComponent,
    ProjetComponent,
    GestionMaterielSalarieComponent,
    ReponseAppelOffreComponent,
    AccueilMOComponent,
    AccueilMOEComponent,
    AccueilEGComponent,
    ProjetEGComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
