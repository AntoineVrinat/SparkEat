package model;

public class Restaurant 
{
	protected String Plat;
	
	protected int FourchettePrix; 
	
	protected String Nom;
	
	public String getPlat() {
		return Plat;
	}
	public void setPlat(String plat) {
		Plat = plat;
	}
	public int getFourchettePrix() {
		return FourchettePrix;
	}
	public void setFourchettePrix(int fourchetteprix) {
		FourchettePrix = fourchetteprix;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	
	protected Restaurant(String plat, int fourchetteprix, String nom) 
	{
		Plat = plat;
		FourchettePrix = fourchetteprix;
		Nom = nom;
	}
	
	@Override
	public String toString() {
		return "Restaurant [Plat=" + Plat + ", FouchettePrix=" + FourchettePrix + ", Nom=" + Nom + "]";
	} 
	
	

}
