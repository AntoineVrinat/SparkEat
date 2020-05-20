import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { CommandeComponent } from './commande/commande.component';
import { HomeComponent } from './home/home.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { ConnexionComponent } from './connexion/connexion.component';
import { ChoixRestaurantComponent } from './choix-restaurant/choix-restaurant.component';
import { ChoixMenuComponent } from './choix-menu/choix-menu.component';


const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'inscription', component: InscriptionComponent },
  { path: 'connexion', component: ConnexionComponent },
  { path: 'choix-restaurant', component: ChoixRestaurantComponent },
//  { path: 'choix-cuisine', component: ChoixCuisinesComponent },
  { path: 'choix-menu', component: ChoixMenuComponent },
  { path: 'commande', component: CommandeComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: '**', component: HomeComponent }
];


@NgModule({
  declarations: [
    AppComponent,
    CommandeComponent,
    HomeComponent,
    InscriptionComponent,
    ConnexionComponent,
    ChoixRestaurantComponent,
    ChoixMenuComponent
  ],
  imports: 
  [
    BrowserModule, FormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
