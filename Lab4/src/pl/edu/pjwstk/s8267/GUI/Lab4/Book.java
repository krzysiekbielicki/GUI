package pl.edu.pjwstk.s8267.GUI.Lab4;

public class Book implements MultiLingual {

	private String tytul;
	private String autor;
	private String wydawnictwo;
	private int lang;
	private int rok;

	public Book(String tytul, String autor, String wydawnictwo, int rok) {
		this(tytul, autor, wydawnictwo, rok, 0);
	}
	
	public Book(String tytul, String autor, String wydawnictwo, int rok, int lang) {
		this.tytul = tytul;
		this.autor = autor;
		this.wydawnictwo = wydawnictwo;
		this.rok = rok;
		this.lang = lang;
	}
	
	@Override
	public String get(int lang) {
		switch(lang) {
		case MultiLingual.PL:
			return String.format("Autor: %s\nTytuł: %s\nWydawnictwo: %s %d", autor, tytul, wydawnictwo, rok);
		case MultiLingual.ENG:
			return String.format("Author: %s\nTitle: %s\nPublishing House: %s %d", autor, tytul, wydawnictwo, rok);
		}
		return null;
	}
	
	public String toString() {
		return get(lang);
	}

}
