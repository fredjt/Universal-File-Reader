package filereader.textreader;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import filereader.MainPane;
import javafx.scene.control.TextArea;

public class TextFileUtils {
	private static File currentFile;

	public static File getCurrentFile() {
		return currentFile;
	}

	public static void setCurrentFile(File file) {
		currentFile = file;
	}

	private TextArea outputArea;

	public TextFileUtils(TextArea outputArea) {
		this.outputArea = outputArea;
	}

	private TextFileUtils() {
	}

	public void readFile(File file) throws IOException {
		MainPane.getTextPane().getOutputArea().setText("");
		Scanner reader = new Scanner(file);
		while (reader.hasNext()) {
			outputArea.appendText(reader.nextLine() + "\n");
		}
		reader.close();
	}
}
