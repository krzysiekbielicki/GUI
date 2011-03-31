package pl.edu.pjwstk.s8267.GUI.Lab4;

public class JustificationTest {
	public static void main(String args[]) {
		Justification[] t = {
				new FormattedString("Alicja", 20), // na 20 miejscach
				new FormattedInt(345, 20),
				new FormattedString("w krainie", 20),
				new FormattedInt(-7.5, 20, 5), // na 20 miejscach, 5 po
												// przecinku
				new FormattedString("kota", 20)
			};

		System.out.println("123456789*123456789*");
		for (int i = 0; i < t.length; i++)
			System.out.println(t[i].justify(Justification.LEFT) + "<---");

		for (int i = 0; i < t.length; i++)
			System.out.println(t[i].justify(Justification.CENTER) + "<---");

		for (int i = 0; i < t.length; i++)
			System.out.println(t[i].justify(Justification.RIGHT) + "<---");
	}
}
