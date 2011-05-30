package pl.edu.pjwstk.s8267.GUI.Lab10;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class Oczy  extends JFrame{
	private OczyPanel oczy;

	public Oczy() {
		super("Oczy");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		oczy = new OczyPanel();
		add(oczy, BorderLayout.CENTER);
		JPanel toolBar = new JPanel();
		toolBar.setBackground(new Color(0, 200, 0));
		toolBar.add(Box.createHorizontalGlue());
		JButton b1 = new JButton("Kolor oczu");
		b1.setBackground(new Color(0, 150, 0));
		b1.setMnemonic('k');
		toolBar.add(b1);
		JButton b2 = new JButton("Kolor źrenic");
		b2.setBackground(new Color(0, 150, 0));
		b2.setMnemonic('o');
		toolBar.add(b2);
		JButton b3 = new JButton("Kolor tła");
		b3.setBackground(new Color(0, 150, 0));
		b3.setMnemonic('t');
		toolBar.add(b3);
		toolBar.add(Box.createHorizontalGlue());
		add(toolBar, BorderLayout.NORTH);
		pack();
		setVisible(true);
		addMou
	}
	
	public static void main(String[] args) {
		new Oczy();
	}
}
