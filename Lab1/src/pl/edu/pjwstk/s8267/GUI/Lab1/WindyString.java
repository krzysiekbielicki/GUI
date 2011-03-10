package pl.edu.pjwstk.s8267.GUI.Lab1;

import java.util.ArrayList;

public class WindyString {
	public static void main(String[] args) {
		System.out.println(WindyString.blow("Abrakadabra!          The    second  chance to pass has already BEGUN! "));
	}
	
	private static ArrayList<Character> samogloski = new ArrayList<Character>();
	static {
		samogloski.add('a');
		samogloski.add('e');
		samogloski.add('i');
		samogloski.add('o');
		samogloski.add('u');
		samogloski.add('y');
		samogloski.add('A');
		samogloski.add('E');
		samogloski.add('I');
		samogloski.add('O');
		samogloski.add('U');
		samogloski.add('Y');
	}
	
	public static String blow(String s) {
		String line1 = "";
		String line2 = "";
		String line3 = "";
		String[] slowa = s.split("\\s+");
		char[] znaki;
		for(int i = 0; i < slowa.length; i++) {
			znaki = slowa[i].toCharArray();
			for(char z : znaki) {
				if(samogloski.contains(z)) {
					if(i%2 == 1) {
						line1+=z;
						line2+=" ";
						line3+=" ";
					} else {
						line1+=" ";
						line2+=" ";
						line3+=z;
					}
				} else {
					line1+=" ";
					line2+=z;
					line3+=" ";
				}
			}
			line1+=" ";
			line2+=" ";
			line3+=" ";
		}
		return line1+"\n"+line2+"\n"+line3;
	}
}
