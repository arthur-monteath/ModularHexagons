package utils;

public class Hexagon {

	private int[] x, y;
	private int xPos, yPos;
	private int radius;
	
	// @param r = radius of the hexagon
	public Hexagon(int xPos, int yPos, int r)
	{
		this.xPos = xPos;
		this.yPos = yPos;
		this.radius = r;
		
		x = new int[6];
		y = new int[6];
		
		x[0] = r;
		x[1] = (int) Math.round(Math.cos(Math.toRadians(60.0))*r);
		x[2] = (int) Math.round(Math.cos(Math.toRadians(120.0))*r);
		x[3] = -r;
		x[4] = (int) Math.round(Math.cos(Math.toRadians(240.0))*r);
		x[5] = (int) Math.round(Math.cos(Math.toRadians(300.0))*r);
		
		y[0] = 0;
		y[1] = (int) Math.round(Math.sin(Math.toRadians(60.0))*r);
		y[2] = (int) Math.round(Math.sin(Math.toRadians(120.0))*r);
		y[3] = 0;
		y[4] = (int) Math.round(Math.sin(Math.toRadians(240.0))*r);
		y[5] = (int) Math.round(Math.sin(Math.toRadians(300.0))*r);
		
		for(int i = 0; i<x.length; i++)
		{
			x[i] += xPos;
			y[i] += yPos;
		}
	}
	
	public int[][] getPoints()
	{
		int[][] a = {x,y};
		return a;
	}
	
	public int getApothem()
	{
		return (int) (Math.cos(Math.toRadians(30.0))*radius);
	}
	
	public int[] getPos()
	{
		int[] a = {xPos, yPos};
		return a;
	}
}
