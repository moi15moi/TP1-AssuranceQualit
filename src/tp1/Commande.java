package tp1;

public class Commande {

	private String nom, repas;
	int quantite;

	public Commande(String nom, String repas, String quantite) {
		this.nom = nom;
		this.repas = repas;

		try {
			this.quantite = Integer.parseInt(quantite);
		} catch (Exception e) {
			System.out.println("Erreur lors de la lecture de la quantité d'une commande.\n");
		}
	}

	public String getNom() {
		return this.nom;
	}

	public String getRepas() {
		return this.repas;
	}

	public int getQuantite() {
		return quantite;
	}
}
