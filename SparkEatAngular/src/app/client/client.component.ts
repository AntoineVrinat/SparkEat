import { Component, OnInit } from '@angular/core';
import { ClientService } from '../client.service';
import { Client } from '../client';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {
  private formInscription: Client = new Client();

  constructor(private srvClient: ClientService) { }

  ngOnInit() {
    this.srvClient.reload();
  }
  public ajouterClient() {
    this.srvClient.add(this.formInscription);
    this.formInscription = new Client();
  }

  public supprimerClient(client) {
    this.srvClient.delete(client);
  }
}
