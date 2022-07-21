//816006490
//Jean-Luke Chankoo
//COMP 3609
//A3
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;
import java.awt.Image;

public class Player{

   public int hp= 10;


   private GamePanel panel;

   private int x;
   private int y;
   private int width;
   private int height;

   private int dx;
   private int dy;
   private int originalY;

   private boolean isLeft=false;
   private boolean isRight=false;
   private boolean isJump=false;


   private Rectangle2D.Double player;

   private Image PlayerRightStartImage;
   private Image PlayerLeftStartImage;

   private Image PlayerRightRun1;
   private Image PlayerRightRun2;
   private Image PlayerRightRun3;
   private Image PlayerRightRun4;
   private Image PlayerRightRun5;
   private Image PlayerRightRun6;
   private Image PlayerRightRun7;
   private Image PlayerRightRun8;
   private Image PlayerRightRun9;
   private Image PlayerRightRun10;
   private Image PlayerRightRun11;
   private Image PlayerRightRun12;

   private Image PlayerLeftRun1;
   private Image PlayerLeftRun2;
   private Image PlayerLeftRun3;
   private Image PlayerLeftRun4;
   private Image PlayerLeftRun5;
   private Image PlayerLeftRun6;
   private Image PlayerLeftRun7;
   private Image PlayerLeftRun8;
   private Image PlayerLeftRun9;
   private Image PlayerLeftRun10;
   private Image PlayerLeftRun11;
   private Image PlayerLeftRun12;

   private Image PlayerJumpRight;
   private Image PlayerJumpLeft;

   private Image PlayerAttackRight;
   private Image PlayerAttackLeft;

   private Image PlayerDeathRight;
   private Image PlayerDeathLeft;



   private Image PlayerImage;

   private PlayerAttack pAttack;



   //private SoundManager soundManager;

   private Color backgroundColour;


   public Player (GamePanel p, int xPos, int yPos) {
      panel = p;
      backgroundColour = panel.getBackground ();

      xPos=960;
      yPos=790;
      x = xPos;
      y = yPos;

      dx = 10;
      dy = 10;

      width = 100;
      height = 134;

      originalY= 790;

      isRight=true;
      isLeft=false;
      isJump=false;

      
      PlayerRightStartImage = ImageManager.loadImage ("images/player/stand/stand1_right.png");
      PlayerLeftStartImage = ImageManager.loadImage ("images/player/stand/stand1_left.png");

      PlayerRightRun1= ImageManager.loadImage ("images/player/running/run1_right.png");
      PlayerRightRun2= ImageManager.loadImage ("images/player/running/run2_right.png");
      PlayerRightRun3= ImageManager.loadImage ("images/player/running/run3_right.png");
      PlayerRightRun4= ImageManager.loadImage ("images/player/running/run4_right.png");
      PlayerRightRun5= ImageManager.loadImage ("images/player/running/run5_right.png");
      PlayerRightRun6= ImageManager.loadImage ("images/player/running/run6_right.png");
      PlayerRightRun7= ImageManager.loadImage ("images/player/running/run7_right.png");
      PlayerRightRun8= ImageManager.loadImage ("images/player/running/run8_right.png");
      PlayerRightRun9= ImageManager.loadImage ("images/player/running/run9_right.png");
      PlayerRightRun10= ImageManager.loadImage ("images/player/running/run10_right.png");
      PlayerRightRun11= ImageManager.loadImage ("images/player/running/run11_right.png");
      PlayerRightRun12= ImageManager.loadImage ("images/player/running/run12_right.png");

      PlayerLeftRun1= ImageManager.loadImage ("images/player/running/run1_left.png");
      PlayerLeftRun2= ImageManager.loadImage ("images/player/running/run2_left.png");
      PlayerLeftRun3= ImageManager.loadImage ("images/player/running/run3_left.png");
      PlayerLeftRun4= ImageManager.loadImage ("images/player/running/run4_left.png");
      PlayerLeftRun5= ImageManager.loadImage ("images/player/running/run5_left.png");
      PlayerLeftRun6= ImageManager.loadImage ("images/player/running/run6_left.png");
      PlayerLeftRun7= ImageManager.loadImage ("images/player/running/run7_left.png");
      PlayerLeftRun8= ImageManager.loadImage ("images/player/running/run8_left.png");
      PlayerLeftRun9= ImageManager.loadImage ("images/player/running/run9_left.png");
      PlayerLeftRun10= ImageManager.loadImage ("images/player/running/run10_left.png");
      PlayerLeftRun11= ImageManager.loadImage ("images/player/running/run11_left.png");
      PlayerLeftRun12= ImageManager.loadImage ("images/player/running/run12_left.png");

      PlayerJumpRight= ImageManager.loadImage ("images/player/jump/jump1_right.png");
      PlayerJumpLeft= ImageManager.loadImage ("images/player/jump/jump1_left.png");

      PlayerAttackRight= ImageManager.loadImage ("images/player/attack/attack1_right.png");
      PlayerAttackLeft= ImageManager.loadImage ("images/player/attack/attack1_left.png");

      PlayerDeathRight= ImageManager.loadImage ("images/player/death/death_right.png");
      PlayerDeathLeft= ImageManager.loadImage ("images/player/death/death_left.png");

      PlayerImage= PlayerRightStartImage;

     
      //soundManager = SoundManager.getInstance();
   }


