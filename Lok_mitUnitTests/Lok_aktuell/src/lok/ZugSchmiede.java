package lok;

import lok.Lokomotive.LokException;

public class ZugSchmiede{
//---------------------Personenzug erstellen---------------------------
   static Lokomotive erstellePersonenZug(int lokZugkraft, int waggonLeergewicht, int waggonMaxPersonen, int waggonAnzahl) throws LokException {
        Lokomotive lok = new Lokomotive(lokZugkraft);
        for (int i = 0; i < waggonAnzahl-1; i++) {
            Personenwaggon p = new Personenwaggon(waggonLeergewicht, waggonMaxPersonen);
            lok.ankoppeln(p);
        }
        return lok;
    }
//---------------------Gueterzug erstellen--------------------------------
	static Lokomotive erstelleGueterZug(int lokZugkraft, int waggonLeergewicht, int waggonMaxGewicht, int waggonAnzahl) throws LokException{
		Lokomotive lok = new Lokomotive(lokZugkraft);
        for (int i = 0; i < waggonAnzahl-1; i++) {
            Gueterwaggon g = new Gueterwaggon(waggonLeergewicht, waggonMaxGewicht);
            lok.ankoppeln(g);
        }
        return lok;
	}
//---------------------Kippwaggon-Zug erstellen---------------------------------
	static Lokomotive erstelleKippwaggonZug(int lokZugkraft, int waggonLeergewicht, int waggonMaxGewicht, int waggonAnzahl) throws LokException{
		Lokomotive lok = new Lokomotive(lokZugkraft);
        for (int i = 0; i < waggonAnzahl-1; i++) {
            Kippwaggon k = new Kippwaggon(waggonMaxGewicht, waggonLeergewicht);
            lok.ankoppeln(k);
        }
        return lok;
	}
}