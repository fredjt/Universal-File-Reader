package filereader.textreader;

import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class TextFilePane extends BorderPane {
	private TextArea outputArea;

	public TextFilePane() {
		outputArea = new TextArea();

		setCenter(outputArea);
	}

	/**
	 * @return the output TextArea
	 */
	public TextArea getOutputArea() {
		return outputArea;
	}
}
