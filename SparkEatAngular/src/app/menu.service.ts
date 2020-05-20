import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AppConfigService } from './app-config.service';
import { Menu } from './menu';


@Injectable({
  providedIn: 'root'
})
export class MenuService {
  private apiUrl: string ="";
  public menus: Array<Menu> = null;

  constructor(private appConfig: AppConfigService, private http: HttpClient) {
    this.apiUrl= `${ this.appConfig.url }/menu`;
   }
   
}
