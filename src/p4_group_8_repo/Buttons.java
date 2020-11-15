package p4_group_8_repo;


import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Buttons extends Actor{
	String userName;
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	public Buttons(String imageLink, int xpos, int ypos, int xsize, int ysize, Stage stage, Scene resultScene, MyStage dispAtPage) {
		Button button = new Button();
		ImageView buttonImage = new ImageView(imageLink);
		buttonImage.setFitHeight(xsize);
		buttonImage.setFitWidth(ysize);
		button.setGraphic(buttonImage);
		setButtonStyle(button, xpos, ypos);
		setButtonAction(button, stage, resultScene);
		dispAtPage.getChildren().add(button);
	}

	public void setButtonAction(Button button, Stage stage,Scene resultScene) {
		button.setOnAction(e -> stage.setScene(resultScene));
	}
	
	public Buttons(String imageLink, int xpos, int ypos, int xsize, int ysize, Stage stage, Scene resultScene, MyStage dispAtPage, TextField text) {
		Button button = new Button();
		ImageView buttonImage = new ImageView(imageLink);
		buttonImage.setFitHeight(xsize);
		buttonImage.setFitWidth(ysize);
		button.setGraphic(buttonImage);
		setButtonStyle(button, xpos, ypos);
		dispAtPage.getChildren().add(button);
		button.setOnAction(e -> {
			//Retrieving data
			User user = new User(text.getText());
			stage.setScene(resultScene);
			//System.out.println(user.getUsername());
			//System.out.println(user.getCurrentScore());
			}
		);
	}

	
	public void setButtonStyle(Button button, int xpos, int ypos){
		
		button.setLayoutX(xpos);
		button.setLayoutY(ypos);
		button.setStyle("-fx-focus-color: transparent;-fx-background-color: transparent");
		button.setCursor(Cursor.HAND);
	}
	
}
