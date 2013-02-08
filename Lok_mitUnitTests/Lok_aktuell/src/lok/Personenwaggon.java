package lok;

import java.util.ArrayList;
import java.util.List;

import lok.DieselLokomotive.LokException;
import lok.DieselLokomotive.LokStehtNichtException;

public class Personenwaggon extends Waggon{


	private List<String> personen;
	private final int GEWICHT_PRO_PERSON_KG = 80;
	
	/**
	 * @param leergewicht
	 * @param maxPersonen
	 */
	public Personenwaggon(float leergewicht, int maxPersonen) {
		super(leergewicht, maxPersonen);	
		this.personen = new ArrayList<String>();
	}

	public boolean fuegeHinzuPerson(String name) throws MaxPersonenException{
		boolean result = false;
		if (personen.size() < maxCapacity) {
			personen.add(name);
			ladungsGewichtKg+=GEWICHT_PRO_PERSON_KG;			
			result = true;
			System.out.println("Person \"" + name + "\" hinzugef�gt");
		} else {
			throw new MaxPersonenException("Fehler: Person \""
							+ name
							+ "\" kann nicht hinzugef�gt werden, da die max. Personenzahl �berschritten werden w�rde!");
		}
		return result;
		
	}

	public int getMaxPersonen() {
		return (int)maxCapacity;
	}

	public class MaxPersonenException extends Exception {

	    public MaxPersonenException(String message) {
	        super(message);
	    }	    
	}



}
