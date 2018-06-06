/**
 *	Class to create a bullet object.
 */

import java.awt.Color;

public class Bullet
{
	private Color color;
	private Location loc;
	private int length;
	
	/**
	 *	Creates a Bullet at location (0,0) with no length
	 */
	public Bullet()
	{
		color = Color.RED;
		loc = new Location();
		length = 0;
	}
	
	/**
	 *	Creates a Bullet with values passed
	 *	@param col the color of the bullet
	 *	@param l the location of the bullet
	 *	@param theLength the length of the bullet
	 */
	 
	public Bullet(Color col, Location l, int theLength)
	{
		color = col;
		loc = l;
		length = theLength;
	}

	/**
	 *	Creates a bullet with values passed
	 *	@param col the color of the bullet
	 *	@param x the x coordinate of the bullet
	 *	@param y the y coordinate of the bullet
	 *	@param theLength the length of the bullet
	 */
	public Bullet(Color col, int x, int y, int theLength)
	{
		color = col;
		loc = new Location(x, y);
		length = theLength;
		
	}
	
	public void setColor( Color col )
	{
		color = col;
	}
	
	/**
	 *	Returns the location of the bullet
	 *	@return returns the location of the bullet
	 */
	public Location getLocation()
	{
		return loc;
	}
	
	/**
	 *	Returns the x-coordinate of the bullet
	 *	@return returns the x-coordinate of the bullet
	 */
	public int getX()
	{
		return loc.getX();
	}
	
	/**
	 *	Returns the y-coordinate of the bullet
	 *	@return returns the y-coordinate of the bullet
	 */
	public int getY()
	{
		return loc.getY();
	}
	
	/**
	 *	Returns the color of the bullet
	 *	@return returns the color of the bullet
	 */
	public Color getColor()
	{
		return color;
	}
	
	/**
	 *	Returns the length of the bullet
	 *	@return returns the length  of the bullet
	 */
	public int getHeight()
	{
		return length * 3;
	}
	
	/**
	 *	Returns the diameter of the bullet
	 *	@return returns the diameter  of the bullet
	 */
	public int getLength()
	{
		return length;
	}
	
	/**
	 *	Changes the location of the bullet
	 *	@param x the new x-coordinate of the bullet
	 *	@param y the new y-coordinate of the bullet
	 */
	public void setLocation(int x, int y)	
	{
		loc.setX(x);
		loc.setY(y);
	}
	
	/**
	 *	Changes the x-coordinate of the bullet
	 *	@param x the new x-coordinate of the bullet
	 */
	public void setX(int x)
	{
		loc.setX(x);
	}
	
	/**
	 *	Changes the y-coordinate of the bullet
	 *	@param y the new y-coordinate of the bullet
	 */
	public void setY(int y)
	{
		loc.setY(y);
	}
	
	/**
	 *	Returns all the information about the bullet
	 *	@return returns a string containing the bullet's color,
	 *	x and y coordinate and length
	 */
	public String toString()
	{
		return "Color: "+ color + " Location: " + loc + " length: " + length;
	}
}