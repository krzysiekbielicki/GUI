package pl.edu.pjwstk.s8267.GUI.Lab7_8.Z2;

public class Shared { // współdzielone przez graczy dane
	private int ktory = 0; // którego z graczy jest teraz ruch
	private int ileZapalek; // ile jest aktualnie zapałek na stole
	private int playerCount;

	public Shared(int matches) {
		ileZapalek = matches;
		playerCount = 0;
	}

	public synchronized boolean myTurn(int playerId) {
		return ktory == playerId;
	}

	public synchronized int drawMatches(int playerId, int matchesCount) {
		if (myTurn(playerId)) {
			ileZapalek -= matchesCount;
			ktory = (ktory + 1) % playerCount;
		}
		return ileZapalek;
	}

	public int registerNewPlayer() {
		return playerCount++;
	}

	public int getMatches() {
		return ileZapalek;
	}
}
