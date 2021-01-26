package fr.formation;

import java.util.ArrayList;

import fr.formation.jeu.Carte;

public class BugApplication3 {
	public static void main(String[] args) {
		ArrayList<Carte> cartes = new ArrayList<Carte>();
		
		//CREATION DES 32 CARTES
		for (int i = 1; i < 33; i++) {
			Carte maCarte = new Carte("Carte " + i);
			
//			maCarte.setNom("Carte " + i);
			cartes.add(maCarte);
		}
		
		
		//PARCOURS & AFFICHAGE DU NOM
		for (Carte c : cartes) {
			System.out.println(c.getNom());
		}
	}
}