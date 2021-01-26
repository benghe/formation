package fr.formation.jeu;


//public -> rend l'élément public (accessible à tous)
//private -> rend l'élément privé (indisponible pour tous - sauf la classe)
//protected -> rend l'élément public (pour les classes enfants) + rend l'élément privé pour tous les autres
//package -> rend l'élément public pour les classes du même package, privé pour les autres

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