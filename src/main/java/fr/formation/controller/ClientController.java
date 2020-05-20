package fr.formation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.dao.IDAOClient;
import fr.formation.dao.IDAOMenu;
import fr.formation.dao.IDAORestaurant;
import fr.formation.model.Client;
import fr.formation.model.Cuisines;
import fr.formation.model.Menu;
import fr.formation.model.Restaurant;



@Controller
public class ClientController 
{
	@Autowired
	private IDAOMenu daoMenu;
	
	@Autowired
	private IDAOClient daoClient;
	
	@Autowired
	private IDAORestaurant daoRestaurant;
	
	@GetMapping({"/","/home","/connexion"})
	public String homeInscription(HttpSession session, Model model) 
	{
		model.addAttribute("message",session.getAttribute("message"));
		session.removeAttribute("message");
		return "accueil";
	}
	
	@GetMapping("/deconnexion")
	public String deconnection(HttpSession session)
	{
		session.removeAttribute("Client");
		return "redirect:/accueil";
	}
	
	
	@PostMapping("/connexion")
	public String connection(@RequestParam(value="login") String login, @RequestParam(value="password") String password, Model model, HttpSession session) 
	{	
		Client c = this.daoClient.checkConnect(login, password);

		if (c==null) 
		{
			model.addAttribute("login", login);
			model.addAttribute("error", "Le login/password est incorrect");
			System.out.println("Mauvaise connexion");
			return "accueil";
		}
		return null;
	}
	
	@GetMapping("/Menu_Client")
	public String MenuClient(HttpSession session,Model model)
	{
			return "menuClient";
		
		//else {return "redirect:/accueil" ;}
	}
	
	
	@GetMapping("/FourchettePrix")
	public String afficherPrix(HttpSession session,Model model) 
	{
		Restaurant r = (Restaurant) session.getAttribute("restaurants");
		Menu m = this.daoMenu.findByPrix(r.getFourchettePrix());

		model.addAttribute("Menu",m);
		
		return "PrixRestaurants";
	}
	
	
	@GetMapping("/ChoixRestaurant")
	public String afficherRestaurant(HttpSession session,Model model) 
	{
		//Client c = (Client) session.getAttribute("clients");*??
		Cuisines c = (Cuisines) session.getAttribute("cuisines");
		Restaurant r = this.daoRestaurant.findByCuisines(c.getCuisines());

		model.addAttribute("Restaurant", r);
		
		return "ListeRestaurants";
	}
	
	@GetMapping("/ChoixMenu")
	public String afficherMenu(HttpSession session,Model model) 
	{
		//Client c = (Client) session.getAttribute("clients");??
		Menu m = (Menu) session.getAttribute("menus");
		Restaurant r = this.daoRestaurant.findByFourchettePrix((int) m.getPrix());

		model.addAttribute("Restaurant", r);
		return "ListeMenus";
	}
	
	@PutMapping("/ModifierPanier")
	public String modifierPanier(HttpSession session,Model model) 
	{
		Menu m = (Menu) session.getAttribute("menus");
		Restaurant r = this.daoRestaurant.findAll().get(0);
		
		model.addAttribute("Menu",m);
		return "Panier";
	}
	
	

}