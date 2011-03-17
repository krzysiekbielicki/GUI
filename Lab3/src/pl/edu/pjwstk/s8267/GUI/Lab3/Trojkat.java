package pl.edu.pjwstk.s8267.GUI.Lab3;

public class Trojkat extends Figura {

	private int a;
	private int b;
	private int c;

	public Trojkat(String kolor, int a, int b, int c) {
		super(kolor);
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public double getPowierzchnia() {
		double p = (a+b+c)/2;
		return Math.sqrt(p*(p-a)*(p-b)*(p-c));
	}

	@Override
	public double getObwod() {
		return a+b+c;
	}

}
