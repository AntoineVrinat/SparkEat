package fr.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//import fr.formation.model.Cuisines;
import fr.formation.model.Menu;
import fr.formation.model.Restaurant;

public interface IDAOMenu extends JpaRepository<Menu, Integer> 
{

	public Menu selectById(int id_m);
	
	public Menu findByPrix();
	
	@Query("select r from Restaurant r")
	public List<Restaurant> findAllRestaurants();
	
	
}
