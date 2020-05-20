import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { CommandeComponent } from './commande/commande.component';
import { ClientComponent } from './client/client.component';
import { HomeComponent } from './home/home.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { ConnexionComponent } from './connexion/connexion.component';
import { ChoixRestaurantComponent } from './choix-restaurant/choix-restaurant.component';

@NgModule({
  declarations: [
    AppComponent,
    CommandeComponent,
    ClientComponent,
    HomeComponent,
    InscriptionComponent,
    ConnexionComponent,
    ChoixRestaurantComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
