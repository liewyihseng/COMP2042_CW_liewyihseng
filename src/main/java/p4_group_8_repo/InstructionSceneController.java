package p4_group_8_repo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class InstructionSceneController {
	@FXML
	private AnchorPane instructionRoot;
	
	@FXML
	private ImageView control;
	
	@FXML
	private ImageView wasd;
	
	@FXML
	private ImageView frogger;
	
	@FXML
	private ImageView obstacles;
	
	@FXML
	private ImageView avoid;
	
	@FXML
	private ImageView ridable;
	
	@FXML
	private ImageView logs;
	
	@FXML
	private ImageView nonsubmerging;
	
	@FXML
	private ImageView submerging;
	
	@FXML
	private ImageView scoring;
	
	@FXML
	private ImageView end;
	
	@FXML
	private ImageView homebutton;
	
	@FXML 
	void backMenu(MouseEvent event) throws Exception{
		FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("/views/MenuScene.fxml"));
		AnchorPane pane = menuLoader.load();
		instructionRoot.getChildren().setAll(pane);
	}
}
