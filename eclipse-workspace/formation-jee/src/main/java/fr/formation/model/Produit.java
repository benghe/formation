package fr.formation.model;

public class Produit {

	private String nom;
	private Fournisseur fournisseur;

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	


	/**
	 * @param nom
	 * @param fournisseur
	 */
	public Produit(String nom, Fournisseur fournisseur) {
		super();
		this.nom = nom;
		this.fournisseur = fournisseur;
	}

	@Override
	public String toString() {
		return "Produit [nom=" + nom + ", fournisseur=" + fournisseur + "]";
	}
	
	
}
