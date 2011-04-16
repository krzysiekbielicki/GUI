package pl.edu.pjwstk.s8267.GUI.Lab7_8.Z1;

public class BusyPerson implements Runnable {

	private String name;
	private Task[] tasks;

	public BusyPerson(String name, Task[] tasks) {
		this.name = name;
		this.tasks = tasks;
	}

	@Override
	public void run() {
		for(int i = 0; i < tasks.length; i++) {
			tasks[i].perform(name);
		}
	}

}
