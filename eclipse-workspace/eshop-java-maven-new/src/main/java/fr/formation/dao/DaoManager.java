package fr.formation.dao;

import fr.formation.dao.jpa.CategorieDaoJpa;
import fr.formation.dao.jpa.FournisseurDaoJpa;
import fr.formation.dao.jpa.ProduitDaoJpa;

public class DaoManager {
	private static IProduitDao daoProduit;
	private static IFournisseurDao daoFournisseurDao;
	private static ICategorieDao daoCategorie;
	
	public static IProduitDao getProduitDao() {
		if (daoProduit == null) {
			daoProduit = new ProduitDaoJpa();
		}
		
		return daoProduit;
	}
	
	public static IFournisseurDao getFournisseurDao() {
		if (daoFournisseurDao == null) {
			daoFournisseurDao = new FournisseurDaoJpa();
		}
		
		return daoFournisseurDao;
	}
	
	public static ICategorieDao getCategorieDao() {
		if (daoCategorie == null) {
			daoCategorie = new CategorieDaoJpa();
		}
		
		return daoCategorie;
	}
}