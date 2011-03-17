package pl.edu.pjwstk.s8267.GUI.Lab3;

public class Karta45 extends Karta23 {

	private String promotor;

	public Karta45(String imie, String nazwisko, int grupa, int przedmioty, String specjalizacja, String promotor) {
		super(imie, nazwisko, grupa, przedmioty, specjalizacja);
		this.promotor = promotor;
	}
	
	public String toString() {
		return super.toString("       PROMOTOR: "+promotor+"\n");
	}

}
