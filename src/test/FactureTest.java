package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import tp1.Facture;

public class FactureTest {
	
	//fait par Simon Delteil
	@Test
	public void calculTaxesTest() {
		assertEquals(1.14975, Facture.calculTaxes(1), 0.00001);
		assertEquals(2.2995, Facture.calculTaxes(2), 0.00001);
		assertEquals(3.44925, Facture.calculTaxes(3), 0.00001);
	}
	
	//fait par Simon Delteil
	@Test
	public void calculTPSTest() {
		assertEquals(0.05, Facture.calculTPS(1), 0.00001);
		assertEquals(0.1, Facture.calculTPS(2), 0.00001);
		assertEquals(0.15, Facture.calculTPS(3), 0.00001);
	}
	
	//fait par Simon Delteil
	@Test
	public void calculTVQTest() {
		assertEquals(0.09975, Facture.calculTVQ(1), 0.00001);
		assertEquals(0.1995, Facture.calculTVQ(2), 0.00001);
		assertEquals(0.29925, Facture.calculTVQ(3), 0.00001);
	}
	
	//fait par Simon Delteil
	@Test
	public void calculPrixTotalTest() {
		assertEquals(1.14975, Facture.calculPrixTotal(1, 0.05, 0.09975), 0.00001);	
		assertEquals(2.2995, Facture.calculPrixTotal(2, 0.1, 0.1995), 0.00001);
		assertEquals(3.44925, Facture.calculPrixTotal(3, 0.15, 0.29925), 0.00001);
	}

}
