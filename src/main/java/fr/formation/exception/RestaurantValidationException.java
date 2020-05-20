package fr.formation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "La visite n'a pas pu être validée")
public class RestaurantValidationException extends RuntimeException 
{
	
}



