//816006490
//Jean-Luke Chankoo
//COMP 3609
//A3
import javax.swing.JPanel;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JOptionPane;
import java.util.Random;


public class GamePanel extends JPanel {
   



	private GameThread gameThread;
    private GameWindow gameWindow;
	private BufferedImage image;
   	private Image backgroundImage;
    private int height;
    private int width;
    private Player player;
	private PlayerAttack pAttack;
	private PlayerAttackLeft pAttackL;

    private BackgroundManager backgroundManager;
	private SoundManager soundManager;



	private ImageFX imageFXh1;
	private ImageFX imageFXh2;
	private ImageFX imageFXh3;
	private ImageFX imageFXh4;
	private ImageFX imageFXh5;
	private ImageFX imageFXh6;
	private ImageFX imageFXh7;
	private ImageFX imageFXh8;
	private ImageFX imageFXh9;
	private ImageFX imageFXh10;

	private ImageFX alucardHeart1;
	private ImageFX alucardHeart2;
	private ImageFX alucardHeart3;
	private ImageFX alucardHeart4;
	private ImageFX alucardHeart5;

	private ImageFX deathHeart1;
	private ImageFX deathHeart2;
	private ImageFX deathHeart3;

	private ImageFX draculaHeart1;
	private ImageFX draculaHeart2;
	private ImageFX draculaHeart3;
	private ImageFX draculaHeart4;
	private ImageFX draculaHeart5;
	private ImageFX draculaHeart6;
	private ImageFX draculaHeart7;
	private ImageFX draculaHeart8;


	private Animation GargoyleWoman;
	private Animation GargoyleWoman1;
	private Animation GargoyleWoman2;
	private Animation GargoyleWoman3;
	private Animation GargoyleWoman4;


	private GargoyleWomanAttack gargoyleWomanAtkR;
	private GargoyleWomanAttack gargoyleWomanAtkR1;
	//private GargoyleWomanAttack gargoyleWomanAtkR2;
	//private GargoyleWomanAttack gargoyleWomanAtkR3;
	private GargoyleWomanAttack gargoyleWomanAtkR4;


	//private GargoyleWomanAttack1 gargoyleWomanAtkL;
	private GargoyleWomanAttack1 gargoyleWomanAtkL1;
	private GargoyleWomanAttack1 gargoyleWomanAtkL2;
	private GargoyleWomanAttack1 gargoyleWomanAtkL3;
	//private GargoyleWomanAttack1 gargoyleWomanAtkL4;

	private GargoyleWomanAttack2 gargoyleWomanAtkD;

	//private Animation alucard;

	private AlucardAnimation alucard2;
	private AlucardAttack1 alucardAtk1;
	private AlucardLose alucardLose;

	private DeathAnimation death1;
	private DeathAttack deathAtk;
	private DeathLose deathLose;

	private DraculaAnimation draculaL;


	private DraculaAttackL draculaAtkL;
	private DraculaAttack2L draculaAtkL2;
	private DraculaLose draculaLose;

	private Won winScreen;
	private VerticalAttack [] draculaAtkV;
	private static int numV=4;

	public boolean lvl1=true;



	



	public GamePanel () {

      	


        player = null;
		pAttack=null;
		pAttackL=null;
		gargoyleWomanAtkR=null;
		gargoyleWomanAtkR1=null;
		gargoyleWomanAtkR4=null;
		gargoyleWomanAtkL1=null;
		gargoyleWomanAtkL2=null;
		gargoyleWomanAtkL3=null;
		gargoyleWomanAtkD=null;
		alucardAtk1=null;
		deathAtk=null;
		alucard2=null;
		alucardLose=null;
		deathLose=null;
		draculaLose=null;
		winScreen=null;
		draculaL=null;
		draculaAtkL=null;
		draculaAtkL2=null;
		draculaAtkV=null;


		loadGargoyleWomanAnimation();
		loadDraculaAnimation(3000,3000);
	

		

        image = new BufferedImage (1920, 1080, BufferedImage.TYPE_INT_RGB);



		


		soundManager = SoundManager.getInstance();
		

	}






