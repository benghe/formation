package fr.formation.model;

import java.time.LocalDate;

public class Client extends Personne {
	private String password;
	private LocalDate dateNaissance;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public int getType() {
		return 0;
	}
	
	public Client() { }
	
	public Client(String nom, String prenom) {
		super(nom, prenom);
	}
}