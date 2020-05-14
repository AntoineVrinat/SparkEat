package fr.formation.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.dao.IDAOClient;
import fr.formation.dao.IDAORestaurant;
import fr.formation.model.Restaurant;
import fr.formation.projection.Views;

@RestController 
@CrossOrigin("*")
@RequestMapping("/api/restaurant")
public class RestaurantApiController 
{
	
	@Autowired
	private IDAORestaurant daoRestaurant;
	
	@GetMapping
	public List<Restaurant> findAll(){
		return this.daoRestaurant.findAll();
	}
	
	
	@GetMapping("/{id}")
	public Restaurant findById(@PathVariable int id) {
		return this.daoRestaurant.findById(id).orElse(new Restaurant());
	}
	
	@PostMapping
	public Restaurant add(@Valid @RequestBody Restaurant r) {
		return r;
	}
	
	@DeleteMapping("/{id}")
	public Restaurant delete(@PathVariable int id) {
		return this.delete(id);
	}
	
	@PutMapping("/{id}")
	public Restaurant update(@PathVariable int id, @RequestBody Restaurant r) {
		return r;
	}

	

}

