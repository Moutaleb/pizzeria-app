package fr.pizzeria.ihm;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoMemoire;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import java.util.Scanner;
import java.util.concurrent.CancellationException;

public class AjouterPizzaOptionMenu extends OptionMenu {

	public AjouterPizzaOptionMenu(IPizzaDao stockage) {
		super(stockage);
		this.titre = "Ajouter une nouvelle pizza";
	}

	public AjouterPizzaOptionMenu(IPizzaDao stockage, Scanner question) {
		super(stockage, question);
		this.titre = "Ajouter une nouvelle pizza";
	}

	@Override
	public void execute() {
		
		System.out.println("Veuillez saisir un code:");
		String code = question.next();
		System.out.println("Veuillez saisir un libellé:");
		String libelle = question.next();
		System.out.println("En majuscule veuillez saisir une categorie de pizza parmi : VIANDE , POISSON , SANS_VIANDE : ");
		String cat = question.next();
		CategoriePizza categorie = CategoriePizza.valueOf(cat);
		System.out.println("Veuillez saisir un prix:");
		double prix = question.nextDouble();
		
		if (categorie == null)
			categorie = CategoriePizza.VIANDE;		

		Pizza p = new Pizza(code, libelle, prix, categorie);
		
		try {
			stockage.saveNewPizza(p);
		} catch (StockageException e) {
			// e.printStackTrace();
			System.out.println("Erreure/Exception à l'ajout d'une pizza ! (tableau plein)");
		}
	}

}
