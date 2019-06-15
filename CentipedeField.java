
import java.util.*;
import java.awt.Color;

public class CentipedeField extends Observable
{	
	
	
	private Ship theShip;
	private int shipVelocity = 0;
	private List<Segment> segments;	
	private List <Mushroom> shrooms;
	private ArrayList<Bullet> bullets;
	
	private boolean gameOver = false;
	private boolean win = false;
		

	public CentipedeField(int width, int height, Color col)
	{
		theShip = new Ship(270, 480);
		
		bullets = new ArrayList<Bullet>();
		
		segments = new ArrayList<Segment>();
		for(int i = 0; i <= 10; i++)
		{
			segments.add(new Segment(col, (10 + (i*20)), 0, 20));
		}	
		
		shrooms = new ArrayList<Mushroom>();
		for(int i = 0; i<=35; i++)
		{
			int y = (int) (20 * Math.floor(Math.random()*22+1));
			int x = (int) (20 * Math.floor(Math.random()*26+1));
			shrooms.add(new Mushroom(x, y));
		}
		
	}
	
	/**
	 *	Returns a list of all the segments
	 *	@return returns a list of all segments 
	 */
	public List<Segment> getSegments()
	{
		return segments;
	}
	
	public void moveSegments()
	{
		if(segments.isEmpty())
		{
			win = true;
			gameOver = true;
			setChanged();
			notifyObservers();
			return;
		}
		
		for(int k = 0; k<segments.size(); k++)
		{
			
			if(segments.get(k).getCount()>= 5)
			{
				segments.get(k).setCount(0);
				segments.get(k).setUp(0);
			}
		
			
			segments.get(k).move(segments.get(k).getRight(), segments.get(k).getUp());
							
			//wall detection
				
			if(segments.get(k).hitWall() == 1)
			{
				segments.get(k).setRight(false);
				segments.get(k).setUp(1);
			}	
			if(segments.get(k).hitWall() == 2)
			{
				segments.get(k).setRight(true);
				segments.get(k).setUp(1);
			}
				
			if(segments.get(k).hitWall() == 3)
				segments.get(k).setUp(1);
				
			if(segments.get(k).hitWall() == 4)
				segments.get(k).setUp(2);
			
			//shroom detection
			for(Mushroom m: shrooms)
			{
				if(segments.get(k).getY() == m.getY() && (segments.get(k).getUp() == 0))
				{
					if(segments.get(k).getX() > m.getX() && (segments.get(k).getX()) - m.getX() <= 20)
					{
						segments.get(k).setRight(true);
						segments.get(k).setUp(1);
					}
					
					if(segments.get(k).getX() < m.getX() && (m.getX() - segments.get(k).getX()) <= 20)
					{
						segments.get(k).setRight(false);
						segments.get(k).setUp(1);
					}
				}	
					
			}
			
			if(segments.get(k).getY() >= 480 && segments.get(k).getX() - theShip.getX() <= 20 && segments.get(k).getX() - theShip.getX() >= 0)
			{
				gameOver = true;
				
			}
			
			
	
			
				
		}		
		setChanged();
		notifyObservers();
		
		// Set changes and notify observers
	}
	
	public List<Mushroom> getShrooms()
	{
		return shrooms;
	}
	
	public Ship getShip()
	{
		return theShip;
	}
	
	public void moveShip()
	{
		if(shipVelocity < 0 && theShip.getX() < 0 )
			return;
		if(shipVelocity > 0 && theShip.getX() > 530 )
			return;
		theShip.setX(theShip.getX() + shipVelocity);		
	}
	
	public void setVelocity(int i)
	{
		shipVelocity = i;
	}
	
	public void shoot()
	{
		if(bullets.size() < 2)
			bullets.add(new Bullet(Color.RED, theShip.getX() + 29, 480, 4));
	}
	
	public void moveBullets()
	{
		if(!bullets.isEmpty())
		{
			List<Bullet> bulletsRemoved = new ArrayList<Bullet>();
			for(Bullet b: bullets)
			{
				b.setY(b.getY() - 10);
				
				List<Mushroom> shroomsRemoved = new ArrayList<Mushroom>();
				for(Mushroom m: shrooms)
				{
					if(b.getY() - (m.getY() + 10) <= 0 && ( b.getX() >= m.getX() && b.getX() <= m.getX() + 20 ))
					{
						bulletsRemoved.add(b);
						shroomsRemoved.add(m);
					}						
				}
				shrooms.removeAll(shroomsRemoved);								
			}
			bullets.removeAll(bulletsRemoved);
			for(Bullet b: bullets)
			{
				List<Segment> segsRemoved = new ArrayList<Segment>();
				for(Segment s: segments)
				{
					if(b.getY() - (s.getY() + 10) <= 0 && ( b.getX() >= s.getX() && b.getX() <= s.getX() + 10 ))
					{
						bulletsRemoved.add(b);
						segsRemoved.add(s);
						shrooms.add(new Mushroom(s.getX(),s.getY()));
					}						
				}
				segments.removeAll(segsRemoved);
			}
			bullets.removeAll(bulletsRemoved);
		}
	}
	
	public List<Bullet> getBullets()
	{
		return bullets;
	}
	
	
	public boolean gameOver()
	{
		return gameOver;
	}
	
	public boolean getWin()
	{
		return win;
	}
	

}