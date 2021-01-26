package fr.formation;

import java.math.BigDecimal;
import java.util.Scanner;

import fr.formation.exception.LibelleVideException;
import fr.formation.exception.PrixNegatifException;
import fr.formation.model.Produit;
import fr.formation.service.ProduitService;

public class ApplicationProduit {
	public static void main(String[] args) {
		//Demander à l'utilisateur les infos libelle + prix
		Scanner sc = new Scanner(System.in);
		Produit monProduit = new Produit();
		String libelle = "";
		double prix = 0;
		
		System.out.println("Saisir un libellé :");
//		monProduit.setLibelle(sc.nextLine());
		libelle = sc.nextLine();
		
		System.out.println("Saisir un prix :");
		prix = sc.nextDouble();
		
		monProduit.setLibelle(libelle);
		monProduit.setPrix(new BigDecimal(prix));
		
		//Faire appel à ProduitService pour ajouter un produit
		ProduitService srvProduit = new ProduitService();
		
		try {
			srvProduit.ajouterProduit(monProduit);
			System.out.println("Sauvegarde OK !!");
		}
		
		catch (LibelleVideException lve) {
			System.out.println("Oups, le libellé doit être saisi !");
		}
		
		catch (PrixNegatifException pne) {
			System.out.println("Oups, le prix doit être supérieur à 0 !");
		}
		
//		boolean marche = srvProduit.ajouterProduitSansException(null);
//		
//		if (marche == false) {
//			System.out.println("Une erreur : soit le libellé, soit le prix");
//		}
//		
//		else {
//			
//		}
	}
}