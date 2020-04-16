package test;

import static org.junit.Assert.*;

import org.junit.Test;

import tp1.Client;
import tp1.Commande;
import tp1.Plats;

public class CommandeTest {

	Client clientTest1 = new Client("client1");
	Client clientTest2 = new Client("client2");
	Client clientTest3 = new Client("client3");

	Plats repasTest1 = new Plats("repas1", 5.00);
	Plats repasTest2 = new Plats("repas2", 10.00);
	Plats RepasTest3 = new Plats("repas3", 15.00);

	Commande commande1 = new Commande("client1", "repas1", 1);
	Commande commande2 = new Commande("client2", "repas2", 2);
	Commande commande3 = new Commande("client3", "repas3", 3);

	// Fait par Simon Delteil
	@Test
	public void getQuantiteTest() {
		assertEquals(1, commande1.getQuantite());
		assertEquals(2, commande2.getQuantite());
		assertEquals(3, commande3.getQuantite());
	}

	// Fait par Jérémie Bergeron
	@Test
	public void getRepasTest() {
		assertEquals("repas1", commande1.getNomRepas());
	}
}
