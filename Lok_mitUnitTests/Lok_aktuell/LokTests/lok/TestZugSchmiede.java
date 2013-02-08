package lok;

import static org.junit.Assert.*;
import lok.Lokomotive.LokException;

import org.junit.Before;
import org.junit.Test;

public class TestZugSchmiede {	
	
	private Lokomotive zug;
	
	@Before
	public void setUp() throws Exception {
	
		
	}

	@Test
	public void testErstellePersonenZug() throws LokException {
		zug = ZugSchmiede.erstellePersonenZug(2000, 300, 5, 4);
		assertEquals(2000,zug.getZugkraftKg(),0);
	}

	@Test
	public void testErstelleGueterZug() throws LokException {
		zug = ZugSchmiede.erstelleGueterZug(2000, 300, 600, 4);
		assertEquals(2000,zug.getZugkraftKg(),0);
	}

	@Test
	public void testErstelleKippwaggonZug() throws LokException {
		zug = ZugSchmiede.erstelleKippwaggonZug(2000, 300, 600, 4);
		assertEquals(2000,zug.getZugkraftKg(),0);
	}

}
