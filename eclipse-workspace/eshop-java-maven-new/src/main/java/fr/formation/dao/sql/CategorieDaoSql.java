package fr.formation.dao.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.formation.dao.ICategorieDao;
import fr.formation.model.Categorie;
import fr.formation.model.Produit;

public class CategorieDaoSql extends DaoSql implements ICategorieDao {

	@Override
	public List<Categorie> findAll() {
		List<Categorie> mesCategories = new ArrayList<>();

		try {
			this.openConnection();

			Statement monStatement = this.connexionSql.createStatement();
			ResultSet monResultat = monStatement.executeQuery("SELECT * FROM categorie");

			while (monResultat.next()) {
				Categorie maCategorie = new Categorie();

				maCategorie.setId(monResultat.getInt("CAT_ID"));
				maCategorie.setLibelle(monResultat.getString("CAT_LIBELLE"));
				// SET Parents?

				mesCategories.add(maCategorie);

			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		finally {
			this.closeConnection();
		}

		return mesCategories;
	}

	@Override
	public Categorie findById(int id) {

		Categorie maCategorie = new Categorie();

		try {
			this.openConnection();

			PreparedStatement monStatement = this.connexionSql
					.prepareStatement("SELECT * FROM categorie WHERE CAT_ID=?");

			// REMPLIR LES ? (Paramètre indexés)
			monStatement.setInt(1, id);

			ResultSet monResultat = monStatement.executeQuery();

			// Récupération du résultat

			monResultat.next();

			maCategorie.setId(monResultat.getInt("CAT_ID"));
			maCategorie.setLibelle(monResultat.getString("CAT_LIBELLE"));
			// SET Parents?

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		finally {
			this.closeConnection();
		}

		return maCategorie;
	}

	@Override
	public Categorie add(Categorie entity) {
		try {
			this.openConnection();

			// REQUETE D'INSERT
			// INSERT INTO produit (PRO_LIBELLE, PRO_PRIX, PRO_STOCK, PRO_FOURNISSEUR_ID)
			// VALUES ('Libellé', 200, 5, 1)
			PreparedStatement monStatementInsert = this.connexionSql
					.prepareStatement("INSERT INTO categorie (CAT_LIBELLE) VALUES (?)");

			// REMPLIR LES ? (Paramètres indexés)
			monStatementInsert.setString(1, entity.getLibelle());

			monStatementInsert.execute();
		}

		catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		finally {
			this.closeConnection();
		}

		return entity;
	}

	@Override
	public Categorie save(Categorie entity) {
		try {
			this.openConnection();
			PreparedStatement monStatementInsert = this.connexionSql
					.prepareStatement("UPDATE categorie SET CAT_LIBELLE=? WHERE CAT_ID=?");

			monStatementInsert.setString(1, entity.getLibelle());
			monStatementInsert.setInt(2, entity.getId());

			monStatementInsert.execute();

		}

		catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		finally {
			this.closeConnection();
		}

		return entity;
	}

	@Override
	public boolean deleteById(int id) {
		try {
			this.openConnection();

			// REQUETE DE DELETE
			// DELETE FROM produit WHERE PRO_ID = 1
			PreparedStatement monStatementInsert = this.connexionSql
					.prepareStatement("DELETE FROM categorie WHERE CAT_ID = ?");

			// REMPLIR LES ? (Paramètres indexés)
			monStatementInsert.setInt(1, id);

			monStatementInsert.execute();

			return true;
		}

		catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}

		finally {
			this.closeConnection();
		}
	}

}