	public void startGame() {				

		Thread thread;
	
		if (gameThread == null) {
			soundManager.playClip ("background", true);
			createGameEntities();
			gameThread = new GameThread (this);
			thread = new Thread (gameThread);			
			thread.start();

		}
	}

	
	public void restartGame() {				

		endGame();
		Thread thread;
	
		if (gameThread == null || !gameThread.isRunning()) {

			soundManager.playClip ("background", true);
			//death1.hp=3;
			//alucard2.hp=5;
			if(lvl1==true){
				death1.hp=3;
				alucard2.hp=5;
			createGameEntities();
			}
			if(lvl1==false){
				player = new Player (this, 960, 790);
				draculaL.hp=8;

				level2();
			}
			gameThread = new GameThread (this);
			thread = new Thread (gameThread);			
			thread.start();
		}
	}


	public void pauseGame() {				
		gameThread.pauseGame();
	}


	public void endGame() {					
		gameThread.endGame();
		
	}


	public void gameUpdate () {

		pAttack.move();
		pAttackL.move();
		gargoyleWomanAtkR.move();
		//gargoyleWomanAtkL.move();
		gargoyleWomanAtkR1.move();
		gargoyleWomanAtkL1.move();
		//gargoyleWomanAtkR2.move();
		gargoyleWomanAtkL2.move();
		//gargoyleWomanAtkR3.move();
		gargoyleWomanAtkL3.move();
		gargoyleWomanAtkR4.move();
		//gargoyleWomanAtkL4.move();
		gargoyleWomanAtkD.move();
		GargoyleWoman.update();
		GargoyleWoman1.update();
		GargoyleWoman2.update();
		GargoyleWoman3.update();
		GargoyleWoman4.update();

		
		alucardAtk1.move();
		alucard2.update();

		death1.update();
		deathAtk.move();
		

		draculaAtkL.move();
		draculaAtkL2.move();

		draculaL.update();




		if(player.hp==9){
			imageFXh1.update();
		}
		
		if(player.hp==8){
			imageFXh1.update();
			imageFXh2.update();
		}

		if(player.hp==7){
			imageFXh1.update();
			imageFXh2.update();
			imageFXh3.update();
		}

		if(player.hp==6){
			imageFXh1.update();
			imageFXh2.update();
			imageFXh3.update();
			imageFXh4.update();
		}
		if(player.hp==5){
			imageFXh1.update();
			imageFXh2.update();
			imageFXh3.update();
			imageFXh4.update();
			imageFXh5.update();

		}
		if(player.hp==4){
			imageFXh1.update();
			imageFXh2.update();
			imageFXh3.update();
			imageFXh4.update();
			imageFXh5.update();
			imageFXh6.update();

		}
		if(player.hp==3){
			imageFXh1.update();
			imageFXh2.update();
			imageFXh3.update();
			imageFXh4.update();
			imageFXh5.update();
			imageFXh6.update();
			imageFXh7.update();

		}
		if(player.hp==2){
			imageFXh1.update();
			imageFXh2.update();
			imageFXh3.update();
			imageFXh4.update();
			imageFXh5.update();
			imageFXh6.update();
			imageFXh7.update();
			imageFXh8.update();

		}
		if(player.hp==1){
			imageFXh1.update();
			imageFXh2.update();
			imageFXh3.update();
			imageFXh4.update();
			imageFXh5.update();
			imageFXh6.update();
			imageFXh7.update();
			imageFXh8.update();
			imageFXh9.update();

		}
		if(player.hp==0){
			imageFXh1.update();
			imageFXh2.update();
			imageFXh3.update();
			imageFXh4.update();
			imageFXh5.update();
			imageFXh6.update();
			imageFXh7.update();
			imageFXh8.update();
			imageFXh9.update();
			imageFXh10.update();
			restartGame();		//can disable for infinite lives

		}



		if(alucard2.hp==4){
			alucardHeart1.update();
		}

		if(alucard2.hp==3){
			alucardHeart1.update();
			alucardHeart2.update();
		}

		if(alucard2.hp==2){
			alucardHeart1.update();
			alucardHeart2.update();
			alucardHeart3.update();
		}

		if(alucard2.hp==1){
			alucardHeart1.update();
			alucardHeart2.update();
			alucardHeart3.update();
			alucardHeart4.update();
		}

		if(alucard2.hp==0){
			alucardHeart1.update();
			alucardHeart2.update();
			alucardHeart3.update();
			alucardHeart4.update();
			alucardHeart5.update();
			alucard2.setLocation();
			alucardLose.setLocation();
			alucardAtk1.removeAttack();
			
		}

		if(death1.hp==2){
			deathHeart1.update();
		}

		if(death1.hp==1){
			deathHeart1.update();
			deathHeart2.update();
		}

		if(death1.hp==0){
			deathHeart1.update();
			deathHeart2.update();
			deathHeart3.update();
			death1.setLocation();
			deathLose.setLocation();
			deathAtk.removeAttack();
		}

		if(death1.hp==0 && alucard2.hp==0){
			
			//setBackground(Color.white);
			lvl1=false;
			backgroundManager=new BackgroundManager(this);
			
			level2();
			//backgroundManager=new BackgroundManager(this);
			//backgroundManager.update();

			
		}

		if(draculaL.hp==7){
			draculaHeart1.update();
		}
		if(draculaL.hp==6){
			draculaHeart1.update();
			draculaHeart2.update();
		}
		if(draculaL.hp==5){
			draculaHeart1.update();
			draculaHeart2.update();
			draculaHeart3.update();
		}
		if(draculaL.hp==4){
			draculaHeart1.update();
			draculaHeart2.update();
			draculaHeart3.update();
			draculaHeart4.update();

		}
		if(draculaL.hp==3 ){
			draculaHeart1.update();
			draculaHeart2.update();
			draculaHeart3.update();
			draculaHeart4.update();
			draculaHeart5.update();
		}
		if(draculaL.hp==2){
			draculaHeart1.update();
			draculaHeart2.update();
			draculaHeart3.update();
			draculaHeart4.update();
			draculaHeart5.update();
			draculaHeart6.update();
		}
		if(draculaL.hp==1){
			draculaHeart1.update();
			draculaHeart2.update();
			draculaHeart3.update();
			draculaHeart4.update();
			draculaHeart5.update();
			draculaHeart6.update();
			draculaHeart7.update();
		}
		if(draculaL.hp==0){
			draculaHeart1.update();
			draculaHeart2.update();
			draculaHeart3.update();
			draculaHeart4.update();
			draculaHeart5.update();
			draculaHeart6.update();
			draculaHeart7.update();
			draculaHeart8.update();
			draculaL.setLocation();
;
			draculaLose.setLocation();
			draculaAtkL.removeAttack();
			draculaAtkL2.removeAttack();
			gargoyleWomanAtkR= new GargoyleWomanAttack(this, 0, 0, player);
			gargoyleWomanAtkR1= new GargoyleWomanAttack(this, 0, 0, player);
			gargoyleWomanAtkL1= new GargoyleWomanAttack1(this, 0, 0, player);
			gargoyleWomanAtkL2= new GargoyleWomanAttack1(this, 0, 0, player);
			gargoyleWomanAtkL3= new GargoyleWomanAttack1(this, 0, 0, player);
			gargoyleWomanAtkR4= new GargoyleWomanAttack(this, 0, 0, player);
			gargoyleWomanAtkD= new GargoyleWomanAttack2(this, 0, 0, player);
			draculaAtkV=  new VerticalAttack[numV];
			draculaAtkV[0]=new VerticalAttack(this, 9000, 9000, 0, player);
			draculaAtkV[1]=new VerticalAttack(this, 9000, 9000, 0, player);
			draculaAtkV[2]=new VerticalAttack(this, 9000, 9000, 0, player);
			draculaAtkV[3]=new VerticalAttack(this, 9000, 9000, 0, player);

			winScreen= new Won(this, 600, 490, 600, 200, player);
			
		}

		for(int i=0; i<numV;i++){
			draculaAtkV[i].move();
		}



		
	}

