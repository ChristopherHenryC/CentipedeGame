/**
 *	Creates a panel for which to display the game in.
 */
 
import java.awt.*;

import javax.swing.*;
import java.util.Observer;
import java.util.Observable;
import java.util.List;

@SuppressWarnings("serial")
public class CentipedeView extends JPanel implements Observer
{
	private ImageIcon ship;
	private ImageIcon shroom;
	private Clock aClock;
		
	private CentipedeField centipedeField;
	
	/**
	 *	Sets the background to this panel to black and collects the image resources
	 *  @param theClock controller passed to the view
	 */
	
	public CentipedeView(Clock theClock)
	{
		aClock = theClock;

		try{
			java.net.URL url = CentipedeView.class.getResource("ship.png");           
			ship = new ImageIcon(url);
			java.net.URL url2 = CentipedeView.class.getResource("shroom.jpg");
			shroom = new ImageIcon(url2);
			
		} catch(Exception e){System.out.println(e.getMessage()); }
		setBackground(Color.BLACK);				
	}
	
	
	/**
	 *	Paints everything on the panel
	 *	@param g - the Graphics object in which to paint
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		//paint segments
		List<Segment> segments = centipedeField.getSegments();
		for (Segment s : segments)
		{
			// Draw each segment
			g.setColor(s.getColor());
			g.fillOval(s.getX(),s.getY(), s.getRadius(), s.getRadius());
			//g.setColor(Color.RED);
		}
		
		//paint mushrooms
		List<Mushroom> shrooms = centipedeField.getShrooms();
		for (Mushroom m : shrooms)
		{
			shroom.paintIcon(this, g, m.getX(), m.getY());
		}
		
		//paint bullets
		g.setColor(Color.RED);
		List<Bullet> bullets = centipedeField.getBullets();
		for (Bullet b: bullets)
		{
			//g.drawRect();
			g.fillRect(b.getX(), b.getY(), b.getLength(), b.getHeight());
		}
		
		//paint the ship
		ship.paintIcon(this, g, centipedeField.getShip().getX(), centipedeField.getShip().getY());
		if(centipedeField.gameOver() == true)
		{
			g.setColor(Color.orange);
			g.setFont(new Font("Verdana",1,40));
			if(centipedeField.getWin())
				g.drawString("You win!", 180, 250);
			else
				g.drawString("Game Over", 180, 250);
			aClock.stop();
		}
		
		
	}
	
	/**
    	This is executed when a change has been observed
    	@param o is the object that we are observing that a change has taken place
    	@param arg an optional argument - not used here
    */
    public void update(Observable o, Object arg)
    {
    	centipedeField = (CentipedeField)o;
    	repaint();
    	// paint the panel
    }
    
    

}