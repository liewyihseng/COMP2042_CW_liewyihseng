package p4_group_8_repo;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import p4_group_8_repo.actor.BackgroundImage;

public class MyStage extends World{

	MediaPlayer mediaPlayer;
	@Override
	public void act(long now) {
		
	}
	
	public MyStage() {
//		mediaPlayer.play();
//		mediaPlayer.setOnEndOfMedia(new Runnable() {
//
//			@Override
//			public void run() {
//				mediaPlayer.seek(Duration.ZERO);
//				
//			}
//			
//		});
//		mediaPlayer.play();
	}
	
	public void playMusic() {
		String musicFile = "src/main/resources/audio/Frogger Main Song Theme (loop).mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}
	
	public void stopMusic() {
		mediaPlayer.stop();
	}
	
	public void addBackgroundImage(String imageLink, MyStage stage) {
		BackgroundImage backgroundIMG = new BackgroundImage(imageLink);
		stage.add(backgroundIMG);
	}
	
}
