package tp1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Principal {

	public static void main(String[] args) throws FileNotFoundException {
		
		PrintStream fichierTexte = new PrintStream(new File("facture\\Facture-du-" + DateHeure.modifierAffichageDateHeure() + ".txt"));
		
		System.out.println("Bienvenue chez Barette !\n");
		
		LireFichier fichier = new LireFichier("facture\\1.txt");
		
		Facture facture = new Facture(fichier.getFichier());

		System.out.println(facture.getFacture());
		System.setOut(fichierTexte); 
		System.out.println(facture.getFacture());
	}

}
