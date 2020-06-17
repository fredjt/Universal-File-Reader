package filereader;

import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class TextFilePane extends BorderPane {
	private static TextArea outputArea;
	
	TextFilePane() {
		outputArea = new TextArea();
		setCenter(outputArea);
	}

	/**
	 * @return the outputArea
	 */
	public static TextArea getOutputArea() {
		return outputArea;
	}
}