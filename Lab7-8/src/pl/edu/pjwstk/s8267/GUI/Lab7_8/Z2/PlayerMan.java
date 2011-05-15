package pl.edu.pjwstk.s8267.GUI.Lab7_8.Z2;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class PlayerMan extends BasePlayer {
	public static final int CONSOLE = 1;
	public static final int INPUT_DIALOG = 2;
	private int type;

	public PlayerMan(String name, Shared s, int type) {
		super(name, s);
		this.type = type;
	}

	@Override
	public int draw(int matches) {
		int c = 0;
		switch (type) {
		case CONSOLE:
			System.out.println("Kolej gracza " + name);
			System.out.print("Na stole jest " + shared.getMatches()
					+ " zapalek.\n Weź 1-3 zapałek.\n Podaj liczbę zapałek:");
			c = new Scanner(System.in).nextInt();
			break;
		case INPUT_DIALOG:
			try {
				c = Integer.parseInt(JOptionPane.showInputDialog(null,
						"Na stole jest " + shared.getMatches()
								+ " zapalek.\n Weź 1-3 zapałek.",
						"Kolej gracza " + name, JOptionPane.QUESTION_MESSAGE));
			} catch (Exception e) {
				c = 0;
			}
			break;
		}
		return c;
	}
}
