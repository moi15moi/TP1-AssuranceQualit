package main;

public class Principal {

	public static void main(String[] args) {

		System.out.println("\nBienvenue chez Barette!\n");
		
		LireFichier fichier = new LireFichier("facture\\1.txt");
		
		Facture facture = new Facture(fichier.getFichier());

		facture.afficherFacture();
		
		
	}

}
