import java.lang.reflect.Array;
import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		int maPuissance = puissance(5, 2);

//		afficher(puissance(5, 2));
//		afficher("Le résultat = ");
//		afficher(maPuissance);
		
		//Création d'un tableau avec quelques valeurs
		//Ca ...
		int[] tab = new int[2];

		tab[0] = 30;
		tab[1] = 20;
		
		//OU ...
		
		int[] tab2 = new int[] { 30, 20 };
		
//		[0] [1]
//		|30|20|
		
		//Appeler somme()
		int maSomme = somme(tab2);
		
		//Afficher le résultat
		afficher(maSomme);
		
		// Afficher une phrase "saisir votre age"
//		afficher("Quel est votre age ?");
		
		// Récupérer la valeur saisie
//		int monAge = saisirEntier();
		
		// Afficher "votre age = " + la valeur
//		afficher("Votre age est : ");
//		afficher(monAge);
		
		
		//Additionner 3 entiers : 5, 6, entier saisi (autre sous-programme ... qui attend 3 entiers en paramètre)
		afficher("Saisir une valeur");
		int maValeur = saisirEntier();
//		int monAddition = additionner(1, 10, maValeur);
//		int[] mesValeurs = new int[3];
//
//		mesValeurs[0] = 1;
//		mesValeurs[1] = 10;
//		mesValeurs[2] = maValeur;
		
		int[] mesValeurs = new int[] { 1, 10, maValeur };
		int monResultat = somme(mesValeurs);
		
		//Afficher le résultat de l'addition de ces 3 entiers
		afficher("Le résultat de l'addition = ");
//		afficher(monAddition);
		afficher(monResultat);
	}
	
	static int additionner(int a, int b, int c) {
//		int resultat = a + b + c;
//		
//		return resultat;
		
		return a + b + c;
	}
	
	static int saisirEntier() {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		
		sc.close();
		return a;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	static int somme(int[] tab) {
		int tailleTableau = taille(tab);
		int resultat = 0;

		for (int i = 0; i < tailleTableau; i++) {
			resultat = resultat + tab[i];
			//resultat += tab[i];
		}

		return resultat;
	}

	static int taille(Object tab) {
		return Array.getLength(tab);
	}

	static void afficher(int a) {
		System.out.println(a);
	}

	static int puissance(int a, int b) {
		int resultat = 1;
		int i = 0;

		if (b == 0) {
			return 1;
		}

		while (i < b) {
			resultat = resultat * a;
			// i = i + 1;
			// i += 1;
			i++;
		}

		return resultat;
	}

	static void afficher(String texte) {
		System.out.println(texte);
	}
}