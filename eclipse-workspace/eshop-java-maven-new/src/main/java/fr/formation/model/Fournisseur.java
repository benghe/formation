package fr.formation.model;

public class Fournisseur extends Personne {
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