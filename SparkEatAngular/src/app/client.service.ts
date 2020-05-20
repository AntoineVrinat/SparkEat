import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AppConfigService } from './app-config.service';
import { Client } from './client';
import { Router } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class ClientService {
  private apiUrl: string ="";
  public clients: Array<Client> = null;

  constructor(private appConfig: AppConfigService, private http: HttpClient, private router: Router) {
    this.apiUrl= `${ this.appConfig.url }/client`;
   }

   public reload() {
    this.http.get<Array<Client>>(this.apiUrl)
        .subscribe(clients => this.clients = this.clients);
  }
  
  public add(c) {
    this.http.post<Client>(this.apiUrl, c)
        .subscribe(respClient => this.clients.push(respClient));
  }

  public Connexion(client){
    this.http.post<Client>(`${this.apiUrl}/connexion`, client)
      .subscribe(respClient => {
        if (respClient == null) {
          `${this.apiUrl}/connexion`;
        }
        else if(respClient !== null){
          this.router.navigate([`${this.apiUrl}/choix-restaurant`]);
        }
          // si respClient est NULL : on ne fait rien (alert pas bon)
          //si respClient est pas null : on redirige vers la page 'choix'
          //pour rediriger, tu as besoin du router (que tu injecte)
          //le router, méthode navigate(url)
      })
  }

  public delete(c) {
    this.http.delete<Boolean>(`${ this.apiUrl }/${ c.id_c }`)
        .subscribe(resp => {
          if (resp) {
            let index = this.clients.indexOf(c);
            this.clients.splice(index, 1);
          }
        });
}
}