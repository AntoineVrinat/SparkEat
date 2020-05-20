import { Menu } from './menu';
import { Client } from './client';

export class Restaurant {

    public menu: Menu;
    public client: Client;
    constructor(public id_r?: number, public nom?: string, public fourchette_prix?: number, public Cuisines?: string,) {}
}
