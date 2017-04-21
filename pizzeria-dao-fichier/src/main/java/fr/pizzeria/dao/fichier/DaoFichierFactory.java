package fr.pizzeria.dao.fichier;

import fr.pizzeria.dao.api.DaoFactoy;
import fr.pizzeria.dao.api.IPizzaDao;

public class DaoFichierFactory implements DaoFactoy {

	private static final String DATA_DIR = "../data";
	private IPizzaDao pizzaDao = new PizzaDaoImplFichier(DATA_DIR);

	@Override
	public IPizzaDao getPizzaDao() {

		return pizzaDao;

	}
}
