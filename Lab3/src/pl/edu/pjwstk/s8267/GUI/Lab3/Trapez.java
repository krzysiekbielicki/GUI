package pl.edu.pjwstk.s8267.GUI.Lab3;

public class Trapez extends Figura {

	private int a;
	private int b;
	private int h;

	public Trapez(String kolor, int a, int b, int h) {
		super(kolor);
		this.a = a;
		this.b = b;
		this.h = h;
	}

	@Override
	public double getPowierzchnia() {
		return ((a+b)*h/2);
	}

	@Override
	public double getObwod() {
		int c = (a-b)*(a-b);
		return Math.sqrt((c*c)+(h*h))+a+b+h;
	}

}
