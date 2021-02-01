package fr.formation.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("F")
public class Fournisseur extends Personne {
	
	@Column(name="PER_SIRET",length = 14)
	private String siret;
	
	@OneToMany(mappedBy = "fournisseur") //(car s'appelle "fournisseur" dans produit)
	private List<Produit> produits;

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