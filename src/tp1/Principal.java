package tp1;

public class Principal {

    public static void main(String[] args) {

        System.out.println("Bienvenue chez Barette !\n");

        LireFichier fichier = new LireFichier("facture_test_integre\\DelteilSimon_Test_Integre_2.txt"); 
        
        if (fichier.exists()) {

			Facture facture = new Facture();
	
			facture.initialiserFacture(fichier.getFichier());
	
	        facture.calculerFacture();
	
	        System.out.println(facture.getFacture());
	
	        facture.enregistrerFactureFicher();
        }
    }
}
