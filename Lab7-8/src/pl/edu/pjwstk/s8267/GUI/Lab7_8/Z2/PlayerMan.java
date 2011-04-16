package pl.edu.pjwstk.s8267.GUI.Lab7_8.Z2;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class PlayerMan extends Player {
	public static final int CONSOLE = 1;
	public static final int INPUT_DIALOG = 2;
	private int type;

	public PlayerMan(String name, Shared s, int type) {
		super(name, s);
		this.type = type;
	}
	
	
	
	public void run() {
		while(true) {
			if(shared.myTurn(id)) {
				if(shared.getMatches() > 0) {
					System.out.println("na stole jest "+shared.getMatches()+" zapalek");
					int c = 0;
					do {
						switch(type) {
						case CONSOLE:
							System.out.println("Kolej gracza "+name);
							System.out.print("Na stole jest "+shared.getMatches()+" zapalek.\n Weź 1-3 zapałek.\n Podaj liczbę zapałek:");
						    c = new Scanner(System.in).nextInt();
							break;
						case INPUT_DIALOG:
							try {
								c = Integer.parseInt(JOptionPane.showInputDialog(null, "Na stole jest "+shared.getMatches()+" zapalek.\n Weź 1-3 zapałek.", "Kolej gracza "+name, JOptionPane.QUESTION_MESSAGE));
							} catch(Exception e){
								c = 0;
							}
							break;
						}
					} while(c < 1 || c > 3);
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
