package filereader;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUI extends Application {
	private static Stage newPrimaryStage;
	private static MainPane pane;
	private static Scene scene;
	static File file;

	public static void main(String[] args) throws IOException {
		if (args.length > 1)
			throw new IllegalArgumentException("Too many arguments!\nUse: GUI [filename]");
		if (args.length == 1)
			GUI.file = new File(args[0]);
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		newPrimaryStage = new Stage();
		pane = new MainPane();
		scene = new Scene(pane);
		newPrimaryStage.setScene(scene);
		newPrimaryStage.setMaximized(true);
		newPrimaryStage.show();
	}
}
