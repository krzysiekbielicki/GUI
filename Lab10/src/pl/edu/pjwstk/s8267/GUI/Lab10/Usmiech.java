package pl.edu.pjwstk.s8267.GUI.Lab10;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Usmiech extends JFrame {
	public Usmiech() {
		super("Uśmiech");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(4, 4));
	}
	
	public void showNumbers() {
		LinkedList<Integer> numbers = new LinkedList<Integer>();
		for(int i = 0; i < 16;i++) {
			numbers.add(i); 
		}
		Collections.shuffle(numbers);
		Iterator<Integer> it = numbers.iterator();
		while(it.hasNext()) {
			int i = it.next();
			JButton b = new JButton(i==0?"":i+"");
			b.setBackground(Color.BLUE);
			b.setPreferredSize(new Dimension(55, 55));
			add(b);
		}
	}
	
	public void showImages() {
		for(int i = 0; i < 16;i++) {
			JButton b = new JButton();
			b.setBackground(Color.YELLOW);
			b.setPreferredSize(new Dimension(55, 55));
			if(i==15) {
				add(b);
			} else {
				b.setIcon(new ImageIcon("usmiech"+File.separator+"u"+(i+1)+".jpg"));
				add(b);
			}
		}
	}
	
	public static void main(String[] args) {
		Usmiech u = new Usmiech();
		u.showNumbers();
		u.pack();
		u.setVisible(true);
	}
}
