package p4_group_8_repo.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
	private ImageView backbutton;
	
	@FXML
	private Button backMenu;
	
	public SceneController scene;
	
	public InstructionSceneController(SceneController scene) {
		this.scene = scene;
	}
	
	@FXML 
	void backMenu(MouseEvent event) throws Exception{
		scene.activate("MenuScene");
	}
}
