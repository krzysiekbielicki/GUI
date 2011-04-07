package pl.edu.pjwstk.s8267.GUI.Lab6;

public class ExchangeRate {

	private String name;
	private double exchange;

	public ExchangeRate(String name, double exchange) {
		this.name = name;
		this.exchange = exchange;
	}

	public String getName() {
		return name;
	}

	public double getExchange() {
		return exchange;
	}

}
