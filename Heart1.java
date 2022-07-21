//816006490
//Jean-Luke Chankoo
//COMP 3609
//A3
import java.util.Random;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;

public class Heart1 implements ImageFX {

	private static final int WIDTH = 20;		
	private static final int HEIGHT = 20;		
	private static final int YPOS = 1;		
	private static final int XPOS = 430;
	private GamePanel panel;

	private int x;
	private int y;

	private BufferedImage spriteImage;		
	private BufferedImage copy;			

	Graphics2D g2;

	int time, timeChange;				
	boolean originalImage, grayImage;


	public Heart1 (GamePanel p, int xPos, int yPos) {
		panel = p;

		
		x = xPos;
		y = yPos;

		time = 0;				
		timeChange = 1;				
		originalImage = true;
		grayImage = false;




		spriteImage = ImageManager.loadBufferedImage("images/heart/transparent_heart.png");
		copy = ImageManager.copyImage(spriteImage);		
							
	}


	private int toGray (int pixel) {

  		int alpha, red, green, blue, gray;
		int newPixel;

		alpha = (pixel >> 24) & 255;
		red = (pixel >> 16) & 255;
		green = (pixel >> 8) & 255;
		blue = pixel & 255;

		

		gray = (int) (0.2126 * red + 0.7152 * green + 0.0722 * blue);

		

		red = green = blue = gray;

		newPixel = blue | (green << 8) | (red << 16) | (alpha << 24);

		return newPixel;
	}


	public void draw (Graphics2D g2) {

		copy = ImageManager.copyImage(spriteImage);	
							

		if (originalImage) {			
			g2.drawImage(copy, x, y, WIDTH, HEIGHT, null);

			return;
		}
							
		int imWidth = copy.getWidth();
		int imHeight = copy.getHeight();

    		int [] pixels = new int[imWidth * imHeight];
    		copy.getRGB(0, 0, imWidth, imHeight, pixels, 0, imWidth);

		for (int i=0; i<pixels.length; i++) {
			if (grayImage)
				pixels[i] = toGray(pixels[i]);
		}
  
    		copy.setRGB(0, 0, imWidth, imHeight, pixels, 0, imWidth);	

		g2.drawImage(copy, x, y, WIDTH, HEIGHT, null);


	}


	public Rectangle2D.Double getBoundingRectangle() {
		return new Rectangle2D.Double (x, y, WIDTH, HEIGHT);
	}


	public void update() {				
	
			originalImage = false;
			grayImage = true;

	}

}