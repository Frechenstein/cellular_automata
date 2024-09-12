package cellular_automata;

import java.awt.Color;
import java.awt.Graphics2D;

import main.WindowPanel;

public class ConwaysGameOfLife {
	
	WindowPanel wp;
	
	int cellSize;
	int screenRows;
	int screenCols;
	
	// CELLS
	boolean[][] cells;
	boolean[][] nextCells;
	
	
	public ConwaysGameOfLife(WindowPanel wp) {
		
		this.wp = wp;
		
		this.cellSize = wp.cellSize;
		this.screenRows = wp.screenRows;
		this.screenCols = wp.screenCols;
		
		cells = new boolean[screenCols][screenRows];
		nextCells = new boolean[screenCols][screenRows];
		
		spawnConwayObjects();
		
	}
	
	private void spawnConwayObjects() {
		//CLOCK
		cells[19][10] = true;
		cells[19][11] = true;
		cells[20][12] = true;
		cells[20][13] = true;
		cells[18][12] = true;
		cells[21][11] = true;
		
		//PULSATOR
		cells[4][5] = true;
		cells[5][5] = true;
		cells[7][5] = true;
		cells[8][5] = true;
		cells[9][5] = true;
		cells[10][5] = true;
		cells[12][5] = true;
		cells[13][5] = true;
		
		cells[6][4] = true;
		cells[6][6] = true;
		cells[11][4] = true;
		cells[11][6] = true;
		
		//OCATGON
		cells[30][3] = true;
		cells[30][5] = true;
		cells[30][6] = true;
		cells[30][8] = true;
		
		cells[33][3] = true;
		cells[33][5] = true;
		cells[33][6] = true;
		cells[33][8] = true;

		cells[29][4] = true;
		cells[31][4] = true;
		cells[32][4] = true;
		cells[34][4] = true;
		
		cells[29][7] = true;
		cells[31][7] = true;
		cells[32][7] = true;
		cells[34][7] = true;
		
		//SAILOR 1 LWSS
		cells[5][18] = true;
		cells[5][20] = true;
		cells[8][20] = true;
		
		cells[6][17] = true;
		cells[7][17] = true;
		cells[8][17] = true;
		cells[9][17] = true;
		cells[9][18] = true;
		cells[9][19] = true;
	}
	
	public void update() {
		updateConway();
	}
	
	private void updateConway() {
		for(int r = 0; r < screenRows; r++) {
			for(int c = 0; c < screenCols; c++) {
				updateCellConway(c, r);
			}
		}
		updateCells();
	}
	
	private void updateCells() {
		for(int r = 0; r < screenRows; r++) {
			for(int c = 0; c < screenCols; c++) {
				cells[c][r] = nextCells[c][r];
				nextCells[c][r] = false;
			}
		}
	}
	
	private void updateCellConway(int x, int y) {
		
		int amountNeigbours = checkNeighbours(x, y);
		
		if((cells[x][y] && amountNeigbours == 2) || cells[x][y] && amountNeigbours == 3) {
			nextCells[x][y] = true;
		} else if(cells[x][y] == false && amountNeigbours == 3) {
			nextCells[x][y] = true;
		} else {
			nextCells[x][y] = false;
		}
		
	}
	
	private int checkNeighbours(int x, int y) {
		
		int amount = 0;
		
		if(x > 0) {
			if(cells[x-1][y]) amount++;
		}
		
		if(y > 0) {
			if(cells[x][y-1]) amount++;
		}
		
		if(x < screenCols-1) {
			if(cells[x+1][y]) amount++;
		}
		
		if(y < screenRows-1) {
			if(cells[x][y+1]) amount++;
		}
		
		if(x > 0 && y > 0) {
			if(cells[x-1][y-1]) amount ++;
		}
		
		if(x > 0 && y < screenRows-1) {
			if(cells[x-1][y+1]) amount++;
		}
		
		if(x < screenCols-1 && y > 0) {
			if(cells[x+1][y-1]) amount++;
		}
		
		if(x < screenCols-1 && y < screenRows-1) {
			if(cells[x+1][y+1]) amount++;
		}
		
		return amount;
	}
	
	public void draw(Graphics2D g2) {
		
		drawCells(g2);
		
	}
	
	private void drawCells(Graphics2D g2) {
		for(int r = 0; r < screenRows; r++) {
			for(int c = 0; c < screenCols; c++) {
				if(cells[c][r]) {
					g2.setColor(Color.white);
					g2.fillRect(c * cellSize, r * cellSize, cellSize, cellSize);
				}
			}
		}
	}
}
