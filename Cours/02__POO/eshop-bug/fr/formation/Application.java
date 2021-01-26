package fr.formation;

import java.util.ArrayList;
import java.util.List;

import com.sun.security.ntlm.Client;

import fr.formation.model.Fournisseur;
import fr.formation.model.Produit;

public class Application {
	public static void main(String[] args) {
		//CLIENT
		fr.formation.model.Client client = new Client("NOM", "Prénom");
		
		//FOURNISSEUR
		Fournisseur fournisseur = new Fournisseur();
		fournisseur.setNom("AMAZON");
		
		//PRODUITS
		List<Produit> produits = new ArrayList<>();
		
		//PRODUIT 1
		Produit p1 = new Produit();
		p1.setLibelle("Parachute de France");
		p1.setPrix(7000.50);
		produits.add(p1);

		//PRODUIT 2
		Produit p1 = new Produit();
		p1.setLibelle("Combinaison Summer");
		p1.setPrix(500);
		produits.add(p1);
		

		System.out.println("-- Affichage des informations --");

		System.out.println("*** CLIENT ***");
		System.out.println(client.getNom() + " " + client.getPrenom());
		
		System.out.println("*** FOURNISSEUR ***");
		System.out.println(fournisseur.getNom());
		
		
		for (int i = 0; i < 3; i++) {
			System.out.println(produits.get(i).getNom() + " - " + produits.get(i).getPrix() + " euros.");
		}
	}
}