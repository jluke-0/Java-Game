//816006490
//Jean-Luke Chankoo
//COMP 3609
//A3
import javax.sound.sampled.AudioInputStream;		// for playing sound clips
import javax.sound.sampled.*;
import java.io.*;
import java.util.HashMap;				// for storing sound clips

public class SoundManager {				// a Singleton class
	HashMap<String, Clip> clips;

	private static SoundManager instance = null;	


	private SoundManager () {
		clips = new HashMap<String, Clip>();

		Clip clip = loadClip("sounds/backgroundMain.wav");	// played from start of the game
		FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(-20.0f); //lowers volume
		clips.put("background", clip);


		clip = loadClip("sounds/deathHit.wav");				
		clips.put("deathHit", clip);

		clip = loadClip("sounds/fireHit.wav");	
        FloatControl gainControlFire = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControlFire.setValue(-10.0f); //lowers volume		
		clips.put("fireHit", clip);

		clip = loadClip("sounds/alucardHit.wav");	
		FloatControl gainControlAlucardHit= (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControlAlucardHit.setValue(+5.0f); //lowers volume				
		clips.put("alucardHit", clip);

		clip = loadClip("sounds/playerAttack.wav");					
		clips.put("playerAttack", clip);

        clip = loadClip("sounds/ghostDied.wav");					
		clips.put("ghostDied", clip);

        clip = loadClip("sounds/alucardDied.wav");					
		clips.put("alucardDied", clip);

        clip = loadClip("sounds/draculaHit1.wav");
		FloatControl gainControlDraculaHit1 = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControlDraculaHit1.setValue(-5.0f); //lowers volume						
		clips.put("draculaHit1", clip);

        clip = loadClip("sounds/draculaHit2.wav");					
		clips.put("draculaHit2", clip);

        clip = loadClip("sounds/draculaDied.wav");					
		clips.put("draculaDied", clip);


	}


	public static SoundManager getInstance() {	
		if (instance == null)
			instance = new SoundManager();
		
		return instance;
	}		


    	public Clip loadClip (String fileName) {	
 		AudioInputStream audioIn;
		Clip clip = null;

		try {
    			File file = new File(fileName);
    			audioIn = AudioSystem.getAudioInputStream(file.toURI().toURL()); 
    			clip = AudioSystem.getClip();
    			clip.open(audioIn);
		}
		catch (Exception e) {
 			System.out.println ("Error opening sound files: " + e);
		}
    		return clip;
    	}


	public Clip getClip (String title) {

		return clips.get(title);
	}


    	public void playClip(String title, Boolean looping) {
		Clip clip = getClip(title);
		if (clip != null) {
			clip.setFramePosition(0);
			if (looping)
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			else
				clip.start();
		}
    	}


    	public void stopClip(String title) {
		Clip clip = getClip(title);
		if (clip != null) {
			clip.stop();
		}
    	}

}