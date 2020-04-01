package tp1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
					System.out.println("Le fichier ne respecte pas le format demandÃ© ! (ligne: " + (i + 1) + ")");
				}
			}

			for (int i = commande + 1; i < fin; i++) {

				String[] ligneFichier = fichier.get(i).split(" ");

				if (ligneFichier.length == 3) {
					Commande comTemp = new Commande(ligneFichier[0], ligneFichier[1], ligneFichier[2]);

					this.commande.add(comTemp);
				} else {
					System.out.println("Le fichier ne respecte pas le format demandÃ© ! (ligne: " + (i + 1) + ")");
				}
			}

		} catch (Exception e) {
			System.out.println("Le fichier ne respecte pas le format demandÃ©. !");
		}

	}

	/*
	 * Argument: Aucun.
	 * 
	 * Retour: Retourne les variables globales "facture" et "erreurFacture".
	 * 
<<<<<<< HEAD
	 * Description: Fait appele ï¿½ la mï¿½thode calculerFacture et retourne la facture.
=======
	 * Description: Fait appele à la méthode calculerFacture et retourne la facture.
>>>>>>> 899d6d5dd490348c21ce3ce86a8b96e646eac5f2
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

<<<<<<< HEAD
		// Associe les commandes aux clients et vï¿½rifie si le client dans la commande
=======
		// Associe les commandes aux clients et vérifie si le client dans la commande
>>>>>>> 899d6d5dd490348c21ce3ce86a8b96e646eac5f2
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

<<<<<<< HEAD
		// Calcule le prix total de la facture et vï¿½rifie si le prix total est ï¿½gale ï¿½ 0
		for (int i = 0; i < client.size(); i++) {

			if ((prixFactureClient = calculTaxes(calculerPrixBrutCommande(client.get(i)))) != 0) {

=======
		// Calcule le prix total de la facture et vérifie si le prix total est égale à 0
		for (int i = 0; i < client.size(); i++) {

			if ((prixFactureClient = calculTaxes(calculerPrixBrutCommande(client.get(i)))) != 0) {

>>>>>>> 899d6d5dd490348c21ce3ce86a8b96e646eac5f2
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
<<<<<<< HEAD
								+ " n'est pas valide, car la quantiï¿½ commandï¿½e est "
=======
								+ " n'est pas valide, car la quantié commandée est "
>>>>>>> 899d6d5dd490348c21ce3ce86a8b96e646eac5f2
								+ listeCommande.get(i).getQuantite() + ".\n";
					}
				}
			}

			if (!trouve) {
<<<<<<< HEAD

				erreurFacture += "Erreur, il n'existe pas de plat nommï¿½: " + listeCommande.get(i).getRepas() + ".\n";

=======
				erreurFacture += "Erreur, il n'existe pas de plat nommé: " + listeCommande.get(i).getRepas() + ".\n";
>>>>>>> 899d6d5dd490348c21ce3ce86a8b96e646eac5f2
			}
		}

		return prix;
	}

<<<<<<< HEAD
	
	/*Argument: le prix brÃ»t.
	 * 
	 *Retour: le prix avec les taxes ajoutÃ©es.
	 * 
	 *Description: prend le prix brÃ»t qui est appelÃ© et ajoute les taxes.
	 */
	public static double calculTaxes(double prixBrut) {
		
		//dÃ©clarations des variables des taxes et d'une autre variable de prix
		double prixTotal;
		double montantTPS = calculTPS(prixBrut);
		double montantTVQ = calculTVQ(prixBrut);
		
		//calcul de l'ajout des taxes au prix
		prixTotal = calculPrixTotal(prixBrut, montantTPS, montantTVQ);
		
		return prixTotal;
	}
	
	public static double calculTPS(double prixBrut) {
		
		double montantTPS = prixBrut * 5 / 100;
		
		return montantTPS;
	}
	
	public static double calculTVQ(double prixBrut) {
		
		double montantTVQ = prixBrut * 9.975 / 100;
		
		return montantTVQ;
	}
	
	public static double calculPrixTotal( double prixBrut, double montantTPS, double montantTVQ ) {
		
		double prixTotal = prixBrut + montantTPS + montantTVQ;
		
=======
	/*
	 * Argument: le prix brût.
	 * 
	 * Retour: le prix avec les taxes ajoutées.
	 * 
	 * Description: prend le prix brût qui est appelé et ajoute les taxes.
	 */
	public double calculTaxes(double prixBrut) {

		// déclarations des variables des taxes et d'une autre variable de prix
		double prixTotal;
		double TPS = 5;
		double TVQ = 9.975;

		// calcul de l'ajout des taxes au prix
		if (prixBrut != 0) {
			prixTotal = prixBrut + (prixBrut * ((TPS + TVQ) / 100));
		} else {
			prixTotal = prixBrut;
		}

>>>>>>> 899d6d5dd490348c21ce3ce86a8b96e646eac5f2
		return prixTotal;
	}
	
	/*
	 * Argument: Aucun.
	 * 
	 * Retour: Rien.
	 * 
	 * Description: Enregistre la facture en fichier texte.
	 */
	public void enregistrerFactureFicher() {
		File file = new File("facture\\Facture-du-" + DateHeure.modifierAffichageDateHeure() + ".txt");

		FileWriter writer;
		try {
			writer = new FileWriter(file);
			writer.write(getFacture());
			writer.close();

		} catch (IOException e) {
			System.out.println("Erreur lors de l'enregistrement de la facture en fichier texte.");
		}
	}

}
