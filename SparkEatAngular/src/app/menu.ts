import { Restaurant } from './restaurant';

export class Menu {
    public restaurant: Restaurant;
    constructor(public id_m?: number, public entree?: string, public plat?: string, public dessert?: string, public boisson?: string, public prix?: number){}
}
