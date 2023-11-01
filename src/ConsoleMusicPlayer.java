import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class ConsoleMusicPlayer {

	public static void main(String[] args) {
		List<String> musicToPlay = new ArrayList<String>();
		musicToPlay.add("1.mp3"); // i = 0 
		musicToPlay.add("2.mp3"); // i = 1
		musicToPlay.add("3.mp3"); // i = 2
		
		try {
		
			for (int i=0; i < musicToPlay.size(); i++) {
				System.out.println("Playing " + musicToPlay.get(i));
				Clip currentClip = PlayMusic(musicToPlay.get(i));
				while (currentClip.getMicrosecondLength() != currentClip.getMicrosecondPosition())
				{
					
				}
					
			}
			
		} catch  (Exception e) {
			System.out.println(e);
		}
		

	}


	public static Clip PlayMusic(String location) {
		try {
			File musicPath = new File(location);
			
			if (musicPath.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
				return clip;
			}
			else {
				System.out.println("Can't find file.");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

}
