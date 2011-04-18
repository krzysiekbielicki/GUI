package pl.edu.pjwstk.s8267.GUI.Lab7_8.Z2;

public abstract class BasePlayer extends Thread {
	protected String name;
	protected Shared shared;
	protected int id;

	public BasePlayer(String name, Shared s) {
		this.name = name;
		this.shared = s;
		id = s.registerNewPlayer();
	}

	public void run() {
		while (true) {
			if (shared.myTurn(id)) {
				if (shared.getMatches() > 0) {
					while (true) {
						try {
							System.out.println("na stole jest "
									+ shared.getMatches() + " zapalek");
							int c = draw(shared.getMatches());
							System.out.println(String.format("%50s", name
									+ " bierze " + c));
							c = shared.drawMatches(id, c);
							if (c <= 0) {
								System.out.println("Gra zakończona " + name
										+ " wygrał!");
								return;
							}
							break;
						} catch (Exception e) {
							System.out
									.println("Nie moesz wziac tylu zapalek!!!");
						}
					}
				} else {
					return;
				}
			}
			if (shared.getMatches() <= 0)
				return;
			try {
				Thread.sleep(Matches.delay);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public abstract int draw(int matches);
}
