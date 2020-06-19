package filereader;

import javafx.scene.layout.BorderPane;

public class MainPane extends BorderPane {
	private static TextFilePane textPane;
	private static MainToolbar mainToolbar;
	
	MainPane() {
		mainToolbar = new MainToolbar();
		textPane = new TextFilePane();
		setTop(mainToolbar);
		setCenter(textPane);
	}
}