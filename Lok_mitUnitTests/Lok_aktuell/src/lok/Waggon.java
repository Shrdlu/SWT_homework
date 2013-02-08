package lok;
abstract class Waggon{
	protected final float maxCapacity;
	protected final float leerGewichtKg;
	protected float ladungsGewichtKg;

	public Waggon(float leerGewicht, float maxGewicht){
		this.leerGewichtKg = leerGewicht;
		this.maxCapacity = maxGewicht;
		this.ladungsGewichtKg = 0;
	}
	
	public float getMaxCapacity() {
		return maxCapacity;
	}

	public float getLeergewichtKg() {
		return leerGewichtKg;
	}

	public float getGewichtKg() {
		return leerGewichtKg+ladungsGewichtKg;
	}
	
	protected boolean beladeWaggon(float kg) throws MaxCapacityExceededException{
		boolean result = false;
		if (getGewichtKg()+kg <= maxCapacity) {
			this.ladungsGewichtKg += kg;
			result = true;
		}
		if(!result) throw new MaxCapacityExceededException("Fehler: Gut mit "+kg+"kg kann nicht hinzugef�gt werden, da das max. Gewicht �berschritten werden w�rde!");
		return result;
	}
	
	public class MaxCapacityExceededException extends Exception {

	    public MaxCapacityExceededException(String message) {
	        super(message);
	    }
	}
	
}
