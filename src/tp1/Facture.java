package tp1;

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
		DecimalFormat formatter = new DecimalFormat("#0.00");

		System.out.println("Factures");

		for (int i = 0; i < client.size(); i++) {

			System.out.println(client.get(i).getNom() + " " + formatter.format(getPrix(getListeCommande(client.get(i).getNom()))) + "$");

		}
	}

	public double getPrix(ArrayList<Commande> commandeTrouve) {
		double prix = 0;

		for (int i = 0; i < commandeTrouve.size(); i++) {
			boolean trouve = false;
			
			for (int j2 = 0; j2 < plats.size(); j2++) {
				if (commandeTrouve.get(i).getRepas().equalsIgnoreCase(plats.get(j2).getNom())) {
					prix += plats.get(j2).getPrix() * commandeTrouve.get(i).getQuantite();
					trouve = true;
				}
			}
			
			if (!trouve) {
				System.out.println("Il n'existe pas de plat nommé: " + commandeTrouve.get(i).getRepas());
			}
		}

		return prix;
	}

	public ArrayList<Commande> getListeCommande(String nomClient) {
		ArrayList<Commande> commandeTrouve = new ArrayList<Commande>();

		for (int j = 0; j < commande.size(); j++) {
			if (nomClient.equalsIgnoreCase(commande.get(j).getNom())) {
				commandeTrouve.add(commande.get(j));
			}
		}

		return commandeTrouve;
	}

}
