package fr.formation.model;

public class Menu {
	
	protected int id;
	protected double prix;
	protected String plat;
	protected String boisson;
	
	protected Menu(double prix, String plat, String boisson) {
		this.prix = prix;
		this.plat = plat;
		this.boisson = boisson;
	}

	protected Menu() {
	}

	
	public double getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getPlat() {
		return plat;
	}

	public void setPlat(String plat) {
		this.plat = plat;
	}

	public String getBoisson() {
		return boisson;
	}

	public void setBoisson(String boisson) {
		this.boisson = boisson;
	}

	@Override
	public String toString() {
		return "Menu [prix=" + prix + ", plat=" + plat + ", boisson=" + boisson + "]";
	}

	
	
	
}
