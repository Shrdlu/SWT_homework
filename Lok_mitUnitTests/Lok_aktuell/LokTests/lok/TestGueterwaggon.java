package lok;

import static org.junit.Assert.*;
import lok.Gueterwaggon;
import lok.Waggon.MaxCapacityExceededException;

import org.junit.Before;
import org.junit.Test;

public class TestGueterwaggon {
	private Gueterwaggon gueter;
	
	@Before
	public void setUp() throws Exception {
		gueter = new Gueterwaggon(200,2000);
	}	

	@Test
	public void testGetLeergewichtKg() {
		assertEquals(200,gueter.getLeergewichtKg(),0);
	}

	@Test
	public void testGetGewichtKg() throws MaxCapacityExceededException {
		gueter.fuegeHinzuGut(200);
		assertEquals(400,gueter.getGewichtKg(),0);
	}

	@Test
	public void testGueterwaggon() {
		assertEquals(200,gueter.leerGewichtKg,0);
		assertEquals(2000,gueter.maxCapacity,0);
		
	}

	@Test
	public void testFuegeHinzuGut() throws MaxCapacityExceededException {
		assertTrue(gueter.fuegeHinzuGut(500));
		assertEquals(700,gueter.getGewichtKg(),0);
	}	
	
	@Test(expected=MaxCapacityExceededException.class)
	public void testFuegeHinzuZuSchweresGut() throws MaxCapacityExceededException {
		assertFalse(gueter.fuegeHinzuGut(2100));
		
	}
	
}
