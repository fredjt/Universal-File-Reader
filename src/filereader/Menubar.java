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
import java.util.Properties;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 * @author Fred T
 *
 */
@SuppressWarnings("serial")
public class Menubar extends JMenuBar {
	/**
	 * @author Fred T
	 *
	 */
	static class OpenFileHandler {
		private static Utils fileOpener;

		/**
		 * @param file the starting directory
		 */
		public static void automaticFileOpener(File file) {
			file = openFile(file);
			try {
				if (fileOpener != null) {
					Thread.sleep(100);
					fileOpener.interrupt();
				}
				fileOpener = new Utils(outputArea, footer);
				fileOpener.openAutomaticEditor(Utils.getCurrentFile());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		/**
		 * @return the fileOpener
		 */
		public static Utils getFileOpener() {
			return fileOpener;
		}

		/**
		 * @param initfile the starting directory
		 * @throws Exception
		 */
		public static void manualFileOpener(File initfile) throws Exception {
			File file = openFile(initfile);
			JFrame editorChooser = new JFrame("Select Editor");
			new Utils(outputArea, footer);
			String[] editors = new String[Utils.getFileTypes().get(1).size()];
			for (int i = 0; i < editors.length - 1; i++)
				editors[i] = (String) ((Properties) Utils.getFileTypes().get(1).get(i)).get("description");
			editors[editors.length - 1] = "automatic";
			JList<String> list = new JList<>(editors);
			list.addListSelectionListener(e -> {
				editorChooser.dispose();
				int index = list.getSelectedIndex();
				if (index == -1)
					return;
				try {
					if (fileOpener != null) {
						Thread.sleep(100);
						fileOpener.interrupt();
					}
					fileOpener = new Utils(outputArea, footer);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				if (index >= Utils.getFileTypes().get(0).size()) {
					try {
						fileOpener.openAutomaticEditor(file);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
					try {
						if (fileOpener != null) {
							Thread.sleep(100);
							fileOpener.interrupt();
						}
						Utils.setEditor((FileType) ((Properties) Utils.getFileTypes().get(1).get(index)).get("object"));
						fileOpener = new Utils(outputArea, footer);
						fileOpener.setFile(file);
						fileOpener.start();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			JScrollPane scrollPane = new JScrollPane(list);
			editorChooser.add(scrollPane);
			editorChooser.setSize(500, 500);
			editorChooser.setLocationByPlatform(true);
			editorChooser.setVisible(true);
		}

		/**
		 * @param file the starting directory
		 * @return the current file
		 */
		public static File openFile(File file) {
			JFileChooser fileChooser = new JFileChooser(file);
			int success = fileChooser.showOpenDialog(null);
			if (success == JFileChooser.APPROVE_OPTION) {
				Utils.setCurrentFile(fileChooser.getSelectedFile());
				pathField.setText(Utils.getCurrentFile().toString());
				pathField.setColumns(pathField.getText().length());
				Utils.setCurrentFile(fileChooser.getSelectedFile());
			}
			return Utils.getCurrentFile();
		}

		/**
		 * @param fileOpener the fileOpener to set
		 */
		public static void setFileOpener(Utils fileOpener) {
			OpenFileHandler.fileOpener = fileOpener;
		}

		/**
		 *
		 */
		@Override
		public String toString() {
			return "OpenFileHandler [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
					+ super.toString() + "]";
		}
	}

	private static Footer footer;
	private static JTextPane outputArea;
	private static JTextField pathField;

	/**
	 * @return the footer
	 */
	public static Footer getFooter() {
		return footer;
	}

	/**
	 * @return the outputArea
	 */
	public static JTextPane getOutputArea() {
		return outputArea;
	}

	/**
	 * @return the pathField
	 */
	public static JTextField getPathField() {
		return pathField;
	}

	/**
	 * @param footer the footer to set
	 */
	public static void setFooter(Footer footer) {
		Menubar.footer = footer;
	}

	/**
	 * @param outputArea the outputArea to set
	 */
	public static void setOutputArea(JTextPane outputArea) {
		Menubar.outputArea = outputArea;
	}

	/**
	 * @param pathField the pathField to set
	 */
	public static void setPathField(JTextField pathField) {
		Menubar.pathField = pathField;
	}

	/**
	 * @param outputArea the output text area
	 * @param footer     the text area for displaying the file type
	 */
	public Menubar(JTextPane outputArea, Footer footer) {
		Menubar.outputArea = outputArea;
		Menubar.footer = footer;
		Menubar.pathField = MainToolbar.getPathField();

		JMenu fileMenu = new JMenu("File");

		JMenuItem openItem = new JMenuItem("Open...");
		openItem.addActionListener(e -> {
			OpenFileHandler.automaticFileOpener(Utils.getCurrentFile());
		});
		fileMenu.add(openItem);

		JMenuItem openWithItem = new JMenuItem("Open With...");
		openWithItem.addActionListener(e -> {
			try {
				OpenFileHandler.manualFileOpener(Utils.getCurrentFile());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		fileMenu.add(openWithItem);

		add(fileMenu);
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return "Menubar [ui=" + ui + ", listenerList=" + listenerList + ", accessibleContext=" + accessibleContext
				+ "]";
	}
}
