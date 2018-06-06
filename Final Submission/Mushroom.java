/**
 *	Class to create a Mushroom object.
 */

public class Mushroom
{
	private Location loc;
	public int increment = 2;
	
	/**
	 *	Creates a Mushroom at location (0,0)
	 */
	public Mushroom()
	{
		loc = new Location();
	}
	
	/**
	 *	Creates a Mushroom with values passed
	 *	@param l the location of the Mushroom
	 */
	 
	public Mushroom(Location l)
	{
		loc = l;
	}

	/**
	 *	Creates a Mushroom with values passed
	 *	@param x the x coordinate of the Mushroom
	 *	@param y the y coordinate of the Mushroom
	 */
	public Mushroom(int x, int y)
	{
		loc = new Location(x, y);		
	}		 	 
		
	/**
	 *	Returns the location of the Mushroom
	 *	@return returns the location of the Mushroom
	 */
	public Location getLocation()
	{
		return loc;
	}
	
	/**
	 *	Returns the x-coordinate of the Mushroom
	 *	@return returns the x-coordinate of the Mushroom
	 */
	public int getX()
	{
		return loc.getX();
	}
	
	/**
	 *	Returns the y-coordinate of the Mushroom
	 *	@return returns the y-coordinate of the Mushroom
	 */
	public int getY()
	{
		return loc.getY();
	}
	
	/**
	 *	Changes the location of the Mushroom
	 *	@param x the new x-coordinate of the Mushroom
	 *	@param y the new y-coordinate of the Mushroom
	 */
	public void setLocation(int x, int y)	
	{
		loc.setX(x);
		loc.setY(y);
	}
	
	/**
	 *	Changes the x-coordinate of the Mushroom
	 *	@param x the new x-coordinate of the Mushroom
	 */
	public void setX(int x)
	{
		loc.setX(x);
	}
	
	/**
	 *	Changes the y-coordinate of the Mushroom
	 *	@param y the new y-coordinate of the Mushroom
	 */
	public void setY(int y)
	{
		loc.setY(y);
	}
	
	/**
	 *	Returns all the information about the Mushroom
	 *	@return returns a string containing the Mushroom's
	 *			x and y coordinate and size
	 */
	public String toString()
	{
		return "Location: " + loc;
	}
	
	/**
	 *	determines if two Mushroom objects have deep equality
	 *	@param obj another Mushroom object to be compared with the one calling equals
	 *	@return returns true if the Mushroom object passed has deep equality
	 *  returns false if obj is unequal or null
	 */
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		Mushroom m = (Mushroom) obj;
		if(m.getX() == this.getX() && m.getY() == this.getY())
			return true;
		return false;		
	}
}