package pl.edu.pjwstk.s8267.GUI.Lab2;

public class Bilet {

	private String co;
	private String gdzie;
	private Data kiedy;

	public Bilet(String co, String gdzie, Data kiedy) {
		this.co = co;
		this.gdzie = gdzie;
		this.kiedy = new Data(kiedy);
	}

	public Data podajDate() {
		return new Data(kiedy);
	}
	
	public String toString() {
		return String.format("%1$6s:  %4$s\n%2$s:  %5$s\n%3$s:  %6$s", "Co", "Gdzie", "Kiedy", co, gdzie, kiedy);
	}
	
	public static void main(String[] args) {
		Data data1 = new Data(30, 4, 2002);
		Bilet impreza1 = new Bilet("koncert Petera Gabriela", "Poznan", data1);

		data1.zmienDzien(6);
		data1.zmienMiesiac(12);
		data1.zmienRok(2004);
		Bilet impreza2 = new Bilet("koncert Diany Krall", "Warszawa", data1);

		Data data2 = impreza2.podajDate();

		data2.przesun(30);
		Bilet impreza3 = new Bilet("Urodziny Panny X", "magiczne miejsce",
				data2);

		System.out.println(impreza1);

		System.out.println(impreza2);

		System.out.println(impreza3);
	}
}
