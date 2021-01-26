package fr.formation.zoo;

public class Chat extends Felide {
	public Chat() {
		super();
		System.out.println("CREATION D'UN CHAT");
	}

	@Override
	public String getType() {
		return "Chat";
	}
}