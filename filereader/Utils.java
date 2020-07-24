package filereader;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;

import filereader.binaryreader.BinaryFileUtils;
import filereader.textreader.TextFileUtils;

public class Utils {
	private JTextPane outputArea;

	public Utils(JTextPane outputArea) {
		this.outputArea = outputArea;
	}

	@SuppressWarnings("unused")
	private Utils() {
	}

	public void openEditor(File file) throws IOException, BadLocationException {
		Scanner reader = new Scanner(file);
		if (file.length() > 0 && !reader.hasNextLine()) {
			BinaryFileUtils fileOpener = new BinaryFileUtils(outputArea);
			fileOpener.readFile(file);
		} else {
			TextFileUtils fileOpener = new TextFileUtils(outputArea);
			fileOpener.readFile(file);
		}
		reader.close();
	}
}
