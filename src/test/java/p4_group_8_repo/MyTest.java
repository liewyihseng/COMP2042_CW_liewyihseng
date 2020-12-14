package p4_group_8_repo;

import org.testfx.framework.junit.ApplicationTest;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MyTest extends ApplicationTest{
	@Override
	public void start(Stage stage) throws Exception{
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 600, 800);
		stage.setScene(scene);
		stage.show();
	}
}
