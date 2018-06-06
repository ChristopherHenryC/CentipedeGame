/**
 *	Class to create a segment object.
 */

import java.awt.Color;

public class Segment
{
	private Color color;
	private Location loc;
	private int radius;
	public int increment = 4;
	public int upIncrement = 4;
	public int up = 0;
	public int count = 0;
	private boolean right = true;
	
	/**
	 *	Creates a centipede segment at location (0,0) with no radius
	 */
	public Segment()
	{
		color = Color.RED;
		loc = new Location();
		radius = 0;
	}
	
	/**
	 *	Creates a centipede segment with values passed
	 *	@param col the color of the segment
	 *	@param l the location of the segment
	 *	@param theRadius the radius of the segment
	 */
	 
	public Segment(Color col, Location l, int theRadius)
	{
		color = col;
		loc = l;
		radius = theRadius;
	}

	/**
	 *	Creates a segment with values passed
	 *	@param col the color of the segment
	 *	@param x the x coordinate of the segment
	 *	@param y the y coordinate of the segment
	 *	@param theRadius the radius of the segment
	 */
	public Segment(Color col, int x, int y, int theRadius)
	{
		color = col;
		loc = new Location(x, y);
		radius = theRadius;
		
	}
	
	/**
	 *	segment moves to the right
	 *	post-condition the location of the segment is moved INCREMENT
	 *					pixels to the right on the x-axis
	 * @return Integer encoding what direction a wall was hit
	 */
	public int hitWall()
	{
		if((this.getX() + radius+10 > 600) && up == 0)
			return 1;
		else if(this.getX() < 0)
			return 2;
		else if(this.getY() + this.getDiameter() > 600)
			return 3;
		else if(this.getY() < 0)
			return 4;
		else
			return 0;
		
	}	
	
	public void setIncriment(int i)
	{
		increment = i;
	}
	
	public int getCount()
	{
		return count;
	}
	
	public void setCount(int x)
	{
		count = x;
	}
	
	public void setUp(int x)
	{
		up=x;
	}
	
	public int getUp()
	{
		return up; 
	}
	
	public boolean getRight()
	{
		return right;
	}
	
	public void setRight(boolean rite)
	{
		right = rite; 
	}
	
	public void move(boolean right, int up)
	{
		if(right==true && up==0)
			loc.setX(loc.getX() + increment);
		else if(right == false && up == 0)
			loc.setX(loc.getX() - increment);
		if(up==1)
		{
			loc.setY(loc.getY() + upIncrement);
			count++;
		}
		
		else if(up==2)
		{
			
			loc.setY(loc.getY() - upIncrement);
			count++;
		}
	}
	
	
	public void setColor( Color col )
	{
		color = col;
	}
	
	/**
	 *	Returns the location of the segment
	 *	@return returns the location of the segment
	 */
	public Location getLocation()
	{
		return loc;
	}
	
	/**
	 *	Returns the x-coordinate of the segment
	 *	@return returns the x-coordinate of the segment
	 */
	public int getX()
	{
		return loc.getX();
	}
	
	/**
	 *	Returns the y-coordinate of the segment
	 *	@return returns the y-coordinate of the segment
	 */
	public int getY()
	{
		return loc.getY();
	}
	
	/**
	 *	Returns the color of the segment
	 *	@return returns the color of the segment
	 */
	public Color getColor()
	{
		return color;
	}
	
	/**
	 *	Returns the radius of the segment
	 *	@return returns the radius  of the segment
	 */
	public int getRadius()
	{
		return radius;
	}
	
	/**
	 *	Returns the diameter of the segment
	 *	@return returns the diameter  of the segment
	 */
	public int getDiameter()
	{
		return 2 * radius;
	}
	
	/**
	 *	Changes the location of the segment
	 *	@param x the new x-coordinate of the segment
	 *	@param y the new y-coordinate of the segment
	 */
	public void setLocation(int x, int y)	
	{
		loc.setX(x);
		loc.setY(y);
	}
	
	/**
	 *	Changes the x-coordinate of the segment
	 *	@param x the new x-coordinate of the segment
	 */
	public void setX(int x)
	{
		loc.setX(x);
	}
	
	/**
	 *	Changes the y-coordinate of the segment
	 *	@param y the new y-coordinate of the segment
	 */
	public void setY(int y)
	{
		loc.setY(y);
	}
	
	/**
	 *	Returns all the information about the segment
	 *	@return returns a string containing the segment's color,
	 *			x and y coordinate and radius
	 */
	public String toString()
	{
		return "Color: "+ color + " Location: " + loc + " Radius: " + radius;
	}
}