package fr.formation;

import java.util.ArrayList;
import java.util.Collections;

import fr.formation.jeu.Carte;

public class Application {
	public static void main(String[] args) {
		ArrayList<Carte> cartes = new ArrayList<Carte>();
		
		//CREATION DES 32 CARTES
		for (int i = 0; i < 32; i++) {
			Carte maCarte = new Carte("Carte " + (i + 1));
			
			cartes.add(maCarte);
		}
		
		//AFFICHAGE ALEATOIRE ?
		Collections.shuffle(cartes);
		
		//PARCOURS & AFFICHAGE DU NOM
		for (int i = 0; i < cartes.size(); i++) {
			Carte c = cartes.get(i);
			
			System.out.println(c.getNom());
		}
		
		//Pour chaque Carte contenues dans cartes
		for (Carte c : cartes) {
			System.out.println(c.getNom());
		}
	}
}