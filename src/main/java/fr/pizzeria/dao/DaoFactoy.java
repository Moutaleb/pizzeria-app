package fr.pizzeria.dao;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.tab.IPizzaDaoTableau;

public interface DaoFactoy {
	
	public IPizzaDao getPizzaDao();
}
