package fr.formation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ApplicationDemoSql {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//CONNEXION AU SERVEUR
			Connection maConnexionSql = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/eshop?serverTimezone=UTC", "root", "");
			
			System.out.println("Connexion OK !");
			
			//REQUETE DE SELECT
			Statement monStatement = maConnexionSql.createStatement();
			ResultSet monResultat = monStatement.executeQuery("SELECT * FROM produit");
			
			while (monResultat.next()) {
				System.out.println( monResultat.getString("PRO_LIBELLE") );
			}
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		catch (ClassNotFoundException cnfe) {
			System.out.println("Driver non chargé ...");
		}
	}
}