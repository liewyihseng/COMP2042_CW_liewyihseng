package p4_group_8_repo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class InstructionSceneController {
	@FXML
	private Pane instructionRoot;
	
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
	private Button backMenu;
	
	public SceneController screen;
	
	public InstructionSceneController(SceneController scene) {
		this.screen = scene;
	}
	
	@FXML 
	void backMenu(MouseEvent event) throws Exception{
		screen.activate("MenuScene");
	}
}
