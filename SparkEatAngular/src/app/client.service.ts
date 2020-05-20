import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AppConfigService } from './app-config.service';
import { Client } from './client';


@Injectable({
  providedIn: 'root'
})
export class ClientService {
  private apiUrl: string ="";
  public clients: Array<Client> = null;

  constructor(private appConfig: AppConfigService, private http: HttpClient) {
    this.apiUrl= `${ this.appConfig.url }/client`;
   }

   public reload() {
    this.http.get<Array<Client>>(this.apiUrl)
        .subscribe(clients => this.clients = this.clients);
  }
   
  public add(client) {
    this.http.post<Client>(this.apiUrl, Client)
        .subscribe(respClient => this.clients.push(respClient));
  }

  public delete(client) {
    this.http.delete<Boolean>(`${ this.apiUrl }/${ client.id_c }`)
        .subscribe(resp => {
          if (resp) {
            let index = this.clients.indexOf(client);
            this.clients.splice(index, 1);
          }
        });
}
}