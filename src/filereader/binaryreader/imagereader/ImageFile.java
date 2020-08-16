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

package filereader.binaryreader.imagereader;

import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;

import filereader.MainPane;
import filereader.binaryreader.BinaryFile;

/**
 * @author Fred T
 *
 */
@SuppressWarnings("serial")
public abstract class ImageFile extends BinaryFile {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	private JTextPane outputArea;

	/**
	 * 
	 */
	public ImageFile() {
		super();
	}

	/**
	 * @param outputArea
	 */
	public ImageFile(JTextPane outputArea) {
		super();
		this.outputArea = outputArea;
	}

	/**
	 * @return the outputArea
	 */
	public JTextPane getOutputArea() {
		return outputArea;
	}

	/**
	 *
	 */
	@Override
	public void readFile(File file) throws IOException, BadLocationException {
		MainPane.getTextPane().setText("");
		MainPane.getTextPane().insertIcon(new ImageIcon(file.toString()));
	}

	/**
	 * @param outputArea the outputArea to set
	 */
	public void setOutputArea(JTextPane outputArea) {
		this.outputArea = outputArea;
	}
}
