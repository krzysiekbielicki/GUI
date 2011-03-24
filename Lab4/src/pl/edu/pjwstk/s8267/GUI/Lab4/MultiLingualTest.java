package pl.edu.pjwstk.s8267.GUI.Lab4;

public class MultiLingualTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MultiLingual gatecrasher[] = {
				new Data(3, 12, 1998),
				new Data(10, 6, 1924, MultiLingual.ENG),
				new Book("Sekret", "Rhonda Byrne", "Nowa proza", 2007),
				new Book("Tuesdays with Morrie", "Mitch Albom",
						"Time Warner Books", 2003, MultiLingual.ENG),
				new Money(1232895 / 33.0, MultiLingual.PL),
				new Money(134566 / 23.0, MultiLingual.ENG), };

		System.out.println("-------------- 1st checkpoint");
		for (int i = 0; i < gatecrasher.length; i++)
			System.out.println(gatecrasher[i] + "\n");

		System.out.println("\n\n-------------- 2nd checkpoint");
		for (int i = 0; i < gatecrasher.length; i++)
			System.out.println(gatecrasher[i].get(MultiLingual.ENG) + "\n");

		System.out.println("\n\n-------------- 3rd checkpoint");
		for (int i = 0; i < gatecrasher.length; i++)
			System.out.println(gatecrasher[i] + "\n");
	}
}
