//816006490
//Jean-Luke Chankoo
//COMP 3609
//A3
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D;
import javax.swing.JPanel;
import java.util.Random;
import java.awt.Image;


public class AlucardLose {

   private JPanel panel;
   private int x;
   private int y;

   private int width;
   private int height;
         
   private Image alucardLose;


   private int dx;      // increment to move along x-axis
   private int dy;      // increment to move along y-axis

   private Color backgroundColour;

   private int posX;
   private int posY;

   private Player player;
   //private SoundManager soundManager;








   public AlucardLose (JPanel p, int xPos, int yPos, Player player) {
      panel = p;
      backgroundColour = panel.getBackground ();

      width = 90;
      height = 130;

      
   
      x = xPos;
      y = yPos;
      dx = 0;       

      dy = 0;       

      this.player = player;

      alucardLose = ImageManager.loadImage ("images/boss/alucardLose.png");

      //soundManager = SoundManager.getInstance();
   }

   
   public void setLocation() {

    x=10;
    y=790;


   }

   public void draw (Graphics2D g2) {

      
      g2.drawImage(alucardLose, x, y, width, height, null);

   }




   }