package tp1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.sun.prism.paint.Stop;

import static tp1.Constantes.TPS;
import static tp1.Constantes.TVQ;

public class Facture {

	private ArrayList<Client> client = new ArrayList<Client>();
	private ArrayList<Plats> plats = new ArrayList<Plats>();
	private ArrayList<Commande> commande = new ArrayList<Commande>();

	private String facture = "";
	private String erreurClient = "";
	private String erreurFacture = "";

	public Facture() {

	}

	public void initialiserFacture(ArrayList<String> fichier) {
		try {

			int client = fichier.indexOf("Clients :");
			int plat = fichier.indexOf("Plats :");
			int commande = fichier.indexOf("Commandes :");
			int fin = fichier.indexOf("Fin");

			for (int i = client + 1; i < plat; i++) {
				String[] ligneFichier = fichier.get(i).split(" ");
				if (ligneFichier.length == 1) {
					try {
						Client cliTemp = new Client(fichier.get(i));
						this.client.add(cliTemp);
					} catch (Exception e) {
						System.out.println("Erreur lors de la lecture du prix d'un plats.\n");
						System.exit(0);
					}

				} else {
					System.out.println("Le fichier ne respecte pas le format demandé ! (ligne: " + (i + 1) + ")");
					System.exit(0);

				}
			}
			
			for (int i = plat + 1; i < commande; i++) {
				String[] ligneFichier = fichier.get(i).split(" ");

				if (ligneFichier.length == 2) {
					try {
						double prix = Double.parseDouble(ligneFichier[1]);
						Plats platTemp = new Plats(ligneFichier[0], prix);
						this.plats.add(platTemp);
					} catch (Exception e) {
						System.out.println("Erreur lors de la lecture du prix d'un plats.\n");
						System.exit(0);
					}
				} else {
					System.out.println("Le fichier ne respecte pas le format demandé ! (ligne: " + (i + 1) + ")");
					System.exit(0);
				}
			}

			for (int i = commande + 1; i < fin; i++) {

				String[] ligneFichier = fichier.get(i).split(" ");

				if (ligneFichier.length == 3) {
					try {
						int quantite = Integer.parseInt(ligneFichier[2]);
						Commande comTemp = new Commande(ligneFichier[0], ligneFichier[1], quantite);
						this.commande.add(comTemp);
					} catch (Exception e) {
						System.out.println("Erreur lors de la lecture de la quantité d'une commande.\n");
						System.exit(0);
					}
				} else {
					System.out.println("Le fichier ne respecte pas le format demandé ! (ligne: " + (i + 1) + ")");
					System.exit(0);
				}
			}

			// Associe les commandes aux clients et vérifie si le client dans la commande
			// existe
			for (int i = 0; i < this.commande.size(); i++) {

				boolean trouver = false;
				for (int j = 0; j < this.client.size() && !trouver; j++) {

					if (this.commande.get(i).getNomClient().equalsIgnoreCase(this.client.get(j).getNomClient())) {
						trouver = true;
						this.client.get(j).ajouterCommande(this.commande.get(i));
					}
				}

				if (!trouver) {
					erreurClient += "Erreur, le client " + this.commande.get(i).getNomClient() + " n'existent pas.\n";
				}
			}

		} catch (Exception e) {
			System.out.println("Le fichier ne respecte pas le format demandé. !");
		}
	}

	public void mettreClientdansListeClient(int client, int plat, ArrayList<String> fichier) {

		for (int i = client + 1; i < plat; i++) {
			String[] ligneFichier = fichier.get(i).split(" ");
			if (ligneFichier.length == 1) {
				try {
					Client cliTemp = new Client(fichier.get(i));
					this.client.add(cliTemp);
				} catch (Exception e) {
					System.out.println("Erreur lors de la lecture du prix d'un plats.\n");
				}

			} else {
				System.out.println("Le fichier ne respecte pas le format demandé ! (ligne: " + (i + 1) + ")");
			}
		}
	}

	public void setTableauClient(ArrayList<Client> pClient) {
		this.client = pClient;
	}

	public void setTableauPlats(ArrayList<Plats> pPlats) {
		this.plats = pPlats;
	}

