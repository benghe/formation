package fr.formation.zoobug;

public class Mammifere extends Animal {
	private int couleur;
	
	public int getCouleur() {
		return couleur;
	}

	public void setCouleur(int couleur) {
		this.couleur = couleur;
	}

	public void courir() {
		System.out.println("Le mammifère court ...");
	}
}