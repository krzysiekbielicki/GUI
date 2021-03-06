package pl.edu.pjwstk.s8267.GUI.Lab2;

public class Zespolona {
	private static char nextName = 'A';
	private char name;
	private double realis, imaginaris;
	public Zespolona(double realis, double imaginaris) {
		this.name = nextName++;
		this.realis = realis;
		this.imaginaris = imaginaris;
	}

	private void wyswietlDzielenie(Zespolona z) {
		if(z.realis + z.imaginaris == 0) {
			System.out.println(" "+name+" ");
			System.out.println("--- Err: nie mozna dzielic przez ZERO!");
			System.out.println(" "+z.name+" ");
			return;
		}
		Zespolona wynik = new Zespolona( (realis*z.realis+imaginaris*z.imaginaris)/(z.realis*z.realis+z.imaginaris*z.imaginaris), (imaginaris*z.realis-realis*z.imaginaris)/(z.realis*z.realis+z.imaginaris*z.imaginaris));
		System.out.println(" "+name+"     "+this);
		System.out.println("--- = ---------- = "+wynik);
		System.out.println(" "+z.name+"     "+z+"\n");
		
	}

	public static void wyswietlDzielenie(Zespolona z1, Zespolona z2) {
		z1.wyswietlDzielenie(z2);
	}

	public char getName() {
		return name;
	}

	public static void setNextName(char c) {
		nextName = c;
	}
	
	public String toString() {
		String ret = ""+realis;
		if(imaginaris != 0)
			ret += (imaginaris>0?"+":"")+imaginaris+"i";
		return ret;
	}
	
	public static void main(String[] args) {
		Zespolona z1 = new Zespolona(1, 2);
		Zespolona z2 = new Zespolona(2, -1);
		System.out.println(z1);

		System.out.println(z2);

		Zespolona.setNextName('P');
		Zespolona z3 = new Zespolona(4, 3);
		Zespolona z4 = new Zespolona(0, 0);

		System.out.println(z1.getName() + " = " + z1);

		System.out.println(z2.getName() + " = " + z2);

		System.out.println(z3.getName() + " = " + z3);

		System.out.println(z4.getName() + " = " + z4);

		Zespolona.wyswietlDzielenie(z1, z2);

		z1.wyswietlDzielenie(z3);

		z1.wyswietlDzielenie(z4);
	}
}
