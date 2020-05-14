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
public class Client implements Serializable
{
	//private static final long serialVersionUID = 1L;  qu'est ce que c'est ??
	
	@Id
	@Column(name = "id_c", length = 11, nullable = false)
	protected int id;
	
	@Column(name = "nom", length = 50, nullable = false)
	protected String nom;

	@Column(name = "login", length = 50, nullable = false)
	protected String login;
	
	@Column(name = "passord", length = 50, nullable = false)
	protected String password;

	@ManyToMany(mappedBy = "restaurants")
	private List<Restaurant> restaurants = new ArrayList<>();  //en public peut être?? NON.
	
	

	protected Client(int id, String nom, String login, String password) 
	{
		this.id = id;
		this.nom = nom;
		this.login = login;
	}
	protected Client(int id, String nom, String password) {
		this.id = id;
		this.nom = nom;
		this.password = password;
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
	
	


	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", login=" + login + ", password=" + password + "]";
	}
	
	
	
}
