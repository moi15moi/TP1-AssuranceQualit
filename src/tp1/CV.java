package tp1;

public class CV {

	// Champs d'instance privés

	private String nom;
	private String prenom;
	private String formation;
	private int expTravail;
	private String[] competence;
	private String attente;

	public static void afficher(String nom, String prenom, String formation, int expTravail, String[] competence,
			String attente) {

		System.out.println("Nom : " + nom + "\nPrenom : " + prenom + "\nFormation : " + formation
				+ "\nNombre d'années d'expérience au travail : " + expTravail + "");

	}

	public String getNom() {
		return this.nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public String getFormation() {
		return this.formation;
	}

	public int getExpTravail() {
		return this.expTravail;
	}

	public String[] getCompetence() {
		return competence;
	}
	
	public String getAttente() {
		return attente;
	}
	
	public void setNom(String nom) {
		 this.nom = nom;
	}

	public void setPrenom(String prenom) {
		 this.prenom = prenom;
	}

	public void setFormation(String formation) {
		 this.formation = formation;
	}

	public void setExpTravail(int expTravail) {
		 this.expTravail = expTravail;
	}

	public void setCompetence(String[] competence) {
		 this.competence = competence;
	}
	
	public void setAttente(String attente) {
		 this.attente = attente;
	}

}
