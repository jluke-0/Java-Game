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

public class PlayerAttackLeft {

   private JPanel panel;
   private int x;
   private int y;

   private int width;
   private int height;
			
   private Image rightPlayerAttack;
   private Image leftPlayerAttack;

   private int dx;		// increment to move along x-axis
   private int dy;		// increment to move along y-axis

   private Color backgroundColour;

   private int posX;
   private int posY;

   private Player player;
   private SoundManager soundManager;

   private boolean Pos;

   public boolean attackHappened=false;
   private AlucardAnimation alucard;


   public PlayerAttackLeft (JPanel p, int xPos, int yPos, Player player,AlucardAnimation alucard) {
      panel = p;
      backgroundColour = panel.getBackground ();

      width = 88;
      height = 40;

      

      x = xPos;
      y = yPos;
      dx = 14;			


      dy = 0;			

      this.player = player;
      this.alucard=alucard;

      leftPlayerAttack = ImageManager.loadImage ("images/attacks/player_attack1_left.png");

      soundManager = SoundManager.getInstance();
   }

   
   public void setLocation() {
    x=player.getPosX()-40;
    y=player.getPosY()+40;
   }


   public void draw (Graphics2D g2) {

      
      g2.drawImage(leftPlayerAttack, x, y, width, height, null);

   }


   public void move() {

      if (!panel.isVisible ()) return;


      x = x - dx;
      y = y + dy;
      boolean collision = collidesWithAlucard();
     
      if(attackHappened==true){


      setLocation();
      dx=dx+0;
      attackHappened=false;



   }
   if(collision){
      System.out.println("HIT ALUCARD!");

      x=4000;
      y=4000;
      alucard.hp=alucard.hp-1;
      soundManager.playClip("playerAttack", false);
      if(alucard.hp==0){
         soundManager.playClip("alucardDied", false);
      }
   }


   }



   public Rectangle2D.Double getBoundingRectangle() {
      return new Rectangle2D.Double (x, y, width, height);
   }

   public boolean collidesWithAlucard() {
      Rectangle2D.Double myRect = getBoundingRectangle();
      Rectangle2D.Double AlucardRect = alucard.getBoundingRectangle();
      
      return myRect.intersects(AlucardRect); 
   }
   


}
