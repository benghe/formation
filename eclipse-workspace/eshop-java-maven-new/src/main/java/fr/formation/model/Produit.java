package fr.formation.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity //Obigatoire
@Table(name="produit") //Pas obligatoire
public class Produit {
	
	@Id //OBLIGATOIRE UNE FOIS ET UNE SEULE DANS UNE CLASSE ENTITY
	@GeneratedValue(strategy = GenerationType.IDENTITY) //STRATEGIE D'AUTO-INCREMENT SUR CET ID
	@Column(name="PRO_ID") // OPTIONNEL SI LE NOM DU CHAMP = LE NOM DE L'ATTRIBUT
	private int id;
	
	@Column(name="PRO_LIBELLE", length=50,nullable=false)
	private String libelle;
	
	@Column(name="PRO_PRIX", precision= 10 , scale =2,nullable=false)
	private BigDecimal prix;
	@Column(name="PRO_STOCK", nullable=false)
	private int stock;
	@Column(name="PRO_PHOTO", length=250)
	private String photo;
	@Column(name="PRO_NOTE", precision= 4 , scale =2,nullable=false)
	private BigDecimal note;
	

	@ManyToOne
	@JoinColumn(name ="PRO_FOURNISSEUR_ID")
	private Fournisseur fournisseur;
	
	@ManyToMany(mappedBy="produits")
//	@ManyToMany
//	@JoinTable(name="produit_categorie",
//			joinColumns=@JoinColumn(name="PRCA_PRODUIT_ID", referencedColumnName="PRO_ID"),
//			inverseJoinColumns=@JoinColumn(name="PRCA_CATEGORIE_ID", referencedColumnName="CAT_ID"))
	private List<Categorie> categories;
	
	@OneToMany(mappedBy="produit")
	private List<Commentaire> commentaires;
	

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

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
	
	
	public Produit(String libelle, double prix, int stock, Fournisseur fournisseur) {
		this.libelle = libelle;
		this.prix = new BigDecimal(prix);
		this.stock=stock;
		this.fournisseur=fournisseur;
	}
	
	public Produit(String libelle) {
		this.libelle = libelle;
		this.prix = new BigDecimal(0);
	}
	
	public Produit(String libelle, Fournisseur fournisseur) {
		this.libelle = libelle;
		this.prix = new BigDecimal(0);
		this.fournisseur=fournisseur;
	}
	
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
		return this.getLibelle() + ", " + this.getPrix() + " euros.";
	}
}