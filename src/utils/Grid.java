package utils;

public class Grid {
	
	private int hexRadius, x, y, hexApothem;
	
	private Hexagon[][] hex;
	
	private int[][] init;
	
	/*
	 * Creates a filled grid of a specified size.
	 * 
	 * @param row the number of rows
	 * @param col the number of cols
	 */
	public Grid(int row, int col, int x, int y, int radius)
	{
		hexRadius = radius;
		this.x = x;
		this.y = y;
		
		hex = new Hexagon[row][col];
		
		hexApothem = (int) (Math.cos(Math.toRadians(30.0))*hexRadius);
		
		for(int i = 0; i<hex.length; i++)
		{
			for(int j = 0; j<hex[0].length; j++)
			{
				if(i%2==0)
				{
					hex[i][j] = new Hexagon((int)(x + (3*hexRadius*j)), (int)(y + (hexApothem*i)), hexRadius);
				}
				else
				{
					hex[i][j] = new Hexagon((int)(x + ((3*hexRadius*j)+(3*hexRadius/2))), (int)(y + (hexApothem*i)), hexRadius);
				}
			}
		}
	}
	
	/*
	 * Creates a filled grid of a specified size.
	 * 
	 * @param init determines the grid, 0 = no hexagon; 1 = hexagon.
	 */
	public Grid(int[][] init, int x, int y, int radius)
	{
		hex = new Hexagon[init.length][init[0].length];
		
		hexRadius = radius;
		this.x = x;
		this.y = y;
		
		hexApothem = (int) (Math.cos(Math.toRadians(30.0))*hexRadius);
		
		for(int i = 0; i<hex.length; i++)
		{
			for(int j = 0; j<hex[0].length; j++)
			{
				if(init[i][j] == 1)
				{
					if(i%2==0)
					{
						hex[i][j] = new Hexagon((int)(x + (3*hexRadius*j)), (int)(y + (hexApothem*i)), hexRadius);
					}
					else
					{
						hex[i][j] = new Hexagon((int)(x + ((3*hexRadius*j)+(3*hexRadius/2))), (int)(y + (hexApothem*i)), hexRadius);
					}
				}
				else
				{
					hex[i][j] = null;
				}
			}
		}
	}

	/*
	 * A method for adquiring an array with the x and y positions of the grid.
	 * 
	 * @return returns an array with the x and y positions of the grid.
	 */
	public int[] getPos()
	{
		int[] a = {x,y};
		return a;
	}
	
	/*
	 * Returns a Hexagon object from a specified position in the grid.
	 * 
	 * @param row the index of the row you want to get the hexagon from
	 * @param col the index of the col you want to get the hexagon from
	 * @return the Hexagon object at the specified position
	 */
	public Hexagon getHex(int row, int col)
	{
		return hex[row][col];
	}
}
