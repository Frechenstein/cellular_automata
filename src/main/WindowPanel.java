package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import cellular_automata.ConwaysGameOfLife;

public class WindowPanel extends JPanel implements Runnable{

	// SYSTEM VARIABLES
	int FPS = 3;
	
	public int cellSize = 16;
	public int screenRows = 50;
	public int screenCols = 80;
	
	public int screenWidth = cellSize * screenCols;
	public int screenHeight = cellSize * screenRows;
	
	// SYSTEM
	Thread thread;
	IOhandler ioHandler = new IOhandler(this);
	
	UI ui;
	
	int simulationState;
	int menuState = 0;
	int conwayState = 1;
	
	// CELLS
	boolean[][] cells = new boolean[screenCols][screenRows];
	boolean[][] nextCells = new boolean[screenCols][screenRows];
	
	// VARIATIONS
	ConwaysGameOfLife cgol;
	
	public WindowPanel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.setFocusable(true);
		this.addMouseListener(ioHandler);
		this.addKeyListener(ioHandler);
		
		ui = new UI(this);
		cgol = new ConwaysGameOfLife(this);
		
		simulationState = menuState;
		
	}
	
	public void startThread() {
		thread = new Thread(this);
		thread.start();
	}
	
	
	@Override
	public void run() {
		
		double drawIntervall = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;
		
		while(thread != null) {
			
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawIntervall;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			if(delta >= 1) {
				update();
				repaint();
				delta--;
				drawCount++;
			}
			
			if(timer >= 1000000000) {
				drawCount = 0;
				timer = 0;
			}
			
		}
		
	}
	
	public void update() {
		
		if(simulationState == conwayState) {
			//updateConway();
			cgol.update();
		}
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		if(simulationState == menuState) {
			ui.draw(g2);
		}
		if(simulationState == conwayState) {
			//drawGrid(g2);
			cgol.draw(g2);
		}
		
		
	}
	
	public void drawGrid(Graphics2D g2) {
		
		for(int r = 0; r < screenRows; r++) {
			for(int c = 0; c < screenCols; c++) {
				g2.drawRect(c * cellSize, r * cellSize, cellSize, cellSize);
			}
		}
		
	}

}
