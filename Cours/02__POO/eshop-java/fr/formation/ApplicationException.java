package fr.formation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import fr.formation.exception.InputTropPetitException;

public class ApplicationException {
	public static void main(String[] args) {
		System.out.println("Saisir votre age :");
		
		Scanner sc = new Scanner(System.in);
		boolean saisie = false;
		
//		while (saisie == false) {
//		while (saisie != true) {
		while (!saisie) {
			try {
				int a = sc.nextInt();
				
				if (a < 10) {
					throw new InputTropPetitException();
				}
				
				saisie = true;
				System.out.println("Votre saisie est : " + a);
			}

			catch (InputMismatchException ime) {
//			catch (Exception e) {
				sc.next();
				System.out.println("Attention, vous devez saisir un chiffre, resaisir un age :");
			}

			catch (InputTropPetitException itpe) {
				System.out.println("Vous devez saisir un chiffre supérieur à 10, resaisir un age :");
			}

			catch (Exception e) {
				System.out.println("Une erreur inconnue est survenue ...");
			}
		}
		
		System.out.println("FIN !!");
	}
	
	static int getEntier() {
		Scanner sc = new Scanner(System.in);
		
		try {
			return sc.nextInt();
		}
		
		catch (Exception e) {
			return 0;
		}
		
		finally {
			//Ca s'exécute dans tous les cas, juste avant un "return" (si on a return)
			sc.close();
		}
	}
	
	static int getEntierAlternatif() {
		//Cette syntaxe va "créer implicitement" un finally avec sc.close()
		try (Scanner sc = new Scanner(System.in)) {
			return sc.nextInt();
		}
		
		catch (Exception e) {
			return 0;
		}
	}
}