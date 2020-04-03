package test;

import static org.junit.Assert.*;

import org.junit.Test;

import tp1.Client;

public class ClientTest {
	
	Client clientTest1 = new Client("Test1");
	Client clientTest2 = new Client("Test2");
	Client clientTest3 = new Client("Test3");
	
	//fait par Simon Delteil
	@Test
	public void getNomTest() {
		assertEquals("Test1", clientTest1.getNom());
		assertEquals("Test2", clientTest2.getNom());
		assertEquals("Test3", clientTest3.getNom());
	}
	
}
