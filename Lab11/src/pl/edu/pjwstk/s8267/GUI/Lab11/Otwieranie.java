package pl.edu.pjwstk.s8267.GUI.Lab11;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Otwieranie {

	private JTextField path;
	private ButtonGroup shapeGroup;
	private ButtonGroup colorGroup;
	private JCheckBox linked;
	public Otwieranie() {
		JPanel message = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridwidth = 2;
		c.fill = GridBagConstraints.BOTH;
		path = new JTextField();
		message.add(new JLabel("Nazwa pliku:"), c);
		c.gridy = 1;
		message.add(path, c);
		JPanel shape = new JPanel(new GridLayout(3, 1));
		shape.setBorder(BorderFactory.createTitledBorder("Kształt"));
		shapeGroup = new ButtonGroup();
		JRadioButton radio = new JRadioButton("kółko");
		radio.setActionCommand(Drawer.CIRCLE+"");
		radio.setSelected(true);
		shape.add(radio);
		shapeGroup.add(radio);
		radio = new JRadioButton("kwadrat");
		radio.setActionCommand(Drawer.SQUARE+"");
		shape.add(radio);
		shapeGroup.add(radio);
		radio = new JRadioButton("krzyżyk");
		radio.setActionCommand(Drawer.CROSS+"");
		shape.add(radio);
		shapeGroup.add(radio);
		c.gridwidth=1;
		c.gridy=2;
		message.add(shape, c);
		JPanel color = new JPanel(new GridLayout(3, 1));
		color.setBorder(BorderFactory.createTitledBorder("Kolor"));
		colorGroup = new ButtonGroup();
		radio = new JRadioButton("czerwony");
		radio.setSelected(true);
		radio.setActionCommand("RED");
		color.add(radio);
		colorGroup.add(radio);
		radio = new JRadioButton("zielony");
		radio.setActionCommand("GREEN");
		color.add(radio);
		colorGroup.add(radio);
		radio = new JRadioButton("niebieski");
		radio.setActionCommand("BLUE");
		color.add(radio);
		colorGroup.add(radio);
		c.gridwidth=1;
		c.gridx=1;
		message.add(color, c);
		linked = new JCheckBox("linia łącząca");
		c.gridwidth=2;
		c.gridx=0;
		c.gridy=3;
		message.add(linked, c);
		String[] options = new String[] {"OK", "Anuluj", "Przeglądaj..."};
		while(true) {
			int ret = JOptionPane.showOptionDialog(null, message, "Otwieranie", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
			if(ret == 0) {
				JFrame frame = new JFrame("Viewer");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Drawer painter = new Drawer();
				painter.setShape(Integer.parseInt(shapeGroup.getSelection().getActionCommand()));
				if(colorGroup.getSelection().getActionCommand().equals("RED"))
					painter.setShapeColor(Color.RED);
				else if(colorGroup.getSelection().getActionCommand().equals("GREEN"))
					painter.setShapeColor(Color.GREEN);
				else if(colorGroup.getSelection().getActionCommand().equals("BLUE"))
					painter.setShapeColor(Color.BLUE);
				painter.setDrawLine(linked.isSelected());
				frame.setContentPane(painter);
				try {
					BufferedReader reader = new BufferedReader( new FileReader(path.getText()) );
					String line;
					ArrayList<Point> points = new ArrayList<Point>();
					while((line = reader.readLine()) != null) {
						String[] ptsString = line.split(" ");
						for(int i = 0; i < ptsString.length; i++) {
							String[] pString = ptsString[i].replace("(", "").replace(")", "").split(",");
							points.add(new Point(Integer.parseInt(pString[0].trim()), Integer.parseInt(pString[1].trim())));
						}
					}
					painter.setPoints(points);
					frame.pack();
					painter.repaint();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				frame.setVisible(true);
				break;
			} else if(ret == 2) { //Browse
				JFileChooser chooser = new JFileChooser();
				if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					path.setText(chooser.getSelectedFile().getAbsolutePath());
				}
			} else {
				break;
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Otwieranie();
	}

}
