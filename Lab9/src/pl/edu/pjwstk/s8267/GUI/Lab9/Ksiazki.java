package pl.edu.pjwstk.s8267.GUI.Lab9;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ksiazki extends JFrame {

	public Ksiazki(File data) {
		super("Ksiazki na stoliku");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Vector<Book> books = new Vector<Book>();
		int totalHeight = 10;
		int maxWidth = 0;
		try {
			BufferedReader reader = new BufferedReader( new FileReader(data) );
			String line;
			while((line = reader.readLine()) != null) {
				String[] d = line.trim().split("\\s+", 6);
				for(String s : d)
					System.out.println(s);
				int height = Integer.parseInt(d[1]);
				int width = Integer.parseInt(d[0]);
				maxWidth = Math.max(maxWidth, width);
				totalHeight += height;
				books.addElement(new Book(
						height,
						width,
						d[5],
						Integer.parseInt(d[2]),
						Integer.parseInt(d[3]),
						Integer.parseInt(d[4])));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setContentPane(new Painter(books, totalHeight, maxWidth));
		pack();
		setVisible(true);
	}

	class Painter extends JPanel {
		private Vector<Book> books;
		private int totalHeight;
		private int maxWidth;

		public Painter(Vector<Book> books, int totalHeight, int maxWidth) {
			this.totalHeight = totalHeight;
			this.maxWidth = maxWidth;
			Dimension dim = new Dimension(maxWidth+20, totalHeight+30);
			setSize(dim);
			setMinimumSize(dim);
			setMaximumSize(dim);
			setPreferredSize(dim);
			this.books = books;
			int t = totalHeight;
			for(Book b : books) {
				t -= b.getWidth();
				b.setPosition(10, t);
			}
		}

		@Override
		public void paint(Graphics g) {
			System.out.println("paint");
			//int i = 10;
			for(Book b : books) {
				b.drawBook(g);
			}
			g.setColor(Color.BLACK);
			g.fillRect(5, totalHeight, maxWidth+10, 10);
			g.fillRect(15, totalHeight+10, 10, 20);
			g.fillRect(maxWidth-10, totalHeight+10, 10, 20);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Ksiazki(new File(args[0]));
	}

}
