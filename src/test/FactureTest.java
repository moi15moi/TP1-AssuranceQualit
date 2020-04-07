package test;

import org.junit.Assert.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import tp1.Commande;
import tp1.Client;
import tp1.Facture;
import tp1.LireFichier;
import tp1.Plats;

public class FactureTest {

	Facture facture = new Facture();

	// fait par Simon Delteil
	@Test
	public void calculTaxesTest() {
		assertEquals(1.14975, facture.calculTaxes(1), 0.00001);
		assertEquals(2.2995, facture.calculTaxes(2), 0.00001);
		assertEquals(3.44925, facture.calculTaxes(3), 0.00001);
	}

	// fait par Simon Delteil
	@Test
	public void calculTPSTest() {
		assertEquals(0.05, facture.calculTPS(1), 0.00001);
		assertEquals(0.1, facture.calculTPS(2), 0.00001);
		assertEquals(0.15, facture.calculTPS(3), 0.00001);
	}

	// fait par Simon Delteil
	@Test
	public void calculTVQTest() {
		assertEquals(0.09975, facture.calculTVQ(1), 0.00001);
		assertEquals(0.1995, facture.calculTVQ(2), 0.00001);
		assertEquals(0.29925, facture.calculTVQ(3), 0.00001);
	}

	// fait par Simon Delteil
	@Test
	public void calculPrixTotalTest() {
		assertEquals(1.14975, facture.calculPrixTotal(1, 0.05, 0.09975), 0.00001);
		assertEquals(2.2995, facture.calculPrixTotal(2, 0.1, 0.1995), 0.00001);
		assertEquals(3.44925, facture.calculPrixTotal(3, 0.15, 0.29925), 0.00001);
	}

	// fait par Jérémie Bergeron
	@Test
	public void calculerPrixBrutCommandeTest1() {
		Client client1 = new Client("test");

		Commande commande1 = new Commande("test1", "repasTest1", 1);
		Commande commande2 = new Commande("test2", "repasTest2", 2);
		Commande commande3 = new Commande("test3", "repasTest3", 3);

		Plats repas1 = new Plats("repasTest1", 10);
		Plats repas2 = new Plats("repasTest2", 5);
		Plats repas3 = new Plats("repasTest3", 5);

		client1.ajouterCommande(commande1);
		client1.ajouterCommande(commande2);
		client1.ajouterCommande(commande3);

		Facture facture = new Facture();

		ArrayList<Client> client = new ArrayList<Client>();
		ArrayList<Plats> plats = new ArrayList<Plats>();
		ArrayList<Commande> commande = new ArrayList<Commande>();

		client.add(client1);
		plats.add(repas1);
		plats.add(repas2);
		plats.add(repas3);
		commande.add(commande1);
		commande.add(commande2);
		commande.add(commande3);

		facture.setTableauClient(client);
		facture.setTableauPlats(plats);
		facture.setTableauCommande(commande);

		assertEquals(35, facture.calculerPrixBrutCommande(client1), 0.00001);
	}

	// fait par Jérémie Bergeron
	@Test
	public void calculerPrixBrutCommandeTest2() {
		Client client1 = new Client("test");

		Commande commande1 = new Commande("test1", "repasTest1", 0);
		Commande commande2 = new Commande("test2", "repasTest2", 0);
		Commande commande3 = new Commande("test3", "repasTest3", 0);

		Plats repas1 = new Plats("repasTest1", 10);
		Plats repas2 = new Plats("repasTest2", 5);
		Plats repas3 = new Plats("repasTest3", 5);

		client1.ajouterCommande(commande1);
		client1.ajouterCommande(commande2);
		client1.ajouterCommande(commande3);

		Facture facture = new Facture();

		ArrayList<Client> client = new ArrayList<Client>();
		ArrayList<Plats> plats = new ArrayList<Plats>();
		ArrayList<Commande> commande = new ArrayList<Commande>();

		client.add(client1);
		plats.add(repas1);
		plats.add(repas2);
		plats.add(repas3);
		commande.add(commande1);
		commande.add(commande2);
		commande.add(commande3);

		facture.setTableauClient(client);
		facture.setTableauPlats(plats);
		facture.setTableauCommande(commande);

		assertEquals(0, facture.calculerPrixBrutCommande(client1), 0.00001);
	}

	// fait par Jérémie Bergeron
	@Test
	public void calculerPrixBrutCommandeTest3() {
		Client client1 = new Client("test");

		Commande commande1 = new Commande("test1", "repasTest0", 1);
		Commande commande2 = new Commande("test2", "repasTest0", 2);
		Commande commande3 = new Commande("test3", "repasTest0", 3);

		Plats repas1 = new Plats("repasTest1", 10);
		Plats repas2 = new Plats("repasTest2", 5);
		Plats repas3 = new Plats("repasTest3", 5);

		client1.ajouterCommande(commande1);
		client1.ajouterCommande(commande2);
		client1.ajouterCommande(commande3);

		Facture facture = new Facture();

		ArrayList<Client> client = new ArrayList<Client>();
		ArrayList<Plats> plats = new ArrayList<Plats>();
		ArrayList<Commande> commande = new ArrayList<Commande>();

		client.add(client1);
		plats.add(repas1);
		plats.add(repas2);
		plats.add(repas3);
		commande.add(commande1);
		commande.add(commande2);
		commande.add(commande3);

		facture.setTableauClient(client);
		facture.setTableauPlats(plats);
		facture.setTableauCommande(commande);

		assertEquals(0, facture.calculerPrixBrutCommande(client1), 0.00001);
	}

	// fait par Jérémie Bergeron
	@Test
	public void initialiserFactureTest() {
		LireFichier fichier = new LireFichier("facture\\factureTest.txt");

		Client client1 = new Client("test");
		Commande commande1 = new Commande("test", "repasTest1", 1);
		Commande commande2 = new Commande("test", "repasTest2", 2);
		Commande commande3 = new Commande("test", "repasTest3", 3);

		Plats repas1 = new Plats("repasTest1", 10);
		Plats repas2 = new Plats("repasTest2", 5);
		Plats repas3 = new Plats("repasTest3", 5);

		client1.ajouterCommande(commande1);
		client1.ajouterCommande(commande2);
		client1.ajouterCommande(commande3);

		ArrayList<Client> client = new ArrayList<Client>();
		ArrayList<Plats> plats = new ArrayList<Plats>();
		ArrayList<Commande> commande = new ArrayList<Commande>();

		client.add(client1);
		plats.add(repas1);
		plats.add(repas2);
		plats.add(repas3);
		commande.add(commande1);
		commande.add(commande2);
		commande.add(commande3);

		Facture facture = new Facture();

		facture.setTableauClient(client);
		facture.setTableauPlats(plats);
		facture.setTableauCommande(commande);

		Facture factureFichier = new Facture();

		factureFichier.initialiserFacture(fichier.getFichier());

		assertEquals(35, facture.calculerPrixBrutCommande(client1), 0.00001);

		assertEquals(facture.calculerPrixBrutCommande(client1),
				factureFichier.calculerPrixBrutCommande(factureFichier.getTableauClient().get(0)), 0.00001);
	}

	// Fait par Jérémie Bergeron
	@Test
	public void calculerFacture() {
		LireFichier fichier = new LireFichier("facture\\factureTest.txt");

		Facture factureFichier = new Facture();

		factureFichier.initialiserFacture(fichier.getFichier());

		factureFichier.calculerFacture();
		
		assertEquals("Factures :\n" + "test 40,24$\n\n", factureFichier.getFacture());
	}
}
