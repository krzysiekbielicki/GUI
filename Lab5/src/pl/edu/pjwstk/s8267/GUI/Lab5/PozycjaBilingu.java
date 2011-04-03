package pl.edu.pjwstk.s8267.GUI.Lab5;

import java.text.DecimalFormat;
import java.util.Arrays;

public class PozycjaBilingu implements Comparable<PozycjaBilingu> {
	public static final int KEY_TIME = 1;
	public static final int KEY_LENGTH = 2;
	public static final int KEY_NAME = 3;
	public static final DecimalFormat timeFormat = new DecimalFormat("00");
	
	private static int sortKey = KEY_TIME;
	private String kto;
	private int godz;
	private int min;
	private int czas;

	public PozycjaBilingu(String kto, int godz, int min, int czas) {
		this.kto = kto;
		this.godz = godz;
		this.min = min;
		this.czas = czas;
	}

	public static void setSortKey(int sort) {
		sortKey = sort;
	}

	@Override
	public int compareTo(PozycjaBilingu o) {
		switch(sortKey) {
		case KEY_LENGTH:
			return czas - o.czas;
		case KEY_NAME:
			return kto.compareToIgnoreCase(o.kto);
		default:
		case KEY_TIME:
			return godz*60+min - o.godz*60+o.min;
		}
	}
	
	public String toString() {
		return String.format("%6s start(godz:min): %2d:%2s  czas polaczenia (min:sek): %2d:%2s", kto, godz, timeFormat.format(min), czas/60, timeFormat.format(czas%60));
	}
	
	public static void main(String[] args) {
		PozycjaBilingu biling[] = { new PozycjaBilingu("Arek", 5, 59, 94),
				new PozycjaBilingu("Zosia", 17, 5, 61),
				new PozycjaBilingu("Mat", 12, 0, 180) };
		for (PozycjaBilingu b : biling)
			System.out.println(b);
		
		System.out.println();
		
		PozycjaBilingu.setSortKey(PozycjaBilingu.KEY_TIME);
		Arrays.sort(biling);
		for (PozycjaBilingu b : biling)
			System.out.println(b);
		
		System.out.println();
		
		PozycjaBilingu.setSortKey(PozycjaBilingu.KEY_LENGTH);
		Arrays.sort(biling);
		for (PozycjaBilingu b : biling)
			System.out.println(b);

		System.out.println();
		
		PozycjaBilingu.setSortKey(PozycjaBilingu.KEY_NAME);
		Arrays.sort(biling);
		for (PozycjaBilingu b : biling)
			System.out.println(b);
	}
}
