import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class Clock implements ActionListener
{
	private Timer timer;
	private int timeIncr;  // in milliseconds
	private CentipedeField centipedeField;
	
	/**
	 *	Creates a timer object with the given data
	 *	@param theCentipedeField the listener for the timer
	 *	@param dt the interval duration time in milliseconds that timer fires
	 */
	public Clock(CentipedeField theCentipedeField, int dt)
	{
		centipedeField = theCentipedeField;
		timeIncr = dt;
		timer = new Timer(timeIncr, this);
	}  
	
	/**
	 *	Starts the timer
	 */
	public void start()
	{
		timer.start();
	}
	
	/**
	 *	@return integer describing milliseconds delay
	 */
	public int getDelay()
	{
		return timer.getDelay();
	}
	
	/**
	 *	Stops the timer
	 */
	public void stop()
	{
		timer.stop();
	}
	
	public void setDelay(int i)
	{
		timer.setDelay(i);
	}
	
	/**
	 *	Called automatically when the timer fires.
	 *	@param e contains the action event
	 *	postcondition Move all Objects in the model every time the timer goes off
	 */
	public void actionPerformed(ActionEvent e)
	{
		// Tell the model to move the objects.
		if(e.getSource() == timer)
		{
			Thread t = new Thread()
			{
				public void run()
				{
					centipedeField.moveSegments();
				}
				
			};
			t.run();
			centipedeField.moveShip();
			centipedeField.moveBullets();			
			
		}
	}
}
