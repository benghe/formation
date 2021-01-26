package fr.formation.model;

import java.math.BigDecimal;
import java.util.List;

public class Produit {
	private int id;
	private String libelle;
	private BigDecimal prix;
	private int stock;
	private String photo;
	private Fournisseur fournisseur;
	private List<Categorie> categories;

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

	public BigDecimal getPrix() {
		return prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public List<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}
	
	public Produit() { }
	
	public Produit(String libelle, double prix) {
		this.libelle = libelle;
		this.prix = new BigDecimal(prix);
	}
	
	public Produit(String libelle, BigDecimal prix) {
		this.libelle = libelle;
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", libelle=" + libelle + ", prix=" + prix + ", stock=" + stock + ", photo=" + photo
				+ ", fournisseur=" + fournisseur + ", categories=" + categories + "]";
	}
}