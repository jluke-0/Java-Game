//816006490
//Jean-Luke Chankoo
//COMP 3609
//A3
import java.awt.Image;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.*;
import java.util.Random;
import java.awt.Color;




public class DraculaAnimation {

    private JPanel panel;					
    private ArrayList<AnimFrame> frames;			
    private int currFrameIndex;					
    private long animTime;					
    private long startTime;					
    private long totalDuration;					

   private int x;
   private int y;

   private int width;
   private int height;
			


   private int dx;		
   private int dy;		

   private Player player;
   private PlayerAttackLeft lAttack;
 
   private Color backgroundColour;
   public int hp=8;


 
    public DraculaAnimation(JPanel p, int xPos, int yPos, Player player) {
	panel = p;
        frames = new ArrayList<AnimFrame>();
        totalDuration = 0;
        start();

	    x = xPos;
        y = yPos;
        dx = 0;
        dy = 0;
        width=90;
        height=130;

        backgroundColour = panel.getBackground ();
         

    }



    public synchronized void addFrame(Image image, long duration)
    {
        totalDuration += duration;
        frames.add(new AnimFrame(image, totalDuration));

    }

    public synchronized void start() {

        animTime = 0;						
        currFrameIndex = 0;					
	startTime = System.currentTimeMillis();			
    }


    public synchronized void update() {
        
    
        long currTime = System.currentTimeMillis();		
	long elapsedTime = currTime - startTime;		
	startTime = currTime;					
    
        if (frames.size() > 1) {
            animTime += elapsedTime;				
            if (animTime >= totalDuration) {			
                animTime = animTime % totalDuration;		
                currFrameIndex = 0;				
                
            }

            while (animTime > getFrame(currFrameIndex).endTime) {
                currFrameIndex++;				

            }
            
 

        
        }
        
        
        


    }



    public synchronized Image getImage() {
        if (frames.size() == 0) {
            return null;
        }
        else {
            return getFrame(currFrameIndex).image;
        }
    }

    public void draw (Graphics2D g2) {				
 


       g2.drawImage(getImage(), x, y, width, height, null);

      


      
  

    }

    public int getNumFrames() {					// find out how many frames in animation
	return frames.size();
    }

    private AnimFrame getFrame(int i) {				// returns ith frame in the collection
        return frames.get(i);
    }


    private class AnimFrame {					// inner class for the frames of the animation

        Image image;
        long endTime;

        public AnimFrame(Image image, long endTime) {
            this.image = image;
            this.endTime = endTime;
        }
    }




    public Rectangle2D.Double getBoundingRectangle() {
        return new Rectangle2D.Double (x, y, width, height);
     }

     public void setLocation() {



            x=5000;
            y=5000;

     }
}