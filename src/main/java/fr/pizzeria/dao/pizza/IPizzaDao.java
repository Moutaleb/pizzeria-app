package fr.pizzeria.dao.pizza;

import java.util.List;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	
	//Pizza[] findAllPizzas();
	
	List<Pizza> findAllPizzas();

	void saveNewPizza(Pizza pizza) throws StockageException ;

	void updatePizza(String codePizza, Pizza pizza) throws StockageException;

	void deletePizza(String codePizza) throws StockageException;

	int existPizza(String codeATester);

}
