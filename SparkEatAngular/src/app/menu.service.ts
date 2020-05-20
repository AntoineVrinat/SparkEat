import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AppConfigService } from './app-config.service';
import { Menu } from './menu';


@Injectable({
  providedIn: 'root'
})
export class MenuService
{
  private apiUrl: string ="";
  public menus: Array<Menu> = null;

  constructor(private appConfig: AppConfigService, private http: HttpClient) {
    this.apiUrl= `${ this.appConfig.url }/menu`;
   }
  
  public reload() 
  {
    this.http.get<Array<Menu>>(this.apiUrl)
        .subscribe(menus => this.menus = menus);
  }

 /* public add(menu) 
  {
    this.http.post<Menu>(this.apiUrl, menu)
        .subscribe(respMenu => this.menus.push(respMenu));
  }

  public update(menu) 
  {
    this.http.put<Menu>(`${ this.apiUrl }/${ menu.id_m }`, menu)
        .subscribe(respMenu => {
          let index = this.menus.indexOf(this.menus.find(r => menu.id_m == menu.id_m));
          this.menus.splice(index, 1, respMenu);
        });
  }

  public delete(menu) 
  {
    this.http.delete<Boolean>(`${ this.apiUrl }/${ menu.id_m }`)
        .subscribe
        (resp => 
          {
            if (resp) 
            {
              let index = this.menus.indexOf(menu);
              this.menus.splice(index, 1);
            }
          }
        );
  }*/
}