import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FactureComponent } from './facture/facture.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import { AccueilComponent } from './accueil/accueil.component';
import { ProjetComponent } from './projet-moe/projet.component';
import { GestionMaterielSalarieComponent } from './gestion-materiel-salarie/gestion-materiel-salarie.component';
import { ReponseAppelOffreComponent } from './reponse-appel-offre/reponse-appel-offre.component';
import { AccueilMOComponent } from './accueil-mo/accueil-mo.component';
import { ProjetMOComponent } from './projet-mo/projet-mo.component';
import { AccueilMOEComponent } from './accueil-moe/accueil-moe.component';
import { AccueilEGComponent } from './accueil-eg/accueil-eg.component';
import { ProjetEGComponent } from './projet-eg/projet-eg.component';
import { ConsultationEGComponent } from './consultation-eg/consultation-eg.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonToggleModule} from "@angular/material/button-toggle";
import { ProfilComponent } from './profil/profil.component';
import { ReponseConsultationComponent } from './reponse-consultation/reponse-consultation.component';
import {RouterModule} from "@angular/router";
import { ActionComponent } from './action/action.component';
import { ReunionComponent } from './reunion/reunion.component';
import { CreationAppelOffreComponent } from './creation-appel-offre/creation-appel-offre.component';



@NgModule({
  declarations: [
    AppComponent,
    FactureComponent,
    AccueilComponent,
    ProjetComponent,
    GestionMaterielSalarieComponent,
    ReponseAppelOffreComponent,
    AccueilEGComponent,
    AccueilMOComponent,
    AccueilMOEComponent,
    AccueilEGComponent,
    ProjetEGComponent,
    ConsultationEGComponent,
    ProjetMOComponent,
    ProfilComponent,
    ReponseConsultationComponent,
    AccueilEGComponent,
    ProjetEGComponent,
    CreationAppelOffreComponent,
    ActionComponent,
    ReunionComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    MatButtonToggleModule,
    RouterModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
