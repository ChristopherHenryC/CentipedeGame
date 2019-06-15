/**
 *	Class to create a ship object.
 */


public class Ship
{
	private Location loc;
	
	/**
	 *	Creates a ship at location (0,0) with no radius
	 */
	public Ship()
	{;
		loc = new Location();
	}
	
	/**
	 *	Creates a ship with values passed
	 *	@param l the location of the ship
	 */
	 
	public Ship( Location l)
	{
		loc = l;
	}

	/**
	 *	Creates a ship with values passed
	 *	@param x the x coordinate of the ship
	 *	@param y the y coordinate of the ship
	 */
	public Ship(int x, int y)
	{
		loc = new Location(x, y);
		
	}
	 	 			
	/**
	 *	Returns the location of the ship
	 *	@return returns the location of the ship
	 */
	public Location getLocation()
	{
		return loc;
	}
	
	/**
	 *	Returns the x-coordinate of the ship
	 *	@return returns the x-coordinate of the ship
	 */
	public int getX()
	{
		return loc.getX();
	}
	
	/**
	 *	Returns the y-coordinate of the ship
	 *	@return returns the y-coordinate of the ship
	 */
	public int getY()
	{
		return loc.getY();
	}
	
	/**
	 *	Changes the location of the ship
	 *	@param x the new x-coordinate of the ship
	 *	@param y the new y-coordinate of the ship
	 */
	public void setLocation(int x, int y)	
	{
		loc.setX(x);
		loc.setY(y);
	}
	
	/**
	 *	Changes the x-coordinate of the ship
	 *	@param x the new x-coordinate of the ship
	 */
	public void setX(int x)
	{
		loc.setX(x);
	}
	
	/**
	 *	Changes the y-coordinate of the ship
	 *	@param y the new y-coordinate of the ship
	 */
	public void setY(int y)
	{
		loc.setY(y);
	}
	
	/**
	 *	Returns all the information about the ship
	 *	@return returns a string containing the ship's color,
	 *	x and y coordinate and radius
	 */
	public String toString()
	{
		return " Location: " + loc;
	}
}