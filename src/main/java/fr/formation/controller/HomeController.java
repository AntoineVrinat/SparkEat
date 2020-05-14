package fr.formation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import fr.formation.dao.IDAOClient;

@Controller
//@RequestMapping("/home") // PREFIXER TOUS LES MAPPINGS DE CETTE CLASSE
public class HomeController 
{
	@Autowired
	private IDAOClient daoClient;
	
	private static Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping({"/home" })
	public String home() 
	{
		this.daoClient.findAll();
		return "home";
	}
	
	
}