import { Component, OnInit } from '@angular/core';
import { ClientService } from '../client.service';
import { Client } from '../client';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent implements OnInit {
  private formInscription: Client = new Client();

  constructor(private srvClient: ClientService) { }

  ngOnInit() {
    this.srvClient.reload();
  }
  /*public InscriptionClient() {
    this.srvClient.Inscription(this.formInscription);
  }
*/
  public ajouterClient() {
    this.srvClient.Inscription(this.formInscription);
    this.formInscription = new Client();
  }
}