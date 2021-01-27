package fr.formation.model;

import java.util.List;

public class Categorie {
	private int id;
	private String libelle;
	private Categorie parent;
	private List<Categorie> enfants;
	private List<Produit> produits;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Categorie getParent() {
		return parent;
	}

	public void setParent(Categorie parent) {
		this.parent = parent;
	}

	public List<Categorie> getEnfants() {
		return enfants;
	}

	public void setEnfants(List<Categorie> enfants) {
		this.enfants = enfants;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	/**
	 * @param libelle
	 */
	public Categorie(String libelle) {
		this.libelle = libelle;
	}
	
	/**
	 * @param id
	 * @param libelle
	 */
	public Categorie(int id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}

	public Categorie() {
	
	}
	
}