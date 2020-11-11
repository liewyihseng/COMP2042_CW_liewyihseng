package p4_group_8_repo;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class startController implements Initializable{
	 @FXML
	 private AnchorPane start;
	 
	 @FXML
	 private Button startGame;
	 
	 @FXML
	 private ImageView startgame;
	 
	 @FXML
	 private ImageView frame;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
    @FXML
    void startGame(MouseEvent event) throws Exception{
        System.out.println("Test");
        
        ///Enter code here so that can link to the gameplay page
    }
}