    public void updatePlayer (int direction) {

        if (backgroundManager != null) {
			backgroundManager.move(direction);
		}
		
		if (player != null) {
			player.move(direction);
		
			
		}
		
	}

	public void attackPressed(){
		if(pAttack!=null){
			if(player.checkAttackPosR()==true){
			pAttack.attackHappened=true;
			pAttack.move();
		}
	}
		if(pAttackL!=null){
			if(player.checkAttackPosR()==false){
			pAttackL.attackHappened=true;
			pAttackL.move();
		
			}
		}
	}


	public void gameRender () {				

		Graphics2D imageContext = (Graphics2D) image.getGraphics();

        backgroundManager.draw(imageContext);
		

		imageFXh1.draw(imageContext);
		imageFXh2.draw(imageContext);
		imageFXh3.draw(imageContext);
		imageFXh4.draw(imageContext);
		imageFXh5.draw(imageContext);
		imageFXh6.draw(imageContext);
		imageFXh7.draw(imageContext);
		imageFXh8.draw(imageContext);
		imageFXh9.draw(imageContext);
		imageFXh10.draw(imageContext);

		

		alucardHeart1.draw(imageContext);
		alucardHeart2.draw(imageContext);
		alucardHeart3.draw(imageContext);
		alucardHeart4.draw(imageContext);
		alucardHeart5.draw(imageContext);

		deathHeart1.draw(imageContext);
		deathHeart2.draw(imageContext);
		deathHeart3.draw(imageContext);

		draculaHeart1.draw(imageContext);
		draculaHeart2.draw(imageContext);
		draculaHeart3.draw(imageContext);
		draculaHeart4.draw(imageContext);
		draculaHeart5.draw(imageContext);
		draculaHeart6.draw(imageContext);
		draculaHeart7.draw(imageContext);
		draculaHeart8.draw(imageContext);



		GargoyleWoman.draw(imageContext);
		GargoyleWoman1.draw(imageContext);
		GargoyleWoman2.draw(imageContext);
		GargoyleWoman3.draw(imageContext);
		GargoyleWoman4.draw(imageContext);


		alucard2.draw(imageContext);


		draculaL.draw(imageContext);

		death1.draw(imageContext);


        if (player != null) {
			player.draw(imageContext);
		}
		if (pAttack != null) {
			pAttack.draw(imageContext);
		}
		if (pAttackL != null) {
			pAttackL.draw(imageContext);
		}
		if(gargoyleWomanAtkR !=null){
			gargoyleWomanAtkR.draw(imageContext);
		}
		if(gargoyleWomanAtkR1 !=null){
			gargoyleWomanAtkR1.draw(imageContext);
		}
		//if(gargoyleWomanAtkR2 !=null){
			//gargoyleWomanAtkR2.draw(imageContext);
		//}
		//if(gargoyleWomanAtkR3 !=null){
			//gargoyleWomanAtkR3.draw(imageContext);
		//}
		if(gargoyleWomanAtkR4 !=null){
			gargoyleWomanAtkR4.draw(imageContext);
		}
		//if(gargoyleWomanAtkL !=null){
			//gargoyleWomanAtkL.draw(imageContext);
		//}
		if(gargoyleWomanAtkL1 !=null){
			gargoyleWomanAtkL1.draw(imageContext);
		}
		if(gargoyleWomanAtkL2 !=null){
			gargoyleWomanAtkL2.draw(imageContext);
		}
		if(gargoyleWomanAtkL3 !=null){
			gargoyleWomanAtkL3.draw(imageContext);
		}
		//if(gargoyleWomanAtkL4 !=null){
			//gargoyleWomanAtkL4.draw(imageContext);
		//}
		if(gargoyleWomanAtkD!=null){
			gargoyleWomanAtkD.draw(imageContext);
		}


		if(alucardAtk1 !=null){
			alucardAtk1.draw(imageContext);
		}
		if(deathAtk!=null){
			deathAtk.draw(imageContext);
		}

		if(draculaAtkL!=null){
			draculaAtkL.draw(imageContext);
		}
		if(draculaAtkL2!=null){
			draculaAtkL2.draw(imageContext);
		}

		if(alucardLose!=null){
		alucardLose.draw(imageContext);
		}
		if(deathLose!=null){
			deathLose.draw(imageContext);
		}
		if(draculaLose!=null){
			draculaLose.draw(imageContext);
		}
		if(winScreen!=null){
			winScreen.draw(imageContext);
		}

		if(draculaAtkV!=null){
			for(int i=0; i<numV;i++){
				draculaAtkV[i].draw(imageContext);
			}
		}







		Graphics2D g2 = (Graphics2D) getGraphics();	

        g2.drawImage(image, 0, 0, null);

		imageContext.dispose();
		g2.dispose();


	}


