package pl.edu.pjwstk.s8267.GUI.Lab4;

public class FormattedDouble implements Justification {
	private double num;
	private int length;
	private int precision;

	public FormattedDouble(double num, int length, int precision) {
		this.num = num;
		this.length = length;
		this.precision = precision;
	}

	@Override
	public String justify(int alignment) {
		if(precision>0)
			return (new FormattedString(String.format("%."+precision+"f", num), length)).justify(alignment);
		else
			return (new FormattedString(num+"", length)).justify(alignment);
	}
}
