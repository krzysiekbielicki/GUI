package pl.edu.pjwstk.s8267.GUI.Lab7_8.Z2;

public class Matches {
	public static final long delay = 1000;

	public static void main(String[] args) {
		Shared t = new Shared(51); // 51 zapalek, 2 graczy
		Player ps[] = { new Player("Alice-Computer", t),
				// automatyczny przydział numeru 0

				new Player("Mark-Computer", t),
				new PlayerMan("The Student I",t,PlayerMan.CONSOLE),
				new PlayerMan("The Student II",t,PlayerMan.INPUT_DIALOG)
		// automatyczny przydział numeru 1
		};
		for (Player p : ps)
			p.start();
		System.out.println("Główny watek czeka, az ktos wygra...");
	}
}
