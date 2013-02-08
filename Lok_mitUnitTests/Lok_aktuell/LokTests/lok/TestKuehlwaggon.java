package lok;

import static org.junit.Assert.*;
import lok.Kuehlwaggon;
import lok.Waggon.MaxCapacityExceededException;

import org.junit.Before;
import org.junit.Test;

public class TestKuehlwaggon {
	
	private Kuehlwaggon kuehl;
	@Before
	public void setUp() throws Exception {
		kuehl = new Kuehlwaggon(200,1000);
	}

	@Test
	public void testFuegeHinzuGut() throws MaxCapacityExceededException{
		
		assertTrue(kuehl.fuegeHinzuGut(200));
		assertEquals(400,kuehl.getGewichtKg(),0);
	}

	@Test
	public void testKuehlwaggon() {
		Kuehlwaggon k = new Kuehlwaggon(500,1500);
		assertEquals(500,k.getLeergewichtKg(),0);
		assertEquals(1500,k.getMaxCapacity(),0);
		assertEquals(500,k.getGewichtKg(),0);
		
	}
	
	@Test(expected = RuntimeException.class)
	public void testKaeltemaschineAusschalten() throws MaxCapacityExceededException {
		kuehl.ausschaltenKaeltemaschine();
		assertFalse(kuehl.fuegeHinzuGut(50));
		kuehl.einschaltenKaeltemaschine();
		assertTrue(kuehl.fuegeHinzuGut(50));
		//RuntimeException: Kältemaschine nicht ausschalten wenn noch beladen
		kuehl.ausschaltenKaeltemaschine();
		
		
	}

}
