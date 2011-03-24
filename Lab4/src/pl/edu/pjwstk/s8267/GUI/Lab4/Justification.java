package pl.edu.pjwstk.s8267.GUI.Lab4;

public interface Justification {
	public static final int LEFT = 0;
	public static final int CENTER = 1;
	public static final int RIGHT = 2;

	public abstract String justify(int alignment);
}
