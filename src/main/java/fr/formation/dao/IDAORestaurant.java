package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Cuisines;
import fr.formation.model.Restaurant;


public interface IDAORestaurant extends JpaRepository<Restaurant, Integer> 
{
	public Restaurant findByFourchettePrix(int fourchettePrix);
	public Restaurant findByCuisines(Cuisines cuisines);
}
