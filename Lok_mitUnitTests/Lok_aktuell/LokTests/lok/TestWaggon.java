package lok;

import static org.junit.Assert.*;
import lok.Kippwaggon;
import lok.Waggon;
import lok.Waggon.MaxCapacityExceededException;

import org.junit.Before;
import org.junit.Test;

public class TestWaggon {
	
	private Waggon k;

	@Before
	public void setUp() throws Exception {
		k = new Kippwaggon(200,1000);
	}

	
	@Test
	public void testGetMaxCapacity() {
		assertEquals(1000,k.getMaxCapacity(),0);
	}

	@Test
	public void testGetLeergewichtKg() {
		assertEquals(200,k.getLeergewichtKg(),0);
	}

	@Test
	public void testGetGewichtKg() throws MaxCapacityExceededException {
		assertEquals(200,k.getGewichtKg(),0);
		k.beladeWaggon(100);
		assertEquals(300,k.getGewichtKg(),0);
	}

	@Test
	public void testBeladeWaggon() throws MaxCapacityExceededException {
		assertTrue(k.beladeWaggon(200));
	}
	
	@Test(expected = MaxCapacityExceededException.class)
	public void testMaxCapacityExceeded() throws MaxCapacityExceededException {
		assertFalse(k.beladeWaggon(1100));
	}

}
