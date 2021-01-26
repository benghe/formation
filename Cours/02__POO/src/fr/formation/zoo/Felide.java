package fr.formation.zoo;

public abstract class Felide extends Mammifere {
	private boolean tache;

	public boolean isTache() {
		return tache;
	}

	public void setTache(boolean tache) {
		this.tache = tache;
	}
	
	public void manger() {
		System.out.println("Le félidé mange ...");
	}
}