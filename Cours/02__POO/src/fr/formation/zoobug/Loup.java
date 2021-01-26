package fr.formation.zoobug;

public class Loup extends Canide {
	@Override
	public void manger() {
		this.devorer();
		super.manger();
	}
	
	public void devorer() {
		System.out.println("Le loup dévore ...");
	}
}