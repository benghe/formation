package fr.formation.science;

public class Maths {
	public int addition(int a, int b) {
		return a + b;
	}
	
	public int soustraction(int a, int b) {
		return a - b;
	}
	
	public int puissance(int a, int b) {
		int resultat = 1;
		
		if (b < 0) {
			return 0;
		}
		
		if (b == 0) {
			return 1;
		}
		
		for (int i = 0; i < b; i++) {
			resultat *= a;
		}
		
		return resultat;
	}
}