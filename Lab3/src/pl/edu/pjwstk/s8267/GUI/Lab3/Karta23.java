package pl.edu.pjwstk.s8267.GUI.Lab3;

public class Karta23 extends Karta {

	private String specjalizacja;

	public Karta23(String imie, String nazwisko, int grupa, int przedmioty, String specjalizacja) {
		super(imie, nazwisko, grupa, przedmioty);
		this.specjalizacja = specjalizacja;
	}
	
	public void setSpecjalnosc(String specjalnosc) throws Exception {
		if(grupa/100 < 3 && grupa/100 > 4 && grupa/100 < 6)
			throw new Exception("Specjalność można zmieniać tylko na semestrach 3,4,6...");
		this.specjalizacja = specjalnosc;
	}
	
	public String toString() {
		return toString("");
	}
	
	protected String toString(String more) {
		return super.toString("    SPECJALNOŚĆ: "+specjalizacja+"\n"+more);
	}

}
