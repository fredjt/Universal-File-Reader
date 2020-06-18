package filereader;

import javafx.scene.layout.GridPane;

public class MainPane extends GridPane {
	TextFilePane textPane;
	
	MainPane() {
		MainToolbar mainToolbar = new MainToolbar();
		textPane = new TextFilePane();
		add(mainToolbar, 0, 0);
		add(textPane, 0, 1);
	}

	/**
	 * @param textPane the textPane to set
	 */
	public void setTextPane(TextFilePane textPane) {
		this.textPane = textPane;
	}
}