package lok;

public class Kippwaggon extends Waggon{

	private boolean gekippt;

	/**
	 * @param maxKg
	 * @param leerGewichtKg	 
	 */
	public Kippwaggon(float leerGewichtKg, float maxKg) {
		super(leerGewichtKg, maxKg);
		this.gekippt = false;
	}// constructor

	public boolean beladen(float kg) throws WaggonGekipptException, MaxCapacityExceededException{
		boolean result = false;
		//try{
		if (this.isGekippt()) {
			
			throw new WaggonGekipptException("Fehler: Beladung nicht m�glich, da der Waggon noch gekippt ist!");
			
		} else {
			if (result=beladeWaggon(kg)) {				
				System.out.println("Weitere " + kg
						+ "kg der Ladung hinzugef�gt.");
			} 
		}// if
		//}
		//catch(WaggonGekipptException w){
		//	System.out.println(w.getMessage());
		//}
		//catch(MaxCapacityExceededException m){
		//	System.out.println(m.getMessage());
		//}
		return result;
	}// beladen

	public void kippen() {
		this.ladungsGewichtKg = 0;
		this.gekippt = true;
	}// kippen

	/**
	 * Aufrichten der Beladefl�che. Damit ist der Kippwaggon bereit, neu beladen
	 * zu werden.
	 */
	public void aufrichten() {
		this.gekippt = false;
	}// aufrichten

	public boolean isGekippt() {
		return this.gekippt;
	}// isGekippt

	public class WaggonGekipptException extends Exception {

	    public WaggonGekipptException(String message) {
	        super(message);
	    }	   
	}
	
	
	
}// class


