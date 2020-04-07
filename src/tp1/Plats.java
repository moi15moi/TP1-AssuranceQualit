package tp1;

public class Plats {

	private String nomPlats;
	private double prix;

	public Plats(String nomPlats, double prix) {
		this.nomPlats = nomPlats;
		this.prix = prix;
	}

	public String getNomPlats() {
		return this.nomPlats;
	}

	public double getPrix() {
		return this.prix;
	}
}
