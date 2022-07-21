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
import java.lang.Math;

public class GargoyleWomanAttack2 {

   private JPanel panel;
   private int x;
   private int y;

   private int width;
   private int height;
         
   private Image enemyAttackDown;


   private int dx;      // increment to move along x-axis
   private int dy;      // increment to move along y-axis

   private Color backgroundColour;

   private int posX;
   private int posY;

   private Player player;
   private SoundManager soundManager;

   private int temp;







   public GargoyleWomanAttack2 (JPanel p, int xPos, int yPos, Player player) {
      panel = p;
      backgroundColour = panel.getBackground ();

      width = 80;
      height = 100;

      
   
      x = xPos;
      y = yPos;
      dx = 0;       

      dy = 10;       

      this.player = player;

      enemyAttackDown = ImageManager.loadImage ("images/attacks/enemy_attack1.png");

      soundManager = SoundManager.getInstance();
   }

   
   public void setLocation() {


    x=850;
    y=270;


   }

   public void draw (Graphics2D g2) {

      
      g2.drawImage(enemyAttackDown, x, y, width, height, null);

   }

   public void move() {

      if (!panel.isVisible ()) return;


      x = x + dx;
      y = y + dy;






     
      int width= panel.getWidth();

   boolean collision = collidesWithPlayer();
   if(y>=920 || x>=1819 || x<=0|| collision){
      if(collision){
         System.out.println("HIT! By Gargoyle fire!");
         player.hp=player.hp-1;
         soundManager.playClip("fireHit", false);
      }
      setLocation();
	  dy = dy + 0;	
      
   }

   }





   public Rectangle2D.Double getBoundingRectangle() {
      return new Rectangle2D.Double (x, y, width, height);
   }

   public boolean collidesWithPlayer() {
      Rectangle2D.Double myRect = getBoundingRectangle();
      Rectangle2D.Double PlayerRect = player.getBoundingRectangle();
      
      return myRect.intersects(PlayerRect); 
   }

   

}