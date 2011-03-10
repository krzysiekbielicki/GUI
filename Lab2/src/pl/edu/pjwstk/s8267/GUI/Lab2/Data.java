package pl.edu.pjwstk.s8267.GUI.Lab2;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Data {

	private int dzien;
	private int miesiac;
	private int rok;
	private static final String[] miesiacString = { "stycznia", "lutego",
			"marca", "kwietnia", "maja", "czerwca", "lipca", "sierpnia",
			"wrzesnia", "pazdziernika", "listopada", "grudnia" };

	public Data(int dzien, int miesiac, int rok) {
		this.dzien = dzien;
		this.miesiac = miesiac;
		this.rok = rok;
	}

	public Data(Data kiedy) {
		dzien = kiedy.dzien;
		miesiac = kiedy.miesiac;
		rok = kiedy.rok;
	}

	public void zmienDzien(int i) {
		dzien = i;
	}

	public void zmienMiesiac(int i) {
		miesiac = i;
	}
	
	public void zmienRok(int i) {
		rok = i;
	}

	public void przesun(int i) {
		GregorianCalendar gc = new GregorianCalendar(rok, miesiac, dzien);
		gc.add(Calendar.DAY_OF_MONTH, i);
		dzien = gc.get(Calendar.DAY_OF_MONTH);
		miesiac = gc.get(Calendar.MONTH);
		rok = gc.get(Calendar.YEAR);
	}

	public String toString() {
		return String.format("%d %s %d", dzien, miesiacString[miesiac-1], rok);
	}
}
