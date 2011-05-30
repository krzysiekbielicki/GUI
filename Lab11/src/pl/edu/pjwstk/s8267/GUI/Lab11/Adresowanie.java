package pl.edu.pjwstk.s8267.GUI.Lab11;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Adresowanie {

	private JTextField name;
	private JTextField surname;
	private JTextField street;
	private JTextField city;
	private JComboBox fontSize;
	private String myName;
	private String mySurname;
	private String myStreet;
	private String myCity;
	private Address sender;
	private Address receiver;
	public Adresowanie() {
		try {
			BufferedReader reader = new BufferedReader( new FileReader("nadawca.dat") );
			String line;
			int i = 0;
			while((line = reader.readLine()) != null) {
				switch(i++) {
				case 0:
					myName = line;
					break;
				case 1:
					mySurname = line;
					break;
				case 2:
					myStreet = line;
					break;
				case 3:
					myCity = line;
					break;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sender = new Address(myName, mySurname, myStreet, myCity);
		sender.setSize(Address.SMALL);
		Box message = Box.createVerticalBox();
		Box address = Box.createVerticalBox();
		address.setBorder(BorderFactory.createTitledBorder("Adresat"));
		
		address.add(new JLabel("Imię:"));
		name = new JTextField("Jerzy");
		address.add(name);
		address.add(new JLabel("Nazwisko:"));
		surname = new JTextField("Jeż");
		address.add(surname);
		address.add(new JLabel("Ulica:"));
		street = new JTextField("ul. Jeżynowa 12");
		address.add(street);
		address.add(new JLabel("Miejscowość:"));
		city = new JTextField("00-123 Jerzewo");
		address.add(city);
		message.add(address);
		message.add(new JLabel("Wielkość czcionki:"));
		fontSize = new JComboBox(new String[] {"mała", "średnia", "duża", "bardzo duża"});
		message.add(fontSize);
		if(JOptionPane.showConfirmDialog(null, message, "Adresowanie kopert", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {
				JFrame frame = new JFrame("Koperta");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				receiver = new Address(name.getText(), surname.getText(), street.getText(), city.getText());
				receiver.setSize(fontSize.getSelectedIndex());
				Envelope koperta = new Envelope();
				frame.setContentPane(koperta);
				frame.pack();
				frame.setVisible(true);
		}
	}

	class Envelope extends JComponent {
		
		public Envelope() {
			setPreferredSize(new Dimension((int)(receiver.size*25), (int)(receiver.size*15)));
		}
		
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			Graphics2D g2d = (Graphics2D) g;
			g2d.setFont(g2d.getFont().deriveFont(sender.size));
			FontMetrics fm = g2d.getFontMetrics();
			int height = fm.getHeight();
			int y = 0;
			int x = 0;
			int width = Math.max(fm.stringWidth(sender.name+" "+sender.surname), Math.max(fm.stringWidth(sender.street), fm.stringWidth(sender.city)));
			y+=height;
			g2d.drawString(sender.name+" "+sender.surname, (width-fm.stringWidth(sender.name+" "+sender.surname))/2, y);
			y+=height*1.1;
			g2d.drawString(sender.street, (width-fm.stringWidth(sender.street))/2, y);
			y+=height*1.1;
			g2d.drawString(sender.city, (width-fm.stringWidth(sender.city))/2, y);
			y+=height*2;
			x = width;
			g2d.setFont(getFont().deriveFont(receiver.size));
			fm = g2d.getFontMetrics();
			height = fm.getHeight();
			x = getWidth() - Math.max(fm.stringWidth(receiver.name+" "+receiver.surname), Math.max(fm.stringWidth(receiver.street), fm.stringWidth(receiver.city))) - fm.stringWidth("Sz. P.") - 10;
			y = (int) (getHeight() - height * 3.3) - 10;
			g2d.drawString("Sz. P.", x, y);
			x+=fm.stringWidth("Sz. P.");
			y+=height*1.1;
			g2d.drawString(receiver.name+" "+receiver.surname, x, y);
			y+=height*1.1;
			g2d.drawString(receiver.street, x, y);
			y+=height*1.1;
			g2d.drawString(receiver.city, x, y);
			//receiver.paint(g, 100, 100);
			
		}
	}
	
	class Address {
		public static final int SMALL = 0;
		public static final int MEDIUM = 1;
		public static final int BIG = 2;
		public static final int VERYBIG = 3;
		private String name;
		private String surname;
		private String street;
		private String city;
		private float size;

		public Address(String name, String surname, String street, String city) {
			this.name = name;
			this.surname = surname;
			this.street = street;
			this.city = city;
		}
		
		public void setSize(int vSize) {
			switch(vSize) {
			case SMALL:
				size = 12f;
				break;
			case MEDIUM:
				size = 14f;
				break;
			case BIG:
				size = 18f;
				break;
			case VERYBIG:
				size = 22f;
				break;
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Adresowanie();
	}

}
