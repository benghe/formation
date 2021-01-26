package fr.formation.zoo;

public class Leopard extends Felide {
	public void manger() {
		System.out.println("Le léopard mange ...");
	}

	public void dormir() {
		System.out.println("Le léopard dort ...");
	}

	public void courir() {
		System.out.println("Le léopard court ...");
	}

	@Override
	public String getType() {
		return "Léopard";
	}
}