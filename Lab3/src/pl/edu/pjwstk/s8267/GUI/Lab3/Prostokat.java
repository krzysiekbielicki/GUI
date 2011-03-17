package pl.edu.pjwstk.s8267.GUI.Lab3;

public class Prostokat extends Figura {

	private int a;
	private int b;

	public Prostokat(String kolor, int a, int b) {
		super(kolor);
		this.a = a;
		this.b = b;
	}

	@Override
	public double getPowierzchnia() {
		return a*b;
	}

	@Override
	public double getObwod() {
		return (a+b)*2;
	}

}
