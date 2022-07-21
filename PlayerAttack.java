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

public class PlayerAttack {

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
   private DeathAnimation death;
   private DraculaAnimation dracula;
   private DraculaAttackL dAtkL;

   public PlayerAttack (JPanel p, int xPos, int yPos, Player player, DeathAnimation death,DraculaAnimation dracula) {
      panel = p;
      backgroundColour = panel.getBackground ();

      width = 88;
      height = 40;

      

      x = xPos;
      y = yPos;
      dx = 14;			


      dy = 0;			

      this.player = player;
      this.death = death;
      this.dracula=dracula;


      rightPlayerAttack = ImageManager.loadImage ("images/attacks/player_attack1_right.png");

      soundManager = SoundManager.getInstance();
   }

   
   public void setLocation() {
    x=player.getPosX()+40;
    y=player.getPosY()+40;
   }


   public void draw (Graphics2D g2) {

      
      g2.drawImage(rightPlayerAttack, x, y, width, height, null);

   }


   public void move() {

      if (!panel.isVisible ()) return;

  
      x = x + dx;
      y = y + dy;
      boolean collision = collidesDeath();
      boolean collisionDrac=collidesDracula();
     
      int width= panel.getWidth();
      if(attackHappened==true){
      setLocation();
      dx=dx+0;
      attackHappened=false;
   }
   if(collision){
      System.out.println("HIT DEATH!");
      //setLocation();
      //dx=dx+0;
      x=8000;
      y=8000;
      death.hp=death.hp-1;
      soundManager.playClip("playerAttack", false);
      if(death.hp==0){
         soundManager.playClip("ghostDied", false);
      }
   }
   if(collisionDrac){
      System.out.println("HIT DRACULA!");
      x=8000;
      y=8000;
      dracula.hp=dracula.hp-1;
      soundManager.playClip("playerAttack", false);
      if(dracula.hp==0){
         soundManager.playClip("draculaDied", false);
      }
   }


   }

   public void hitBySlow(){
      x=8000;
      y=8000;
   }



   public Rectangle2D.Double getBoundingRectangle() {
      return new Rectangle2D.Double (x, y, width, height);
   }

   public boolean collidesDeath() {
      Rectangle2D.Double myRect = getBoundingRectangle();
      Rectangle2D.Double DeathRect = death.getBoundingRectangle();
      
      return myRect.intersects(DeathRect); 
   }

   public boolean collidesDracula() {
      Rectangle2D.Double myRect = getBoundingRectangle();
      Rectangle2D.Double DraculaRect = dracula.getBoundingRectangle();
      
      return myRect.intersects(DraculaRect); 
   }


   

   


}
