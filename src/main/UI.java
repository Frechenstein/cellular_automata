package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class UI {
	
	WindowPanel wp;
	Graphics2D g2;
	
	public int commandNum = 0;
	public int titleScreenState = 0;
	
	public UI(WindowPanel wp) {
		this.wp = wp;
	}
	
	void draw(Graphics2D g2) {
		this.g2 = g2;
		
		drawMenu();
		
	}
	
	private void drawMenu() {
		
		if(titleScreenState == 0) {
			g2.setColor(new Color(160, 130, 3));
			g2.fillRect(0, 0, wp.screenWidth, wp.screenHeight);
			
			
			// TITLE NAME
			g2.setFont(g2.getFont().deriveFont(Font.BOLD, 96F));
			String text1 = "Cellular Automata";
			String text2 = "Simulator";
			
			int x1 = getXforCenteredText(text1);
			int y1 = wp.cellSize * 20;
			
			int x2 = getXforCenteredText(text2);
			int y2 = wp.cellSize * 25;
			
			// SHADOW
			g2.setColor(Color.black);
			g2.drawString(text1, x1+3, y1+3);
			g2.setColor(Color.black);
			g2.drawString(text2, x2+3, y2+3);
			// MAIN COLOR
			g2.setColor(Color.white);
			g2.drawString(text1, x1, y1);
			g2.setColor(Color.white);
			g2.drawString(text2, x2, y2);
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

}
