import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class CentipedeMain extends JFrame implements ActionListener, MouseListener, MouseMotionListener, KeyListener
{
	
	private CentipedeField centipedeField;
	Clock clock;
	
	private JMenuItem m1;
	private JMenuItem m2;
	private JMenuItem m3;
	private JMenuItem m4;
	private Integer i;
	
	private CentipedeView centipedeView;
	
	/**
	 *	creates the model controller and view
	 *  associates view with model and displays model
	 */
	public CentipedeMain()
	{
		super("Centipede");
		
		i = 15;
        File theFile = new File("speedData.txt");
        
        //load saved difficulty if it exists
		if(!theFile.exists())
	    {
			try{
				theFile.createNewFile();
				
			    FileOutputStream fileOut = new FileOutputStream(theFile);
   	            ObjectOutputStream out = new ObjectOutputStream(fileOut);
   	            int tempInt = i; 
   	            out.writeObject(tempInt);
   	            out.close();
   	            fileOut.close();
			}catch(Exception e){e.printStackTrace();}
	    }
	    else
	    {
		    try {
		          FileInputStream fileIn = new FileInputStream(theFile);
		          ObjectInputStream in = new ObjectInputStream(fileIn);
			      i = (Integer) in.readObject();
			      System.out.println("do we get here");
		          in.close();
		          fileIn.close();
		       }catch(Exception e) 
		    	{
		          e.printStackTrace();
		          return;
		        }
	    }

		int time_inc = i;
		
		Color col = Color.RED;
		if(i > 15)
			col = Color.GREEN;
		else if(i < 15)
			col = Color.BLUE;
		
		final int WIDTH = 600;
		final int HEIGHT = 600;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		
		// Create the model
		centipedeField = new CentipedeField(WIDTH,HEIGHT, col);
	        	
		// Create the controller (the clock) and add the model as the listener
		clock = new Clock(centipedeField, time_inc);

		// Create the view
		centipedeView = new CentipedeView(clock);
		
		// Associate the view with the model
		centipedeField.addObserver(centipedeView);
		// Display the view of the model
		centipedeView.update(centipedeField, null);
		// Add the view to this frame
		Container c = getContentPane();
		c.add(centipedeView);
				
		setResizable(false);
		clock.start();
		
		//Menu zone
		
		JMenu memoMenu = new JMenu("Options");

        m1 = new JMenuItem("Easy"); 
        m1.addActionListener(this);

        m2 = new JMenuItem("Hard"); 
        m2.addActionListener(this);
        
        m3 = new JMenuItem("Normal"); 
        m3.addActionListener(this);
        
        m4 = new JMenuItem("Exit");
        m4.addActionListener(this);
        
        memoMenu.add(m1);
        memoMenu.add(m2);
        memoMenu.add(m3);
        memoMenu.add(m4);
        

        JMenuBar mBar = new JMenuBar();
        mBar.add(memoMenu);
        setJMenuBar(mBar);
        
        //mouse zone
        
        addMouseListener( this );
		addMouseMotionListener( this ); 
		addKeyListener( this );
	}

	/**
	 *	listens for actions involving the drop down menu
	 *	@param e the mouse click to be analyzed and responded to accordingly
	 */
	    public void actionPerformed(ActionEvent e)
	    {
	    	ArrayList<Segment> segments = (ArrayList<Segment>) centipedeField.getSegments();
	    	
	    	
	    	if(e.getSource() == m1)
	    	{
	    		for(Segment s: segments)
	    		{
	    			try{
		    			Method m = Segment.class.getDeclaredMethod("setColor", Color.class);
						m.invoke(s, Color.GREEN);
	    			}catch (Exception hrm){
	    				System.out.println(hrm.getMessage());
	    				}
	    		}
    			clock.setDelay(40);	
	    	}
	    	
	    	if(e.getSource() == m2)
	    	{
	    		for(Segment s: segments)
	    		{
	    			s.setColor(Color.BLUE);
	    		}
    			clock.setDelay(8);
    			//System.out.println(clock.getDelay());
	    	}
	    	
	    	if(e.getSource() == m3)
	    	{
	    		for(Segment s: segments)
	    		{
	    			s.setColor(Color.RED);
	    		}
    			clock.setDelay(15);
    			//System.out.println(clock.getDelay());
	    	}
	    	
	    	if(e.getSource() == m4)
	    	{
	    	  //save difficulty settings
    	      try {
    	          FileOutputStream fileOut = new FileOutputStream("speedData.txt");
    	          ObjectOutputStream out = new ObjectOutputStream(fileOut);
    	          int theInt = clock.getDelay(); 
    	          out.writeObject(theInt);
    	          out.close();
    	          fileOut.close();
    	       }catch(IOException ex) {
    	          ex.printStackTrace();
    	       }
	    			    		
	    		System.exit(0);
	    	}
	    	
	    		
	    	
	    } 
	    	
	    public void mouseClicked(MouseEvent event ){}        
        public void mousePressed(MouseEvent event ){}        
        public void mouseMoved(MouseEvent event ){}        
        public void mouseDragged(MouseEvent event ){}        
        public void mouseReleased(MouseEvent event ){}        
       	public void mouseEntered( MouseEvent event ){}       		
       	public void mouseExited( MouseEvent event ){}
       	
       	
       //key listeners
       	public void keyTyped(KeyEvent event){}
       	
       	/**
    	 *	listens for pressed keys relevant to the game
    	 *	@param event the pressed key to be analyzed and responded to
    	 */
       	public void keyPressed(KeyEvent event)
       	{
       	    if (event.getKeyCode() == KeyEvent.VK_LEFT) 
       	    {
       	    	centipedeField.setVelocity(-8);
       	    }
       	    if (event.getKeyCode() == KeyEvent.VK_RIGHT) 
       	    {
       	    	centipedeField.setVelocity(8);
       	    }
       	    if (event.getKeyCode() == KeyEvent.VK_SPACE) 
       	    {
       	    	centipedeField.shoot();
       	    }
       	    if(event.getKeyCode() == KeyEvent.VK_P)
       	    {
       	    	clock.stop();
       	    }
       	    if(event.getKeyCode() == KeyEvent.VK_R)
       	    {
       	    	clock.start();
       	    }
       	}
       	
       	public void keyReleased(KeyEvent event)
       	{
       		centipedeField.setVelocity(0);
       	}
       	

       	
		
       	/**
    	 *	Main method of the program, creates the main which runs the program
    	 *  @param args input into the terminal, not used
    	 */
	public static void main(String[] args)
	{
		CentipedeMain main = new CentipedeMain();
		main.setVisible(true);
		main.setFocusable(true);
		main.requestFocusInWindow();
	}
	
}