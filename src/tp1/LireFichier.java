package tp1;

import java.io.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class LireFichier extends File {
	private ArrayList<String> fichier = new ArrayList<String>();

	public LireFichier(String nomFichier) {

		super(nomFichier);
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(nomFichier), "UTF-8"));
			String st;
			while ((st = br.readLine()) != null) {
				fichier.add(st);
			}
			br.close();
		} catch (Exception e) {
			System.out.println("Erreur lors de la lecture du fichier.");
		}
	}

	public ArrayList<String> getFichier() {
		return this.fichier;
	}
}
