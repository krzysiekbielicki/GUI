package pl.edu.pjwstk.s8267.GUI.Lab11;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class Z4 extends JFrame {
	private Drawer painter;
	private JCheckBoxMenuItem laczaca;

	public Z4() {
		super("Skromny edytor graficzny");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		painter = new Drawer();
		setContentPane(painter);
		initMenuBar();
		
		pack();
		setVisible(true);
	}
	
	private void initMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu plik = new JMenu("Plik");
		plik.setMnemonic(KeyEvent.VK_P);
		menuBar.add(plik);
		JMenuItem nowy = new JMenuItem("Nowy");
		nowy.setMnemonic(KeyEvent.VK_N);
		nowy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		plik.add(nowy);
		JMenuItem otworz = new JMenuItem("Otworz");
		otworz.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					loadFile(chooser.getSelectedFile().getAbsolutePath());
				}
			}
		});
		otworz.setMnemonic(KeyEvent.VK_O);
		otworz.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		plik.add(otworz);
		JMenuItem zapisz = new JMenuItem("Zapisz");
		zapisz.setMnemonic(KeyEvent.VK_Z);
		zapisz.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		plik.add(zapisz);
		plik.addSeparator();
		JMenuItem koniec = new JMenuItem("Koniec");
		koniec.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		koniec.setMnemonic(KeyEvent.VK_K);
		koniec.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		plik.add(koniec);
		JMenu punkty = new JMenu("Punkty");
		punkty.setMnemonic(KeyEvent.VK_K);
		menuBar.add(punkty);
		JMenu kolory = new JMenu("Kolory");
		punkty.add(kolory);
		ButtonGroup colorGroup = new ButtonGroup();
		JRadioButtonMenuItem czerwony = new JRadioButtonMenuItem("czerwony");
		czerwony.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				painter.setShapeColor(Color.RED);
				painter.repaint();
			}
		});
		colorGroup.add(czerwony);
		czerwony.setMnemonic(KeyEvent.VK_C);
		kolory.add(czerwony);
		JRadioButtonMenuItem zielony = new JRadioButtonMenuItem("zielony");
		zielony.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				painter.setShapeColor(Color.GREEN);
				painter.repaint();
			}
		});
		colorGroup.add(zielony);
		zielony.setMnemonic(KeyEvent.VK_Z);
		kolory.add(zielony);
		JRadioButtonMenuItem niebieski = new JRadioButtonMenuItem("niebieski");
		niebieski.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				painter.setShapeColor(Color.BLUE);
				painter.repaint();
			}
		});
		colorGroup.add(niebieski);
		niebieski.setMnemonic(KeyEvent.VK_N);
		kolory.add(niebieski);
		kolory.addSeparator();
		JRadioButtonMenuItem uzytkownika = new JRadioButtonMenuItem("użytkownika");
		uzytkownika.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] clr = JOptionPane.showInputDialog(null, "Podaj kolor (rrr,ggg,bbb)", "Kolor punktu", JOptionPane.QUESTION_MESSAGE).replace("(", "").replace(")", "").split(",");
				painter.setShapeColor(new Color(Integer.parseInt(clr[0]), Integer.parseInt(clr[1]), Integer.parseInt(clr[2])));
				painter.repaint();
			}
		});
		colorGroup.add(uzytkownika);
		uzytkownika.setMnemonic(KeyEvent.VK_U);
		kolory.add(uzytkownika);
		
		JMenu ksztalty = new JMenu("Kształty");
		punkty.add(ksztalty);
		
		ButtonGroup shapeGroup = new ButtonGroup();
		JRadioButtonMenuItem kolko = new JRadioButtonMenuItem("kółko");
		kolko.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				painter.setShape(Drawer.CIRCLE);
				painter.repaint();
			}
		});
		shapeGroup.add(kolko);
		kolko.setMnemonic(KeyEvent.VK_K);
		ksztalty.add(kolko);
		JRadioButtonMenuItem kwadrat = new JRadioButtonMenuItem("kwadrat");
		kwadrat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				painter.setShape(Drawer.SQUARE);
				painter.repaint();
			}
		});
		shapeGroup.add(kwadrat);
		kwadrat.setMnemonic(KeyEvent.VK_W);
		ksztalty.add(kwadrat);
		JRadioButtonMenuItem krzyzyk = new JRadioButtonMenuItem("krzyżyk");
		krzyzyk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				painter.setShape(Drawer.CROSS);
				painter.repaint();
			}
		});
		shapeGroup.add(krzyzyk);
		krzyzyk.setMnemonic(KeyEvent.VK_R);
		ksztalty.add(krzyzyk);
		
		JMenu linia = new JMenu("Linia");
		linia.setMnemonic(KeyEvent.VK_L);
		menuBar.add(linia);
		
		laczaca = new JCheckBoxMenuItem("łącząca");
		laczaca.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				painter.setDrawLine(laczaca.isSelected());
				painter.repaint();
			}
		});
		laczaca.setMnemonic(KeyEvent.VK_C);
		linia.add(laczaca);
		linia.addSeparator();
		JMenuItem kolorLinii = new JMenuItem("Kolor linii");
		kolorLinii.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] clr = JOptionPane.showInputDialog(null, "Podaj kolor (rrr,ggg,bbb)", "Kolor linii", JOptionPane.QUESTION_MESSAGE).replace("(", "").replace(")", "").split(",");
				painter.setLineColor(new Color(Integer.parseInt(clr[0]), Integer.parseInt(clr[1]), Integer.parseInt(clr[2])));
				painter.repaint();
			}
		});
		kolorLinii.setMnemonic(KeyEvent.VK_K);
		linia.add(kolorLinii);
		menuBar.add(Box.createHorizontalGlue());
		JMenu about = new JMenu("O autorze");
		about.addMenuListener(new MenuListener() {
			@Override
			public void menuSelected(MenuEvent e) {
				JOptionPane.showMessageDialog(Z4.this, "Aplikacja stworzona przez:\nKrzysiek Bielicki\nhttp://skyman.pl", "O Autorze", JOptionPane.INFORMATION_MESSAGE);
			}
			@Override
			public void menuDeselected(MenuEvent e) {
			}
			@Override
			public void menuCanceled(MenuEvent e) {
			}
		});
		menuBar.add(about);
	}

	protected void loadFile(String absolutePath) {
		try {
			BufferedReader reader = new BufferedReader( new FileReader(absolutePath) );
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
			pack();
			painter.repaint();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new Z4();
	}
}
