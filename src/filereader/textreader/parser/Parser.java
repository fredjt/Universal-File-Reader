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

package filereader.textreader.parser;

import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledDocument;

import filereader.CreateFileTypeProperties;
import filereader.Utils;

public class Parser {
	private static int begin, end;
	private static SimpleAttributeSet defaultStyle = new SimpleAttributeSet();
	private static ArrayList<Object> functions, symbols;
	private static SimpleAttributeSet functionStyle, symbolStyle;

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ObjectInputStream objIn = new ObjectInputStream(
				new FileInputStream("filereader/textreader/parser/mathematica/functions.dat"));
		@SuppressWarnings("unchecked")
		ArrayList<Object> functionproperties = (ArrayList<Object>) objIn.readObject();
		objIn.close();

		for (int i = 0; i < functionproperties.size(); i++)
			System.out.println(functionproperties.get(i));
		System.out.flush();
		System.out.println("Is Abs a function? " + functionproperties.contains("Abs"));
	}

	private String currentToken = "";

	public void appendText(KeyEvent e, JTextPane textArea)
			throws BadLocationException, ClassNotFoundException, IOException {
		begin = textArea.getCaretPosition() - 1;
		end = textArea.getCaretPosition();
		if (begin > 0) {
			while (!symbols.contains(textArea.getText(begin, 1))) {
				begin--;
				if (begin == 0) {
					begin = 0;
					break;
				}
			}
		} else {
			begin = 0;
		}
		while (end < textArea.getText().length() && !symbols.contains(textArea.getText(end, 1))) {
			end++;
		}
		if (begin != 0) {
			begin++;
		}
		end--;
		int i = 0;
		if (e.getKeyChar() == '\b') {
			i = 1;
		}
		currentToken = textArea.getText(begin, end - begin + i);
		if (e.getKeyChar() != '\b') {
			currentToken += e.getKeyChar();
		}
		parse(textArea.getStyledDocument(), currentToken);
	}

	@SuppressWarnings("unchecked")
	public void parse(StyledDocument document, String token)
			throws BadLocationException, IOException, ClassNotFoundException {
		if (functionStyle == null) {
			ObjectInputStream objIn = new ObjectInputStream(
					new FileInputStream("filereader/textreader/parser/" + "mathematica" + "/functions.dat"));
			functions = (ArrayList<Object>) objIn.readObject();
			objIn.close();
			functionStyle = (SimpleAttributeSet) functions.get(0);
			objIn = new ObjectInputStream(new FileInputStream("filereader/textreader/parser/mathematica/symbols.dat"));
			symbols = (ArrayList<Object>) objIn.readObject();
			objIn.close();
			symbolStyle = (SimpleAttributeSet) symbols.get(0);
		}
		if (functions.contains(token)) {
			document.setCharacterAttributes(begin, end - begin + 1, functionStyle, true);
		} else {
			document.setCharacterAttributes(begin, end - begin + 1, defaultStyle, true);
		}
		System.out.println(token + " : " + functions.contains(token));
	}

}
