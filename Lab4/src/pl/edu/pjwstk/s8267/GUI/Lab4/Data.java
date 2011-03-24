package pl.edu.pjwstk.s8267.GUI.Lab4;

import java.util.Date;

public class Data implements MultiLingual {
	
	private static final String[] miesiacStringPL = { "stycznia", "lutego",
		"marca", "kwietnia", "maja", "czerwca", "lipca", "sierpnia",
		"wrzesnia", "pazdziernika", "listopada", "grudnia" };

	private static final String[] miesiacStringENG = { "January", "February",
		"March", "Aprin", "May", "June", "July", "August",
		"September", "October", "November", "December" };

	private int day;
	private int month;
	private int year;
	private int lang;

	public Data(int day, int month, int year) {
		this(day, month, year, 0);
	}

	public Data(int day, int month, int year, int lang) {
		this.day = day;
		this.month = month;
		this.year = year;
		this.lang = lang;
	}

	@Override
	public String get(int lang) {
		switch(lang) {
		case MultiLingual.PL:
			return String.format("%d %s %d", day, miesiacStringPL[month-1], year);
		case MultiLingual.ENG:
			String dayString;
			int modulo = day<=20?day%20:day%10;
			if(modulo == 1)
				dayString=day+"st";
			else if(modulo == 2)
				dayString=day+"nd";
			else if(modulo == 3)
				dayString=day+"rd";
			else
				dayString=day+"th";
			
			return String.format("%s of %s %d", dayString, miesiacStringENG[month-1], year);
		}
		return null;
	}
	
	public String toString() {
		return get(lang);
	}
}
