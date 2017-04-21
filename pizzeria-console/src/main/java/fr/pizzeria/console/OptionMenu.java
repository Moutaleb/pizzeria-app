package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.api.IPizzaDao;
import fr.pizzeria.dao.memoire.PizzaDaoMemoire;



public abstract class OptionMenu {
	
	protected IPizzaDao stockage;
	protected Scanner question;
	protected String titre;

	
	
	public OptionMenu(IPizzaDao stockage) {
		
		this.stockage = stockage;
		
	}
	
	public OptionMenu(IPizzaDao stockage, Scanner question) {
		
		this.stockage = stockage;
		this.question = question;
	}
	
	String getLibelle() {
		
		return titre;
		
	}
	
	public abstract void execute();

	
	
	public IPizzaDao getTabPizza() {
		return stockage;
	}

	public void setTabPizza(PizzaDaoMemoire stockageTableau) {
		this.stockage = stockageTableau;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
}
