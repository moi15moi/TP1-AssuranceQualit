package tp1;

public class CV {

	//Champs d'instance priv�s
	
	 private String nom;
	 private String prenom;
	 private String formation;
	 private int expTravail;
	 private String[] competence;
	 private String attente;
	 
	 
	 public static void afficher(String nom, String prenom, String formation, int expTravail, String[] competence, String attente ) {
		 
		 System.out.println("Nom : " + nom + "\nPrenom : " + prenom + "\nFormation : " + formation
	 + "\nNombre d'ann�es d'exp�rience au travail : " + expTravail + "\nComp�tences : " + competence + "\nAttente : " + attente); 
		 
		 
	 }
	 
}

