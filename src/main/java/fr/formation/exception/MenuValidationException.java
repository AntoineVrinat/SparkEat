package fr.formation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "Le menu n'a pas pu être validée")
public class MenuValidationException extends RuntimeException 
{
	
}



