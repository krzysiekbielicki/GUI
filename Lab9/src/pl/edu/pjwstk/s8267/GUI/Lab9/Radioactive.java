package pl.edu.pjwstk.s8267.GUI.Lab9;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Radioactive extends JFrame {

	public Radioactive() {
		super("Odrobina radioaktywności");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setSize(300, 300);
		setContentPane(new Painter());
		setVisible(true);
	}
	class Painter extends JComponent {
		public Painter() {
		}
		
		@Override
		public void paint(Graphics g) {
			Graphics2D g2d = (Graphics2D) g;
			int height = getHeight();
			int width = getWidth();
			g2d.setColor(Color.GREEN);
			g2d.fillRect(0, 0, width, height);
			g2d.setColor(Color.YELLOW);
			g2d.fillOval((width-250)/2, (height-250)/2, 250, 250);
			g2d.setColor(Color.BLACK);
			g2d.drawOval((width-250)/2, (height-250)/2, 250, 250);
			int n = 7;
			int i;
			for(i = 1; i <= n; i++) {
				for(int j = 0; j < 3; j++)
					g2d.drawArc((width-250)/2+i*(125/n), (height-250)/2+i*(125/n), 250-i*(250/n), 250-i*(250/n), 60+120*j, 60);
			}
			i--;
			g2d.fillOval((width-250)/2+i*(125/n), (height-250)/2+i*(125/n), 250-i*(250/n), 250-i*(250/n));
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Radioactive();
	}

}
