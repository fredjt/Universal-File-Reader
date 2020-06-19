package filereader;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MainToolbar extends HBox {
	private TextField pathField;
	private static Button openButton;
	
	MainToolbar() {
		openButton = new Button("Open");
		openButton.setOnAction(new OpenFileHandler());
		
		pathField = new TextField();
		getChildren().addAll(openButton, pathField);
		pathField.setPrefColumnCount(50);
	}
	
	class OpenFileHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			FileChooser fileChooser = new FileChooser();
			TextFileUtils.setCurrentFile(fileChooser.showOpenDialog(new Stage()));
			pathField.setText(TextFileUtils.getCurrentFile().toString());
			try {
				TextFileUtils.readFileLines(TextFileUtils.getCurrentFile());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}