package fr.formation;

import fr.formation.jeu.Carte;

public class ApplicationTransmissionDemo {
	public static void main(String[] args) {
		//Transmission = transfert d'une varible vers un paramètre de méthode
		//Valeur = lecture de la valeur, puis transfert
		//Référence = transfert directement
		
		
		//Transmission par valeur concerne : les types primitifs
		//Transmission par référence concerne : les instances de classe / les objets
		
		int a = 5;
		demoValeur(a);
		System.out.println(a);
		
		Carte c = new Carte();
		c.setNom("MA CARTE");
		demoReference(c);
		System.out.println(c.getNom());
		
		Carte c2 = new Carte();
		c2.setNom("MA CARTE");
		
		Carte c3 = demoReference2(c2);
		System.out.println(c2.getNom());
		System.out.println(c3.getNom());
	}
	
	public static void demoValeur(int a) {
		a = 6;
		System.out.println(a);
	}
	
	public static void demoReference(Carte c) {
		c.setNom("MA CARTE 2");
		System.out.println(c.getNom());
	}
	
	public static Carte demoReference2(Carte c) {
		c = new Carte();
		c.setNom("MA CARTE 3");
		System.out.println(c.getNom());
		
		return c;
	}
}