package pl.edu.pjwstk.s8267.GUI.Lab7_8.Z2;

import java.util.Random;

public class Player extends BasePlayer {
	private Random rand;

	public Player(String name, Shared s) {
		super(name, s);
		rand = new Random();
	}

	@Override
	public int draw(int matches) {
		return rand.nextInt(3)+1;
	}
	
}
