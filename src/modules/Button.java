package modules;

import java.awt.Graphics2D;

import main.WindowPanel;

public class Button {
	
	WindowPanel wp;
	Graphics2D g2;
	
	String text;
	
	Integer x;
	Integer y;
	int width;
	int height;

	public Button(WindowPanel wp) {
		this.wp = wp;
	}
	
	public void setTextY(String text, int y) {
		this.text = text;
		this.y = y;
	}
	
	public void setTextXY(String text, int x, int y) {
		this.text = text;
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics2D g2) {
		this.g2 = g2;
		
		if(x == null) {
			x = getXforCenteredText(text) + 20;
			width = getTextWidth(text) + 40;
		}
		
	}
	
	/**
	 * Returns x-coordinates for a text window based on its width, to place it centered.
	 * 
	 * @param text String with the text to display.
	 * @return x int with the x-coordinate for the text to be centered.
	 */
	public int getXforCenteredText(String text) {
		int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = wp.screenWidth / 2 - length / 2;
		return x;
	}
	
	public int getTextWidth(String text) {
		return (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
	}
	
}
