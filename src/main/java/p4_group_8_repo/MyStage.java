package p4_group_8_repo;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import p4_group_8_repo.actor.BackgroundImage;

/**
 * A class that provides a pane for the background of the Game Scene.
 * It extends the class {@link World} and has the function to handle
 * background activities during the game play.
 * @author Liew Yih Seng
 *
 */
public class MyStage extends World{

	MediaPlayer mediaPlayer;
	
	/**
	 * A class inherited from the class {@link World}.
	 */
	@Override
	public void act(long now) {
		
	}
	
	/**
	 * A default constructor of the class.
	 */
	public MyStage() {

	}
	
	/**
	 * A method that handles the playing of background music when the program is launched.
	 */
	public void playMusic() {
		String musicFile = "src/main/resources/audio/Frogger Main Song Theme (loop).mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}
	
	/**
	 * A method that handles the stopping of background music.
	 */
	public void stopMusic() {
		mediaPlayer.stop();
	}
	
	/**
	 * A method that adds the background image to the Game Scene.
	 * @param imageLink A string that represents the path to the background image.
	 * @param stage A MyStage that represents the stage where the background images should be added into.
	 */
	public void addBackgroundImage(String imageLink, MyStage stage) {
		BackgroundImage backgroundIMG = new BackgroundImage(imageLink);
		stage.add(backgroundIMG);
	}
	
}
