package pl.edu.pjwstk.s8267.GUI.Lab6;

public class ShoppingItem extends pl.edu.pjwstk.s8267.GUI.Lab5.ShoppingItem {

	private String currency;

	public ShoppingItem(String nazwa, double cena) {
		this(nazwa, cena, "PLN");
	}

	public ShoppingItem(String nazwa, double cena, String currency) {
		super(nazwa, cena);
		this.currency = currency;
	}

	public void show(int i, ExchangeRate[] exchangeTable) {
		show(i, "PLN", exchangeTable);
	}

	public static void printFooter(ShoppingItem[] items, String currency,
			ExchangeRate[] exchangeTable) {
		double total = 0;
		for(ShoppingItem i : items) {
			total += i.exchange(currency, exchangeTable);
		}
		System.out.println("------------------------------------");
		System.out.println(String.format("%25s %6.2f %s", "RAZEM:", total, currency));
	}

	public static void printFooter(ShoppingItem[] items, ExchangeRate[] exchangeTable) {
		printFooter(items, "PLN", exchangeTable);
	}

	public void show(int nr, String currency, ExchangeRate[] exchangeTable) {
		System.out.println(String.format("%3d. %20s %6.2f %s --> %6.2f %s", nr, nazwa, cena, this.currency, exchange(currency, exchangeTable), currency));
	}
	
	public void show(int nr) {
		System.out.println(String.format("%3d. %20s %6.2f %s", nr, nazwa, cena, currency));
	}
	
	private double exchange(String currency, ExchangeRate[] table) {
		double value = cena;
		for(ExchangeRate er : table) {
			if(er.getName().equals(this.currency)) {
				value *= er.getExchange();
			}
			if(er.getName().equals(currency)) {
				value /= er.getExchange();
			}
		}
		return value;
	}

	public static void main(String[] args) {
		ExchangeRate[] exchangeTable = { new ExchangeRate("USD", 3.1994),
				new ExchangeRate("CAD", 2.6394),
				new ExchangeRate("EUR", 4.1449),
				new ExchangeRate("CHF", 2.6755),
				new ExchangeRate("GBP", 6.0233),
				new ExchangeRate("NOK", 0.5048), new ExchangeRate("SEK", 04533) };

		ShoppingItem[] items = { new ShoppingItem("pieczywo", 4.3),
				new ShoppingItem("czasopisma", 3, "USD") };

		for (int i = 0; i < items.length; i++)
			items[i].show(i + 1);

		for (int i = 0; i < items.length; i++)
			items[i].show(i + 1, "GBP", exchangeTable);

		printFooter(items, "GBP", exchangeTable);

		for (int i = 0; i < items.length; i++)
			items[i].show(i + 1, exchangeTable);

		printFooter(items, exchangeTable);

		for (int i = 0; i < items.length; i++)
			items[i].show(i + 1, "NOK", exchangeTable);

		printFooter(items, "NOK", exchangeTable);
	}
}
