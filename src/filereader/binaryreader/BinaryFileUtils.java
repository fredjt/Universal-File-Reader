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

package filereader.binaryreader;

import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;

import filereader.FileType;

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
		FileInputStream input = new FileInputStream(file);
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
}
