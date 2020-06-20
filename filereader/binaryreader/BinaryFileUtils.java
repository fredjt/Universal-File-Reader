package filereader.binaryreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javafx.scene.control.TextArea;

public class BinaryFileUtils {
	private TextArea outputArea;

	public BinaryFileUtils(TextArea outputArea) {
		this.outputArea = outputArea;
	}

	private BinaryFileUtils() {
	}

	public void readFile(File file) throws IOException {
		int i = 0;
		int j;
		int nextByte = 0;
		String line;
		outputArea.setText("");
		FileInputStream reader = new FileInputStream(file);
		while (nextByte != -1) {
			j = 0;
			line = "";
			while (j++ < 16 && (nextByte = reader.read()) != -1) {
				line += String.format("\t%02X", nextByte);
			}
			outputArea.appendText(String.format("%07X0 \t", i) + line + "\n");
			i++;
		}
		reader.close();
	}
}
