package filereader.binaryreader;

import java.awt.Font;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;

import filereader.FileType;
import filereader.Utils;

public class BinaryFileUtils implements FileType {
	private JTextPane outputArea;

	public BinaryFileUtils(JTextPane outputArea) {
		this.outputArea = outputArea;
		this.outputArea.setFont(Font.decode("COURIER NEW"));
	}

	@Override
	public void readFile(File file) throws IOException, BadLocationException {
		int i, j;
		outputArea.setText("");
		@SuppressWarnings("resource")
		DataInputStream input = new DataInputStream(new FileInputStream(file));
		if (file.length() > 1 << 8 && input.markSupported()) {
			Utils.setBuffered(true);
			readFile(file, 0, 1 << 8);
		}
		for (j = 0; j < file.length(); j++) {
			i = input.read();
			if (j % 16 == 0)
				outputArea.getDocument().insertString(outputArea.getDocument().getLength(),
						String.format(j == 0 ? "%07X0   " : "\n%07X0   ", j / 16), new SimpleAttributeSet());
			outputArea.getDocument().insertString(outputArea.getDocument().getLength(),
					j % 8 == 0 ? String.format("    %02X", i) : String.format("  %02X", i), new SimpleAttributeSet());
			outputArea.validate();
		}
		outputArea.setCaretPosition(0);
		input.close();
	}

	@Override
	public void readFile(File file, int start, int bufferSize) throws IOException, BadLocationException {
		int i, j;
		outputArea.setText("");
		@SuppressWarnings("resource")
		DataInputStream input = new DataInputStream(new FileInputStream(file));
		input.mark(start);
		for (j = 0; j < Math.min(file.length(), bufferSize); j++) {
			i = input.read();
			if (j % 16 == 0)
				outputArea.getDocument().insertString(outputArea.getDocument().getLength(),
						String.format(j == 0 ? "%07X0   " : "\n%07X0   ", j / 16), new SimpleAttributeSet());
			outputArea.getDocument().insertString(outputArea.getDocument().getLength(),
					j % 8 == 0 ? String.format("    %02X", i) : String.format("  %02X", i), new SimpleAttributeSet());
			outputArea.validate();
		}
		outputArea.setCaretPosition(0);
		input.close();
	}
}
