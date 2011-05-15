package pl.edu.pjwstk.s8267.GUI.Lab9;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Gwiazdka extends JFrame {

	public Gwiazdka(int n, int rOut, int rIn, int bgR, int bgG, int bgB,
			int fgR, int fgG, int fgB) {
		super(String.format("n=%d, rOut=%d, rIn=%d", n, rOut, rIn));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new Painter(n, rOut, rIn, bgR, bgG, bgB, fgR, fgG, fgB));
		pack();
		setVisible(true);
	}
	
	class Painter extends JPanel {
		private Color background;
		private int n;
		private Color foreground;
		private int rOut;
		private BasicStroke stroke;
		private Polygon gwiazda;

		public Painter(int n, int rOut, int rIn, int bgR, int bgG, int bgB, int fgR, int fgG, int fgB) {
			Dimension dim = new Dimension(rOut*2, rOut*2);
			setSize(dim);
			setMinimumSize(dim);
			setMaximumSize(dim);
			setPreferredSize(dim);
			//this.n = n;
			this.rOut = rOut;
			//this.rIn = rIn;
			background = new Color(bgR, bgG, bgB);
			foreground = new Color(fgR, fgG, fgB);
			stroke = new BasicStroke(2);
			gwiazda = new Polygon();
			double angle = Math.PI/n;
			for(int i = 0; i < n*2; i++) {
				gwiazda.addPoint((int)(rOut*Math.cos(angle*i))+rOut, (int)(rOut*Math.sin(angle*i))+rOut);
				i++;
				gwiazda.addPoint((int)(rIn*Math.cos(angle*i))+rOut, (int)(rIn*Math.sin(angle*i))+rOut);
			}
		}
		
		@Override
		public void paint(Graphics g) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(background);
			g2d.fillRect(0, 0, rOut*2, rOut*2);
			g2d.setColor(foreground);
			g2d.fillPolygon(gwiazda);
			g2d.setColor(Color.BLACK);
			g2d.setStroke(stroke);
			g2d.drawPolygon(gwiazda);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = Integer.parseInt(JOptionPane.showInputDialog("Liczba ramion", 5));
		int outer = Integer.parseInt(JOptionPane.showInputDialog("Promien zewnetrzny", 100));
		int inner = Integer.parseInt(JOptionPane.showInputDialog("Promien wewnetrzny", 40));
		int bgR = Integer.parseInt(JOptionPane.showInputDialog("Kolor tła - RED (0-255)", 5));
		int bgG = Integer.parseInt(JOptionPane.showInputDialog("Kolor tła - GREEN (0-255)", 5));
		int bgB = Integer.parseInt(JOptionPane.showInputDialog("Kolor tła - BLUE (0-255)", 5));
		int fgR = Integer.parseInt(JOptionPane.showInputDialog("Kolor wnętrzna - RED (0-255)", 50));
		int fgG = Integer.parseInt(JOptionPane.showInputDialog("Kolor wnętrzna - GREEN (0-255)", 50));
		int fgB = Integer.parseInt(JOptionPane.showInputDialog("Kolor wnętrzna - BLUE (0-255)", 50));
		new Gwiazdka(n, outer, inner, bgR, bgG, bgB, fgR, fgG, fgB);
	}

}
