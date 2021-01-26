package fr.formation.jeu;


//public -> rend l'�l�ment public (accessible � tous)
//private -> rend l'�l�ment priv� (indisponible pour tous - sauf la classe)
//protected -> rend l'�l�ment public (pour les classes enfants) + rend l'�l�ment priv� pour tous les autres
//package -> rend l'�l�ment public pour les classes du m�me package, priv� pour les autres

public class Carte /* extends Object */ {
	//Nom
	private String nom;
	
	//Valeur
	private int valeur;
	
	//Couleur
	private int couleur;
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void setCouleur(int couleur) {
		if (couleur >= 0 && couleur <= 3) {
			this.couleur = couleur;
		}
	}
	
	//CONSTRUCTEUR
	public Carte() {
	}
	
	public Carte(String nom) {
		this.nom = nom;
		System.out.println("CREATION DE LA CARTE " + nom);
	}
}