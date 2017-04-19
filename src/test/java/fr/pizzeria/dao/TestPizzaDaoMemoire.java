package fr.pizzeria.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.pizzeria.dao.pizza.PizzaDaoMemoire;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class TestPizzaDaoMemoire {

	@Test /* (expected = IOException.class) */
	public void test_find_All_Pizzas_init() {

		PizzaDaoMemoire pizzaDao = new PizzaDaoMemoire();

		List listPizza = pizzaDao.findAllPizzas();

		Assert.assertTrue("La liste ne doit pas être vide", listPizza.size() != 0);
		Assert.assertEquals(8, listPizza.size());
	}

	@Test
	public void test_find_All_Pizzas_save() {

		PizzaDaoMemoire pizzaDao = new PizzaDaoMemoire();

		
		
		Pizza p = new Pizza("test", "Pizza test", 12.5, CategoriePizza.POISSON);
		
		pizzaDao.saveNewPizza(p);
		
		List listPizza = pizzaDao.findAllPizzas();
		
		Assert.assertEquals(9, listPizza.size());
	}

}