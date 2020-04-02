package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import tp1.Commande;
import tp1.Client;
import tp1.Facture;
import tp1.Plats;

public class FactureTest {

	// fait par Simon Delteil
	@Test
	public void calculTaxesTest() {
		assertEquals(1.14975, Facture.calculTaxes(1), 0.00001);
		assertEquals(2.2995, Facture.calculTaxes(2), 0.00001);
		assertEquals(3.44925, Facture.calculTaxes(3), 0.00001);
	}

	// fait par Simon Delteil
	@Test
	public void calculTPSTest() {
		assertEquals(0.05, Facture.calculTPS(1), 0.00001);
		assertEquals(0.1, Facture.calculTPS(2), 0.00001);
		assertEquals(0.15, Facture.calculTPS(3), 0.00001);
	}

	// fait par Simon Delteil
	@Test
	public void calculTVQTest() {
		assertEquals(0.09975, Facture.calculTVQ(1), 0.00001);
		assertEquals(0.1995, Facture.calculTVQ(2), 0.00001);
		assertEquals(0.29925, Facture.calculTVQ(3), 0.00001);
	}

	// fait par Simon Delteil
	@Test
	public void calculPrixTotalTest() {
		assertEquals(1.14975, Facture.calculPrixTotal(1, 0.05, 0.09975), 0.00001);
		assertEquals(2.2995, Facture.calculPrixTotal(2, 0.1, 0.1995), 0.00001);
		assertEquals(3.44925, Facture.calculPrixTotal(3, 0.15, 0.29925), 0.00001);
	}

	/*
	 * @Test public void getFacture() {
	 * 
	 * assertEquals(
	 * "Factures :\nRoger 12,07$\nCéline 5,75$\n\nErreur, la commande 1 de Roger n'est pas valide, car la quantiï¿½ commandï¿½e est  n'est pas valide, car la quantiï¿½ commandï¿½e est 0.\nErreur, il n'existe pas de plat nommï¿½: Repaus_Poulet.\n"
	 * , Facture.getFacture());
	 * 
	 * //assertEquals(expected, actual); }
	 */

	// fait par Jérémie Bergeron
	@Test
	public void calculerPrixBrutCommandeTest() {
		Client client1 = new Client("test");
		Commande commande1 = new Commande("test1", "repasTest1", "1");
		Commande commande2 = new Commande("test2", "repasTest2", "2");
		Commande commande3 = new Commande("test3", "repasTest3", "3");
		
		Plats repas1 = new Plats("repasTest1", "10");
		Plats repas2 = new Plats("repasTest2", "5");
		Plats repas3 = new Plats("repasTest3", "5");
		

		client1.ajouterCommande(commande1);
		client1.ajouterCommande(commande2);
		client1.ajouterCommande(commande3);
		
		Facture facture = new Facture();
		
		//assertEquals(35, facture.calculerPrixBrutCommande(client1), 0.00001);


	}

}
