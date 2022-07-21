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

public class AlucardAttack1 {

   private JPanel panel;
   private int x;
   private int y;

   private int width;
   private int height;
         
   private Image alucardAttack;


   private int dx;      // increment to move along x-axis
   private int dy;      // increment to move along y-axis

   private Color backgroundColour;

   private int posX;
   private int posY;

   private Player player;
   private SoundManager soundManager;


   public boolean check=false;









   public AlucardAttack1 (JPanel p, int xPos, int yPos, Player player) {
      panel = p;
      backgroundColour = panel.getBackground ();

      width = 84;
      height = 50;

      
   
      x = xPos;
      y = yPos;
      dx = 25;       

      dy = 0;       

      this.player = player;

      alucardAttack = ImageManager.loadImage ("images/attacks/alucard_attack1.png");

      soundManager = SoundManager.getInstance();
   }

   
   public void setLocation() {
    x=56;
    y=830;


   }

   public void draw (Graphics2D g2) {

      
      g2.drawImage(alucardAttack, x, y, width, height, null);

   }



   public void move() {

      if (!panel.isVisible ()) return;


      x = x+dx;
      y = y+dy;

   boolean collision = collidesWithPlayer();
   if((y>=920 || x>=1819 || x<=0 ||collision) &&(x!=7000 && y!=7000)){
      if(collision){
         System.out.println("HIT! By Alucard");
         player.hp=player.hp-1;
         soundManager.playClip("alucardHit", false);
      }
      setLocation();
      dx=dx+0;
      
   }

   }

   public void removeAttack(){
      dy=0;
      dx=0;
      x=7000;
      y=7000;
   }





   public Rectangle2D.Double getBoundingRectangle() {
      return new Rectangle2D.Double (x, y, width, height);
   }

   public boolean collidesWithPlayer() {
      Rectangle2D.Double myRect = getBoundingRectangle();
      Rectangle2D.Double PlayerRect = player.getAllucardBoundingRectangle();
      
      return myRect.intersects(PlayerRect); 
   }

   

}