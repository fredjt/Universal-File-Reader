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

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 * @author Fred T
 *
 */
@SuppressWarnings("serial")
public class MainToolbar extends JPanel {
	private static Menubar menubar;
	private static JTextField pathField;

	/**
	 * @return
	 */
	public static Menubar getMenubar() {
		return MainToolbar.menubar;
	}

	/**
	 * @return the field containing the current file path
	 */
	public static JTextField getPathField() {
		return MainToolbar.pathField;
	}

	/**
	 * @param menubar the menubar to set
	 */
	public static void setMenubar(Menubar menubar) {
		MainToolbar.menubar = menubar;
	}

	/**
	 * @param pathField the pathField to set
	 */
	public static void setPathField(JTextField pathField) {
		MainToolbar.pathField = pathField;
	}

	private Utils fileOpener;

	/**
	 * @param textPane the output text area for the file contents
	 * @param footer   the output text area for the file type
	 * @throws IOException
	 */
	public MainToolbar(JTextPane textPane, Footer footer) throws IOException {
		pathField = new JTextField();
		pathField.setColumns(50);
		pathField.setEditable(false);
		add(pathField);
		if (!(GUI.getFile() == null)) {
			if (GUI.getFile().isFile()) {
				Utils.setCurrentFile(GUI.getFile());
				pathField.setText(Utils.getCurrentFile().toString());
				GUI.setFile(null);
				try {
					Thread.sleep(100);
					fileOpener.interrupt();
					fileOpener = new Utils(textPane, footer);
					fileOpener.openAutomaticEditor(Utils.getCurrentFile());
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				throw new FileNotFoundException(Messages.getString("MainToolbar.0")); //$NON-NLS-1$
			}
		}

		menubar = new Menubar(textPane, footer);
	}

	/**
	 *
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof MainToolbar))
			return false;
		MainToolbar other = (MainToolbar) obj;
		if (fileOpener == null) {
			if (other.fileOpener != null)
				return false;
		} else if (!fileOpener.equals(other.fileOpener))
			return false;
		return true;
	}

	/**
	 * @return the Utils object for opening files
	 */
	public Utils getFileOpener() {
		return fileOpener;
	}

	/**
	 *
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fileOpener == null) ? 0 : fileOpener.hashCode());
		return result;
	}

	/**
	 * @param fileOpener the fileOpener to set
	 */
	public void setFileOpener(Utils fileOpener) {
		this.fileOpener = fileOpener;
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return "MainToolbar [fileOpener=" + fileOpener + "]";
	}

	/**
	 *
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		MainToolbar clone = (MainToolbar) super.clone();
		clone.fileOpener = this.fileOpener;
		return clone;
	}
}
