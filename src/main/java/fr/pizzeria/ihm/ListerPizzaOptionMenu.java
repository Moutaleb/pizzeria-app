package fr.pizzeria.ihm;
import java.util.List;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoMemoire;
import fr.pizzeria.model.Pizza;


public class ListerPizzaOptionMenu extends OptionMenu {
	
	public ListerPizzaOptionMenu(IPizzaDao stockage) {
		super(stockage);
		this.titre = "Liste des pizzas";
	}

	@Override
	public void execute() {
		
		
		System.out.println("Il y a " + Pizza.getNbrPizza() + " Pizza stocké.");
		
		List<Pizza> listPizza = stockage.findAllPizzas();
		
		if(stockage == null){
		}else {
			
			for (int i = 0; i < listPizza.size(); i++) {
				if (listPizza.get(i) != null && listPizza.get(i).getId() != -1) {
					System.out.println(listPizza.get(i).getCode() + " " + listPizza.get(i).getNom() + " " + listPizza.get(i).getPrix() + " " + listPizza.get(i).getCategoriePizza());
				}
			}
		}
	}

}
