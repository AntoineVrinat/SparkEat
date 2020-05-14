package fr.formation.model;

import java.io.Serializable;


import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "restaurants")
public class Restaurant /*implements Serializable*/
{
	
	
	@Id
	@Column(name = "fourchette_prix", length = 10, nullable = false)
	protected int fourchettePrix; 
	
	@Id
	@Column(name = "nom", length = 50, nullable = false)
	protected String nom;
	
	@Id
	@Column(name = "menu", length = 50, nullable = false)
	protected Menu menu;
	
	@Id
	@Column(name = "cuisines", length = 50, nullable = false)
	protected Cuisines cuisines;
	
	
	

	protected Restaurant(int fourchettePrix, String nom, Menu menu, Cuisines cuisines) {
		this.fourchettePrix = fourchettePrix;
		this.nom = nom;
		this.menu = menu;
		this.cuisines = cuisines;
	}

	protected Restaurant()
	{
		
	}
	
	public int getFourchettePrix() {
		return fourchettePrix;
	}



	public void setFourchettePrix(int fourchettePrix) {
		this.fourchettePrix = fourchettePrix;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public Menu getMenu() {
		return menu;
	}



	public void setMenu(Menu menu) {
		this.menu = menu;
	}



	public Cuisines getCuisines() {
		return cuisines;
	}



	public void setCuisines(Cuisines cuisines) {
		this.cuisines = cuisines;
	}

	@Override
	public String toString() {
		return "Restaurant [fourchettePrix=" + fourchettePrix + ", nom=" + nom + ", menu=" + menu + ", cuisines="
				+ cuisines + "]";
	}


	

}



