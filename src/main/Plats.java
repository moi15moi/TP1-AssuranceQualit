package main;

public class Plats {

	private String nom;
	private double prix;

	public Plats(String nom, String prix) {
		this.nom = nom;
		this.prix = Double.parseDouble(prix);
	}

	public String getNom() {
		return this.nom;
	}

	public double getPrix() {
		return this.prix;
	}
}
