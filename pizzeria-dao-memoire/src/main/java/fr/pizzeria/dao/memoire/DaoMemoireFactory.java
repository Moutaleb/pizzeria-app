package fr.pizzeria.dao.memoire;

import fr.pizzeria.dao.api.DaoFactoy;
import fr.pizzeria.dao.api.IPizzaDao;

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
