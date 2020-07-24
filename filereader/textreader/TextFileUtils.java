package filereader.textreader;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;

import filereader.MainPane;

public class TextFileUtils {
	private static File currentFile;

	public static File getCurrentFile() {
		return currentFile;
	}

	public static void setCurrentFile(File file) {
		currentFile = file;
	}

	private JTextPane outputArea;

	public TextFileUtils(JTextPane outputArea) {
		this.outputArea = outputArea;
	}

	@SuppressWarnings("unused")
	private TextFileUtils() {
	}

	public void readFile(File file) throws IOException, BadLocationException {
		MainPane.getTextPane().setText("");
		Scanner reader = new Scanner(file);
		while (reader.hasNext()) {
			outputArea.getDocument().insertString(outputArea.getDocument().getLength(), reader.nextLine() + "\n",
					new SimpleAttributeSet());
		}
		reader.close();
	}
}
