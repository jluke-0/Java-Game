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


public class Won {

   private JPanel panel;
   private int x;
   private int y;

   private int width;
   private int height;
         
   private Image won;


   private int dx;      // increment to move along x-axis
   private int dy;      // increment to move along y-axis

   private Color backgroundColour;

   private int posX;
   private int posY;

   private Player player;




   public Won (JPanel p, int xPos, int yPos, int widthX, int heightX, Player player) {
      panel = p;
      backgroundColour = panel.getBackground ();

      width=widthX;
      height=heightX;

      
   
      x = xPos;
      y = yPos;
      dx = 0;       

      dy = 0;       

      this.player = player;

      won = ImageManager.loadImage ("images/won/winScreen.png");

   }

   
   public void setLocation() {

    x=1730;
    y=790;


   }

   public void draw (Graphics2D g2) {

      
      g2.drawImage(won, x, y, width, height, null);

   }




   }