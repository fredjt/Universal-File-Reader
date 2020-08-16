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

package filereader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.regex.Pattern;

import javax.swing.JTextPane;

import filereader.utils.CharacterData;

/**
 * @author Fred T
 *
 */
public class Utils extends Thread {
	private static File currentFile;
	private static FileType editor;
	private static int fileDesc;
	private static ArrayList<ArrayList<Object>> fileTypes;

	/**
	 * @return the currentFile
	 */
	public static File getCurrentFile() {
		return currentFile;
	}

	/**
	 * @return the editor
	 */
	public static FileType getEditor() {
		return editor;
	}

	/**
	 * @return the fileDesc
	 */
	public static int getFileDesc() {
		return fileDesc;
	}

	/**
	 * @return the fileTypes
	 */
	public static ArrayList<ArrayList<Object>> getFileTypes() {
		return fileTypes;
	}

	/**
	 * @param file
	 */
	public static void setCurrentFile(File file) {
		currentFile = file;
	}

	/**
	 * @param editor
	 */
	public static void setEditor(FileType editor) {
		Utils.editor = editor;
	}

	/**
	 * @param fileDesc the fileDesc to set
	 */
	public static void setFileDesc(int fileDesc) {
		Utils.fileDesc = fileDesc;
	}

	/**
	 * @param fileTypes the fileTypes to set
	 */
	public static void setFileTypes(ArrayList<ArrayList<Object>> fileTypes) {
		Utils.fileTypes = fileTypes;
	}

	private File file;

	private Footer footer;

	private JTextPane outputArea;

	/**
	 * @param textPane
	 * @param footer
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public Utils(JTextPane textPane, Footer footer) throws ClassNotFoundException, IOException {
		this.outputArea = textPane;
		this.footer = footer;
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(FileTypes.getFileTypePropertiesFile()));
		Utils.fileTypes = (ArrayList<ArrayList<Object>>) in.readObject();
	}

	/**
	 * @return
	 */
	public File getFile() {
		return this.file;
	}

	/**
	 * @return the footer
	 */
	public Footer getFooter() {
		return footer;
	}

	/**
	 * @return the outputArea
	 */
	public JTextPane getOutputArea() {
		return outputArea;
	}

	/**
	 * @param file
	 * @throws Exception
	 */
	public void openAutomaticEditor(File file) throws Exception {
		this.file = file;
		try {
			fileDesc = probeContentType(file);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		footer.setText(fileDesc != 0
				? (String) ((Properties) fileTypes.get(1).get(fileDesc)).get(Messages.getString("Utils.0")) //$NON-NLS-1$
				: Messages.getString("Utils.1")); //$NON-NLS-1$
		if (fileDesc == 0 || fileDesc == 1) {
			fileDesc = 1;
			FileInputStream in = new FileInputStream(file);
			int ur = 0;
			for (int i = 0; i < file.length(); i++) {
				if (!CharacterData.isText((char) in.read())) {
					ur++;
					if (ur >= file.length() / 1000) {
						in.close();
						footer.setText(Messages.getString("Utils.5")); //$NON-NLS-1$
						fileDesc = 0;
						break;
					}
				}
			}
			in.close();
		}
		Utils.editor = (FileType) ((Properties) fileTypes.get(1).get(fileDesc)).get(Messages.getString("Utils.7"));
		this.start();
	}

	/**
	 * @param file
	 * @param editor
	 */
	public void openManualEditor(File file, FileType editor) {
		this.file = file;
		try {
			editor.readFile(file);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public int probeContentType(File file) throws IOException {
		FileInputStream in = new FileInputStream(file);
		String[] tmp, exts;
		String temp, ext;
		String magic = Messages.getString("Utils.9"); //$NON-NLS-1$
		byte[] magicarray;
		int bestMatch = 0;
		for (int i = 0; i < fileTypes.get(1).size(); i++) {
			tmp = (String[]) (((Properties) fileTypes.get(1).get(i)).getOrDefault(Messages.getString("Utils.11"), //$NON-NLS-1$
					new String[] { Messages.getString("Utils.12") })); //$NON-NLS-1$
			for (int j = 0; j < (tmp.length); j++) {
				magic = Messages.getString("Utils.13"); //$NON-NLS-1$
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
				} while (l != 0);
				count--;
				magicarray = new byte[(temp.length() - 7 * count) / 2];
				if (temp.length() == 0 && file.toString().lastIndexOf('.') != -1) {
					ext = file.toString().substring(file.toString().lastIndexOf('.'));
					exts = (String[]) ((Properties) fileTypes.get(1).get(i)).get(Messages.getString("Utils.16")); //$NON-NLS-1$
					for (int m = 0; m < exts.length; m++) {
						if (exts[m].equals(ext)) {
							in.close();
							bestMatch = i;
						}
					}
					continue;
				}
				in.read(magicarray);
				for (int k = 0; k < magicarray.length; k++)
					magic += String.format(Messages.getString("Utils.19"), magicarray[k]); //$NON-NLS-1$
				if (Pattern.matches(temp, magic) && file.toString().lastIndexOf('.') != -1) {
					ext = file.toString().substring(file.toString().lastIndexOf('.'));
					exts = (String[]) ((Properties) fileTypes.get(1).get(i)).get(Messages.getString("Utils.22")); //$NON-NLS-1$
					for (int m = 0; m < exts.length; m++) {
						if (exts[m].equals(ext)) {
							in.close();
							return i;
						}
					}
					bestMatch = i;
				} else if (Pattern.matches(temp, magic)) {
					bestMatch = i;
				}
			}
		}
		in.close();
		return bestMatch;
	}

	/**
	 *
	 */
	@Override
	public void run() {
		openManualEditor(this.file, Utils.editor);
	}

	/**
	 * @param file
	 */
	public void setFile(File file) {
		this.file = file;
	}

	/**
	 * @param footer the footer to set
	 */
	public void setFooter(Footer footer) {
		this.footer = footer;
	}

	/**
	 * @param outputArea the outputArea to set
	 */
	public void setOutputArea(JTextPane outputArea) {
		this.outputArea = outputArea;
	}
}
