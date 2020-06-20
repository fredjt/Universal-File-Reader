package filereader;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import filereader.binaryreader.BinaryFileUtils;
import filereader.textreader.TextFileUtils;
import javafx.scene.control.TextArea;

public class Utils {
	private TextArea outputArea;

	public Utils(TextArea outputArea) {
		this.outputArea = outputArea;
	}

	private Utils() {
	}

	public void openEditor(File file) throws IOException {
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
