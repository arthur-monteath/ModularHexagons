package main;

import input.*;
import utils.Grid;
import utils.Hexagon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panel extends JPanel {

	public int x=Toolkit.getDefaultToolkit().getScreenSize().width,y=Toolkit.getDefaultToolkit().getScreenSize().height;
	
	private BufferedImage img;
	
	public Panel()
	{
		addKeyListener(new KeyboardInput(this)); // listens to keyboard input.
		
		this.setBackground(new Color(54, 41, 35)); // Sets the color of the background.
	}
	
	public void increaseWidth(int inc)
	{
		w+= w+inc>0 ? inc : 0;
		repaint();
	}
	
	public void increaseHeight(int inc)
	{
		h+= h+inc>0 ? inc : 0;
		repaint();
	}
	
	int w=3,h=10;
	
	/*
	 * Paints the graphic to the screen, call it again trough repaint();
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g); // calls the JPanel's paint component method this is used to clean the surface
		int pos = 32;
		
		Color HexagonColor = new Color(222,180,108,255);
		Color HexagonBorder = Color.white;
		
		/*
		 *  0: null
		 *  
		 *  1: Hexagon
		 */
		int[][] init = {
				{	0,0,1,0,0	},
				{	 0,1,1,0,0  },
				{	0,1,1,1,0   },
				{	 1,1,1,1,0	},
				{	1,1,1,1,1	},
				{	 1,1,1,1,0	},
				{	0,1,1,1,0	},
				{	 0,1,1,0,0	},
				{	0,0,1,0,0	}
		}; 
		/*
		 *  if you rotate this 90° to the left it will turn into the figure you want.
		 */
		
		Grid hexGrid = new Grid(init, 50,50,16);
		
		for(int i = 0; i<init.length; i++)
		{
			for(int j = 0; j<init[0].length; j++)
			{
				if(hexGrid.getHex(i,j) != null)
				{
					/*
					 * if there is a Hexagon, it will paint it and then add the border.
					 */
					g.setColor(HexagonColor);
					g.fillPolygon(
							hexGrid.getHex(i,j).getPoints()[0],
							hexGrid.getHex(i,j).getPoints()[1], 
							hexGrid.getHex(i,j).getPoints()[0].length);
					
					g.setColor(HexagonBorder);
					g.drawPolygon(
							hexGrid.getHex(i,j).getPoints()[0],
							hexGrid.getHex(i,j).getPoints()[1], 
							hexGrid.getHex(i,j).getPoints()[0].length);
				}	
			}
		}
		
		hexGrid = new Grid(h,w,50,250,32);
		
		for(int i = 0; i<h; i++)
		{
			for(int j = 0; j<w; j++)
			{
				if(hexGrid.getHex(i,j) != null)
				{
					/*
					 * if there is a Hexagon, it will paint it and then add the border.
					 */
					g.setColor(HexagonColor);
					g.fillPolygon(
							hexGrid.getHex(i,j).getPoints()[0],
							hexGrid.getHex(i,j).getPoints()[1], 
							hexGrid.getHex(i,j).getPoints()[0].length);
					
					g.setColor(HexagonBorder);
					g.drawPolygon(
							hexGrid.getHex(i,j).getPoints()[0],
							hexGrid.getHex(i,j).getPoints()[1], 
							hexGrid.getHex(i,j).getPoints()[0].length);
				}	
			}
		}
	}
}
