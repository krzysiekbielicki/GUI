package pl.edu.pjwstk.s8267.GUI.Lab10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Kalkulator extends JFrame {
	private JTextField result;

	public Kalkulator() {
		super("Kalkulator");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		result = new JTextField();
		add(result, BorderLayout.NORTH);
		JPanel systems = new JPanel();
		systems.setBorder(BorderFactory.createTitledBorder("System liczbowy:"));
		JRadioButton hex = new JRadioButton("szesnastkowy");
		JRadioButton dec = new JRadioButton("dziesiętny");
		JRadioButton bin = new JRadioButton("binarny");
		ButtonGroup group = new ButtonGroup();
		group.add(hex);
		group.add(dec);
		group.add(bin);
		systems.add(hex);
		systems.add(dec);
		systems.add(bin);
		JPanel center = new JPanel(new BorderLayout());
		center.add(systems, BorderLayout.NORTH);
		JPanel buttons = new JPanel(new GridLayout(5, 4));
		for(int i = 0; i < 16; i++) {
			buttons.add(new JButton( (i<10?i+"":(char)(i+55))+""));
		}
		JButton ce = new JButton("CE");
		ce.setForeground(Color.RED);
		buttons.add(ce);
		JButton minus = new JButton("-");
		minus.setForeground(Color.RED);
		buttons.add(minus);
		JButton plus = new JButton("+");
		plus.setForeground(Color.RED);
		buttons.add(plus);
		JButton exec = new JButton("=");
		exec.setForeground(Color.RED);
		buttons.add(exec);
		center.add(buttons, BorderLayout.CENTER);
		add(center, BorderLayout.CENTER);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Kalkulator();
	}
}
