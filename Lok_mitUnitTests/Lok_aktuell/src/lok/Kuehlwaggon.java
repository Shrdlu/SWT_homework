package lok;

import lok.Waggon.MaxCapacityExceededException;

class Kuehlwaggon extends Gueterwaggon{
	
	private Kaeltemaschine kaltHalten;
	
	public Kuehlwaggon(float leergewichtKg, float maxKg){
		super(leergewichtKg,maxKg);
		this.kaltHalten = new Kaeltemaschine();
		kaltHalten.einschalten();
	}
	
	public boolean fuegeHinzuGut(float Kg) throws MaxCapacityExceededException{
		if(!this.kaltHalten.eingeschaltet)return false;
		else {
			this.kaltHalten.ausschaltbar = false;
			return super.fuegeHinzuGut(Kg);
		}
	}
		
		public void ausschaltenKaeltemaschine(){
			kaltHalten.ausschalten();
			
		}
		
		public void einschaltenKaeltemaschine(){
			kaltHalten.einschalten();
			
		}
	
	
}