    private void createGameEntities() {
		backgroundManager = new BackgroundManager(this);
        player = new Player (this, 960, 790);

		loadAlucardAnimation();
		loadDeathAnimation();
		
		
		imageFXh1 = new Heart1(this, 200, 1);
		imageFXh2 = new Heart1(this, 180, 1);
		imageFXh3 = new Heart1(this, 160, 1);
		imageFXh4 = new Heart1(this, 140, 1);
		imageFXh5 = new Heart1(this, 120, 1);
		imageFXh6 = new Heart1(this, 100, 1);
		imageFXh7 = new Heart1(this, 80, 1);
		imageFXh8 = new Heart1(this, 60, 1);
		imageFXh9 = new Heart1(this, 40, 1);
		imageFXh10= new Heart1(this, 20, 1);

		alucardHeart1= new AlucardHeart(this, 1800, 1);
		alucardHeart2= new AlucardHeart(this, 1780, 1);
		alucardHeart3= new AlucardHeart(this, 1760, 1);
		alucardHeart4= new AlucardHeart(this, 1740, 1);
		alucardHeart5= new AlucardHeart(this, 1720, 1);

		deathHeart1= new DeathHeart(this,1800,30);
		deathHeart2= new DeathHeart(this,1780,30);
		deathHeart3= new DeathHeart(this,1760,30);

		draculaHeart1= new DraculaHeart(this, 18000, 10000);
		draculaHeart2= new DraculaHeart(this, 17800, 10000);
		draculaHeart3= new DraculaHeart(this, 17600, 10000);
		draculaHeart4= new DraculaHeart(this, 17400, 10000);
		draculaHeart5= new DraculaHeart(this, 17200, 10000);
		draculaHeart6= new DraculaHeart(this, 17000, 10000);
		draculaHeart7= new DraculaHeart(this, 16800, 10000);
		draculaHeart8= new DraculaHeart(this, 16600, 10000);

        

		pAttack= new PlayerAttack(this, 5000, 5000, player,death1,draculaL);
		pAttackL= new PlayerAttackLeft(this, 5000, 5000, player,alucard2);

		gargoyleWomanAtkR= new GargoyleWomanAttack(this, 450, 270, player);
		//gargoyleWomanAtkL= new GargoyleWomanAttack1(this, 450, 270, player);

		gargoyleWomanAtkR1= new GargoyleWomanAttack(this, 850, 270, player);
		gargoyleWomanAtkL1= new GargoyleWomanAttack1(this, 850, 270, player);

		//gargoyleWomanAtkR2= new GargoyleWomanAttack(this, 1250, 270, player);
		gargoyleWomanAtkL2= new GargoyleWomanAttack1(this, 1250, 270, player);

		//gargoyleWomanAtkR3= new GargoyleWomanAttack(this, 1650, 270, player);
		gargoyleWomanAtkL3= new GargoyleWomanAttack1(this, 1650, 270, player);

		gargoyleWomanAtkR4= new GargoyleWomanAttack(this, 150, 270, player);
		//gargoyleWomanAtkL4= new GargoyleWomanAttack1(this, 150, 270, player);

		gargoyleWomanAtkD= new GargoyleWomanAttack2(this, 850, 270, player);

		alucardAtk1= new AlucardAttack1(this, 56, 830, player);
		deathAtk= new DeathAttack(this, 1735, 870, player);
		draculaAtkL= new DraculaAttackL(this, 5500, 5500, player);
		draculaAtkL2= new DraculaAttack2L(this, 4500, 4500, player);

		alucardLose= new AlucardLose(this, 6000, 6000, player);
		deathLose= new DeathLose(this,6500,6500,player);
		draculaLose= new DraculaLose(this, 8600, 8600, player);
		winScreen= new Won(this, 7777, 7777, 1, 1, player);

		draculaAtkV=  new VerticalAttack[numV];
		draculaAtkV[0]=new VerticalAttack(this, 9000, 9000, 0, player);
		draculaAtkV[1]=new VerticalAttack(this, 9000, 9000, 0, player);
		draculaAtkV[2]=new VerticalAttack(this, 9000, 9000, 0, player);
		draculaAtkV[3]=new VerticalAttack(this, 9000, 9000, 0, player);


    }


