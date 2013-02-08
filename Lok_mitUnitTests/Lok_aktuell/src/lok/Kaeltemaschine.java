package lok;

class Kaeltemaschine {
	
	protected boolean eingeschaltet;
	protected boolean ausschaltbar;
	
	public Kaeltemaschine(){
		this.eingeschaltet = false;
		this.ausschaltbar = true;
	}
	
	public void einschalten(){ this.eingeschaltet = true;}
	
	public void ausschalten(){ 
		if(this.ausschaltbar)this.eingeschaltet = false;
		else throw new RuntimeException("Waggon beladen: Kein Ausschalten moeglich!");
	}
	
}