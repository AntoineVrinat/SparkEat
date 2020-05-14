package fr.formation.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client implements Serializable {

	@Id
	@Column(name = "id_c", length = 11, nullable = false)
	protected int id;

	@Column(name = "nom", length = 50, nullable = false)
	protected String nom;

	@Column(name = "login", length = 50, nullable = false)
	protected String login;

	@Column(name = "passord", length = 50, nullable = false)
	protected String password;

	@ManyToMany
	private List<Restaurant> restaurants = new ArrayList<>();

	protected Client(int id, String nom, String login, String password) {
		this.id = id;
		this.nom = nom;
		this.login = login;
		this.password = password;
	}

	protected Client() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", login=" + login + ", password=" + password + "]";
	}

}
