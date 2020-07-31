package filereader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.swing.JTextPane;

import filereader.binaryreader.BinaryFileUtils;
import filereader.textreader.TextFileUtils;

public class Utils extends Thread {
	private File file;
	private static boolean isBuffered;

	public static void setBuffered(boolean isBuffered) {
		Utils.isBuffered = isBuffered;
	}

	private ArrayList<ArrayList<Object>> fileTypes;
	private Footer footer;

	private JTextPane outputArea;

	@SuppressWarnings("unchecked")
	public Utils(JTextPane textPane, Footer footer) throws ClassNotFoundException, IOException {
		this.outputArea = textPane;
		this.footer = footer;
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream(CreateFileTypeProperties.getFileTypePropertiesFile()));
		this.fileTypes = (ArrayList<ArrayList<Object>>) in.readObject();
	}

	public boolean isBuffered() {
		return isBuffered;
	}
	
	@Override 
	public void run() {
		Scanner reader = null;
		try {
			reader = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		FileType fileOpener;
		String fileType = "";
		try {
			fileType = probeContentType(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		footer.setText(fileType);
		System.out.println(fileType);
		if (fileType != null && fileType.contains("text")) {
			fileOpener = new TextFileUtils(outputArea);
		} else {
			fileOpener = new BinaryFileUtils(outputArea);
		}
		try {
			fileOpener.readFile(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		reader.close();
	}

	public void openEditor(File file) {
		this.file = file;
		this.start();
	}

	public String probeContentType(File file) throws IOException {
		FileInputStream in = new FileInputStream(file);
		String[] tmp;
		String temp;
		String magic = "";
		byte[] magicarray;
		for (int i = 0; i < fileTypes.get(1).size(); i++) {
			System.out.println("i: " + i);
			tmp = (String[]) (((Properties) fileTypes.get(1).get(i)).getOrDefault("magic", new String[] { "" }));
			for (int j = 0; j < (tmp.length); j++) {
				magic = "";
				temp = tmp[j];
				if (in.markSupported()) {
					in.reset();
				} else {
					in = new FileInputStream(file);
				}
				int count = 0;
				int l = 0;
				do {
					l = temp.indexOf('[', l);
					count++;
					l++;
					System.out.println("l: " + l);
				} while (l != 0);
				count--;
				System.out.println("count: " + count);
				magicarray = new byte[(temp.length() - 7 * count) / 2];
				if (temp.length() == 0)
					continue;
				in.read(magicarray);
				for (int k = 0; k < magicarray.length; k++)
					magic += String.format("%02X", magicarray[k]);
				System.out.println("magic: " + magic);
				System.out.println("temp: " + temp);
				if (Pattern.matches(temp, magic)) {
					in.close();
					return (String) fileTypes.get(0).get(i);
				}
			}
		}
		in.close();
		return null;
	}
}
