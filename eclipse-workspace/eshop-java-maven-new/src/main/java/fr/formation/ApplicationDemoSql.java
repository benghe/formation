package fr.formation;

import java.math.BigDecimal;
import java.util.List;

import fr.formation.dao.IProduitDao;
import fr.formation.dao.sql.ProduitDaoSql;
import fr.formation.model.Fournisseur;
import fr.formation.model.Produit;

public class ApplicationDemoSql {
	public static void main(String[] args) {
		IProduitDao daoProduit = new ProduitDaoSql();
		
		Produit monProduit = new Produit();
		Fournisseur monFournisseur = new Fournisseur();
		
		monFournisseur.setId(1);
		
		monProduit.setLibelle("NEW PRODUIT PRODUIT");
		monProduit.setPrix(new BigDecimal(600));
		monProduit.setStock(4);
		monProduit.setFournisseur(monFournisseur);
		
		daoProduit.add(monProduit);
		
		
		
//		daoProduit.deleteById(7);
		
		List<Produit> produits = daoProduit.findAll();
		
		for (Produit produit : produits) {
			System.out.println(produit);
		}
	}
}