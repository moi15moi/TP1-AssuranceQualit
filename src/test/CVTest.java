package test;

import static org.junit.Assert.*;

import org.junit.Test;

import tp1.CV;

public class CVTest {
	
	private String[] competences1 = {"Photoshop", "Blender"};
	private String[] competences2 = {"Excel", "Word"};
	private String[] competences3 = {"Java", "C++"};
	
	CV CVTest1 = new CV("St-Germain", "Simon", "Informatique de gestion", 1, competences1, "aucune");
	CV CVTest2 = new CV("Delteil", "Simon", "Informatique de gestion", 2, competences2, "aucune");
	CV CVTest3 = new CV("Bergeron", "Jérémie", "Informatique de gestion", 3, competences3, "aucune");
	
	//fait par Simon St-Germain
	@Test
	public void getNomTest() {
		assertEquals("St-Germain", CVTest1.getNom());
		assertEquals("Delteil", CVTest2.getNom());
		assertEquals("Bergeron", CVTest3.getNom());
	}
	
	//fait par Simon St-Germain
	@Test
	public void getPrenomTest() {
		assertEquals("Simon", CVTest1.getPrenom());
		assertEquals("Simon", CVTest2.getPrenom());
		assertEquals("Jérémie", CVTest3.getPrenom());
	}
	
	//fait par Simon St-Germain
	@Test
	public void getFormationTest() {
		assertEquals("Informatique de gestion", CVTest1.getFormation());
		assertEquals("Informatique de gestion", CVTest2.getFormation());
		assertEquals("Informatique de gestion", CVTest3.getFormation());
	}
	
	//fait par Simon St-Germain
	@Test
	public void getExpTravailTest() {
		assertEquals(1, CVTest1.getExpTravail());
		assertEquals(2, CVTest2.getExpTravail());
		assertEquals(3, CVTest3.getExpTravail());
	}
	
	//fait par Simon St-Germain
	@Test
	public void getAttente() {
		assertEquals("aucune", CVTest1.getAttente());
		assertEquals("aucune", CVTest2.getAttente());
		assertEquals("aucune", CVTest3.getAttente());
	}
}
