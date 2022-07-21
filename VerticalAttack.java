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

public class VerticalAttack {

   private JPanel panel;

   private int x;
   private int y;

   private int width;
   private int height;
			
   private Image verticalAttack;

   private int dx;		
   private int dy;		

   private Color backgroundColour;

   private Random random;	
   private int temp;

   private Player player;
   private SoundManager soundManager;

   public VerticalAttack(JPanel p, int xPos, int yPos, int speed, Player player) {
      panel = p;
      backgroundColour = panel.getBackground ();

      width = 13;
      height = 62;
      temp=xPos;
      random = new Random();

      x = xPos;
      y = yPos;


      dx = 0;			
      dy = speed;			

      this.player = player;

      verticalAttack = ImageManager.loadImage ("images/attacks/dracula_attackV.png");

      soundManager = SoundManager.getInstance();
   }

   
   public void setLocation() {

      x = random.nextInt (1700 - 2);
      y = 920;
   }


   public void draw (Graphics2D g2) {
      

      g2.drawImage(verticalAttack, x, y, width, height, null);

   }


   public void move() {

      if (!panel.isVisible ()) return;

      x = x + dx;
      y = y - dy;

      boolean collision = collidesWithPlayer();
      if((y<=0 ||collision) &&(x!=9000 && y!=9000)){ 
      if (collision){
        System.out.println("HIT! By Dracula!");
         player.hp=player.hp-1;
         soundManager.playClip("draculaHit2", false);
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
      Rectangle2D.Double PlayerRect = player.getAllucardBoundingRectangle();
      
      return myRect.intersects(PlayerRect); 
   }

}