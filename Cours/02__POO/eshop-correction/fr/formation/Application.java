package fr.formation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import fr.formation.model.Client;
import fr.formation.model.Fournisseur;
import fr.formation.model.Produit;

public class Application {
	public static void main(String[] args) {
		//CLIENT
		Client client = new Client("NOM", "Prénom");
		
		//FOURNISSEUR
		Fournisseur fournisseur = new Fournisseur();
		fournisseur.setNom("AMAZON");
		
		//PRODUITS
		List<Produit> produits = new ArrayList<>();
		
		//PRODUIT 1
		Produit p1 = new Produit();
		p1.setLibelle("Parachute de France");
		p1.setPrix(new BigDecimal(7000.50));
		produits.add(p1);

		//PRODUIT 2
		Produit p2 = new Produit();
		p2.setLibelle("Combinaison Summer");
		p2.setPrix(new BigDecimal(500));
		produits.add(p2);
		

		System.out.println("-- Affichage des informations --");

		System.out.println("*** CLIENT ***");
		System.out.println(client.getNom() + " " + client.getPrenom());
		
		System.out.println("*** FOURNISSEUR ***");
		System.out.println(fournisseur.getNom());
		
		
		for (int i = 0; i < produits.size(); i++) {
			System.out.println(produits.get(i).getLibelle() + " - " + produits.get(i).getPrix() + " euros.");
		}
	}
}