package fr.formation.projection;

import org.springframework.data.rest.core.config.Projection;

import fr.formation.model.Menu;



@Projection
(
		name = "menuProjection",
		types = { Menu.class } 
)

public interface MenuProjection 
{
	public int getId();

}

