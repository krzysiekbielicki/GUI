package pl.edu.pjwstk.s8267.GUI.Lab4;

public class FormattedString implements Justification {

	private String string;
	private int length;

	public FormattedString(String string, int length) {
		this.string = string;
		this.length = length;
	}

	@Override
	public String justify(int alignment) {
		String ret = string;
		while(ret.length() < length) {
			switch(alignment) {
			case Justification.LEFT:
				ret += " ";
				break;
			case Justification.RIGHT:
				ret = " " + ret;
				break;
			case Justification.CENTER:
				if(ret.length() < (string.length()+length)/2)
					ret = " " + ret;
				else
					ret += " ";
				break;
				
			}
		}
		return ret;
	}

}
