package tp1;

public class Commande {

	private String nomClient, nomRepas;
	private int quantite;

	public Commande(String nomClient, String nomRepas, int quantite) {

		this.quantite = quantite;
		this.nomClient = nomClient;
		this.nomRepas = nomRepas;

	}

	public String getNomClient() {
		return this.nomClient;
	}

	public String getNomRepas() {
		return this.nomRepas;
	}

	public int getQuantite() {
		return quantite;
	}
}
