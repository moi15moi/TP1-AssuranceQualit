package main;

public class Client {

	private String nom;

	public Client(String nom) {
		setNom(nom);
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