	public void loadGargoyleWomanAnimation(){
		String prefix = "images/enemy/GargoyleWoman";
		String suffix = "-f.png";

		GargoyleWoman= new Animation(this,400, 200,player);
		GargoyleWoman1= new Animation(this,800, 200,player);
		GargoyleWoman2= new Animation(this,1200, 200,player);
		GargoyleWoman3= new Animation(this,1600, 200,player);
		GargoyleWoman4= new Animation(this,100, 200,player);


		for (int i=1; i<=7; i++) {
			String fullPath = prefix + i + suffix;
			Image animImage = ImageManager.loadImage(fullPath);
			GargoyleWoman.addFrame(animImage, 100);
			GargoyleWoman1.addFrame(animImage, 100);
			GargoyleWoman2.addFrame(animImage, 100);
			GargoyleWoman3.addFrame(animImage, 100);
			GargoyleWoman4.addFrame(animImage, 100);


		}
	}

	public void loadAlucardAnimation(){
		String prefix = "images/boss/alucard";
		String suffix = "-f.png";

		alucard2= new AlucardAnimation(this,10, 790,player);

		for (int i=1; i<=10; i++) {
			String fullPath = prefix + i + suffix;
			Image animImage = ImageManager.loadImage(fullPath);
			alucard2.addFrame(animImage, 100);

		if(i==10){
			
			animImage = ImageManager.loadImage(fullPath);
			alucard2.addFrame(animImage, 900);
			
			
		}
		
		}
		
		
	}

