package filereader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javafx.scene.text.Font;

public class TextFileUtils {
	private static File currentFile;
	
	private TextFileUtils() {}
	
	public static String readFile(File file, int length) throws IOException {
		char[] contents = new char[length];
		FileReader reader = new FileReader(file);
		reader.read(contents);
		reader.close();
		return new String(contents);
	}
	
	public static void readFileLines(File file) throws IOException {
		TextFilePane.getOutputArea().setText("");
		Scanner reader = new Scanner(file);
		while (reader.hasNext()) {
			TextFilePane.getOutputArea().setText(TextFilePane.getOutputArea().getText() + reader.nextLine() + "\n");
		}
		reader.close();
	}
	
	public static File getCurrentFile() {
		return currentFile;
	}
	
	public static void setCurrentFile(File file) {
		currentFile = file;
	}
}