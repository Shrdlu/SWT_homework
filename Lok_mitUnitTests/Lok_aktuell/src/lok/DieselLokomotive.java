package lok;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DieselLokomotive {

	private static final int STATUS_HAELT = 0;
	private static final int STATUS_FAEHRT = 1;

	private final float zugkraftKg; 
	private int lokStatus; 
	private String lokfuehrerName;
	private String lokfuehrerId;
	private Date lokfuehrerSeit;
	private final List<Waggon> waggons; 

	public DieselLokomotive(float zugkraft) {
		this.zugkraftKg = zugkraft;
		this.waggons = new ArrayList<Waggon>();
		this.lokStatus = STATUS_HAELT;
	}

	public void losfahren() throws LokException {
		if (this.lokStatus == STATUS_HAELT) {
			if (lokfuehrerName != null) {

				float gewicht = 0;
				for (Waggon w : waggons) {
					gewicht += w.getGewichtKg();
				}// for

				if (gewicht <= zugkraftKg) {
					this.lokStatus = STATUS_FAEHRT;
					System.out.println("Die Lok f�hrt los! Die Last betraegt "
							+ gewicht + "kg");
				} else {
					throw new WaggonsZuSchwerException("Fehler: Lokomotive kann nicht losfahren, da die Waggons zu schwer sind. Es m�ssen Waggons abgekoppelt werden!");
				} // if else

			} else {
				throw new KeinLokfuehrerException("Fehler: Kein Lokfuehrer vorhanden!");
			}// if else
		} else {
			throw new LokFaehrtException("Die Lok faehrt bereits!");
		}// if else

	}// losfahren

	public void anhalten() throws LokException{
		if (this.lokStatus == STATUS_FAEHRT) {
			this.lokStatus = STATUS_HAELT;
			System.out.println("Die Lok h�lt an");
		} else {
			throw new LokStehtException("Die Lok steht bereits!");
		}
	}// anhalten

	public void ankoppeln(Waggon waggon) throws LokException{
		if (this.lokStatus == STATUS_HAELT) {
			if (!this.waggons.contains(waggon))
				this.waggons.add(waggon);
		} else {
			throw new LokStehtNichtException("Fehler: Waggons k�nnen nur angekoppelt werden, wenn die Lok steht!");
		}
	}

	public void abkoppeln(Waggon waggon)throws LokException{
		if (this.lokStatus == STATUS_HAELT) {
			this.waggons.remove(waggon);
		} else {
			throw new LokStehtNichtException("Fehler: Waggons k�nnen nur abgekoppelt werden, wenn die Lok steht!");
		}

	}// abkoppeln

	public void lokfuehrerSteigtEin(String name, String lokfuehrerId,
			Date lokfuehrerSeit) {		
		this.lokfuehrerName = name;
		this.lokfuehrerId = lokfuehrerId;
		this.lokfuehrerSeit = lokfuehrerSeit;
	}// lokfuehrerSteigtEin

	public void lokfuehrerSteigtAus() {
		this.lokfuehrerName = null;
		this.lokfuehrerId = null;
		this.lokfuehrerSeit = null;
	}// lokfuehrerSteigtAus

	public float getZugkraftKg() {
		return zugkraftKg;
	}// getZugkraftKg

	public String getLokfuehrerName() {
		return lokfuehrerName;
	}// getLokfuehrerName

	
	public class LokException extends Exception {

	    public LokException(String message) {
	        super(message);
	    }	    
	}
	
	public class WaggonsZuSchwerException extends LokException {

	    public WaggonsZuSchwerException(String message) {
	        super(message);
	    }	    
	}
	
	public class KeinLokfuehrerException extends LokException {

	    public KeinLokfuehrerException(String message) {
	        super(message);
	    }	    
	}
	
	public class LokFaehrtException extends LokException {

	    public LokFaehrtException(String message) {
	        super(message);
	    }	    
	}
	
	public class LokStehtException extends LokException {

	    public LokStehtException(String message) {
	        super(message);
	    }	    
	}
	
	public class LokStehtNichtException extends LokException {

	    public LokStehtNichtException(String message) {
	        super(message);
	    }	    
	}
}
