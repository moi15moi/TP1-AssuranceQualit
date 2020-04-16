package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import tp1.Client;
import tp1.Commande;

public class ClientTest {
	
	Client clientTest1 = new Client("Test1");
	Client clientTest2 = new Client("Test2");
	Client clientTest3 = new Client("Test3");
	
	ArrayList<Commande> listeCommande = new ArrayList<Commande>();
	
	//fait par Simon Delteil
	@Test
	public void getNomTest() {
		assertEquals("Test1", clientTest1.getNomClient());
		assertEquals("Test2", clientTest2.getNomClient());
		assertEquals("Test3", clientTest3.getNomClient());
	}
	
	@Test
	public void setNomTest() {
		clientTest1.setNomClient("1Test");
		clientTest2.setNomClient("2Test");
		clientTest3.setNomClient("3Test");
		
		assertEquals("1Test", clientTest1.getNomClient());
		assertEquals("2Test", clientTest2.getNomClient());
		assertEquals("3Test", clientTest3.getNomClient());
	}
	
	@Test
	public void getListeCommandeTest() {
		
		assertEquals(listeCommande, clientTest1.getListeCommande());
		assertEquals(listeCommande, clientTest2.getListeCommande());
		assertEquals(listeCommande, clientTest3.getListeCommande());
	}
	
}
