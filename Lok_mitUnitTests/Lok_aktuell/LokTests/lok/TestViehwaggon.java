package lok;

import static org.junit.Assert.*;
import lok.Viehwaggon;
import lok.Waggon.MaxCapacityExceededException;

import org.junit.Before;
import org.junit.Test;

public class TestViehwaggon {

	private Viehwaggon vieh;

	@Before
	public void setUp() throws Exception {
		vieh = new Viehwaggon(100,2000,5);		
	}

	@Test
	public void testViehwaggon() {
		Viehwaggon v = new Viehwaggon(100,2100,10);

		assertEquals(100,v.leerGewichtKg,0);
		assertEquals(2100,v.maxCapacity,0);
		assertEquals(10,v.getMaxVieh(),0);
	}

	@Test
	public void testFuegeHinzuVieh() throws MaxCapacityExceededException {
		assertTrue(vieh.fuegeHinzuVieh(200));
		assertEquals(200,vieh.ladungsGewichtKg,0);

	}
	
	@Test(expected = MaxCapacityExceededException.class)
	public void testMaxCapacityExceededException() throws MaxCapacityExceededException {
		assertFalse(vieh.fuegeHinzuVieh(3000));		
	}
	
	@Test
	public void testMaxViehExceeded() throws MaxCapacityExceededException {
		assertTrue(vieh.fuegeHinzuVieh(100));
		assertTrue(vieh.fuegeHinzuVieh(100));
		assertTrue(vieh.fuegeHinzuVieh(100));
		assertTrue(vieh.fuegeHinzuVieh(100));
		assertTrue(vieh.fuegeHinzuVieh(100));
		//passt nicht mehr
		assertFalse(vieh.fuegeHinzuVieh(100));
	}

	@Test
	public void testGetMaxVieh() {
		assertEquals(5, vieh.getMaxVieh());
	}

}
