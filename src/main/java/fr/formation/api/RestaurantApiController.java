package fr.formation.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
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

import fr.formation.dao.IDAORestaurant;
import fr.formation.exception.RestaurantValidationException;
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
	@JsonView(Views.Restaurant.class)
	public List<Restaurant> findAll(){
		return this.daoRestaurant.findAll();

	}
	
	
	@GetMapping("/{id}")
	@JsonView(Views.Restaurant.class)
	public Restaurant findById(@PathVariable int id) {
		return this.daoRestaurant.findById(id).orElse(new Restaurant());
	}
	
	
	@PostMapping
	@JsonView(Views.Restaurant.class)
	public Restaurant add(@Valid @RequestBody Restaurant r, BindingResult result)
	{
		if (result.hasErrors())
		{
		throw new RestaurantValidationException();
		}
		this.daoRestaurant.save(r);
		return r;
	}
	
	@DeleteMapping("/{id}")
	public boolean delete(@PathVariable int id) 
	{
		try
		{
			this.daoRestaurant.deleteById(id);
			return true;
		}
		
		catch (Exception e) {
			return false;
		}
	}
	
//	@PutMapping("/{id}")
//	@JsonView(Views.Restaurant.class)
//	public Restaurant update(@PathVariable int id, @RequestBody Restaurant r) 
//	{
//		r.setId(id);
//		return this.daoRestaurant.save(r);
//	}

	

}

