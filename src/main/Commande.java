package main;

public class Commande {

	private String nomClient, repas;
	int quantite;

	public Commande(String nomClient, String repas, String quantite) {
		this.nomClient = nomClient;
		this.repas = repas;

		try {
			this.quantite = Integer.parseInt(quantite);
		} catch (Exception e) {
			System.out.println("Erreur lors de la lecture de la quantit� d'une commande.\n");
		}
	}

	public String getNomClient() {
		return this.nomClient;
	}

	public String getRepas() {
		return this.repas;
	}

	public int getQuantite() {
		return quantite;
	}
}
