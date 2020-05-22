import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AppConfigService } from './app-config.service';
import { Cuisines } from './cuisines';
//import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class CuisinesService {
  private apiUrl: string = "";

  constructor(private appConfig: AppConfigService, private http: HttpClient) {
    this.apiUrl = `${ this.appConfig.url }/cuisines`;
  }


}
