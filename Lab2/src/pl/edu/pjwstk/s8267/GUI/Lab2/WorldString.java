package pl.edu.pjwstk.s8267.GUI.Lab2;

public class WorldString {

	private static final int LEFT = 1;
	private static final int DOWN = 2;
	private static final int RIGHT = 4;
	private static final int UP = 8;

	private String string;
	private int mask;

	public WorldString(String string) {
		this(string, LEFT);
	}

	public WorldString(String string, int mask) {
		this.string = string;
		this.mask = mask;
	}

	public void setPosition(int mask) {
		this.mask = mask;
	}

	public void println(int mask) {
		int oldmask = this.mask;
		this.mask = mask;
		System.out.println(this);
		this.mask = oldmask;
	}

	public String toString() {
		if(((mask & LEFT) == LEFT && (mask & RIGHT) == RIGHT ) || ((mask & DOWN) == DOWN && (mask & UP) == UP))
			return "Err: too many parameters";
		if((mask & LEFT) == LEFT && (mask & DOWN) != DOWN && (mask & UP) != UP) {
			return string;
		}
		int len = string.length();
		String ret = "";
		String tmp;
		for (int i = 0; i < len; i++) {
			if ((mask & RIGHT) == RIGHT)
				tmp = String.format("%" + (len-i) + "c", string.charAt(i))+"\n";
			else if ((mask & LEFT) == LEFT)
				tmp = String.format("%" + (i+1) + "c", string.charAt(i))+"\n";
			else
				tmp = string.charAt(i)+"\n";
			
			if((mask & DOWN) == DOWN)
				ret += tmp;
			else if((mask & UP) == UP)
				ret = tmp + ret;
			else
				ret = tmp.trim() + ret;
		}
		return ret;
	}

	public static void main(String[] args) {
		WorldString w1 = new WorldString("Eukaliptus");
		WorldString w2 = new WorldString("Yuka", WorldString.LEFT
				| WorldString.DOWN);
		WorldString w3 = new WorldString("Kaktus", WorldString.RIGHT
				| WorldString.UP);

		System.out.println(w1);

		System.out.println(w2);

		System.out.println(w3);

		w1.println(WorldString.RIGHT);
		System.out.println(w1);

		w2.println(WorldString.LEFT | WorldString.UP);

		w2.println(WorldString.UP);

		w2.println(WorldString.DOWN);

		System.out.println(w2);

		w3.setPosition(WorldString.RIGHT | WorldString.DOWN);
		System.out.println(w3);

		w3.println(WorldString.LEFT | WorldString.RIGHT | WorldString.DOWN);
	}
}
