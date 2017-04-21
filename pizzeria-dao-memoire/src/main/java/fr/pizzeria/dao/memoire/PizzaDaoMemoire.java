package fr.pizzeria.dao.memoire;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.dao.api.DeletePizzaException;
import fr.pizzeria.dao.api.IPizzaDao;
import fr.pizzeria.dao.api.SavePizzaException;
import fr.pizzeria.dao.api.UpdatePizzaException;
import fr.pizzeria.domain.CategoriePizza;
import fr.pizzeria.domain.Pizza;



public class PizzaDaoMemoire implements IPizzaDao {

	private List<Pizza> listPizza;

	public PizzaDaoMemoire() {

		listPizza = new ArrayList<Pizza>();

		Pizza p0 = new Pizza("PEP", "Pépéroni", 12.5, CategoriePizza.POISSON);
		Pizza p1 = new Pizza("MAR", "Margherita", 14.00, CategoriePizza.SANS_VIANDE);
		Pizza p2 = new Pizza("REIN", "La Reine", 11.50, CategoriePizza.VIANDE);
		Pizza p3 = new Pizza("FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE);
		Pizza p4 = new Pizza("CAN", "La cannibale", 12.50, CategoriePizza.VIANDE);
		Pizza p5 = new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE);
		Pizza p6 = new Pizza("ORI", "L’orientale", 13.50, CategoriePizza.VIANDE);
		Pizza p7 = new Pizza("IND", "L’indienne", 14.00, CategoriePizza.POISSON);

		listPizza.add(p0);
		listPizza.add(p1);
		listPizza.add(p2);
		listPizza.add(p3);
		listPizza.add(p4);
		listPizza.add(p5);
		listPizza.add(p6);
		listPizza.add(p7);

	}

	@Override
	public List<Pizza> findAllPizzas() {

		return listPizza;
	}

	@Override
	public void saveNewPizza(Pizza pizza) throws SavePizzaException {

		Boolean resultat = false;

		resultat = listPizza.add(pizza);

		if (resultat == false)
			throw new SavePizzaException();
	}

	@Override // code pizza non utilisé
	public void updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {

		int indicePizza = existPizza(codePizza);

		if (indicePizza == -1)
			throw new UpdatePizzaException("erreure à la mise à jours !!!");
		else
			listPizza.set(indicePizza, pizza);

	}

	@Override
	public void deletePizza(String codeAmodifier) throws DeletePizzaException {

		int indicePizza = existPizza(codeAmodifier);

		if (indicePizza == -1)
			throw new DeletePizzaException("erreure !!!");
		else
			listPizza.remove(indicePizza);

	}

	// retourne -1 si la pizza n'hexiste pas sinon retourne l'indice de la
	// position de la pizza
	@Override
	public int existPizza(String codeATester) {

		int resultat = -1;

		for (int i = 0; i < listPizza.size(); i++) {

			Pizza p = listPizza.get(i);

			String code = p.getCode();

			if (codeATester.equals(code)) {
				listPizza.remove(i);
				resultat = i;
			}

		}

		return resultat;

	}

	public List<Pizza> getListPizza() {
		return listPizza;
	}

	public void setListPizza(List<Pizza> listPizza) {
		this.listPizza = listPizza;
	}

}
