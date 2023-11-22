package PLDataBase;

import javax.sound.sampled.*;
import java.io.*;

public class BackgroundMusic extends Thread{
	
	public static Clip clip;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		 try
	        {
	            File musicPath = new File("src\\PLDataBase\\The-Official-Premier-League-Anthem.wav");
	                if(musicPath.exists())
	                {
	                    AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
	                    clip = AudioSystem.getClip();
	                    clip.open(audioInput);
	                    FloatControl gainControl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
	                    gainControl.setValue(-20.0f);//������������ΧΪ -60.0f �� 6.0f
	                    clip.start();
	                    clip.loop(Clip.LOOP_CONTINUOUSLY);
	                }
	        }
	        catch(Exception ex)
	        {
	            ex.printStackTrace();
	        }

	}

}

