package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

//import fr.formation.model.Cuisines;
import fr.formation.model.Menu;

public interface IDAOMenu extends JpaRepository<Menu, Integer> {
	public Menu findByPrix(double prix);
}
