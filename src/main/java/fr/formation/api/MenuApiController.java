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

import fr.formation.dao.IDAOMenu;
import fr.formation.exception.MenuValidationException;
import fr.formation.model.Menu;
import fr.formation.model.Restaurant;
import fr.formation.projection.Views;

@RestController 
@CrossOrigin("*")
@RequestMapping("/api/menu")
public class MenuApiController 
{
	
	@Autowired
	private IDAOMenu daoMenu;
	
	@GetMapping
	@JsonView(Views.Menu.class)
	public List<Menu> findAll(){
		return this.daoMenu.findAll();

	}
	
	
	@GetMapping("/{id}")
	@JsonView(Views.Menu.class)
	public Menu findById(@PathVariable int id) {
		return this.daoMenu.findById(id).orElse(new Menu());
	}
	
	
	@PostMapping
	@JsonView(Views.Menu.class)
	public Menu add(@Valid @RequestBody Menu m, BindingResult result)
	{
		if (result.hasErrors())
		{
		throw new MenuValidationException();
		}
		this.daoMenu.save(m);

		return m;
	}
	
	@DeleteMapping("/{id}")
	public boolean delete(@PathVariable int id) 
	{
		try
		{
			this.daoMenu.deleteById(id);
			return true;
		}
		
		catch (Exception e) {
			return false;
		}
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.Menu.class)
	public Menu update(@PathVariable int id, @RequestBody Menu m) 
	{
		m.setId(id);
		return this.daoMenu.save(m);
	}

	

}

