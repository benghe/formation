package fr.formation.dao.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoSql {
	protected Connection connexionSql;
	
	public void openConnection() {
		
		try {
			this.connexionSql=DriverManager.getConnection("jdbc:mysql://localhost:3306/eshop?serverTimezone=UTC", "root", "");
			System.out.println("Connexion OK!");
		}
		
		catch(SQLException sqle) {
			sqle.printStackTrace();			
		}
		
	}
	
	public void closeConection() {
		try {
			this.connexionSql.close();
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}
