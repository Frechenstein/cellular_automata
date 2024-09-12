package main;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

public class IOhandler implements MouseListener, KeyListener{

	WindowPanel wp;
	
	public IOhandler(WindowPanel wp) {
		this.wp = wp;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		PointerInfo a = MouseInfo.getPointerInfo();
		Point point = new Point(a.getLocation());
		SwingUtilities.convertPointFromScreen(point, e.getComponent());
		int[] mouseXY = new int[2];
		mouseXY[0] =(int) point.getX();
		mouseXY[1] =(int) point.getY();
		
		System.out.println(mouseXY[0] + ", " + mouseXY[1]);
		//return mouseXY;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		if(wp.simulationState == wp.menuState) {
			if(code == KeyEvent.VK_ESCAPE) wp.simulationState = wp.conwayState;
		}
		else if(wp.simulationState == wp.conwayState) {
			if(code == KeyEvent.VK_ESCAPE) wp.simulationState = wp.menuState;
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
