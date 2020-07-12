package filereader;

import java.io.FileNotFoundException;
import java.io.IOException;

import filereader.textreader.TextFileUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MainToolbar extends HBox {
	class OpenFileHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			FileChooser fileChooser = new FileChooser();
			TextFileUtils.setCurrentFile(fileChooser.showOpenDialog(new Stage()));
			pathField.setText(TextFileUtils.getCurrentFile().toString());
			try {
				Utils fileOpener = new Utils(outputArea);
				fileOpener.openEditor(TextFileUtils.getCurrentFile());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static Button openButton;
	private TextArea outputArea;
	private TextField pathField;

	MainToolbar(TextArea outputArea) throws IOException {
		this.outputArea = outputArea;
		openButton = new Button("Open");
		openButton.setOnAction(new OpenFileHandler());
		pathField = new TextField();
		pathField.setPrefColumnCount(50);
		pathField.setEditable(false);
		getChildren().addAll(openButton, pathField);
		if (!(GUI.file == null)) {
			if (GUI.file.isFile()) {
				TextFileUtils.setCurrentFile(GUI.file);
				pathField.setText(TextFileUtils.getCurrentFile().toString());
				GUI.file = null;
				try {
					Utils fileOpener = new Utils(outputArea);
					fileOpener.openEditor(TextFileUtils.getCurrentFile());
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				throw new FileNotFoundException("File does not exist!");
			}
		}

	}
}
