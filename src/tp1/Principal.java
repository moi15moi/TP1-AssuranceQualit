package tp1;

public class Principal {

	public static void main(String[] args) {
		
		System.out.println("Bienvenue chez Barette!");
		
		CV simon = new CV();
		CV jeremie = new CV();
		
		simon.afficher( prenom, formation, expTravail, competence, attente);
		jeremie.afficher(nom, prenom, formation, expTravail, competence, attente);
	}

}
