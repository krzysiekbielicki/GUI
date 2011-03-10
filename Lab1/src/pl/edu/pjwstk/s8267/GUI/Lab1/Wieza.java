package pl.edu.pjwstk.s8267.GUI.Lab1;

import java.util.ArrayList;

public class Wieza {

	private ArrayList<Klocek> klocki;
	
	public Wieza() {
		klocki = new ArrayList<Klocek>();
		System.out.println(this);
	}
	
	private void delete(Klocek ... klocki) {
		int affectedElements = 0;
		for(Klocek k : klocki) {
			if(this.klocki.contains(k)) {
				this.klocki.remove(k);
				affectedElements++;
			} else {
				System.out.println("ERR: ten klocek nie znajduje sie w wiezy");
			}
		}
		if(affectedElements > 0)
			System.out.println("INFO: dodalem "+affectedElements+" kloc"+(affectedElements>1?(affectedElements>4?"ków":"ki"):"ek"));
	}

	private void add(Klocek ...  klocki) {
		int affectedElements = 0;
		for(Klocek k : klocki) {
			if(this.klocki.contains(k)) {
				System.out.println("ERR: ten klocek znajduje sie juz w wiezy");
			} else {
				this.klocki.add(k);
				affectedElements++;
			}
		}
		if(affectedElements > 0)
			System.out.println("INFO: usunalem "+affectedElements+" kloc"+(affectedElements>1?(affectedElements>4?"ków":"ki"):"ek"));
	}
	
	public String toString() {
		String ret = "";
		if(klocki.size() > 0)
			for(Klocek k : klocki)
				ret+=k+"\n";
		else
			ret = "Wieza nie zawiera zadnych klockow\n";
		
		return ret+"--------------------------------------------------";
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Klocek k1 = new Klocek("yellow", 1, 5, 4);
		Klocek k2 = new Klocek("blue", 2, 2, 6);
		Klocek k3 = new Klocek("green", 3, 4, 2);
		Klocek k4 = new Klocek("yellow", 1, 5, 4);
		Wieza wieza = new Wieza();
		wieza.add(k1, k2, k3);
		System.out.println(wieza);
		wieza.add(k2);
		wieza.add(k4);
		System.out.println(wieza);
		wieza.delete(k1);
		wieza.delete(k1);
		System.out.println(wieza);
	}

}
