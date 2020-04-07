package tp1;

import java.util.ArrayList;

public class Client {

	private String nomClient;
	private ArrayList<Commande> listeCommande = new ArrayList<Commande>();

	public Client(String nom) {
		setNomClient(nom);
	}

	public String getNomClient() {
		return this.nomClient;
	}
	
	public ArrayList<Commande> getListeCommande() {
		return this.listeCommande;
	}
	
	public void setNomClient(String nom) {
		this.nomClient = nom;
	}
	
	public void ajouterCommande(Commande pCommande) {
		this.listeCommande.add(pCommande);
	}
}
