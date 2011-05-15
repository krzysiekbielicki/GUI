package pl.edu.pjwstk.s8267.GUI.Lab9;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;

class Book {
	private static int index = 0;
	private int nr;
	private int x;
	private int y;
	private int height;
	private int width;
	private String title;
	private Color color;

	void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	int getWidth() {
		return height;
	}

	Book(int height, int width, String title, int r, int g, int b) {
		this.height = height;
		this.width = width;
		this.title = title;
		color = new Color(r, g, b);
		nr = ++index;
	}

	void drawBook(Graphics g){
		g.setColor(color);
	    g.fillRect(x, y, width, height);
	    System.out.println(x+" "+y+" "+title+" "+height);
	    FontMetrics fm = g.getFontMetrics();
	    int sWidth = fm.stringWidth(title);
	    int sHeight = fm.getHeight();
	    g.setColor(Color.BLACK);
	    
	    if(width-20>=sWidth) {
	    	if(height>=sHeight)
	    		g.drawString(title, x+(width-sWidth)/2, y+(height+sHeight)/2);
	    } else {
	    	if(height>=sHeight){
		    	sWidth = fm.stringWidth(nr+"");
		    	g.drawString(nr+"", x+(width-sWidth)/2, y+(height+sHeight)/2);
	    	}
	    }
	    for(int i = 0; i < 3; i++) {
	    	g.drawLine(x+width-10+i*2, y, x+width-10+i*2, y+height-1);
	    }/**/
	  }
}
