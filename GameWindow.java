//816006490
//Jean-Luke Chankoo
//COMP 3609
//A3
import javax.swing.*;			
import java.awt.*;			
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;		
	
public class GameWindow extends JFrame 
				implements ActionListener,
					   KeyListener,
					   MouseListener
{


	private JLabel statusBarL;
	private JLabel keyL;
	private JLabel mouseL;



	private JTextField statusBarTF;
	private JTextField keyTF;
	private JTextField mouseTF;

	

	private JButton startB;
	private JButton pauseB;
	private JButton endB;
	private JButton restartB;
	private JButton focusB;
	private JButton exitB;

	private Container c;

	private JPanel mainPanel;
	private GamePanel gamePanel;

	private static final int NUM_BUFFERS = 2;	// used for page flipping

	private int pWidth, pHeight;     		// width and height of screen

	private GraphicsDevice device;			// used for full-screen exclusive mode 
	private Graphics gScr;
	private BufferStrategy bufferStrategy;




	@SuppressWarnings({"unchecked"})
	public GameWindow() {
 
		setTitle ("Vampire Hunter");

		initFullScreen();

		statusBarTF = new JTextField (25);
		keyTF = new JTextField (25);
		mouseTF = new JTextField (25);





	    startB = new JButton ("Start Game");
	    pauseB = new JButton ("Pause Game");
	    endB = new JButton ("End Game");
		restartB = new JButton ("Restart Game");
	    focusB = new JButton ("Focus on Key");
		exitB = new JButton ("Exit");




		startB.addActionListener(this);
		pauseB.addActionListener(this);
		endB.addActionListener(this);
		restartB.addActionListener(this);
		focusB.addActionListener(this);
		exitB.addActionListener(this);
		


		mainPanel = new JPanel();
		FlowLayout flowLayout = new FlowLayout();
		mainPanel.setLayout(flowLayout);

		GridLayout gridLayout;

		// create the gamePanel for game entities

		gamePanel = new GamePanel();
        	gamePanel.setPreferredSize(new Dimension(pWidth-100, pHeight-100));


		
		// create buttonPanel

		JPanel buttonPanel = new JPanel();
		gridLayout = new GridLayout(1, 3);
		buttonPanel.setLayout(gridLayout);

		// add buttons to buttonPanel

		buttonPanel.add (startB);

		buttonPanel.add (restartB);

		buttonPanel.add (exitB);

		// add sub-panels with GUI objects to mainPanel and set its colour


		mainPanel.add(gamePanel);
		mainPanel.add(buttonPanel);
		mainPanel.setBackground(Color.BLACK);

		// set up mainPanel to respond to keyboard and mouse

		gamePanel.addMouseListener(this);
		mainPanel.addKeyListener(this);

		// add mainPanel to window surface

		c = getContentPane();
		c.add(mainPanel);

		// set properties of window

		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);

		// set status bar message


	}

	private void initFullScreen() {				// standard procedure to get into FSEM

		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		device = ge.getDefaultScreenDevice();

		setUndecorated(true);	// no menu bar, borders, etc.
		setIgnoreRepaint(true);	// turn off all paint events since doing active rendering
		setResizable(false);	// screen cannot be resized
		
		if (!device.isFullScreenSupported()) {
			System.out.println("Full-screen exclusive mode not supported");
			System.exit(0);
		}

		device.setFullScreenWindow(this); // switch on full-screen exclusive mode

		// we can now adjust the display modes, if we wish


		pWidth = getBounds().width;
		pHeight = getBounds().height;
		
		System.out.println("Width of window is " + pWidth);
		System.out.println("Height of window is " + pHeight);

		try {
			createBufferStrategy(NUM_BUFFERS);
		}
		catch (Exception e) {
			System.out.println("Error while creating buffer strategy " + e); 
			System.exit(0);
		}

		bufferStrategy = getBufferStrategy();
	}

	public int getScreenHeight(){
		int height= getBounds().height;
		return height;

	}

	public int getScreenWidth(){
		int width= getBounds().width;
		return width;

	}



	// implement single method in ActionListener interface

	public void actionPerformed(ActionEvent e) {

		String command = e.getActionCommand();
		
		statusBarTF.setText(command + " button clicked.");

		if (command.equals(startB.getText())) {
			gamePanel.startGame();
		}

		if (command.equals(pauseB.getText())) {
			gamePanel.pauseGame();
		}

		if (command.equals(endB.getText())) {
			gamePanel.endGame();
		}

		if (command.equals(restartB.getText())){
			gamePanel.restartGame();
		}

		if (command.equals(focusB.getText()))
			mainPanel.requestFocus();

		if (command.equals(exitB.getText()))
			System.exit(0);

		mainPanel.requestFocus();
	}


	// implement methods in KeyListener interface

	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		String keyText = e.getKeyText(keyCode);
		keyTF.setText(keyText + " pressed.");

        if(keyCode==KeyEvent.VK_LEFT){
            gamePanel.updatePlayer(1);
        }

        if(keyCode==KeyEvent.VK_RIGHT){
           gamePanel.updatePlayer(2);
        }
        
        if(keyCode==KeyEvent.VK_UP){
            gamePanel.updatePlayer(3);
			
        }  
        
        if(keyCode==KeyEvent.VK_SPACE){
            gamePanel.updatePlayer(5);
			gamePanel.attackPressed();
        } 
	}

	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode==KeyEvent.VK_UP){
            gamePanel.updatePlayer(4);
			
        }

	}

	public void keyTyped(KeyEvent e) {

	}

	// implement methods in MouseListener interface

	public void mouseClicked(MouseEvent e) {

		int x = e.getX();
		int y = e.getY();

		System.out.println("This position is X: "+x+" and Y: "+y);

	}


	public void mouseEntered(MouseEvent e) {
	
	}

	public void mouseExited(MouseEvent e) {
	
	}

	public void mousePressed(MouseEvent e) {
	
	}

	public void mouseReleased(MouseEvent e) {
	
	}


}