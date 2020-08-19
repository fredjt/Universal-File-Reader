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
import java.io.Serializable;

import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;

import filereader.FileType;
import filereader.MainPane;

/**
 * @author Fred T
 *
 */
@SuppressWarnings("serial")
public abstract class BinaryFile implements FileType, Serializable {
	/**
	 *
	 */
	@Override
	public void readFile(File file) throws IOException, BadLocationException {
		int i, j;
		MainPane.getTextPane().setText("");
		MainPane.getTextPane().setFont(Font.decode("COURIER NEW"));
		@SuppressWarnings("resource")
		FileInputStream input = new FileInputStream(file);
		for (j = 0; j < file.length(); j++) {
			i = input.read();
			if (j % 16 == 0)
				MainPane.getTextPane().getDocument().insertString(MainPane.getTextPane().getDocument().getLength(),
						String.format(j == 0 ? "%07X0   " : "\n%07X0   ", j / 16), new SimpleAttributeSet());
			MainPane.getTextPane().getDocument().insertString(MainPane.getTextPane().getDocument().getLength(),
					j % 8 == 0 ? String.format("    %02X", i) : String.format("  %02X", i), new SimpleAttributeSet());
			MainPane.getTextPane().validate();
		}
		MainPane.getTextPane().setCaretPosition(0);
		input.close();
	}
}
