package pl.edu.pjwstk.s8267.GUI.Lab3;

public class Pies {
	private static final String header = "-------------------------------\n Pies wielorasowy\n-------------------------------\n";
	private int id, wiek;
	protected String imie, kolor, imieWlasciciela, nazwiskoWlasciciela;
	public Pies(int id, String imie, String kolor, int wiek, String imieWlasciciela,
			String nazwiskoWlasciciela) {
		this.id = id;
		this.imie = imie;
		this.kolor = kolor;
		this.wiek = wiek;
		this.imieWlasciciela = imieWlasciciela;
		this.nazwiskoWlasciciela = nazwiskoWlasciciela;
	}

	public static void main(String[] args) {
		Pies sfora[] = {
				new Pies(76589, "As", "biało-czarny", 18, "Anna", "Nowak"),
				new RasowyPies(45321, "Labrador", "Elf", "czarny", 25, "Agus",
						"Mati", "Barbara", "Klopotek"),
				new Pies(102467, "Kumpel", "brazowy, podpalany", 89, "Zennon",
						"Kula"),
				new RasowyPies(9678, "York", "Beta", "brazowy", 8, "Emka",
						"Fidelus", "Alicja", "Kot") };

		for (int i = 0; i < sfora.length; i++)
			System.out.println(sfora[i] + "\n\n");
	}
	
	public String toString() {
		return toString(header);
	}
	
	public String toString(String header) {
		String ret = header; 
		ret += String.format("identyfikator:         %08d\n", id);
		ret += String.format("WLASCICIEL: %s %s\n", imieWlasciciela, nazwiskoWlasciciela);
		ret += String.format("IMIE: %s\n", imie);
		ret += String.format("masc: %s\n", kolor);
		int lata = wiek/12;
		int miesiace = wiek%12;
		String lataString = "";
		if(lata == 1)
			lataString = "1 rok ";
		else if(lata < 5)
			lataString = lata+" lata ";
		else
			lataString = lata+" lat ";
		String miesiaceString = "";
		if(miesiace == 1)
			miesiaceString = "1 miesiac";
		else if(miesiace < 5)
			miesiaceString = lata+" miesiace";
		else
			miesiaceString = lata+" miesiecy";
		ret += String.format("wiek: %s%s\n", lataString, miesiaceString);
		ret += "-------------------------------";
		return ret;
	}
}
