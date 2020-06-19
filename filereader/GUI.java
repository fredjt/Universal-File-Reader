package filereader;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUI extends Application {
	private static Stage newPrimaryStage;
	private static Scene scene;
	private static MainPane pane;
	
	public static void main(String[] args) {
		launch();
	}
	
	@Override
	public void start(Stage primaryStage) {
		newPrimaryStage = new Stage();
		pane = new MainPane();
		scene = new Scene(pane);
		newPrimaryStage.setScene(scene);
		newPrimaryStage.setMaximized(true);
		newPrimaryStage.show();
	}
}