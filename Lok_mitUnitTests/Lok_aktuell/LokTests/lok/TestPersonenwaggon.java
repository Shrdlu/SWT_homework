package lok;

import static org.junit.Assert.*;
import lok.Personenwaggon;
import lok.Personenwaggon.MaxPersonenException;

import org.junit.Before;
import org.junit.Test;


public class TestPersonenwaggon {

	private Personenwaggon pw;
	
	@Before
	public void setUp() throws Exception {
		pw = new Personenwaggon(200,5);
	}
	
	@Test
	public void testPersonenwaggon() {
		assertEquals(200,pw.getLeergewichtKg(),0);
		assertEquals(5,pw.getMaxPersonen(),0);		
		
	}

	@Test
	public void testFuegeHinzuPerson() throws MaxPersonenException {
		assertTrue(pw.fuegeHinzuPerson("Meyer"));
		assertEquals(80,pw.ladungsGewichtKg,0);
	}
	
	@Test(expected = MaxPersonenException.class)
	public void testMaxPersonenException() throws MaxPersonenException {
		assertTrue(pw.fuegeHinzuPerson("Meyer1"));
		assertTrue(pw.fuegeHinzuPerson("Meyer2"));
		assertTrue(pw.fuegeHinzuPerson("Meyer3"));
		assertTrue(pw.fuegeHinzuPerson("Meyer4"));
		assertTrue(pw.fuegeHinzuPerson("Meyer5"));
		assertFalse(pw.fuegeHinzuPerson("Meyer6"));
		assertEquals(400,pw.ladungsGewichtKg,0);
	}

	@Test
	public void testGetMaxPersonen() {
		assertEquals(5,pw.getMaxPersonen());
		
	}

}
