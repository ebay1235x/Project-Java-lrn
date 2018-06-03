/**
 * 
 */
package view;

import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;

/**
 * @author Rayan
 *
 */
/**
 * @author Rayan
 *
 */
@SuppressWarnings("unused")
public enum Sounds {

	/**
	 * The EXPLOSION
	 */
	LOST("Ressources/Sounds/GG.wav"),
	/**
	
	 */
	WON("Ressources/Sounds/B.wav"),
     /**
	
	 */
	START("Ressources//Sounds/START.wav");

	/**
	 * The clip
	 */
	private Clip clip;

	/**
	 * The main constructor for Sounds
	 * @param soundFileName
	 */
	Sounds(String soundFileName) {
		try {
			File f = new File(soundFileName);
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(f);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);

		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Plays the clip
	 * 
	 */
	public void play() {
		stop();
		clip.setFramePosition(0);
		clip.start();
	}

	/**
	 * Loops the clip
	 * 
	 */
	public void loop() {
		while (true) {
			clip.loop(1);
		}
	}
	
	/**
	 * Stops the clip
	 */
	public void stop() {
		if (clip.isRunning()) {
			clip.stop();
		}
	}

	/**
	 * Initialize all the values
	 * 
	 */
	static void init() {
		values();
	}
}
