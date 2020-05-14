package fr.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.formation.model.Client;
//import fr.formation.model.Restaurant;




public interface IDAOClient extends JpaRepository<Client, Integer> 
{
	public Client findByLogin(String login);

	public Client selectByLogin(String login);
	
	@Query("select c from Client c where c.login = ?1 and c.password = ?2")
	public Client checkConnect(String login,String password);
	
	public List<Client> findById(int id_c);
	
//	@Query("select r from Restaurant r")
//	public List<Restaurant> findAllRestaurants();
	
}
