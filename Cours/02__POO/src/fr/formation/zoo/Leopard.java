package fr.formation.zoo;

public class Leopard extends Felide {
	public void manger() {
		System.out.println("Le l�opard mange ...");
	}

	public void dormir() {
		System.out.println("Le l�opard dort ...");
	}

	public void courir() {
		System.out.println("Le l�opard court ...");
	}

	@Override
	public String getType() {
		return "L�opard";
	}
}