	public void setTableauCommande(ArrayList<Commande> pCommande) {
		this.commande = pCommande;
	}

	public ArrayList<Client> getTableauClient() {
		return this.client;
	}

	public ArrayList<Plats> getTableauPlats() {
		return this.plats;
	}

	public ArrayList<Commande> getTableauCommande() {
		return this.commande;
	}

	/*
	 * Argument: Aucun.
	 * 
	 * Retour: Retourne les variables globales "facture" et "erreurFacture".
	 * 
	 * Description: Affiche la facture
	 */
	public String getFacture() {

		return facture + "\n" + erreurClient + erreurFacture;
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

		// Calcule le prix total de la facture et vérifie si le prix total est égale
		// à 0
		for (int i = 0; i < client.size(); i++) {

			if ((prixFactureClient = calculTaxes(calculerPrixBrutCommande(client.get(i)))) != 0) {

				facture += client.get(i).getNomClient() + " " + formatter.format(prixFactureClient) + "$\n";
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

		prix = siCommandeTrouver(listeCommande, prix);

		return prix;
	}

	public double siCommandeTrouver(ArrayList<Commande> listeCommande, double prix) {

		for (int i = 0; i < listeCommande.size(); i++) {
			boolean trouve = false;

			for (int j2 = 0; j2 < plats.size() && !trouve; j2++) {

				if (listeCommande.get(i).getNomRepas().equalsIgnoreCase(plats.get(j2).getNomPlats())) {
					trouve = true;

					prix = siCommandeQuantitePlusGrandQue0(i, j2, listeCommande, prix);
				}
			}

			if (!trouve) {

				siCommandePasTrouve(listeCommande, i);

			}
		}

		return prix;

	}

	public double siCommandeQuantitePlusGrandQue0(int indexCommande, int indexPlat, ArrayList<Commande> listeCommande,
			double prix) {

		if (listeCommande.get(indexCommande).getQuantite() > 0) {
			prix += plats.get(indexPlat).getPrix() * listeCommande.get(indexCommande).getQuantite();
		} else {
			erreurFacture += "Erreur, la commande " + indexCommande + " de "
					+ listeCommande.get(indexCommande).getNomClient()
					+ " n'est pas valide, car la quantité commandé est "
					+ listeCommande.get(indexCommande).getQuantite() + ".\n";
		}

		return prix;
	}

	public void siCommandePasTrouve(ArrayList<Commande> listeCommande, int indexCommande) {

		erreurFacture += "Erreur, il n'existe pas de plat nommé: " + listeCommande.get(indexCommande).getNomRepas()
				+ ".\n";
	}

	/*
	 * Argument: le prix brut.
	 * 
	 * Retour: le prix avec les taxes ajoutées.
	 * 
	 * Description: prend le prix brut qui est appelé et ajoute les taxes.
	 */
	public double calculTaxes(double prixBrut) {

		// déclarations des variables des taxes et d'une autre variable de prix
		double prixTotal;
		double montantTPS = calculTPS(prixBrut);
		double montantTVQ = calculTVQ(prixBrut);

		// calcul de l'ajout des taxes au prix
		prixTotal = calculPrixTotal(prixBrut, montantTPS, montantTVQ);

		return prixTotal;
	}

	public double calculTPS(double prixBrut) {

		double montantTPS = prixBrut * TPS / 100;

		return montantTPS;
	}

	public double calculTVQ(double prixBrut) {

		double montantTVQ = prixBrut * TVQ / 100;

		return montantTVQ;
	}

	public double calculPrixTotal(double prixBrut, double montantTPS, double montantTVQ) {

		double prixTotal = prixBrut + montantTPS + montantTVQ;

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

		LocalDateTime localDateTime = LocalDateTime.now();

		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MMMM-yyyy-HH.mm");

		File file = new File("facture\\Facture-du-" + localDateTime.format(dateFormat) + ".txt");

		FileWriter writer;

		calculerFacture();
		try {
			writer = new FileWriter(file);
			writer.write(getFacture());
			writer.close();

		} catch (IOException e) {
			System.out.println("Erreur lors de l'enregistrement de la facture en fichier texte.");
		}
	}
}
