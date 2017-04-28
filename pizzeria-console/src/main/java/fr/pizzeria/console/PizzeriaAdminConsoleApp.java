package fr.pizzeria.console;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;

import org.pizzeria.dao.jdbc.JDBC;
import org.pizzeria.dao.jpa.PizzaDaoJpa;

import com.github.lalyos.jfiglet.FigletFont;

import fr.pizzeria.dao.api.DaoFactoy;
import fr.pizzeria.dao.api.IPizzaDao;
import fr.pizzeria.dao.fichier.DaoFichierFactory;





public class PizzeriaAdminConsoleApp {

	public static void main(String[] args){
		
		

		
		ResourceBundle bundle = ResourceBundle.getBundle("application");
	    String value = bundle.getString("dao.impl");
	    
	  String $dao = "fr.pizzeria.dao.memoire.PizzaDaoMemoire";
	  java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
				
		/*Class<?> maClasse;
		try {
			maClasse = Class.forName(value);
			IPizzaDao unObjet = (IPizzaDao) maClasse.newInstance();
			unObjet.findAllPizzas().forEach(p -> p.toString());
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}*/
		
	
   
	    
	    
		Scanner question = new Scanner(System.in);
		question.useLocale(Locale.US);
	
		Menu menu = new Menu();
		
		System.out.println(FigletFont.convertOneLine("Pizzeria App"));
		
		//Stock
		
		//DaoFactoy daoFactoy = new DaoFichierFactory();
	
		
				
		
		//IPizzaDao pizzaDao = daoFactoy.getPizzaDao(); 	
		
		
		//IPizzaDao pizzaDao = new JDBC();
		
		IPizzaDao pizzaDao = new PizzaDaoJpa();

		OptionMenu lister = new ListerPizzaOptionMenu(pizzaDao);
		OptionMenu ajouter = new AjouterPizzaOptionMenu(pizzaDao, question);
		OptionMenu mettreAJour = new ModifierPizzaOptionMenu(pizzaDao, question);
		OptionMenu supprimer = new SupprimerPizzaOptionMenu(pizzaDao, question);

		Map<Integer, OptionMenu> actions;

		Map<Integer, OptionMenu> mapActions = new HashMap<Integer, OptionMenu>();

		mapActions.put(0, lister);
		mapActions.put(1, ajouter);
		mapActions.put(2, mettreAJour);
		mapActions.put(3, supprimer);

		menu.setActions(mapActions);

		int choixMenu = 0;
		while (choixMenu != 99) {

			// Affichage du menu
			menu.afficher();

			// Poser une question
			choixMenu = question.nextInt();

			// Analyse de la r�ponse � la question
			switch (choixMenu) {
			case 1: // lister

				mapActions.get(0).execute();

				break;
			case 2: // ajouter

				mapActions.get(0).execute();

				mapActions.get(1).execute();
				break;
			case 3: // modifier

				mapActions.get(0).execute();

				mapActions.get(2).execute();

				break;
			case 4: // supprimer

				mapActions.get(0).execute();

				mapActions.get(3).execute();
				break;
			default:
				break;
			}
		}

		question.close();

	}

}
