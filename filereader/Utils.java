package filereader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class Utils {
	public static File currentFile;
	
	private Utils() {}
	
	public static String readFile(File file, int length) throws IOException {
		char[] contents = new char[length];
		FileReader reader = new FileReader(file);
		reader.read(contents);
		reader.close();
		return new String(contents);
	}
	
	public static String readFileLines(File file, int numberOfLines) throws IOException {
		String contents = "";
		FileReader reader = new FileReader(file);
		int newlines = 0;
		char temp;
		while (newlines < numberOfLines && (temp = (char) reader.read()) != (char) -1) {
			if (temp == Character.LINE_SEPARATOR)
				newlines++;
			contents += temp;
		}
		reader.close();
		return contents;
	}
}