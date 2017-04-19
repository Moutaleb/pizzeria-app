package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.StockageException;

public class SupprimerPizzaOptionMenu extends OptionMenu {

	public SupprimerPizzaOptionMenu(IPizzaDao stockage) {
		super(stockage);
		this.titre = "Supprimer une pizza";
	}

	public SupprimerPizzaOptionMenu(IPizzaDao stockage, Scanner question) {
		super(stockage, question);
		this.titre = "Supprimer une pizza";
	}

	@Override
	public void execute() {

		System.out.println("Veuillez choisir la pizza à supprimer: (code)");
		String codeAmodifier = question.next();

		try {
			stockage.deletePizza(codeAmodifier);
		} catch (StockageException e) {
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}
	}

}
