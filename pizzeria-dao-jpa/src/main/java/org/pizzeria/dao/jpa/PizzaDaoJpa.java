package org.pizzeria.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.pizzeria.dao.api.IPizzaDao;
import fr.pizzeria.dao.api.StockageException;
import fr.pizzeria.domain.CategoriePizza;
import fr.pizzeria.domain.Pizza;

public class PizzaDaoJpa implements IPizzaDao {

	EntityManagerFactory entityManagerFactory;

	public PizzaDaoJpa() {
		super();
		this.entityManagerFactory = Persistence.createEntityManagerFactory("pizzeria-unit");
		saveNewPizza(new Pizza("mer","merguez",12.00,CategoriePizza.VIANDE));
		saveNewPizza(new Pizza("roy","royale",14.00,CategoriePizza.VIANDE));
		saveNewPizza(new Pizza("nor","nordique",12.00,CategoriePizza.POISSON));
		saveNewPizza(new Pizza("keb","kebab",15.00,CategoriePizza.VIANDE));
		
	}

	@Override
	public List<Pizza> findAllPizzas() {

		EntityManager em = entityManagerFactory.createEntityManager();

		List<Pizza> listpizza = new ArrayList<Pizza>();
		Query query = em.createQuery("select p from Pizza p ");

		listpizza = (List<Pizza>) query.getResultList();

		em.close();

		return listpizza;
	}

	@Override
	public void saveNewPizza(Pizza pizza) throws StockageException {

		// creation d'un manager d'entité de pizza
		EntityManager em = entityManagerFactory.createEntityManager();
		// creation d'une transaction sur le manager de pizza
		EntityTransaction et = em.getTransaction();

		// commence la transaction
		et.begin();
		// ajouute la pizza dans le manager de pizza
		em.persist(pizza);
		// valide la transaction dans la base de donnée
		et.commit();

		em.close();

	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) throws StockageException {

		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Query query = em.createQuery("select h from Pizza h where h.code=:codePizza");

		query.setParameter("codePizza", codePizza);

		Pizza pizza1 = (Pizza) query.getSingleResult();

		if (pizza != null) {

			Pizza pizza2 = new Pizza();
			pizza2.setId(pizza1.getId());
			pizza2.setNom(pizza.getNom());
			pizza2.setCode(pizza.getCode());
			pizza2.setPrix(pizza.getPrix());
			pizza2.setCategoriePizza(pizza.getCategoriePizza());
			em.merge(pizza2);

		}
		et.commit();
		em.close();
	}

	@Override
	public void deletePizza(String codePizza) throws StockageException {
	
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Query query = em.createQuery("delete from Pizza p where p.code=:codePizza");
		
		query.setParameter("codePizza", codePizza);
		
		query.executeUpdate();
		
		
		//Pizza pizza1 = (Pizza) query.getResultList().get(0);
		
		
		/*if (pizza1 != null) {

			pizza1.setCode(codePizza);		
			em.remove(pizza1);

		}*/
				
		et.commit();
		em.close();
	
	}

	@Override
	public void importDonne() throws StockageException {
		// TODO Auto-generated method stub

	}

	@Override
	public int existPizza(String codeATester) {
		// TODO Auto-generated method stub
		return 0;
	}

}
