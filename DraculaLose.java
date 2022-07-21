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


public class DraculaLose {

   private JPanel panel;
   private int x;
   private int y;

   private int width;
   private int height;
         
   private Image draculaLose;


   private int dx;      // increment to move along x-axis
   private int dy;      // increment to move along y-axis

   private Color backgroundColour;

   private int posX;
   private int posY;

   private Player player;








   public DraculaLose (JPanel p, int xPos, int yPos, Player player) {
      panel = p;
      backgroundColour = panel.getBackground ();

      width=90;
      height=130;

      
   
      x = xPos;
      y = yPos;
      dx = 0;       

      dy = 0;       

      this.player = player;

      draculaLose = ImageManager.loadImage ("images/boss/draculaLose.png");

   }

   
   public void setLocation() {

    x=1730;
    y=790;


   }

   public void draw (Graphics2D g2) {

      
      g2.drawImage(draculaLose, x, y, width, height, null);

   }




   }