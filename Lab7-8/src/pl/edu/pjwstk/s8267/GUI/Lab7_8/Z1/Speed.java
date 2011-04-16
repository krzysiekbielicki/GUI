package pl.edu.pjwstk.s8267.GUI.Lab7_8.Z1;

import java.util.Random;

public class Speed {
	private static final String[] hows = { "fast", "medium", "slow", "very slow" };
	private static final int[] maxs = { 5000, 10000, 20000, 30000 };
	public static int getSpeedInt(String speedString) {
		int from = 0;
		int to = 0;
		for(int i = 0; i < hows.length; i++) {
			if(hows[i].equals(speedString)) {
				if(i>0)
					from = maxs[i-1];
				to = maxs[i];
			}
		}
		Random rand = new Random();
		return from+rand.nextInt(to-from+1);
	}
}