package fr.formation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "menu")
public class Menu 
{
	@Id
	@Column(name = "id_m", length = 11, nullable = false)
	protected int id;
	
	@Column(name = "entree", length = 50, nullable = false)
	protected String entree;

	@Column(name = "plat", length = 50, nullable = false)
	protected String plat;

	@Column(name = "dessert", length = 50, nullable = false)
	protected String dessert;

	@Column(name = "boisson", length = 50, nullable = false)
	protected String boisson;

	@Column(name = "prix")
	protected double prix;
	
	@ManyToOne
	@JoinColumn(name="id_r")
	private Restaurant restaurant;
	
	
	
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
				+ boisson + ", prix=" + prix + ", restaurant=" + restaurant + "]";
	}

	

	
	
	
}
