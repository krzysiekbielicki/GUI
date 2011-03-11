package pl.edu.pjwstk.s8267.GUI.Lab2;

public class EqSystem {
	private static int nextNumber = 101;
	private Equation[] tab;
	private int number;
	public EqSystem(Equation[] tab) {
		this.tab = tab.clone();
		number = nextNumber++;
	}

	public static void setNextNumber(int i) {
		nextNumber = i;
	}

	public String getSolution() {
		double W = tab[0].getA()*tab[1].getB()-tab[0].getB()*tab[1].getA();
		double Wx = tab[0].getC()*tab[1].getB()-tab[0].getB()*tab[1].getC();
		double Wy = tab[0].getA()*tab[1].getC()-tab[0].getC()*tab[1].getA();
		String ret;
		if(W == 0)
			if(Wx+Wx == 0)
				ret = "ma nieskończenie wiele rozwiązań";
			else
				ret = "jest sprzeczny";
		else {
			double x = Wx/W;
			double y = Wy/W;
			ret = "ma dokładnie jedno rozwiązanie:\nx="+x+", y="+y;
		}
		return "Układ ("+number+") "+ret;
	}
	
	public String toString() {
		return 	 "("+number+")\t+---\n"
	       		+"\t| "+tab[0]+"\n"
	       		+"\t| "+tab[1]+"\n"
	       		+"\t+---";

	}

	public static void main(String[] args) {
		int t1[] = { 1, -2, 0 };
		Equation r1 = new Equation(t1);

		Equation tab[] = { r1, new Equation(new int[] { 3, 1, 28 }) };

		System.out.println("---------------------- 0. checkpoint");
		System.out.println(tab[0]);
		System.out.println(tab[1]);

		EqSystem s1 = new EqSystem(tab);
		System.out.println("\n---------------------- 1. checkpoint");

		System.out.println(s1);

		System.out.println(s1.getSolution());

		EqSystem.setNextNumber(2008); // przygotowanie do drugiego próby
		int t2[] = { -7, -7, 34 };
		t1[0] = 1;
		t1[1] = 1;
		tab[0] = new Equation(t1);
		tab[1] = new Equation(t2);
		EqSystem s2 = new EqSystem(tab);
		System.out.println("\n---------------------- 2. checkpoint");

		System.out.println(s2);

		System.out.println("\n---------------------- 3. checkpoint");

		System.out.println(s1);

		System.out.println(s1.getSolution() + "\n\n\n");

		System.out.println(s2);

		System.out.println(s2.getSolution());

		// przygotowanie do czwartej, ostatniej próby
		Equation tab2[] = { new Equation(new int[] { 3, 1, 5 }),
				new Equation(new int[] { 9, 3, 15 }) };
		EqSystem s3 = new EqSystem(tab2);

		System.out.println("\n---------------------- 4. checkpoint");

		System.out.println(s3);

		System.out.println(s3.getSolution());
	}
}
