import { Component, OnInit } from '@angular/core';
import { RestaurantService } from '../restaurant.service';
import { MenuService } from '../menu.service';
import { Cuisines } from '../cuisines';

@Component({
  selector: 'app-choix-restaurant',
  templateUrl: './choix-restaurant.component.html',
  styleUrls: ['./choix-restaurant.component.css']
})
export class ChoixRestaurantComponent implements OnInit 
{
  filterFourchettePrix: number;
  filterCuisines: string

  constructor
  (
    private srvRestaurant : RestaurantService,
    private srvMenu : MenuService
    //private srvClient : ClientService
  ) { }


  public restaurantsFiltered() {
    if ((this.filterCuisines || this.filterCuisines === null) || (this.filterFourchettePrix || this.filterFourchettePrix === 0)) {
     return this.srvRestaurant.restaurants
                .filter(r => r.Cuisines == this.filterCuisines 
                  || r.fourchette_prix == this.filterFourchettePrix
      );
    }

    return this.srvRestaurant.restaurants;
  }


  ngOnInit(): void 
    {
      this.srvRestaurant.reload();
     // this.srvMenu.reload();
    //  this.srvClient.reload();
    }
  
  }
  