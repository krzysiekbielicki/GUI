package pl.edu.pjwstk.s8267.GUI.Lab3;

public class Kwadrat extends Figura {
	private int bok;
	public Kwadrat(String kolor, int bok) {
		super(kolor);
		this.bok = bok;
	}

	@Override
	public double getPowierzchnia() {
		return bok*bok;
	}

	@Override
	public double getObwod() {
		return 4*bok;
	}

}
