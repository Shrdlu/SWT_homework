package lok;

import lok.Waggon.MaxCapacityExceededException;

public class Viehwaggon extends Waggon{

	private final int maxVieh;
	private int vieh;

	/**
	 * @param leerGewichtKg
	 * @param maxKg	 
	 * @param maxVieh
	 */
	public Viehwaggon(float leerGewichtKg, float maxKg, int maxVieh) {		super(leerGewichtKg, maxKg);
		this.maxVieh = maxVieh;		
		this.vieh = 0;
	}

	public boolean fuegeHinzuVieh(float kg) throws MaxCapacityExceededException {
		boolean result = false;
		if (result=beladeWaggon(kg) && (this.vieh + 1 <= this.maxVieh)) {			
			this.vieh++;
			result = true;
			System.out.println(this.vieh +". Vieh mit "+kg+"kg hinzugef�gt");
		}		
		return result;
	}


	public int getMaxVieh() {
		return maxVieh;
	}

	

}
