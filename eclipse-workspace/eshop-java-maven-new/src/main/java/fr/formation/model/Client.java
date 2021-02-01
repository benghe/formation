package fr.formation.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("C")
public class Client extends Personne {
	
	@Column(name="PER_PASSWORD", length = 300)
	private String password;
	
	@Column(name="PER_DATE_NAISSANCE")
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

	public PersonneType getType() {
		return PersonneType.CLIENT;
	}
	
	public Client() { }
	
	public Client(String nom, String prenom) {
		super(nom, prenom);
	}
}