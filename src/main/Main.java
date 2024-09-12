package main;

import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {
		
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		window.setTitle("Cellular Automata");
		
		WindowPanel windowPanel = new WindowPanel();
		window.add(windowPanel);
		
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		windowPanel.startThread();
		
	}

}
