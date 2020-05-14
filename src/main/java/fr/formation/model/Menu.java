package fr.formation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name = "menus")
public class Menu 
{
	@Id
	@Column(name = "id", length = 11, nullable = false)
	protected int id;
	
	@Id
	@Column(name = "entree", length = 50, nullable = false)
	protected String entree;
	
	@Id
	@Column(name = "plat", length = 50, nullable = false)
	protected String plat;
	
	@Id
	@Column(name = "dessert", length = 50, nullable = false)
	protected String dessert;
	
	@Id
	@Column(name = "boisson", length = 50, nullable = false)
	protected String boisson;
	
	@Id
	@Column(name = "prix")
	protected double prix;
	
	@ManyToMany(mappedBy = "restaurants") //??
	private List<Restaurant> restaurants = new ArrayList<>();  //en public peut être??
	
	
	
	protected Menu( int id, String entree, String plat,  String dessert, String boisson, double prix) 
	{
		this.id = id;
		this.entree = entree;
		this.plat = plat;
		this.dessert = dessert;
		this.boisson = boisson;
		this.prix = prix;
	}

	protected Menu() {	}

	
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

	public String getEntree() {
		return entree;
	}

	public void setEntree(String entree) {
		this.entree = entree;
	}

	public String getDessert() {
		return dessert;
	}

	public void setDessert(String dessert) {
		this.dessert = dessert;
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
	public String toString() 
	{
		return "Menu [id=" + id + ", entree=" + entree + ", plat=" + plat + ", dessert=" + dessert + ", boisson="
				+ boisson + ", prix=" + prix + ", restaurants=" + restaurants + "]";
	}

	

	
	
	
}
