package fr.formation.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity //Obigatoire
@Table(name="categorie") //Pas obligatoire
public class Categorie {
	
	@Id //OBLIGATOIRE UNE FOIS ET UNE SEULE DANS UNE CLASSE ENTITY
	@GeneratedValue(strategy = GenerationType.IDENTITY) //STRATEGIE D'AUTO-INCREMENT SUR CET ID
	@Column(name="CAT_ID") // OPTIONNEL SI LE NOM DU CHAMP = LE NOM DE L'ATTRIBUT
	private int id;
	
	@Column(name="CAT_LIBELLE", length = 50, nullable=false)
	private String libelle;
	
	@ManyToOne //Relation maitresse
	@JoinColumn(name="CAT_PARENT_ID")
	private Categorie parent;
	
	@OneToMany(mappedBy ="parent" ) //relation esclave (mappé sur le nom de l'attribut de la relation inverse qui est ici "parent")
	private List<Categorie> enfants;
	
	
	@ManyToMany(mappedBy="categories")
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