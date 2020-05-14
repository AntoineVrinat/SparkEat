package fr.formation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.dao.IDAOClient;
import fr.formation.model.Client;



@Controller
public class ClientController 
{
	
	
	@GetMapping({"/","/home","/connection"})
    public String homeInscription(HttpSession session, Model model) 
    {
        model.addAttribute("message",session.getAttribute("message"));
        session.removeAttribute("message");
        return "home";
    }

    @GetMapping("/deconnection")
    public String deconnection(HttpSession session)
    {
        session.removeAttribute("Client");
        return "redirect:/home";
    }


    @PostMapping("/connection")
    public String connection(@RequestParam(value="login") String login, @RequestParam(value="password") String password, Model model, HttpSession session) 
    {
        Client c = this.daoClient.checkConnect(login, password);

        if (c==null) 
        {
            model.addAttribute("login", login);
            model.addAttribute("error", "Le login/password est incorrect");
            System.out.println("Mauvaise connection");
            return "home";
        }
        return null;
    }
    
	@Autowired
	private IDAOClient daoClient;
	
}