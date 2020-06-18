package filereader;

import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class TextFilePane extends BorderPane {
	private static Text outputArea;
	
	TextFilePane() {
		outputArea = new Text();
		outputArea.setFont(Utils.font);
		setCenter(outputArea);
	}

	/**
	 * @return the output TextArea
	 */
	public static Text getOutputArea() {
		return outputArea;
	}
}