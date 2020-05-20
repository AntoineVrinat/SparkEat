import { Component, OnInit } from '@angular/core';
import { ClientService } from '../client.service';
import { Client } from '../client';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css']
})
export class ConnexionComponent implements OnInit {
  private formConnexion: Client

  constructor(private srvClient: ClientService) { }

  ngOnInit() {
    this.srvClient.reload();
  }
  public ConnexionClient() {
    this.srvClient.Connexion(this.formConnexion);
  }
}
