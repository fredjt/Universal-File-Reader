package filereader.binaryreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;

public class BinaryFileUtils {
	private JTextPane outputArea;

	public BinaryFileUtils(JTextPane outputArea) {
		this.outputArea = outputArea;
	}

	@SuppressWarnings("unused")
	private BinaryFileUtils() {
	}

	public void readFile(File file) throws IOException, BadLocationException {
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
			outputArea.getDocument().insertString(outputArea.getDocument().getLength(),
					String.format("%07X0 \t", i) + line + "\n", new SimpleAttributeSet());
			i++;
		}
		reader.close();
	}
}
