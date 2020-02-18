package tp1;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Facture {

	private ArrayList<Client> client;
	private ArrayList<Plats> plats;
	private ArrayList<Commande> commande;

	public Facture(ArrayList<Client> client, ArrayList<Plats> plats, ArrayList<Commande> commande) {
		this.client = client;
		this.plats = plats;
		this.commande = commande;
	}

	public void afficherFacture() {
		DecimalFormat formatter = new DecimalFormat("#0.00");

		System.out.println("Factures");
		

		for (int i = 0; i < client.size(); i++) {
			
			double prix = 0;

			prix = getPrix(getListeCommande(client.get(i).getNom()));

			System.out.println(client.get(i).getNom() + " " + formatter.format(prix) + "$");

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
