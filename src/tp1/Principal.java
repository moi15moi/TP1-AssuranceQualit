package tp1;


public class Principal {

    public static void main(String[] args) {

        System.out.println("Bienvenue chez Barette !\n");

        LireFichier fichier = new LireFichier("facture\\Bergeron_Test_integre_1.txt"); 
        
        if (fichier.exists()) {

			Facture facture = new Facture();
	
			facture.initialiserFacture(fichier.getFichier());
	
	        facture.calculerFacture();
	
	        System.out.println(facture.getFacture());
	
	        facture.enregistrerFactureFicher();
        }
    }
}
