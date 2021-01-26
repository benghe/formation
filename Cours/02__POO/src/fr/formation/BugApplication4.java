package fr.formation;

import java.util.ArrayList;

import fr.formation.jeu.Carte;

public class BugApplication4 {
	public static void main(String[] args) {
		ArrayList<Carte> cartes = new ArrayList<Carte>();
		
		//CREATION DES 32 CARTES
		Carte maCarte = new Carte();
		
		for (int i = 0; i < 32; i++) {
			maCarte.setNom("Carte " + (i + 1));
		}
		
		
		//PARCOURS & AFFICHAGE DU NOM
		for (int i = 0; i < 10; i++) {
			System.out.println(cartes.get(i).getNom());
		}
	}
}