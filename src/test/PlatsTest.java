package test;

import static org.junit.Assert.*;

import org.junit.Test;

import tp1.Plats;

public class PlatsTest {
	
	Plats platTest1 = new Plats("Test1", "1.00");
	Plats platTest2 = new Plats("Test2", "5.00");
	Plats platTest3 = new Plats("Test3", "10.00");
	
	//fait par Simon St-Germain
	@Test
	public void getNomTest() {
		assertEquals("Test1", platTest1.getNom());
		assertEquals("Test2", platTest2.getNom());
		assertEquals("Test3", platTest3.getNom());
	}
	
	//fait par Simon St-Germain
	@Test
	public void getPrixTest() {
		assertEquals(1.00, platTest1.getPrix(), 0.01);
		assertEquals(5.00, platTest2.getPrix(), 0.01);
		assertEquals(10.00, platTest3.getPrix(), 0.01);
	}
}
