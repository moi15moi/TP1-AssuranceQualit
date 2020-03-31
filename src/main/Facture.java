package main;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Facture {

	private ArrayList<Client> client = new ArrayList<Client>();
	private ArrayList<Plats> plats = new ArrayList<Plats>();
	private ArrayList<Commande> commande = new ArrayList<Commande>();

	public Facture(ArrayList<String> fichier) {
		try {

			int client = fichier.indexOf("Clients :");
			int plat = fichier.indexOf("Plats :");
			int commande = fichier.indexOf("Commandes :");
			int fin = fichier.indexOf("Fin");

			for (int i = client + 1; i < plat; i++) {
				Client cliTemp = new Client(fichier.get(i));
				this.client.add(cliTemp);
			}

			for (int i = plat + 1; i < commande; i++) {
				String[] ligneFichier = fichier.get(i).split(" ");

				if (ligneFichier.length == 2) {
					Plats platTemp = new Plats(ligneFichier[0], ligneFichier[1]);

					this.plats.add(platTemp);
				} else {
					System.out.println("Le fichier ne respecte pas le format demandé ! (ligne: " + (i + 1) + ")");
				}
			}

			for (int i = commande + 1; i < fin; i++) {

				String[] ligneFichier = fichier.get(i).split(" ");

				if (ligneFichier.length == 3) {
					Commande comTemp = new Commande(ligneFichier[0], ligneFichier[1], ligneFichier[2]);

					this.commande.add(comTemp);
				} else {
					System.out.println("Le fichier ne respecte pas le format demandé ! (ligne: " + (i + 1) + ")");
				}
			}

		} catch (Exception e) {
			System.out.println("Le fichier ne respecte pas le format demandé !");
		}

	}

	public void afficherFacture() {
		double prixFactureClient;
		DecimalFormat formatter = new DecimalFormat("#0.00");
		
		System.out.println("Factures :\n");

		for (int i = 0; i < client.size(); i++) {

			if ((prixFactureClient = calculerPrixTotalCommande(getCommandeSelonClient(client.get(i)))) != 0) {

				System.out.println(client.get(i).getNom() + " " + formatter.format(prixFactureClient) + "$");
			}
		}

		for (int i = 0; i < commande.size(); i++) {

			boolean trouver = false;

			for (int j = 0; j < client.size(); j++) {

				if (commande.get(i).getNomClient().equalsIgnoreCase(client.get(j).getNom())) {
					trouver = true;
				}
			}
			if (!trouver) {
				System.out.println("Erreur, le client " + commande.get(i).getNomClient() + " n'existent pas.");
			}

		}
	}

	public ArrayList<Commande> getCommandeSelonClient(Client pClient) {
		ArrayList<Commande> commandeClient = new ArrayList<Commande>();
		
		for (int i = 0; i < commande.size(); i++) {

			if (pClient.getNom().equalsIgnoreCase(commande.get(i).getNomClient())) {
				commandeClient.add(commande.get(i));
			}
		}

		return commandeClient;
	}

	public double calculerPrixTotalCommande(ArrayList<Commande> commandeSelonXClient) {
		double prix = 0;

		for (int i = 0; i < commandeSelonXClient.size(); i++) {
			boolean trouve = false;

			for (int j2 = 0; j2 < plats.size(); j2++) {

				if (commandeSelonXClient.get(i).getRepas().equalsIgnoreCase(plats.get(j2).getNom())) {

					prix += plats.get(j2).getPrix() * commandeSelonXClient.get(i).getQuantite();
					trouve = true;
				}
			}

			if (!trouve) {
				System.out.println("Il n'existe pas de plat nommé: " + commandeSelonXClient.get(i).getRepas());
			}
		}

		return prix;
	}

}
