package fr.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.formation.model.Client;
import fr.formation.model.Cuisines;
import fr.formation.model.Menu;
import fr.formation.model.Restaurant;


public interface IDAORestaurant extends JpaRepository<Restaurant, Integer> 
{
	//public Restaurant findById1(int id_r);
	public Restaurant selectById(int id_r);
	
	public Restaurant findByFourchettePrix(int fourchettePrix);  //selectBy ou find By ?
	public Restaurant selectByCuisines(Cuisines cuisines); 		 //selectBy ou find By ?
	
	@Query("select c from Client c")
	public List<Client> findAllClients();
	
	@Query("select m from Menu m")
	public List<Menu> findById1(int id_m);
	
	
}
