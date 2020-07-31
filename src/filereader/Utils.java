package filereader;
/*
##################################################################################
# MIT License                                                                    #
#                                                                                #
# Copyright (c) 2020 fredjt                                                      #
#                                                                                #
# Permission is hereby granted, free of charge, to any person obtaining a copy   #
# of this software and associated documentation files (the "Software"), to deal  #
# in the Software without restriction, including without limitation the rights   #
# to use, copy, modify, merge, publish, distribute, sublicense, and/or sell      #
# copies of the Software, and to permit persons to whom the Software is          #
# furnished to do so, subject to the following conditions:                       #
#                                                                                #
# The above copyright notice and this permission notice shall be included in all #
# copies or substantial portions of the Software.                                #
#                                                                                #
# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR     #
# IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,       #
# FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE    #
# AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER         #
# LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,  #
# OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE  #
# SOFTWARE.                                                                      #
# © 2020 GitHub, Inc.                                                            #
##################################################################################
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.swing.JTextPane;

import filereader.binaryreader.BinaryFileUtils;
import filereader.textreader.TextFileUtils;

public class Utils {

	private int fileDesc;
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

	public int getFileDesc() {
		return this.fileDesc;
	}

	public ArrayList<ArrayList<Object>> getFileTypes() {
		return this.fileTypes;
	}

	public void openEditor(File file) throws Exception {
		Scanner reader = new Scanner(file);
		FileType fileOpener;
		fileDesc = probeContentType(file);
		String fileType = (String) (fileTypes.get(0).get(fileDesc));
		footer.setText(fileDesc != 0 ? (String) ((Properties) fileTypes.get(1).get(fileDesc)).get("description")
				: "application/octet-stream");
		System.out.println(fileType);
		if (fileType != null && ((String) fileTypes.get(0).get(fileDesc)).contains("text")) {
			fileOpener = new TextFileUtils(outputArea);
		} else {
			fileOpener = new BinaryFileUtils(outputArea);
		}
		fileOpener.readFile(file);
		reader.close();
	}

	public int probeContentType(File file) throws IOException {
		FileInputStream in = new FileInputStream(file);
		String[] tmp, exts;
		String temp, ext;
		String magic = "";
		byte[] magicarray;
		int bestMatch = 0;
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
				if (temp.length() == 0) {
					ext = file.toString().substring(file.toString().lastIndexOf('.'));
					exts = (String[]) ((Properties) fileTypes.get(1).get(i)).get("extensions");
					System.out.println("ext: " + ext);
					for (int m = 0; m < exts.length; m++) {
						System.out.println("exts: " + exts[m]);
						if (exts[m].equals(ext)) {
							in.close();
							bestMatch = i;
						}
					}
					continue;
				}
				in.read(magicarray);
				for (int k = 0; k < magicarray.length; k++)
					magic += String.format("%02X", magicarray[k]);
				System.out.println("magic: " + magic);
				System.out.println("temp: " + temp);
				if (Pattern.matches(temp, magic)) {
					ext = file.toString().substring(file.toString().lastIndexOf('.'));
					exts = (String[]) ((Properties) fileTypes.get(1).get(i)).get("extensions");
					System.out.println("ext: " + ext);
					for (int m = 0; m < exts.length; m++) {
						System.out.println("exts: " + exts[m]);
						if (exts[m].equals(ext)) {
							in.close();
							return i;
						}
					}
					bestMatch = i;
				}
			}
		}
		in.close();
		return bestMatch;
	}
}
