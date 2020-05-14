package fr.formation.model;

public class Restaurant 
{
	protected int fourchettePrix; 
	protected String nom;
	protected Menu menu;
	protected Cuisines cuisines;
	
	protected Restaurant(int fourchettePrix, String nom, Menu menu, Cuisines cuisines) {
		this.fourchettePrix = fourchettePrix;
		this.nom = nom;
		this.menu = menu;
		this.cuisines = cuisines;
	}

	

	@Override
	public String toString() {
		return "Restaurant [FourchettePrix=" + fourchettePrix + ", Nom=" + nom + ", Menu=" + menu + "]";
	}
	
	

}
