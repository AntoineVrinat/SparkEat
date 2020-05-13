package fr.formation.model;

public class Restaurant 
{

	protected String Plat;
	protected int FourchettePrix; 
	protected String Nom;
	protected Menu Menu;
	
	protected Restaurant(int fourchettePrix, String nom, fr.formation.model.Menu menu) {
		FourchettePrix = fourchettePrix;
		Nom = nom;
		Menu = menu;
	}

	public int getFourchettePrix() {
		return FourchettePrix;
	}

	public void setFourchettePrix(int fourchettePrix) {
		FourchettePrix = fourchettePrix;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public Menu getMenu() {
		return Menu;
	}

	public void setMenu(Menu menu) {
		Menu = menu;
	}

	@Override
	public String toString() {
		return "Restaurant [FourchettePrix=" + FourchettePrix + ", Nom=" + Nom + ", Menu=" + Menu + "]";
	}
	
	

}
