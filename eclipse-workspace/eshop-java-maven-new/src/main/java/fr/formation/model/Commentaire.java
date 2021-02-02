package fr.formation.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "commentaire")
public class Commentaire {

	@Id // OBLIGATOIRE UNE FOIS ET UNE SEULE DANS UNE CLASSE ENTITY
	@GeneratedValue(strategy = GenerationType.IDENTITY) // STRATEGIE D'AUTO-INCREMENT SUR CET ID
	@Column(name = "COM_ID") // OPTIONNEL SI LE NOM DU CHAMP = LE NOM DE L'ATTRIBUT
	private int id;

	@Column(name = "COM_TEXTE", nullable = false, columnDefinition = "TEXT")
	@Lob // Pas obligatoire, mais pour préciser à hibernate que c'est un grand texte
	private String texte;

	@Column(name = "COM_ANONYMOUS", nullable = false)
	private boolean anonymous;

	@Column(name = "COM_DATE", nullable = false)
	private LocalDateTime date;

	//@ManyToOne
	//@JoinColumn(name = "COM_CLIENT_ID", nullable = false)
	@Transient
	private Client client;

	//@ManyToOne
	//@JoinColumn(name = "COM_COMMANDE_ID", nullable = false)
	@Transient
	private Commande commande;

	@ManyToOne
	@JoinColumn(name = "COM_PRODUIT_ID", nullable = false)
	private Produit produit;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public boolean isAnonymous() {
		return anonymous;
	}

	public void setAnonymous(boolean anonymous) {
		this.anonymous = anonymous;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}
}