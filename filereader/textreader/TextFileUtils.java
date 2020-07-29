package filereader.textreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;

import filereader.FileType;
import filereader.MainPane;

public class TextFileUtils implements FileType {
	private static File currentFile;
	private static boolean markSupported;

	public static File getCurrentFile() {
		return currentFile;
	}

	public static boolean isMarkSupported() {
		return markSupported;
	}

	public static void setCurrentFile(File file) {
		currentFile = file;
	}

	private JTextPane outputArea;

	public TextFileUtils(JTextPane outputArea) {
		this.outputArea = outputArea;
	}

	@Override
	public void readFile(File file) throws IOException, BadLocationException {
		MainPane.getTextPane().setText("");
		FileInputStream reader = new FileInputStream(file);
		outputArea.read(reader, null);
		reader.close();
	}

	@Override
	public void readFile(File file, int start, int bufferSize) {
		// TODO Auto-generated method stub

	}
}
