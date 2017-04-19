package fr.pizzeria.dao;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoMemoire;

public class DaoMemoireFactory implements DaoFactoy {
	
	private IPizzaDao pizzaDao = new PizzaDaoMemoire();
	
	
	public DaoMemoireFactory() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public IPizzaDao getPizzaDao() {
		
		return pizzaDao;
		
	}

}
