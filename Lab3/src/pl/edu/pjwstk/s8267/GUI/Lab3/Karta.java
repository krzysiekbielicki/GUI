package pl.edu.pjwstk.s8267.GUI.Lab3;

public class Karta {
	private String imie;
	private String nazwisko;
	protected int grupa;
	private static String defaultStamp;
	private String stamp;
	private int przedmioty;
	private int[] passed = new int[4];
	
	public Karta(String imie, String nazwisko, int grupa, int przedmioty) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.grupa = grupa;
		this.przedmioty = przedmioty;
	}

	public void passed(int passed, int mark) {
		this.passed[mark-1] = passed;
		System.out.println("KARTA: "+imie+" "+nazwisko+"\nZaliczono: "+passed+" przedmiotów\n Na ocenę:  "+mark+"\n");	 
	}

	public void printCard() {
		this.stamp = defaultStamp;
		System.out.println("Drukowanie karty... --> "+imie+" "+nazwisko);
	}

	public void setSurname(String surname) {
		if(stamp == null)
			this.nazwisko = surname;
		else
			System.err.println("ERR: Karta jest wydrukowana,\nnie mogę zmienić danych osobowych");
	}

	public static void setStamp(String s) {
		defaultStamp = s;
	}
	
	protected String toString(String more) {
		String ret = (stamp==null?defaultStamp:stamp)+"\n";
		ret += "IMIE i NAZWISKO: "+imie+" "+nazwisko+"\n";
		ret += "        SEMESTR: "+(grupa/100)+"\n";
        ret += "          GRUPA: "+grupa+"\n";
        ret += more;
        if(stamp == null) {
        	ret += "-------------------------------\n";
            ret += "    KARTA WIRTUALNA\n";
            ret += "-------------------------------\n";
        } else {
        	ret += "-------------------------------\n";
            ret += "    KARTA WYDRUKOWANA\n";
            ret += "-------------------------------\n";
          	ret += "LICZBA PRZEDMIOTOW\n";
           	ret += "     DO ZALICZENIA: "+przedmioty+"\n";
           	boolean header = false;
            for(int i = 0; i<passed.length; i++) {
            	if(passed[i] > 0) {
            		if(!header) {
            			ret += " W TYM OCEN:\n";
            			header = true;
            		}
            		switch(i+1) {
            		case 2:
            			ret+= "NIEDOSTATECZNYCH";
            			break;
            		case 3:
            			ret+= "DOSTATECZNYCH";
            			break;
            		case 4:
            			ret+= "DOBRYCH";
            			break;
            		case 5:
            			ret+= "BARDZO DBRYCH";
            		}
	            	ret += ": "+passed[i]+"\n";
            	}
            }
            ret += "-------------------------------\n";
            
        }
        return ret;
	}
	
	public String toString() {
		return toString("");
	}
	
	public static void main(String[] args) {
		Karta karty[]={
			new Karta("Adam", "Kowalski", 101, 7),
	        new Karta23("Anna", "Malinowska", 421, 4, "BD"),
	        new Karta45("Tomasz", "Król", 421, 10, "BD", "dr hab. XX")
		}; 	
		Karta.setStamp("*** PJWSTK ***");  
		for(int i=0; i < karty.length; i++)
			System.out.print(karty[i]);

		karty[0].setSurname("Nowak");  
		for(int i=1; i < karty.length; i++)
			karty[i].printCard();
		
		karty[1].setSurname("Janiak");  
		karty[2].passed(6,4);
		Karta.setStamp("------> PJWSTK");  
		for(int i=0; i < karty.length; i++)
			System.out.print(karty[i]);
	}
}
