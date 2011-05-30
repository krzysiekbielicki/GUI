package pl.edu.pjwstk.s8267.GUI.Lab10;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Zapalki extends JFrame {
	private JLabel counter;
	public Zapalki() {
		super("Zapałki");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridheight = 1;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 0;
		c.weighty = 1.0;
		c.weightx = 1.0;
		counter = new JLabel("51", JLabel.CENTER);
		counter.setFont(counter.getFont().deriveFont(42f).deriveFont(Font.BOLD));
		counter.setVerticalAlignment(JLabel.CENTER);
		counter.setBorder(BorderFactory.createTitledBorder("Liczba zapałek na stole"));
		add(counter, c);
		
		c.gridwidth = 1;
		c.gridy = 1;
		JPanel left = new JPanel(new GridLayout(3, 1));
		left.setBorder(BorderFactory.createTitledBorder("Gracz 1"));
		left.add(new JButton("Biorę trzy zapałki"));
		left.add(new JButton("Biorę dwie zapałki"));
		left.add(new JButton("Biorę jedną zapałki"));
		add(left, c);
		
		c.gridx = 1;
		JPanel right = new JPanel(new GridLayout(3, 1));
		right.setBorder(BorderFactory.createTitledBorder("Gracz 1"));
		right.add(new JButton("Biorę trzy zapałki"));
		right.add(new JButton("Biorę dwie zapałki"));
		right.add(new JButton("Biorę jedną zapałki"));
		add(right, c);
		
		pack();
		setVisible(true);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
			new Zapalki();
	}

}