	public void loadDeathAnimation(){
		String prefix = "images/boss/death";
		String suffix = "-f.png";

		death1= new DeathAnimation(this, 1730, 790, player);

		for(int i=1;i<=4;i++){
			String fullPath = prefix + i + suffix;
			Image animImage = ImageManager.loadImage(fullPath);
			death1.addFrame(animImage, 200);
		}
	}

	public void loadDraculaAnimation(int x, int y){
		String prefix = "images/boss/draculaL";
		String suffix = "-f.png";

		draculaL= new DraculaAnimation(this, x, y, player);

		for(int i=1;i<=9;i++){
			String fullPath = prefix + i + suffix;
			Image animImage = ImageManager.loadImage(fullPath);
			draculaL.addFrame(animImage, 100);
		}
	}





	public void level2(){

		player.hp=10;
		loadDraculaAnimation(1700,790);

		draculaHeart1= new DraculaHeart(this, 1800, 1);
		draculaHeart2= new DraculaHeart(this, 1780, 1);
		draculaHeart3= new DraculaHeart(this, 1760, 1);
		draculaHeart4= new DraculaHeart(this, 1740, 1);
		draculaHeart5= new DraculaHeart(this, 1720, 1);
		draculaHeart6= new DraculaHeart(this, 1700, 1);
		draculaHeart7= new DraculaHeart(this, 1680, 1);
		draculaHeart8= new DraculaHeart(this, 1660, 1);

		imageFXh1 = new Heart1(this, 200, 1);
		imageFXh2 = new Heart1(this, 180, 1);
		imageFXh3 = new Heart1(this, 160, 1);
		imageFXh4 = new Heart1(this, 140, 1);
		imageFXh5 = new Heart1(this, 120, 1);
		imageFXh6 = new Heart1(this, 100, 1);
		imageFXh7 = new Heart1(this, 80, 1);
		imageFXh8 = new Heart1(this, 60, 1);
		imageFXh9 = new Heart1(this, 40, 1);
		imageFXh10= new Heart1(this, 20, 1);

			

			alucardHeart1= new AlucardHeart(this, 18000, 10000);
			alucardHeart2= new AlucardHeart(this, 17800, 10000);
			alucardHeart3= new AlucardHeart(this, 17600, 10000);
			alucardHeart4= new AlucardHeart(this, 17400, 10000);
			alucardHeart5= new AlucardHeart(this, 17200, 10000);
	
			deathHeart1= new DeathHeart(this,18000,30000);
			deathHeart2= new DeathHeart(this,17800,30000);
			deathHeart3= new DeathHeart(this,17600,30000);

	
	
			pAttack= new PlayerAttack(this, 5000, 5000, player,death1,draculaL);
			pAttackL= new PlayerAttackLeft(this, 5000, 5000, player,alucard2);


			alucardAtk1= new AlucardAttack1(this, 7000, 7000, player);
			deathAtk= new DeathAttack(this, 5000, 5000, player);
			draculaAtkL= new DraculaAttackL(this, 1725, 850, player);
			draculaAtkL2= new DraculaAttack2L(this, 1725, 840, player);

			draculaAtkV=  new VerticalAttack[numV];
			draculaAtkV[0]=new VerticalAttack(this, 200, 960, 6, player);
			draculaAtkV[1]=new VerticalAttack(this, 400, 960, 4, player);
			draculaAtkV[2]=new VerticalAttack(this, 1600, 960, 6, player);
			draculaAtkV[3]=new VerticalAttack(this, 1100, 960, 4, player);

	
			alucardLose= new AlucardLose(this, 6000, 6000, player);
			deathLose= new DeathLose(this,6500,6500,player);



	
	
			gargoyleWomanAtkR= new GargoyleWomanAttack(this, 450, 270, player);
			//gargoyleWomanAtkL= new GargoyleWomanAttack1(this, 450, 270, player);
	
			gargoyleWomanAtkR1= new GargoyleWomanAttack(this, 850, 270, player);
			gargoyleWomanAtkL1= new GargoyleWomanAttack1(this, 850, 270, player);
	
			//gargoyleWomanAtkR2= new GargoyleWomanAttack(this, 1250, 270, player);
			gargoyleWomanAtkL2= new GargoyleWomanAttack1(this, 1250, 270, player);
	
			//gargoyleWomanAtkR3= new GargoyleWomanAttack(this, 1650, 270, player);
			gargoyleWomanAtkL3= new GargoyleWomanAttack1(this, 1650, 270, player);
	
			gargoyleWomanAtkR4= new GargoyleWomanAttack(this, 150, 270, player);
			//gargoyleWomanAtkL4= new GargoyleWomanAttack1(this, 150, 270, player);
	
			gargoyleWomanAtkD= new GargoyleWomanAttack2(this, 850, 270, player);

			draculaLose= new DraculaLose(this, 8600, 8600, player);
			winScreen= new Won(this, 7777, 7777, 1, 1, player);

			
			
	

			
	}




}