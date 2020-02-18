package tp1;

public class Principal {

	public static void main(String[] args) {

		System.out.println("Bienvenue chez Barette!");
		
		LireFichier fichier = new LireFichier("facture\\1.txt");
		
		Facture facture = new Facture(fichier.getClient(), fichier.getPlats(), fichier.getCommande());

		facture.afficherFacture();
		
		
		String tableauSimonCompetence[] = { "Autonome", "Charmant", "Débrouillard" };
		String tableauJeremieCompetence[] = { "Autonome", "Responsable", "Débrouillard" };
		String tableauSimonSCompetence[] = { "Autonome", "Minutieux", "Travaillant" };

		CV simon = new CV("Delteil", "Simon", "Technique en informatique de gestion", 0, tableauSimonCompetence,
				"Avoir du travail");
		CV jeremie = new CV("Bergeron", "Jérémie", "Technique en informatique de gestion", 2, tableauJeremieCompetence,
				"Avoir du travail");
		CV simonS = new CV("St-Germain", "Simon", "Technique en informatique de gestion", 0, tableauSimonCompetence,
                "Avoir du travail");

		simon.afficher();
		jeremie.afficher();
		simonS.afficher();
	}

}
