package fr.formation.zoo;

public class Chien extends Canide {
	@Override
	public void manger() {
		System.out.println("Le chien mange ...");
	}

	@Override
	public String getType() {
		return "Chien";
	}
}