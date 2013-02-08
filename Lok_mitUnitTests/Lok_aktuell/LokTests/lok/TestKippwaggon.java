package lok;

import static org.junit.Assert.*;
import lok.Kippwaggon.WaggonGekipptException;
import lok.Waggon.MaxCapacityExceededException;

import org.junit.Before;
import org.junit.Test;

public class TestKippwaggon {

	private Kippwaggon kipp;
	
	@Before
	public void setUp() throws Exception {
		kipp = new Kippwaggon(100,2000);
	}

	@Test
	public void testKippwaggon() {		
		assertFalse(kipp.isGekippt());
		assertEquals(100,kipp.leerGewichtKg,0);
		assertEquals(2000,kipp.maxCapacity,0);
	}

	@Test
	public void testBeladen() throws WaggonGekipptException, MaxCapacityExceededException {
		assertTrue(kipp.beladen(100));
	}
	
	@Test(expected=WaggonGekipptException.class)
	public void testBeladenWaggonGekippt() throws WaggonGekipptException, MaxCapacityExceededException {
		kipp.kippen();
		assertFalse(kipp.beladen(100));
	}
	
	@Test(expected=MaxCapacityExceededException.class)
	public void testBeladenMaxCapacityExceeded() throws WaggonGekipptException, MaxCapacityExceededException {		
		assertFalse(kipp.beladen(2100));
	}

	@Test
	public void testKippen() {
		kipp.kippen();
		assertTrue(kipp.isGekippt());
		assertEquals((float) 0, kipp.ladungsGewichtKg,0);
	}

	@Test
	public void testAufrichten() {
		kipp.kippen();
		kipp.aufrichten();
		assertFalse(kipp.isGekippt());
	}

	@Test
	public void testIsGekippt() {
		kipp.kippen();
		assertTrue(kipp.isGekippt());
		kipp.aufrichten();
		assertFalse(kipp.isGekippt());
	}

}
