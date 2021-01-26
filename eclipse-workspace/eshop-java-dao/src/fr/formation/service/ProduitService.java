package fr.formation.service;

import java.math.BigDecimal;

import fr.formation.exception.LibelleVideException;
import fr.formation.exception.PrixNegatifException;
import fr.formation.model.Produit;

public class ProduitService {
	public boolean ajouterProduitSansException(Produit produit) {
		if (produit.getLibelle().equals("")) {
			return false;
		}
		
		System.out.println("Sauvegarde en cours ...");
		return true;
	}
	
	public void ajouterProduit(Produit produit) {
//		"" -> String
//		new String("");
		
		//si (adresse mémoire de libelle produit == adresse mémoire de "") alors ...
//		if (produit.getLibelle() == "") {
		
		//Première règle : libellé pas vide
		if (produit.getLibelle().equals("")) {
			//ERREUR
			throw new LibelleVideException();
		}
		
		//Deuxième règle : prix > 0
		if (produit.getPrix().compareTo(new BigDecimal(1)) == -1) {
			throw new PrixNegatifException();
		}
		
		System.out.println("Sauvegarde en cours ...");
	}
	
	public void ajouterProduit(String libelle, double prix) {
		//Première règle : libellé pas vide
		if (libelle.equals("")) {
			//ERREUR
			throw new LibelleVideException();
		}
		
		//Deuxième règle : prix > 0
		if (prix < 1) {
			throw new PrixNegatifException();
		}
		
		Produit produit = new Produit();
		produit.setLibelle(libelle);
		produit.setPrix(new BigDecimal(prix));
		
		System.out.println("Sauvegarde en cours ...");
	}
}