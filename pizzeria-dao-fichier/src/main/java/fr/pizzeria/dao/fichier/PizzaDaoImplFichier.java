package fr.pizzeria.dao.fichier;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import fr.pizzeria.dao.api.DeletePizzaException;
import fr.pizzeria.dao.api.IPizzaDao;
import fr.pizzeria.dao.api.SavePizzaException;
import fr.pizzeria.dao.api.StockageException;
import fr.pizzeria.dao.api.UpdatePizzaException;
import fr.pizzeria.domain.CategoriePizza;
import fr.pizzeria.domain.Pizza;



public class PizzaDaoImplFichier implements IPizzaDao {
	
	String DATA_DIR;

	public PizzaDaoImplFichier(String DATA_DIR) {
		// TODO Auto-generated constructor stub
		
		this.DATA_DIR=DATA_DIR;
		
	}
	
	@Override
	public List<Pizza> findAllPizzas() {
		
		

		List<Pizza> listPizzas;
		try {
			listPizzas = Files.list(Paths.get(DATA_DIR)).map(path -> {

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

	@Override
	public void importDonne() throws StockageException {
		System.err.println("« Veuillez configurer l’application avec une implémentation base de données ».");
		
	}

}
