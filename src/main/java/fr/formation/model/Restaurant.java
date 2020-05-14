package fr.formation.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name = "restaurant")
public class Restaurant
{
	@Id
	@Column(name = "id_R", length = 11, nullable=false)
	protected int id;
	
	
	@Column(name = "fourchette_prix", length = 10, nullable = false)
	protected int fourchettePrix; 
	
	@Column(name = "nom", length = 50, nullable = false)
	protected String nom;
	
	@OneToMany(mappedBy = "menu")
	private List<Menu> menus = new ArrayList<>(); 
	
	@Column(name = "cuisines", length = 50, nullable = false)
	@Enumerated(EnumType.STRING)
	protected Cuisines cuisines;
	
	 
	@ManyToMany(mappedBy ="client")
	private List<Client> client = new ArrayList<>();
	
	
	

	protected Restaurant(int fourchettePrix, String nom, Menu menu, Cuisines cuisines) {
		this.fourchettePrix = fourchettePrix;
		this.nom = nom;
		menu = menu;
		this.cuisines = cuisines;
	}

	protected Restaurant()
	{
		
	}
	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	



	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public Cuisines getCuisines() {
		return cuisines;
	}



	public void setCuisines(Cuisines cuisines) {
		this.cuisines = cuisines;
	}

	@Override
	public String toString() {
		return "Restaurant [fourchettePrix=" + fourchettePrix + ", nom=" + nom + ", menus=" + menus + ", cuisines="
				+ cuisines + "]";
	}


	

}



