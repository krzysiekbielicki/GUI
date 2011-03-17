package pl.edu.pjwstk.s8267.GUI.Lab3;

public abstract class Figura {
	
	private String kolor;

	public Figura(String kolor) {
		this.kolor = kolor;
	}

	private String getKolor() {
		return kolor;
	}

	private String getKsztalt() {
		return getClass().getSimpleName();
	}

	public abstract double getPowierzchnia();
	public abstract double getObwod();
	
	public static void main(String[] args) {
		Figura sumaNieszczesc[] = { new Kwadrat("red", 5), // bok
				new Trapez("green", 10, 8, 4), // podstawa dolna, gorna,
												// wysokosc
				new Kolo("yellow", 12), // promien
				new Prostokat("grey", 7, 10), // boki
				new Trojkat("white", 7, 4, 9) // boki
		};

		for (int i = 0; i < sumaNieszczesc.length; i++) {
			System.out.println("\n\n---------------");
			System.out.println("      FIGURA: "
					+ sumaNieszczesc[i].getKsztalt());
			System.out.println("       Kolor: " + sumaNieszczesc[i].getKolor());
			System.out.println("Powierzchnia: "
					+ sumaNieszczesc[i].getPowierzchnia() + " cm^2");
			System.out.println("       Obwod: " + sumaNieszczesc[i].getObwod()
					+ " cm");
		}
	}
}
