package fr.formation.zoo;

public class Loup extends Canide {
	@Override
	public void manger() {
		this.devorer();
	}
	
	public void devorer() {
		System.out.println("Le loup dévore ...");
	}

	@Override
	public String getType() {
		return "Loup";
	}
}