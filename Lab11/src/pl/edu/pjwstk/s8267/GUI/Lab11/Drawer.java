package pl.edu.pjwstk.s8267.GUI.Lab11;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Iterator;
import java.util.List;

import javax.swing.JComponent;

public class Drawer extends JComponent {
	public static final int CIRCLE = 0;
	public static final int SQUARE = 1;
	public static final int CROSS = 2;
	private List<Point> points;
	private int shape;
	private Color shapeColor = Color.RED;
	private Color lineColor = Color.YELLOW;
	private boolean drawLine = false;

	public void setPoints(List<Point> points) {
		this.points = points;
		int width = 0;
		int height = 0;
		Point p;
		for ( Iterator<Point> it = points.iterator(); it.hasNext(); ) {
			p = it.next();
			width = Math.max(width, p.x);
			height = Math.max(height, p.y);
		}
		setPreferredSize(new Dimension(width+6, height+6));
	}
	
	public void setShape(int shape) {
		this.shape = shape;
	}

	public void setShapeColor(Color color) {
		this.shapeColor = color;
	}
	
	public void setLineColor(Color color) {
		this.lineColor = color;
	}
	
	public void setDrawLine(boolean b) {
		this.drawLine = b;
	}
	
	public void paint(Graphics g) {
		if(points == null) return;
		Point prev = null;
		Point p;
		for ( Iterator<Point> it = points.iterator(); it.hasNext(); ) {
			p = it.next();
			paintPoint(g, p.x, p.y);
			if(drawLine && prev != null) {
				g.setColor(lineColor);
				g.drawLine(prev.x, prev.y, p.x, p.y);
			}
			prev = p;
		}
	}
	
	private void paintPoint(Graphics g, int x, int y) {
		g.setColor(shapeColor);
		switch(shape) {
		case CIRCLE:
			g.fillOval(x-3, y-3, 6, 6);
			break;
		case SQUARE:
			g.fillRect(x-3, y-3, 6, 6);
			break;
		case CROSS:
			g.drawLine(x-3, y-3, x+3, y+3);
			g.drawLine(x+3, y-3, x-3, y+3);
			break;
		}
	}
}
