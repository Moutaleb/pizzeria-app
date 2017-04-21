package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.api.IPizzaDao;
import fr.pizzeria.dao.api.StockageException;
import fr.pizzeria.dao.memoire.PizzaDaoMemoire;
import fr.pizzeria.domain.CategoriePizza;
import fr.pizzeria.domain.Pizza;



public class ModifierPizzaOptionMenu extends OptionMenu {

	public ModifierPizzaOptionMenu(PizzaDaoMemoire stockageTableau) {
		super(stockageTableau);
		this.titre = "Mettre à jour une pizza";
	}

	public ModifierPizzaOptionMenu(IPizzaDao daoImpl, Scanner question) {
		super(daoImpl, question);
		this.titre = "Mettre à jour une pizza";
	}

	@Override
	public void execute() {
		int testPizza = -1;

		System.out.println("Veuillez choisir la pizza à modifier: ");
		String codeAModifier = question.next();

		// si testPizza = -1 alors pas de pizza
		testPizza = stockage.existPizza(codeAModifier);

		if (testPizza != -1) {

			question.nextLine();
			System.out.println("Veuillez saisir un code:");
			String code = question.next();
			System.out.println("Veuillez saisir un libell�:");
			String libelle = question.next();
			System.out.println("En majuscule veuillez saisir une categorie de pizza parmi : VIANDE , POISSON , SANS_VIANDE : ");
			String cat = question.next();
			CategoriePizza categorie = CategoriePizza.valueOf(cat);
			System.out.println("Veuillez saisir un prix:");
			double prix = question.nextDouble();
			System.out.println("Veuillez saisir un prix:");

			if (categorie == null)
				categorie = CategoriePizza.VIANDE;		

			Pizza p = new Pizza(code, libelle, prix, categorie);


			try {
				stockage.updatePizza(codeAModifier, p);
			} catch (StockageException e) {
				System.out.println("Cette pizza n'existe pas");
				
				//e.printStackTrace();
			}

		} else {
			System.out.println("Cette pizza n'existe pas");
		}

	}
}
