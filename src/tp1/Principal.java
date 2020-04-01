package tp1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

public class Principal {

	public static void main(String[] args) throws FileNotFoundException {


		System.out.println("Bienvenue chez Barette !\n");

		LireFichier fichier = new LireFichier("facture\\1.txt");

		Facture facture = new Facture(fichier.getFichier());

		facture.calculerFacture();

		System.out.println(facture.getFacture());

		facture.enregistrerFactureFicher();
	}
	
}
