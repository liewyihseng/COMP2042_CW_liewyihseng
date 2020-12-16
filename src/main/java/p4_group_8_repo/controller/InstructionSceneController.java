package p4_group_8_repo.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * A controller that handles all event within the Instruction Scene.
 * @author Liew Yih Seng
 *
 */
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
	
	/**
	 * Represents the {@link SceneController} in this class.
	 */
	public SceneController scene;
	
	/**
	 * A constructor that sets this {@link #scene} to the {@link SceneController}
	 * initialized in {@link SceneController} class.
	 * @param scene A {@link SceneController} that represents {@link SceneController} to be passed into this class.
	 */
	public InstructionSceneController(SceneController scene) {
		this.scene = scene;
	}
	
	/**
	 * A method that allows users to go back to the Menu Scene.
	 * It invokes the method {@link SceneController#activate(String)} to activate
	 * and display the Menu Scene.
	 * @param event A {@link MouseEvent} that represents if the user has clicked on this button.
	 * @throws Exception If the source is null.
	 */
	@FXML 
	void backMenu(MouseEvent event) throws Exception{
		scene.activate("MenuScene");
	}
}
