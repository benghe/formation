package fr.formation.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="commande")
public class Commande {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CMD_ID")
	private int id;
	
	@Column(name = "CMD_DATE", nullable=false)
	private LocalDateTime date;
	
	@ManyToOne
	@JoinColumn(name="CMD_CLIENT_ID", nullable=false)
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="CMD_PAIEMENT_ID", nullable=false)
	private Paiement paiement;
	
	@Column(name = "CMD_PAIEMENT_AUTORISE", nullable=false)
	private boolean paiementAutorise;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Paiement getPaiement() {
		return paiement;
	}

	public void setPaiement(Paiement paiement) {
		this.paiement = paiement;
	}

	public boolean isPaiementAutorise() {
		return paiementAutorise;
	}

	public void setPaiementAutorise(boolean paiementAutorise) {
		this.paiementAutorise = paiementAutorise;
	}
}