package tp1;

import java.util.ArrayList;

public class Client {

	private String nom;
	private ArrayList<Commande> commande = new ArrayList<Commande>();

	public Client(String nom) {
		setNom(nom);

	}

	public String getNom() {
		return this.nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void ajouterCommande(Commande pCommande) {
		this.commande.add(pCommande);
	}
	
	public ArrayList<Commande> getListeCommande() {
		return this.commande;
	}
}
