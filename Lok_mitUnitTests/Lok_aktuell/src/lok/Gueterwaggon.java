package lok;

import lok.Waggon.MaxCapacityExceededException;

public class Gueterwaggon extends Waggon{
	
	public Gueterwaggon(float leergewichtKg, float maxKg) {
		super(leergewichtKg, maxKg);
	}
	
	public boolean fuegeHinzuGut(float kg) throws MaxCapacityExceededException {
		boolean result=false;
		result=beladeWaggon(kg);
			if(result){
			System.out.println("Gut mit "+kg+"kg hinzugef�gt");
		}
		return result;
	}
		
	public float getLeergewichtKg() {
		return super.getLeergewichtKg();
	}

	public float getGewichtKg() {
		return super.getGewichtKg();
	}


}
