package filereader;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUI extends Application {
	public static Stage newPrimaryStage;
	
	@Override
	public void start(Stage primaryStage) {
		newPrimaryStage = new Stage();
		MainPane pane = new MainPane();
		Scene scene = new Scene(pane);
		newPrimaryStage.setScene(scene);
		newPrimaryStage.setMaximized(true);
		newPrimaryStage.show();
	}
	
	public static void main(String[] args) {
		launch();
	}
}