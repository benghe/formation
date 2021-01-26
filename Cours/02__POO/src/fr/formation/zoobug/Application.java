package fr.formation.zoobug;

import java.util.ArrayList;

public class Application {
	public static void main(String[] args) {
		Chat albert = new Chat();
		Animal bernard = new Leopard();
		Chien clovis = new Chien();
		Loup david = new Loup();
		
		ArrayList<Animal> animaux = new ArrayList<Animal>();

		animaux.add(albert);
		animaux.add(bernard);
		animaux.add(clovis);
		animaux.add(david);
		
		for (Animal animal : animaux) {
			animal.manger();
		}
	}
}