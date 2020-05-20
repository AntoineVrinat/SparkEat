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

import fr.formation.dao.IDAOClient;
import fr.formation.exception.ClientValidationException;
import fr.formation.model.Client;
import fr.formation.model.Restaurant;
import fr.formation.projection.Views;

@RestController 
@CrossOrigin("*")
@RequestMapping("/api/client")
public class ClientApiController 
{
	
	@Autowired
	private IDAOClient daoClient;
	
	@GetMapping
	@JsonView(Views.Client.class)
	public List<Client> findAll(){
		return this.daoClient.findAll();

	}
	
	
	@GetMapping("/{id}")
	@JsonView(Views.Client.class)
	public Client findById(@PathVariable int id)
	{
		return this.daoClient
				.findById(id)
				.orElse(new Client());
	}
	
	
	@PostMapping
	@JsonView(Views.Client.class)
	public Client add(@Valid @RequestBody Client c, BindingResult result)
	{
		if (result.hasErrors())
		{
		throw new ClientValidationException();
		}
		this.daoClient.save(c);

		return c;
	}
	
	@DeleteMapping("/{id}")
	public boolean delete(@PathVariable int id) // ou c'est ici l'id_c
	{
		try
		{
			this.daoClient.deleteById(id);
			return true;
		}
		
		catch (Exception e) {
			return false;
		}
	}
	
	

}

