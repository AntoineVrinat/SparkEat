package fr.formation.api;

import java.util.List;

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

import fr.formation.dao.IDAOVisite;
import fr.formation.model.Visite;
import fr.formation.projection.Views;

@RestController 
@CrossOrigin("*")
@RequestMapping("/api/visite")
public class VisiteApiController 
{
	@Autowired
	private IDAOVisite daoVisite; 
	
	@GetMapping
	@JsonView(Views.Visite.class)
	public List<Visite> findAll()
	{
		return null;
	}
	
	//Une visite
	@GetMapping ("/{id}")
	@JsonView(Views.Visite.class)
	public Visite findById(@PathVariable int id)
	{
		return new Visite();
	}
	
	//Ajoute Une visite
	@PostMapping // requestBody convertit JSON via Spring
	public Visite add(@RequestBody Visite visite)
	{
		return visite;
	}
	
	//Modifie Une visite
	@PutMapping("/{id}")
	public Visite update(@PathVariable int id, @RequestBody Visite visite)
	{
		return visite;
	}
	
	//Supprime Une visite
	@DeleteMapping ("/{id}")
	public Visite delete(@PathVariable int id)
	{
		return new Visite();
	}

}