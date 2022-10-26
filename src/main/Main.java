package main;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {
		
		Panel panel = new Panel();
		JFrame frame = new JFrame();
		
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
		panel.requestFocus();
	}

}
