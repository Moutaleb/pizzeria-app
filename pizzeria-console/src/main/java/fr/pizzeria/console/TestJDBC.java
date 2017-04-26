package fr.pizzeria.console;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.jdbc.Driver");

		Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria?useSSL=false",
				"root", "");
		Statement statement = myConnection.createStatement();
		// ResultSet resultat = statement.executeQuery(" SELECT * FROM pizza ");

		PreparedStatement selectPizzaSt = myConnection.prepareStatement("SELECT * FROM PIZZA WHERE ID=?");
		for (int i = 0; i < 5; i++) {

			selectPizzaSt.setInt(1, i);
			ResultSet resultat = selectPizzaSt.executeQuery();
			if (resultat.next()) {
				Integer id = resultat.getInt("ID");
				String nom = resultat.getString("NOM");
				String prenom = resultat.getString("PRENOM");
				BigDecimal prix = resultat.getBigDecimal("PRIX");

				System.out.println("[id=" + id + " nom=" + nom + " prenom=" + prenom + " prix=" + prix + "]");

			}
			resultat.close();
		}

	}

}
