package lok;

import lok.Waggon.MaxCapacityExceededException;

public class GueterTest {
		
	
	
	static void testeFuegeHinzu() throws MaxCapacityExceededException{
		Gueterwaggon g = new Gueterwaggon(100,1000);
		g.fuegeHinzuGut(200);
		g.fuegeHinzuGut(2000);
	}
	
	public static void main(String[] args) {
		try {
			GueterTest.testeFuegeHinzu();
		} catch (MaxCapacityExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
