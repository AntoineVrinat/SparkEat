package fr.formation.controller;





import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
//@RequestMapping("/home") // PREFIXER TOUS LES MAPPINGS DE CETTE CLASSE
public class HomeController 
{
	
	private static Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping({"/connect" })
	public String connect() 
	{
		int param = 5 ;
		logger.debug("Je suis passée par là {}:{}", param, param * 2);
		return "connect";
	}
	
	/*
	 * @PostMapping("/connect") public String connect(
	 * 
	 * @RequestParam(value = "login") String username,
	 * 
	 * @RequestParam String password, HttpSession session, Model model) {
	 * 
	 * if (username.isEmpty()) { model.addAttribute("error",
	 * "Username must not be empty"); return "connect"; }
	 * 
	 * //On v�rifie la connexion Compte compte =
	 * this.daoCompte.checkConnect(username, password);
	 * 
	 * if (compte == null) { model.addAttribute("error", "Login incorrect"); return
	 * "connect"; }
	 * 
	 * session.setAttribute("compte", compte); return "redirect:/visite"; }
	 */
}