package pl.edu.pjwstk.s8267.GUI.Lab1;

import java.util.Arrays;

public class Klocek {
	private String kolor;
	private int szerokosc;
	private int dlugosc;
	private int wysokosc;

	public Klocek(String kolor, int x, int y, int z) {
		this.kolor = kolor;
		int[] wymiary = new int[] {x, y, z};
		Arrays.sort(wymiary);
		this.szerokosc = wymiary[2];
		this.dlugosc = wymiary[1];
		this.wysokosc = wymiary[0];
	}
	
	public String toString() {
		return String.format("klocek: %s, podstawa: %dcm x %dcm, grubosc: $d cm", kolor, szerokosc, dlugosc, wysokosc);
	}
}
