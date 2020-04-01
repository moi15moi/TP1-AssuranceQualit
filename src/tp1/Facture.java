package tp1;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Facture {

	private ArrayList<Client> client = new ArrayList<Client>();
	private ArrayList<Plats> plats = new ArrayList<Plats>();
	private ArrayList<Commande> commande = new ArrayList<Commande>();

	private String facture = "", erreurFacture = "";

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
					System.out.println("Le fichier ne respecte pas le format demand� ! (ligne: " + (i + 1) + ")");
				}
			}

			for (int i = commande + 1; i < fin; i++) {

				String[] ligneFichier = fichier.get(i).split(" ");

				if (ligneFichier.length == 3) {
					Commande comTemp = new Commande(ligneFichier[0], ligneFichier[1], ligneFichier[2]);

					this.commande.add(comTemp);
				} else {
					System.out.println("Le fichier ne respecte pas le format demand� ! (ligne: " + (i + 1) + ")");
				}
			}

		} catch (Exception e) {
			System.out.println("Le fichier ne respecte pas le format demand� !");
		}

	}

	/*
	 * Argument: Aucun.
	 * 
	 * Retour: Retourne les variables globales "facture" et "erreurFacture".
	 * 
	 * Description: Fait appele � la m�thode calculerFacture et retourne la facture.
	 */
	public String getFacture() {
		return facture + "\n" + erreurFacture;
	}

	/*
	 * Argument: Aucun.
	 * 
	 * Retour: Rien.
	 * 
	 * Description: Modifie les variables globales "facture" et "erreurFacture".
	 */
	public void calculerFacture() {
		double prixFactureClient;
		DecimalFormat formatter = new DecimalFormat("#0.00");
		
		facture = "";
        erreurFacture = "";

		facture += "Factures :\n";

		// Associe les commandes aux clients et v�rifie si le client dans la commande
		// existe
		for (int i = 0; i < commande.size(); i++) {

			boolean trouver = false;
			for (int j = 0; j < client.size() && !trouver; j++) {

				if (commande.get(i).getNomClient().equalsIgnoreCase(client.get(j).getNom())) {
					trouver = true;
					client.get(j).ajouterCommande(commande.get(i));
				}
			}

			if (!trouver) {
				erreurFacture += "Erreur, le client " + commande.get(i).getNomClient() + " n'existent pas.\n";
			}
		}

		// Calcule le prix total de la facture et v�rifie si le prix total est �gale � 0
		for (int i = 0; i < client.size(); i++) {

			if ((prixFactureClient = calculTaxes(calculerPrixBrutCommande(client.get(i)))) != 0) {

				facture += client.get(i).getNom() + " " + formatter.format(prixFactureClient) + "$\n";
			}
		}
	}

	/*
	 * Argument: Client.
	 * 
	 * Retour: Le prix brut.
	 * 
	 * Description: Le prix brut de toutes les commandes du Client.
	 */
	public double calculerPrixBrutCommande(Client pClient) {
		double prix = 0;
		ArrayList<Commande> listeCommande = pClient.getListeCommande();

		for (int i = 0; i < listeCommande.size(); i++) {
			boolean trouve = false;

			for (int j2 = 0; j2 < plats.size() && !trouve; j2++) {

				if (listeCommande.get(i).getRepas().equalsIgnoreCase(plats.get(j2).getNom())) {
					trouve = true;

					if (listeCommande.get(i).getQuantite() > 0) {
						prix += plats.get(j2).getPrix() * listeCommande.get(i).getQuantite();
					} else {
						erreurFacture += "Erreur, la commande " + i + " de " + listeCommande.get(i).getNomClient()
								+ " n'est pas valide, car la quanti� command�e est "
								+ listeCommande.get(i).getQuantite() + ".\n";
					}
				}
			}

			if (!trouve) {
				erreurFacture += "Erreur, il n'existe pas de plat nomm�: " + listeCommande.get(i).getRepas() + ".\n";
			}
		}

		return prix;
	}

	/*
	 * Argument: le prix br�t.
	 * 
	 * Retour: le prix avec les taxes ajout�es.
	 * 
	 * Description: prend le prix br�t qui est appel� et ajoute les taxes.
	 */
	public double calculTaxes(double prixBrut) {

		// d�clarations des variables des taxes et d'une autre variable de prix
		double prixTotal;
		double TPS = 5;
		double TVQ = 9.975;

		// calcul de l'ajout des taxes au prix
		if (prixBrut != 0) {
			prixTotal = prixBrut + (prixBrut * ((TPS + TVQ) / 100));
		} else {
			prixTotal = prixBrut;
		}

		return prixTotal;
	}

}
