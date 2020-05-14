package fr.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.formation.model.Client;
import fr.formation.model.Restaurant;


public interface IDAORestaurant extends JpaRepository<Restaurant, Integer> 
{
	selectById
	selectByFourchettePrix
	selectByCuisines
}
