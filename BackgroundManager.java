//816006490
//Jean-Luke Chankoo
//COMP 3609
//A3
import java.awt.*;


public class BackgroundManager {

	private String bgImages[] = {
				     "images/background layers/layer06.png",
				     "images/background layers/layer05.png",
				     "images/background layers/layer04.png",
				     "images/background layers/layer03.png",
				     "images/background layers/layer02fixed.png",
			       	     "images/background layers/layer01fixed.png"};

							private String bgImages2[] = {
								"images/background2 layers/fixed/layer06.png",
								"images/background2 layers/fixed/layer05.png",
								"images/background2 layers/fixed/layer04.png",
								"images/background2 layers/fixed/layer03.png",
								"images/background2 layers/fixed/layer02.png",
									   "images/background2 layers/fixed/layer01.png"};

  	private int moveAmount[] = {2, 8, 4, 4, 5, 10};  // applied to moveSize
     		// a move amount of 0 would make a background stationary

  	private Background[] backgrounds;
  	private int numBackgrounds;

  	private GamePanel panel;

  	public BackgroundManager(GamePanel panel) {
    		this.panel = panel;

    		numBackgrounds = bgImages.length;
    		backgrounds = new Background[numBackgrounds];
		if(panel.lvl1==true){
    		for (int i = 0; i < numBackgrounds; i++) {
       			backgrounds[i] = new Background(panel, bgImages[i], moveAmount[i]);
    		}
		}
		if(panel.lvl1==false){
    		for (int i = 0; i < numBackgrounds; i++) {
       			backgrounds[i] = new Background(panel, bgImages2[i], moveAmount[i]);
    		}
		}
  	} 


	public void move (int direction) {
		for (int i=0; i<numBackgrounds; i++)
      			backgrounds[i].move(direction);
	}


  	// The draw method draws the backgrounds on the screen. The
  	// backgrounds are drawn from the back to the front.

  	public void draw (Graphics2D g2) { 
		for (int i=0; i<numBackgrounds; i++)
      			backgrounds[i].draw(g2);
  	}



}