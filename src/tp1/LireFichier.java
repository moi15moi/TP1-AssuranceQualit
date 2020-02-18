package tp1;

import java.io.*;
import java.util.ArrayList;

public class LireFichier {

	ArrayList<String> fichier = new ArrayList<String>();
	
	ArrayList<Client> client = new ArrayList<Client>();
	ArrayList<Plats> plats = new ArrayList<Plats>();
	ArrayList<Commande> commande = new ArrayList<Commande>();

	public LireFichier(String nomFichier) {
		try {
			File file = new File(nomFichier);

			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(nomFichier), "UTF-8"));

			String st;

			while ((st = br.readLine()) != null) {
				fichier.add(st);
			}

			br.close();

		} catch (Exception e) {
			System.out.println("Erreur lors de la lecture du fichier.");
		}

		try {
			int client = fichier.indexOf("Clients :");
			int plat = fichier.indexOf("Plats :");
			int commande = fichier.indexOf("Commandes :");
			int fin = fichier.indexOf("Fin");

			for (int i = client + 2; i < plat; i++) {
				Client cliTemp = new Client(fichier.get(i));
				this.client.add(cliTemp);
			}
			

			for (int i = plat + 1; i < commande; i++) {
				String[] temp = fichier.get(i).split(" ");
				
				if (temp.length == 2) {
					Plats platTemp = new Plats(temp[0], temp[1]);

					this.plats.add(platTemp);
				} else {
					System.out.println("Le fichier ne respecte pas le format demandé ! (ligne: " + (i + 1) + ")");
				}
			}
			

			for (int i = commande + 1; i < fin; i++) {

				String[] temp = fichier.get(i).split(" ");
				
				if (temp.length == 3) {
				Commande comTemp = new Commande(temp[0], temp[1], temp[2]);

				this.commande.add(comTemp);
				} else {
					System.out.println("Le fichier ne respecte pas le format demandé ! (ligne: " + (i + 1) + ")");
				}
			}
			
			
		} catch (Exception e) {
			System.out.println("Le fichier ne respecte pas le format demandé !");
		}
	}

	public ArrayList<Client> getClient(){
		return this.client;
	}
	
	public ArrayList<Commande> getCommande(){
		return this.commande;
	}
	
	public ArrayList<Plats> getPlats(){
		return this.plats;
	}

}
