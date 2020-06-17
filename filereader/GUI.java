package filereader;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUI extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		MainPane pane = new MainPane();
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.setMaximized(true);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch();
	}
}