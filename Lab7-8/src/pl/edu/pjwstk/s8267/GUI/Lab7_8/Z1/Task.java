package pl.edu.pjwstk.s8267.GUI.Lab7_8.Z1;

public class Task {

	private String name;
	private String speed;

	public Task(String name, String speed) {
		this.name = name;
		this.speed = speed;
	}

	public void perform(String pname) {
		int time = Speed.getSpeedInt(speed);
		System.out.println(String.format("%s is... %s %s %.3fs", pname, name, speed, ((double)time)/1000.0));
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
