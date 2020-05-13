package fr.formation.projection;

import java.time.LocalDate;

import org.springframework.data.rest.core.config.Projection;



@Projection
(
	
)

public interface VisiteProjection 
{
	public int getId();
	
	public LocalDate getDateVisite();

}