package pl.edu.pjwstk.s8267.GUI.Lab7_8.Z2;

import java.util.Random;

public class Player extends Thread {
	protected String name;
	protected Shared shared;
	private Random rand;
	protected int id;

	public Player(String name, Shared s) {
		this.name = name;
		this.shared = s;
		id = s.registerNewPlayer();
		rand = new Random();
	}
	
	public void run() {
		while(true) {
			if(shared.myTurn(id)) {
				if(shared.getMatches() > 0) {
					System.out.println("na stole jest "+shared.getMatches()+" zapalek");
					int c = rand.nextInt(3)+1;
					System.out.println(String.format("%50s", name+" bierze "+c));
					if(shared.drawMatches(id, c) <= 0) {
						System.out.println("Gra zakończona "+name+" wygrał!");
						return;
					}
				} else {
					return;
				}
			}
			if(shared.getMatches() <= 0) return;
			try {
				Thread.sleep(Matches.delay);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
