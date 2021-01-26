package fr.formation;

import java.util.ArrayList;

import fr.formation.jeu.Carte;

public class BugApplication2 {
	public static void main(String[] args) {
		ArrayList<Carte> cartes = new ArrayList<Carte>();
		
		//CREATION DES 32 CARTES
		for (int i = 0; i < 32; i++) {
			Carte maCarte = new Carte();
			
			maCarte.setNom("Carte " + (i + 1));
			cartes.add(maCarte);
		}
		
		
		//PARCOURS & AFFICHAGE DU NOM
		for (int i = 0; i < cartes.size(); i++) {
			Carte c = cartes.get(i);
			
			System.out.println(c.getNom());
		}
	}
}