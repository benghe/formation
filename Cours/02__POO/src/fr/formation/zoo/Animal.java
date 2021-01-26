package fr.formation.zoo;

public abstract class Animal {
	private int age;
	private int taille;
	private String nom;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Animal() {
		this("avec un nom");
		System.out.println("CREATION D'UN ANIMAL");
	}
	
	public Animal(String nom) {
//		this();
		this.nom = nom;
		System.out.println("CREATION D'UN ANIMAL " + nom);
	}

	public abstract void manger();
	
	public void dormir() {
		System.out.println("L'animal dort ...");
	}
	
	public void dormir(Animal animal) {
		this.dormir();
//		System.out.println("L'animal dort ...");
		System.out.println("... avec un animal ...");
	}
	
	public void hello() {
		System.out.println("Je suis du type ... " + this.getClass().getSimpleName());
	}
	
	public abstract String getType();
}