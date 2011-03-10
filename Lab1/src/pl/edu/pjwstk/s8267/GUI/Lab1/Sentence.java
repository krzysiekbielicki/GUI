package pl.edu.pjwstk.s8267.GUI.Lab1;

public class Sentence {
	String sentence = "";
	public Sentence(Object ... strings) {
		for(int i = 0; i< strings.length; i++) {
			sentence += strings[i]+" ";
		}
		sentence = (sentence.substring(0,1).toUpperCase()+sentence.substring(1).toLowerCase().replace(".", "")+".").trim();
	}
	
	public String toString() {
		return sentence;
	}

	public static void main(String args[]) {
		Sentence s1=new Sentence("tylko","KOT"),
        s2=new Sentence("a","myszy", 2),
        s3=new Sentence(s1,s2,"calkiem","same"),
        s4=new Sentence(s3, "na", new Integer(32), "ulicy");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
	}
}
