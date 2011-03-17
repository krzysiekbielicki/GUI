package pl.edu.pjwstk.s8267.GUI.Lab3;

public class RasowyPies extends Pies {
	private static final String header = "-------------------------------\n Pies rasowy\n-------------------------------\n";
	
	private String rasa;
	private String imieOjca;
	private String imieMatki;

	public RasowyPies(int id, String rasa, String imie, String kolor, int wiek, String imieOjca, String imieMatki, String imieWlasciciela,
			String nazwiskoWlasciciela) {
		super(id, imie, kolor, wiek, imieWlasciciela, nazwiskoWlasciciela);
		this.rasa = rasa;
		this.imieOjca = imieOjca;
		this.imieMatki = imieMatki;
	}
	
	public String toString() {
		String ret = super.toString(header);
		ret += String.format("\nRASA: %s\n", rasa);
		ret += String.format("MATKA: %s\n", imieMatki);
		ret += String.format("OJCIEC: %s\n", imieOjca);
		ret += String.format("MIOT: %d\n", imie.charAt(0)-'A'+1);
		ret += "-------------------------------";
		return ret;
	}

}
