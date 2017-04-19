package fr.pizzeria.dao.pizza;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import fr.pizzeria.dao.pizza.tab.IPizzaDaoTableau;
import fr.pizzeria.exception.*;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImplFichier implements IPizzaDao {

	public PizzaDaoImplFichier() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<Pizza> findAllPizzas() {

		List<Pizza> listPizzas;
		try {
			listPizzas = Files.list(Paths.get("data")).map(path -> {

				String code = path.toFile().getName().replaceAll(".txt", "");

				String[] valueTab;
				try {
					valueTab = Files.lines(path).findFirst().orElseThrow(() -> new StockageException("fichier vide"))
							.split(";");
				} catch (IOException e) {
					throw new StockageException(e);
				}

				return new Pizza(code, valueTab[1], Double.valueOf(valueTab[2]), CategoriePizza.valueOf(valueTab[3]));

			}).collect(Collectors.toList());
		} catch (IOException e) {
			throw new StockageException(e);
		}

		return listPizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza) throws SavePizzaException {
		// TODO Auto-generated method stub
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		// TODO Auto-generated method stub
	}

	@Override
	public void deletePizza(String codePizza) throws DeletePizzaException {
		// TODO Auto-generated method stub
	}

	@Override
	public int existPizza(String codeATester) {
		// TODO Auto-generated method stub
		return 0;
	}

}
