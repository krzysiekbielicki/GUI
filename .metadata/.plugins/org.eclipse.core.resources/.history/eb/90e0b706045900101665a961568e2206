package pl.edu.pjwstk.s8267.GUI.Lab4;

public class FormattedInt implements Justification {

	private double num;
	private int length;
	private int precision;

	public FormattedInt(int num, int length) {
		this(num, length, 0);
	}

	public FormattedInt(double num, int length, int precision) {
		this.num = num;
		this.length = length;
		this.precision = precision;
	}

	@Override
	public String justify(int alignment) {
		if(precision>0)
			return (new FormattedString(String.format("%."+precision+"f", num), length)).justify(alignment);
		else
			return (new FormattedString(String.format("%d", (int)num), length)).justify(alignment);
	}

}
