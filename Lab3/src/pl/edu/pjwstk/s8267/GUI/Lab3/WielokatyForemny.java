package pl.edu.pjwstk.s8267.GUI.Lab3;

public class WielokatyForemny extends Figura {

	private int n;
	private double r;

	public WielokatyForemny(String kolor, int n, double r) {
		super(kolor);
		this.n = n;
		this.r = r;
	}

	@Override
	public double getPowierzchnia() {
		return r*r*Math.sin(2*Math.PI/n)*n;
	}

	@Override
	public double getObwod() {
		return 2*n*r*Math.sin(2*Math.PI/n);
	}
}
