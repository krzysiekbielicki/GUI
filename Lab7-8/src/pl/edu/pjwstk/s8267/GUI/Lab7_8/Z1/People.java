package pl.edu.pjwstk.s8267.GUI.Lab7_8.Z1;

public class People {
	public static void main(String[] args) {
		Task tasksA[] = { new Task("washing", "fast"),
				new Task("reading", "slow"), new Task("shopping", "medium") };
		Task tasksM[] = { new Task("sleeping zzzzzzzzzz", "very slow"),
				new Task("learning", "slow"), new Task("  :**   ", "slow"),
				new Task("passing an exam", "slow") };
		Task tasksJ[] = { new Task("listening music", "medium"),
				new Task("doing nothing", "slow"),
				new Task("walking", "medium") };

		BusyPerson friends[] = { new BusyPerson("Alice", tasksA),
				new BusyPerson("Mark", tasksM), new BusyPerson("John", tasksJ) };

		System.out.println("STARTING.....................");
		for (BusyPerson f : friends)
			(new Thread(f)).start();
		System.out.println("DONE.........................");
	}

}
