package lok;

import static org.junit.Assert.*;
import java.util.Date;



import lok.Gueterwaggon;
import lok.Kippwaggon;
import lok.DieselLokomotive;
import lok.DieselLokomotive.KeinLokfuehrerException;
import lok.DieselLokomotive.LokException;
import lok.DieselLokomotive.LokFaehrtException;
import lok.DieselLokomotive.LokStehtException;
import lok.DieselLokomotive.LokStehtNichtException;
import lok.DieselLokomotive.WaggonsZuSchwerException;

import org.junit.Before;
import org.junit.Test;

public class TestLokomotive {

	private DieselLokomotive lok;
	private Gueterwaggon g;
	private Kippwaggon k;
	private Date d;

	@Before
	public void setUp() throws Exception {
		lok = new DieselLokomotive(2000);
		g = new Gueterwaggon(300,1000);
		k = new Kippwaggon(300,1000);
		d = new Date();
	}

	@Test
	public void testLokomotive() {
		assertEquals(2000,lok.getZugkraftKg(),0);

	}
	
	@Test
	public void testLosfahren() throws LokException {
		lok.ankoppeln(k);
		//losfahren mit Lokfuehrer
		lok.lokfuehrerSteigtEin("Max", "123", d);
		lok.losfahren();
		
	}
	
	@Test(expected = KeinLokfuehrerException.class)
	public void testLosfahrenOhneLokfuehrer() throws LokException {
		lok.ankoppeln(k);
		//losfahren ohne Lokfuehrer
		lok.losfahren();
		
	}
	
	@Test(expected = WaggonsZuSchwerException.class)
	public void testLosfahrenWaggonsZuSchwer() throws LokException {
		Kippwaggon kipp = new Kippwaggon(2100,3000);
		lok.lokfuehrerSteigtEin("Max", "123", d);
		lok.ankoppeln(k);
		lok.ankoppeln(kipp);
		//Waggons zu schwer
		lok.losfahren();
		
	}
	
	@Test(expected = LokFaehrtException.class)
	public void testLosfahrenLokFaehrtBereits() throws LokException {
		
		lok.lokfuehrerSteigtEin("Max", "123", d);
		lok.ankoppeln(k);		
		lok.losfahren();
		//Lok fährt bereits
		lok.losfahren();
		
	}

	@Test
	public void testAnhalten() throws LokException {
		lok.ankoppeln(k);
		lok.lokfuehrerSteigtEin("Max", "123", d);
		lok.losfahren();
		lok.anhalten();
	}
	
	@Test(expected = LokStehtException.class)
	public void testAnhaltenLokSteht() throws LokException {
		lok.ankoppeln(k);
		//Lok steht bereits
		lok.anhalten();
	}

	@Test
	public void testAnkoppeln() throws LokException {
		//STATUS_HAELT
		lok.ankoppeln(g);
		
	}

	@Test(expected = LokStehtNichtException.class)
	public void testAnkoppelnException() throws LokException {
		
		// !STATUS_HAELT
		lok.lokfuehrerSteigtEin("Max", "123", d);
		lok.losfahren();
		lok.ankoppeln(k);
	}

	@Test(expected = LokStehtNichtException.class)
	public void testAbkoppeln() throws LokException {
		//STATUS_HAELT
		lok.abkoppeln(g);


		// !STATUS_HAELT
		
		lok.lokfuehrerSteigtEin("Max", "123", d);		
		lok.losfahren();
		lok.abkoppeln(k);
	}

	
	@Test
	public void testLokfuehrerSteigtAus() {
		lok.lokfuehrerSteigtEin("Max", "123", d);
		lok.lokfuehrerSteigtAus();
		assertNull(lok.getLokfuehrerName());
	}

	@Test
	public void testGetZugkraftKg() {
		assertEquals(2000,lok.getZugkraftKg(),0);
	}

	@Test
	public void testGetLokfuehrerName() {
		lok.lokfuehrerSteigtEin("Max", "123", d);
		assertEquals("Max",lok.getLokfuehrerName());
	}

}
