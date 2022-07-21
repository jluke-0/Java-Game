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

public class GargoyleWomanAttack {

   private JPanel panel;
   private int x;
   private int y;

   private int width;
   private int height;
         
   private Image rightPlayerAttack;


   private int dx;      // increment to move along x-axis
   private int dy;      // increment to move along y-axis

   private Color backgroundColour;

   private int posX;
   private int posY;

   private Player player;
   private SoundManager soundManager;


   private int temp;





   public GargoyleWomanAttack (JPanel p, int xPos, int yPos, Player player) {
      panel = p;
      backgroundColour = panel.getBackground ();

      width = 80;
      height = 100;

      
      temp=xPos;
      x = xPos;
      y = yPos;
      dx = 5;       

      dy = 20;       

      this.player = player;

      rightPlayerAttack = ImageManager.loadImage ("images/attacks/enemy_attack1.png");

      soundManager = SoundManager.getInstance();
   }

   
   public void setLocation() {
    x=temp;
    y=270;


   }

   public void draw (Graphics2D g2) {

      
      g2.drawImage(rightPlayerAttack, x, y, width, height, null);

   }

   public void move() {

      if (!panel.isVisible ()) return;


      x += dx;
      y +=(int) dy * Math.sin(0.7);






   boolean collision = collidesWithPlayer();
   if(y>=920 || x>=1819 || x<=0|| collision){
      if(collision){
         System.out.println("HIT! By Gargoyle fire!");
         
         player.hp=player.hp-1;
         soundManager.playClip("fireHit", false);
      }
      setLocation();
      dx=dx+0;
      
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
