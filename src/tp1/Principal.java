package tp1;

public class Principal {

	public static void main(String[] args) {

		lireCommande test = new lireCommande();

		System.out.println("Bienvenue chez Barette!");

		String tableauSimonCompetence[] = { "Autonome", "Charmant", "D�brouillard" };
		String tableauJeremieCompetence[] = { "Autonome", "Responsable", "D�brouillard" };

		CV simon = new CV("Delteil", "Simon", "Technique en informatique de gestion", 0, tableauSimonCompetence,
				"Avoir du travail");
		CV jeremie = new CV("Bergeron", "J�r�mie", "Technique en informatique de gestion", 2, tableauJeremieCompetence,
				"Avoir du travail");

		simon.afficher();
		System.out.println();
		jeremie.afficher();
	}

}
