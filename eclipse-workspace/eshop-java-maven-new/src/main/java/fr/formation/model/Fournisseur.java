package fr.formation.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("F")
public class Fournisseur extends Personne {
	
	@Column(name="PER_SIRET",length = 14)
	private String siret;

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public PersonneType getType() {
		return PersonneType.FOURNISSEUR;
	}
	
	
	public Fournisseur() {}
	
	
	public Fournisseur(String nom) {
		this.nom=nom;
	}
	
}