package fr.formation;

import fr.formation.exception.ErreurSaisieException;

public class ApplicationExceptionOblige {
	public static void main(String[] args) {
		demoExceptionNonObligatoire();
		
		try {
			demoExceptionObligatoire();
			System.out.println("Tout s'est bien déroulé ...");
		}
		
		catch (Exception e) {
			System.out.println("OUPS");
		}
		
		System.out.println("FIN ?");
	}
	
	static void demoExceptionObligatoire() throws Exception {
		System.out.println("Demo exception obligatoire");
//		Exception monException = new Exception();
		
//		if (heure == midi) {
//		throw monException;
		throw new Exception();
//		}
	}
	
	static void demoExceptionNonObligatoire() {
		System.out.println("Demo exception non obligatoire");
//		RuntimeException monException = new RuntimeException();
		
//		if (heure == midi) {
//		throw monException;
		throw new RuntimeException();
//		}
	}
	
	static void demoErreurSaisieException() {
		System.out.println("Demo erreur saisie exception");
		throw new ErreurSaisieException();
	}
}