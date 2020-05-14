package fr.formation.model;

import java.io.Serializable;


import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "restaurants")
public class Restaurant
{
	@Id
	@Column(name = "id_R", length = 11, nullable=false)
	protected int id;
	
	
	@Column(name = "fourchette_prix", length = 10, nullable = false)
	protected int fourchettePrix; 
	
	@Column(name = "nom", length = 50, nullable = false)
	protected String nom;
	
	@Column(name = "menu", length = 50, nullable = false)
	protected Menu menu; // a transformer en liste avec les bons mappins
	

	@Column(name = "cuisines", length = 50, nullable = false)
	@Enumerated(EnumType.STRING)
	protected Cuisines cuisines;
	
	//Liste des clients (exemple : secrétaire + visite)
	
	
	

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



