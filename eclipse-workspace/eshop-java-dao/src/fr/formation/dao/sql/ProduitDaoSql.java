package fr.formation.dao.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.formation.dao.IProduitDao;
import fr.formation.model.Produit;

public class ProduitDaoSql implements IProduitDao {
	private Connection connexionSql;
	
	@Override
	public List<Produit> findAll() {
		List<Produit> mesProduits = new ArrayList<>();
		
		try {
			//CONNEXION AU SERVEUR
			this.openConnection();
			
			//REQUETE DE SELECT DES PRODUITS
			Statement monStatement = this.connexionSql.createStatement();
			ResultSet monResultat = monStatement.executeQuery("SELECT * FROM produit");
			
			//PARCOURS DES RESULTATS DE LA REQUETE DE SELECTION DES PRODUITS
			while (monResultat.next()) {
				Produit monProduit = new Produit();

				monProduit.setId( monResultat.getInt("PRO_ID") );
				monProduit.setLibelle( monResultat.getString("PRO_LIBELLE") );
				monProduit.setPrix( monResultat.getBigDecimal("PRO_PRIX") );
				
				mesProduits.add(monProduit);
			}
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		finally {
			this.closeConection();
		}
		
		return mesProduits;
	}

	@Override
	public Produit findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit add(Produit entity) {
		try {
			//CONNEXION AU SERVEUR
			this.openConnection();
			
			//REQUETE D'INSERT
			//INSERT INTO produit (PRO_LIBELLE, PRO_PRIX, PRO_STOCK, PRO_FOURNISSEUR_ID) VALUES ('Libellé', 200, 5, 1)
			PreparedStatement monStatementInsert = this.connexionSql.prepareStatement("INSERT INTO produit "
					+ "(PRO_LIBELLE, PRO_PRIX, PRO_STOCK, PRO_FOURNISSEUR_ID) VALUES (?, ?, ?, ?)");
			
			//REMPLIR LES ? (Paramètres indexés)
			monStatementInsert.setString(1, entity.getLibelle());
			monStatementInsert.setBigDecimal(2, entity.getPrix());
			monStatementInsert.setInt(3, entity.getStock());
			monStatementInsert.setInt(4, entity.getFournisseur().getId());
			
			monStatementInsert.execute();
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		finally {
			this.closeConection();
		}
		
		return entity;
		
	}

	@Override
	public Produit save(Produit entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(int id) {
		
		try {
			//CONNEXION AU SERVEUR
			this.openConnection();
			
			//REQUETE DE DELETE
			//DELETE FROM produit where PRO_ID=id;
			PreparedStatement monStatementInsert = this.connexionSql.prepareStatement("DELETE FROM produit WHERE PRO_ID=?");
			
			//REMPLIR LES ? (Paramètres indexés)
			monStatementInsert.setInt(1, id);
			
			monStatementInsert.execute();
			return true;
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
		
		finally {
			this.closeConection();
		}
	}
	
	
	
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