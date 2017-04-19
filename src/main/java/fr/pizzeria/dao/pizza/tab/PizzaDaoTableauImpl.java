package fr.pizzeria.dao.pizza.tab;

import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoTableauImpl implements IPizzaDaoTableau {

	private Pizza[] tabPizza;

	public PizzaDaoTableauImpl() {

		tabPizza = new Pizza[10];

		Pizza p0 = new Pizza("PEP", "Pépéroni", 12.5, CategoriePizza.POISSON);
		Pizza p1 = new Pizza("MAR", "Margherita", 14.00, CategoriePizza.SANS_VIANDE);
		Pizza p2 = new Pizza("REIN", "La Reine", 11.50, CategoriePizza.VIANDE);
		Pizza p3 = new Pizza("FRO", "La 4 fromages", 12.00, CategoriePizza.POISSON);
		Pizza p4 = new Pizza("CAN", "La cannibale", 12.50, CategoriePizza.POISSON);
		Pizza p5 = new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.POISSON);
		Pizza p6 = new Pizza("ORI", "L’orientale", 13.50, CategoriePizza.VIANDE);
		Pizza p7 = new Pizza("IND", "L’indienne", 14.00, CategoriePizza.VIANDE);

		tabPizza[0] = p0;
		tabPizza[1] = p1;
		tabPizza[2] = p2;
		tabPizza[3] = p3;
		tabPizza[4] = p4;
		tabPizza[5] = p5;
		tabPizza[6] = p6;
		tabPizza[7] = p7;

	}

	@Override
	public Pizza[] findAllPizzas() {

		return tabPizza;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) {

		Boolean resultat = false;

		for (int i = 0; i < tabPizza.length; i++) {

			if (tabPizza[i] == null || tabPizza[i].getId() == -1) {
				pizza.setId(i);
				tabPizza[i] = pizza;
				resultat = true;
				break;
			}
		}

		return resultat;
	}

	@Override //code pizza non utilisé
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		
		boolean resultat = false;
		
		for (int i = 0; i < tabPizza.length; i++) {

			if (tabPizza[i] != null && tabPizza[i].getCode().equals(codePizza)) {
				tabPizza[i] = pizza;
				resultat = true;
				break;
			} else if (i == tabPizza.length - 1) {
				//System.out.println("Cette pizza n'existe pas");
				
				throw new UpdatePizzaException();
				
			}
		}		
		return resultat;
	}

	@Override
	public boolean deletePizza(String codeAmodifier) {

		boolean resultat = false;

		for (int i = 0; i < tabPizza.length; i++) {

			if (tabPizza[i] != null && tabPizza[i].getCode().equals(codeAmodifier)) {
				tabPizza[i].setId(-1);
				resultat = true;
				break;
			} else if (i == tabPizza.length - 1) {
				System.out.println("Cette pizza n'existe pas");
			}
		}

		Pizza.setNbrPizza(Pizza.getNbrPizza() - 1);

		return resultat;
	}

	@Override
	public int existPizza(String codeATester) {

		int resultat = -1;

		for (int i = 0; i < tabPizza.length; i++) {

			if (tabPizza[i] != null && tabPizza[i].getCode().equals(codeATester)) {

				resultat = i;

				break;
			}
		}
		return resultat;

	}

	public Pizza[] getTabPizza() {
		return tabPizza;
	}

	public void setTabPizza(Pizza[] tabPizza) {
		this.tabPizza = tabPizza;
	}

}
