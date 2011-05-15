package pl.edu.pjwstk.s8267.GUI.Lab9;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Plotek extends JFrame {

	private Color background;
	private Color plot;

	/**
	 * @param width
	 * @param height
	 * @param n
	 */
	public Plotek(int width, int height, int n) {
		super(String.format("Płotek (%dx%d) żerdzi: %d", width, height, n));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setSize(width, height);
		setContentPane(new Painter(n));
		setVisible(true);
		background = Color.ORANGE;
		plot = Color.BLUE;
	}
	class Painter extends JComponent {
		private int n;
		public Painter(int n) {
			this.n = n;
		}
		
		@Override
		public void paint(Graphics g) {
			double przerwa = (double)getWidth()/(double)(n*5);
			int height = getHeight();
			double szerokosc = przerwa*3;
			System.out.println(getWidth());
			System.out.println(szerokosc);
			System.out.println(przerwa);
			
			g.setColor(background);
			g.fillRect(0, 0, getWidth(), getHeight());
			g.setColor(plot);
			double margin = przerwa;
			for(int i = 0; i < n; i++) {
				g.drawLine((int)margin, (int)(przerwa+szerokosc), (int)margin, (int)(height-przerwa));
				g.drawLine((int)margin, (int)(przerwa+szerokosc), (int)(margin+szerokosc/2), (int)przerwa);
				g.drawLine((int)(margin+szerokosc), (int)(przerwa+szerokosc), (int)(margin+szerokosc/2), (int)przerwa);
				g.drawLine((int)margin, (int)(height-przerwa), (int)(margin+szerokosc), (int)(height-przerwa));
				g.drawLine((int)(margin+szerokosc), (int)(przerwa+szerokosc), (int)(margin+szerokosc), (int)(height-przerwa));
				margin += przerwa*2+szerokosc;
			}
			int x = (int)(getHeight() - przerwa - szerokosc);
			g.fillRect(3, (int) (szerokosc+x*0.3), getWidth()-6, 3);
			g.fillRect(3, (int) (szerokosc+x*0.7), getWidth()-6, 3);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Plotek(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
	}

}
