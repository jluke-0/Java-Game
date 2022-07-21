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

public class DraculaAttackL {

   private JPanel panel;
   private int x;
   private int y;

   private int width;
   private int height;
         
   private Image draculaAttackLeft;


   private int dx;      // increment to move along x-axis
   private int dy;      // increment to move along y-axis

   private Color backgroundColour;

   private int posX;
   private int posY;

   private Player player;
   private SoundManager soundManager;






   public DraculaAttackL(JPanel p, int xPos, int yPos, Player player) {
      panel = p;
      backgroundColour = panel.getBackground ();

      width = 62;
      height = 13;

      
   
      x = xPos;
      y = yPos;
      dx = 40;       

      dy = 0;       

      this.player = player;

      draculaAttackLeft = ImageManager.loadImage ("images/attacks/dracula_attackL.png");

      soundManager = SoundManager.getInstance();
   }

   
   public void setLocation() {
    x=1735;
    y=850;


   }

   public void draw (Graphics2D g2) {

      
      g2.drawImage(draculaAttackLeft, x, y, width, height, null);

   }

   public void move() {

      if (!panel.isVisible ()) return;


      x = x-dx;
      y = y+dy;






   
   boolean collision = collidesWithPlayer();
   if((y>=920 || x>=1819 || x<=0 ||collision) &&(x!=5500 && y!=5500)){
      if(collision){
         System.out.println("HIT! By Dracula!");
         player.hp=player.hp-1;
         soundManager.playClip("draculaHit1", false);
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
      Rectangle2D.Double PlayerRect = player.getAllucardBoundingRectangle();
      
      return myRect.intersects(PlayerRect); 
   }

   public void removeAttack(){
      dy=0;
      dx=0;
      x=5500;
      y=5500;
   }

   

}