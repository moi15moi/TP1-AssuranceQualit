package test;

import static org.junit.Assert.*;

import org.junit.Test;

import tp1.DateHeure;

public class DateHeureTest {
	
	String dateHeureTest1 = DateHeure.modifierAffichageDateHeure();
	String dateHeureTest2 = DateHeure.modifierAffichageDateHeure();
	String dateHeureTest3 = DateHeure.modifierAffichageDateHeure();

	//fait par Simon St-Germian
	@Test
	public void modifierAffichageDateHeureTest() {
		
		assertEquals( dateHeureTest1, DateHeure.modifierAffichageDateHeure() );
		assertEquals( dateHeureTest2, DateHeure.modifierAffichageDateHeure() );
		assertEquals( dateHeureTest3, DateHeure.modifierAffichageDateHeure() );
		
	}
	
}