   public void draw (Graphics2D g2) {

      g2.drawImage(PlayerImage, x, y, width, height, null);

   }



   public void move (int direction) {

      if (!panel.isVisible ()) return;
      
      if (direction == 1) {		// move left

         isLeft=true;
         isRight=false;

         if(PlayerImage==PlayerAttackRight || PlayerImage==PlayerAttackLeft){
            PlayerImage = PlayerLeftStartImage;
         }
         else

         if(PlayerImage==PlayerRightStartImage || PlayerImage==PlayerLeftStartImage){
            PlayerImage = PlayerLeftRun1;
         }
         else
         if(PlayerImage==PlayerLeftRun1 || PlayerImage==PlayerRightRun1){
            PlayerImage = PlayerLeftRun2;
         }
         else
         if(PlayerImage==PlayerLeftRun2 || PlayerImage==PlayerRightRun2){
            PlayerImage = PlayerLeftRun3;
         }
         else
         if(PlayerImage==PlayerLeftRun3 || PlayerImage==PlayerRightRun3){
            PlayerImage = PlayerLeftRun4;
         }
         else
         if(PlayerImage==PlayerLeftRun4 || PlayerImage==PlayerRightRun4){
            PlayerImage = PlayerLeftRun1;
           
         }
         
         else
         if(PlayerImage==PlayerLeftRun5 || PlayerImage==PlayerRightRun5){
            PlayerImage = PlayerLeftRun6;
         }
         else
         if(PlayerImage==PlayerLeftRun6 || PlayerImage==PlayerRightRun6){
            PlayerImage = PlayerLeftRun7;
         }
         else
         if(PlayerImage==PlayerLeftRun7 || PlayerImage==PlayerRightRun7){
            PlayerImage = PlayerLeftRun8;
         }
         else
         if(PlayerImage==PlayerLeftRun8 || PlayerImage==PlayerRightRun8){
            PlayerImage = PlayerLeftRun9;
         }
         else
         if(PlayerImage==PlayerLeftRun9 || PlayerImage==PlayerRightRun9){
            PlayerImage = PlayerLeftRun10;
         }
         else
         if(PlayerImage==PlayerLeftRun10 || PlayerImage==PlayerRightRun10){
            PlayerImage = PlayerLeftRun11;
         }
         else
         if(PlayerImage==PlayerLeftRun11 || PlayerImage==PlayerRightRun11){
            PlayerImage = PlayerLeftRun12;
         }
         else
         if(PlayerImage==PlayerLeftRun12 || PlayerImage==PlayerRightRun12){
            PlayerImage = PlayerLeftRun1;
         }
        

        x = x - dx;
          if(x<0)
           x=0;
           if(x+ width>panel.getWidth())
           x=panel.getWidth()-width;

           System.out.println("This position is "+x);

      }	
      if (direction == 2) {		// move right

         
         isLeft=false;
         isRight=true;

         if(PlayerImage==PlayerAttackRight || PlayerImage==PlayerAttackLeft){
            PlayerImage = PlayerRightStartImage;
         }
         else

         if(PlayerImage==PlayerRightStartImage || PlayerImage==PlayerLeftStartImage){
            PlayerImage = PlayerRightRun1;
         }
         else
         if(PlayerImage==PlayerRightRun1 || PlayerImage==PlayerLeftRun1){
            PlayerImage = PlayerRightRun2;
         }
         else
         if(PlayerImage==PlayerRightRun2 || PlayerImage==PlayerLeftRun2){
            PlayerImage = PlayerRightRun3;
         }
         else
         if(PlayerImage==PlayerRightRun3 || PlayerImage==PlayerLeftRun3){
            PlayerImage = PlayerRightRun4;
         }
         else
         if(PlayerImage==PlayerRightRun4 || PlayerImage==PlayerLeftRun4){
            PlayerImage = PlayerRightRun1;
         }
       
         else
         if(PlayerImage==PlayerRightRun5 || PlayerImage==PlayerLeftRun5){
            PlayerImage = PlayerRightRun6;
         }
         else
         if(PlayerImage==PlayerRightRun6 || PlayerImage==PlayerLeftRun6){
            PlayerImage = PlayerRightRun7;
         }

         else
         if(PlayerImage==PlayerRightRun7 || PlayerImage==PlayerLeftRun7){
            PlayerImage = PlayerRightRun8;
         }

         else
         if(PlayerImage==PlayerRightRun8 || PlayerImage==PlayerLeftRun8){
            PlayerImage = PlayerRightRun9;
         }

         else
         if(PlayerImage==PlayerRightRun9 || PlayerImage==PlayerLeftRun9){
            PlayerImage = PlayerRightRun10;
         }
         else
         if(PlayerImage==PlayerRightRun10 || PlayerImage==PlayerLeftRun10){
            PlayerImage = PlayerRightRun11;
         }

         else
         if(PlayerImage==PlayerRightRun11 || PlayerImage==PlayerLeftRun11){
            PlayerImage = PlayerRightRun12;
         }
         else
         if(PlayerImage==PlayerRightRun12 || PlayerImage==PlayerLeftRun12){
            PlayerImage = PlayerRightRun1;
         }
  

         x = x + dx;
          if(x+ width>panel.getWidth())
            x=panel.getWidth()-width;

            System.out.println("This position is "+x);

      }
      
      if(direction==3){ //jump up


         if(isLeft==true){
            isJump=true;
   
            PlayerImage= PlayerJumpLeft;
               
               y = originalY - 150;	
               if(y>640)
                 y=originalY;
            }
            
            if(isRight==true){
               isJump=true;
   
               PlayerImage= PlayerJumpRight;
           
               y = originalY - 150;	
               if(y>640)
                 y=originalY;
            }
        
         }
   
       
         if(direction==4){
   
               if(isRight==true){
                  isJump=false;
                  PlayerImage= PlayerRightStartImage;
                  y=originalY;
               }
               if(isLeft==true){
                  isJump=false;
                  PlayerImage= PlayerLeftStartImage;
                  y=originalY;
               }
   
   
         }

      if(direction==5){  //player attack

         if(isJump==false){

            if(isLeft==true){
               PlayerImage= PlayerAttackLeft; //left attack
               
            }
   
            if(isRight==true){
               PlayerImage= PlayerAttackRight;  //right attack
            
               
            }
         }
      }
   }


   public void attack (boolean pressed){

   }

   public void playerAttack(){
      pAttack.move();
   }



   public boolean isOnPlayer (int x, int y) {
      if (player == null)
      	  return false;

      return player.contains(x, y);
   }

   public int getPosX(){
      return x;
   }

   public int getPosY(){
      return y;
   }

   public boolean checkAttackPosR(){
      if(isRight==true){
         return true;
      }
   else{
      return false;
   }
   }
 

   public Rectangle2D.Double getBoundingRectangle() {
      return new Rectangle2D.Double (x, y, width*0.2F, height*0.2F);
   }

   public Rectangle2D.Double getAllucardBoundingRectangle() {
      return new Rectangle2D.Double (x, y, width, height);
   }




}