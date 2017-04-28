package org.pizzeria.dao.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.pizzeria.dao.api.IPizzaDao;
import fr.pizzeria.dao.api.StockageException;
import fr.pizzeria.domain.Pizza;

public class JDBC implements IPizzaDao {
	

	
			
	private String url; //jdbc:mysql://localhost:3306/pizzeria?useSSL=false
	private String username; //root
	private String password; //""


	public JDBC(){
		
		
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
	    url = bundle.getString("jdbc.url");
	    username = bundle.getString("jdbc.username");
	    password = bundle.getString("jdbc.password");
		
		try {
			
			
			Class.forName("com.mysql.jdbc.Driver");
			//myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria?useSSL=false","root", "");
			//statement = myConnection.createStatement();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}						
	}
	
	
	@Override
	public List<Pizza> findAllPizzas() {
		
		
		Statement statement;
		Connection myConnection;
							
		List<Pizza> pizza = new ArrayList<>();
		
		PreparedStatement selectPizzaSt;
		try {
			
			myConnection = DriverManager.getConnection(url,username, password);
			statement = myConnection.createStatement();
			selectPizzaSt = myConnection.prepareStatement("SELECT * FROM PIZZA");
			ResultSet resultat = selectPizzaSt.executeQuery();
			while(resultat.next()){
					
				String nom = resultat.getString("NOM");
				String prenom = resultat.getString("PRENOM");
				double prix = resultat.getDouble("PRIX");
				
				pizza.add(new Pizza(nom,prenom,prix, null));
				
				//System.out.println("[id=" + nom + " nom=" + " prenom=" + prenom + " prix=" + prix + "]");												
			}
			resultat.close();
			statement.close();
			myConnection.close();
				
		} catch (SQLException e) {
		
			e.printStackTrace();
		}						
		return pizza;
	}

	@Override
	public void saveNewPizza(Pizza pizza) throws StockageException {	
		Statement statement;
		Connection myConnection;
		
		PreparedStatement selectPizzaSt;
		try {
			myConnection = DriverManager.getConnection(url,username, password);
			statement = myConnection.createStatement();
			selectPizzaSt = myConnection.prepareStatement("INSERT INTO `pizza` (`ID`, `Nom`, `Prenom`, `prix`) VALUES (NULL, ?, ?, ?)" ); 
			selectPizzaSt.setString(1, pizza.getCode());
			selectPizzaSt.setString(2, pizza.getNom());
			selectPizzaSt.setDouble(3, pizza.getPrix());
			
			
			selectPizzaSt.executeUpdate();
			selectPizzaSt.close();
			statement.close();
			myConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) throws StockageException {
		
		Statement statement;
		Connection myConnection;
		
		PreparedStatement selectPizzaSt;
		try {
			myConnection = DriverManager.getConnection(url,username, password);
			statement = myConnection.createStatement();
			selectPizzaSt = myConnection.prepareStatement("UPDATE `pizza` SET `Nom` = ? '', `Prenom` = ? '', `prix` = ? '' WHERE `pizza`.`NOM`=? " );
			selectPizzaSt.setString(1, pizza.getCode());
			selectPizzaSt.setString(2, pizza.getNom());
			selectPizzaSt.setDouble(3, pizza.getPrix());
			
			selectPizzaSt.setString(4, codePizza);
			
			
			selectPizzaSt.executeUpdate();
			selectPizzaSt.close();
			statement.close();
			myConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
	}

	@Override
	public void deletePizza(String codePizza) throws StockageException {		
		Statement statement;
		Connection myConnection;
		PreparedStatement selectPizzaSt;
		try {
			myConnection = DriverManager.getConnection(url,username, password);
			statement = myConnection.createStatement();
			
			selectPizzaSt = myConnection.prepareStatement("DELETE FROM `pizza` WHERE `pizza`.`NOM`= ?" ); 
			selectPizzaSt.setString(1, codePizza);
			
			selectPizzaSt.executeUpdate();
			selectPizzaSt.close();
			statement.close();
			myConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						
	}


	@Override
	public int existPizza(String codeATester) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void importDonne() throws StockageException {
		
		return;		
		
	}
}

