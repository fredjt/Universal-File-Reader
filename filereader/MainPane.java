package filereader;

import javafx.scene.layout.BorderPane;

public class MainPane extends BorderPane {
	TextFilePane textPane;
	
	MainPane() {
		MainToolbar mainToolbar = new MainToolbar();
		textPane = new TextFilePane();
		setTop(mainToolbar);
		setCenter(textPane);
	}

	/**
	 * @param textPane the textPane to set
	 */
	public void setTextPane(TextFilePane textPane) {
		this.textPane = textPane;
	}
}