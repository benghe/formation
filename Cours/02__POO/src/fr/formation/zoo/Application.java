package fr.formation.zoo;

import java.util.ArrayList;

public class Application {
	public static void main(String[] args) {
		Animal albert = new Chat();
		Leopard bernard = new Leopard();
		Chien clovis = new Chien();
		Loup david = new Loup();
		
		ArrayList<Animal> animaux = new ArrayList<Animal>();

		animaux.add(albert);
		animaux.add(bernard);
		animaux.add(clovis);
		animaux.add(david);
		
		for (Animal animal : animaux) {
//			animal.manger();
			animal.hello();
			
			if (animal.getType().equals("Chat")) {
				System.out.println("C'EST UN CHAT !!!!!!!!!");
			}
		}
		
		

		
//		ArrayList<Object> animaux = new ArrayList<Object>();
//
//		animaux.add(albert);
//		animaux.add(bernard);
//		animaux.add("test");
//		
//		for (Object animal : animaux) {
//			//CAST
////			((Type)variable).method();
////			((Animal)animal).dormir();
//			
//			Animal a = (Animal)animal;
//			
//			a.dormir();
////			animal.dormir();
//		}
		
		//polymorphisme (override)
//		albert.dormir();
//		bernard.dormir();
	}
}