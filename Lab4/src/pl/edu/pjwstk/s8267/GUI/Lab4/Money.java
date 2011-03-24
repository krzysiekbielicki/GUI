package pl.edu.pjwstk.s8267.GUI.Lab4;

public class Money implements MultiLingual {

	private double money;
	private int lang;

	public Money(double money, int lang) {
		this.money = money;
		this.lang = lang;
	}

	@Override
	public String get(int lang) {
		switch(lang) {
		case MultiLingual.PL:
			if(money/1000 == 0)
				return String.format("%d,%2d PLN", (int)Math.floor(money)%1000, (int) ((money-Math.floor(money))*100) );
			else
				return String.format("%d %d,%2d PLN", (int) money/1000, (int)Math.floor(money)%1000, (int) ((money-Math.floor(money))*100) );
		case MultiLingual.ENG:
			if(money/1000 == 0)
				return String.format("%d.%2d GBP", (int)Math.floor(money)%1000, (int)((money-Math.floor(money))*100));
			else
				return String.format("%d,%d.%2d GBP", (int) money/1000, (int)Math.floor(money)%1000, (int)((money-Math.floor(money))*100));
		}
		return null;
	}
	
	public String toString() {
		return get(lang);
	}

}
