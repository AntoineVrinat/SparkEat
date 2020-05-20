import { Injectable } from '@angular/core';
import { Restaurant } from './restaurant';
import { AppConfigService } from './app-config.service';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService 
{
  private apiUrl: string = "";
  public restaurants: Array<Restaurant> = null;


  constructor
  (private appConfig: AppConfigService, private http: HttpClient) 
  {
    this.apiUrl = `${ this.appConfig.url }/restaurant`;
  } 

  public reload() 
  {
    this.http.get<Array<Restaurant>>(this.apiUrl)
        .subscribe(restaurants => this.restaurants = restaurants);
  }

  public add(restaurant) 
  {
    this.http.post<Restaurant>(this.apiUrl, restaurant)
        .subscribe(respRestaurant => this.restaurants.push(respRestaurant));
  }

 /* public update(restaurant) 
  {
    this.http.put<Restaurant>(`${ this.apiUrl }/${ restaurant.id_r }`, restaurant)
        .subscribe(respRestaurant => {
          let index = this.restaurants.indexOf(this.restaurants.find(r => r.id_r == restaurant.id_r));
          this.restaurants.splice(index, 1, respRestaurant);
        });
  }
*/
  public delete(restaurant) 
  {
    this.http.delete<Boolean>(`${ this.apiUrl }/${ restaurant.id_r }`)
        .subscribe
        (resp => 
          {
            if (resp) 
            {
              let index = this.restaurants.indexOf(restaurant);
              this.restaurants.splice(index, 1);
            }
          }
        );
  }
}
