package tp1;

import java.io.FileNotFoundException;

public class Principal {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Bienvenue chez Barette !\n");

        LireFichier fichier = new LireFichier("facture\\1.txt");

        if (fichier.exists()) {

            Facture facture = new Facture();

            facture.initialiserFacture(fichier.getFichier());

            facture.calculerFacture();

            System.out.println(facture.getFacture());

            facture.enregistrerFactureFicher();
        }
    }

}
