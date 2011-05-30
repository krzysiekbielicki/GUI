package pl.edu.pjwstk.s8267.GUI.Lab10;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class OczyPanel extends JPanel {
	private Point mouse;
	public OczyPanel() {
		setBackground(Color.GREEN);
		setPreferredSize(new Dimension(100, 50));
	}
	public void setPoint(Point p) {
		mouse = p;
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		Rectangle r = getBounds();
		int diameter = Math.min(r.height-10, r.width/2-10);
		int left = ((r.width/2)-diameter-10)/2 + 5;
		int top = (r.height-diameter-10)/2 + 5;
		g.setColor(Color.YELLOW);
		g.fillOval(left, top, diameter, diameter);
		g.fillOval(r.width/2+left, top, diameter, diameter);
		g.setColor(Color.BLACK);
		g.drawOval(left, top, diameter, diameter);
		g.drawOval(r.width/2+left, top, diameter, diameter);
		
		g.fillOval((int)(r.width*0.25-diameter*0.05), (int)(r.height/2-diameter*0.05), diameter/10, diameter/10);
		g.fillOval((int)(r.width*0.75-diameter*0.05), (int)(r.height/2-diameter*0.05), diameter/10, diameter/10);
		
	}
	
}
