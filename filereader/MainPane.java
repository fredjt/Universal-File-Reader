package filereader;

import java.io.IOException;

import filereader.textreader.TextFilePane;
import javafx.scene.layout.BorderPane;

public class MainPane extends BorderPane {
	private static MainToolbar mainToolbar;
	private static TextFilePane textPane;

	public static TextFilePane getTextPane() {
		return textPane;
	}

	MainPane() throws IOException {
		textPane = new TextFilePane();
		mainToolbar = new MainToolbar(textPane.getOutputArea());
		setTop(mainToolbar);
		setCenter(textPane);
	}
}
