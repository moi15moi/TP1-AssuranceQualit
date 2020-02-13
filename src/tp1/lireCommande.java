package tp1;

import java.io.*;
import java.util.ArrayList;

public class lireCommande {

	ArrayList<String> fichier = new ArrayList<String>();
	ArrayList<Client> client = new ArrayList<Client>();
	ArrayList<Commande> commande = new ArrayList<Commande>();

	public lireCommande() {
		try {
			File file = new File("facture\\1.txt");

			BufferedReader br = new BufferedReader(
					new InputStreamReader(new FileInputStream("facture\\1.txt"), "UTF-8"));

			String st;

			while ((st = br.readLine()) != null) {
				fichier.add(st);
			}

			br.close();

		} catch (Exception e) {

		}

		int client = fichier.indexOf("Clients :");
		int plat = fichier.indexOf("Plats :");
		int commande = fichier.indexOf("Commandes :");
		int fin = fichier.indexOf("Fin");

		for (int i = client + 1; i < plat; i++) {
			Client cliTemp = new Client(fichier.get(i));
			this.client.add(cliTemp);
		}
		
		for (int i = plat + 1; i < commande; i++) {
			String[] temp = fichier.get(i).split(" ");
			
			Commande comTemp = new Commande(temp[0], temp[1]);
			
			this.commande.add(comTemp);
		}
		
		for (int i = commande + 1; i < fin; i++) {
			
		}
	}

}
