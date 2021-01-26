package fr.formation.model;

import java.time.LocalDateTime;

public class Commande {
	private int id;
	private LocalDateTime date;
	private Client client;
	private Paiement paiement;
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