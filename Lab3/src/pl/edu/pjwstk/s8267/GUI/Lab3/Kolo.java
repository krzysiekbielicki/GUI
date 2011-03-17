package pl.edu.pjwstk.s8267.GUI.Lab3;

public class Kolo extends Figura {

	private int r;

	public Kolo(String kolor, int r) {
		super(kolor);
		this.r = r;
	}

	@Override
	public double getPowierzchnia() {
		return Math.PI*r*r;
	}

	@Override
	public double getObwod() {
		return 2*Math.PI*r;
	}

}
