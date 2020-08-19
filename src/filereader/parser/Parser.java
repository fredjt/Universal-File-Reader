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

package filereader.parser;

import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledDocument;

import filereader.Utils;

/**
 * @author Fred T
 *
 */
public class Parser {
	private static int begin, end;
	private static ArrayList<Object> comments, functions, symbols;
	@SuppressWarnings("unused")
	private static SimpleAttributeSet commentStyle, functionStyle, symbolStyle;
	private static SimpleAttributeSet defaultStyle = new SimpleAttributeSet();

	/**
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ObjectInputStream objIn = new ObjectInputStream(
				new FileInputStream("src/filereader/parser/mathematicaNotebook/functions.dat"));
		@SuppressWarnings("unchecked")
		ArrayList<Object> functionproperties = (ArrayList<Object>) objIn.readObject();
		objIn.close();

		for (int i = 0; i < functionproperties.size(); i++)
			System.out.flush();
		System.out.println("Is Abs a function? " + functionproperties.contains("Abs"));
	}

	private String currentToken = "";

	/**
	 * @param e
	 * @param textArea
	 * @throws BadLocationException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
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

	/**
	 * Returns true iff the currentToken fields of both objects are the same
	 * 
	 * @param obj the object to compare
	 * @return true if both this and obj are equal
	 */
	@Override
	public boolean equals(Object obj) {
		Parser obj1 = (Parser) obj;
		return obj1.currentToken == this.currentToken;
	}

	/**
	 * @param document
	 * @param token
	 * @throws BadLocationException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public void parse(StyledDocument document, String token)
			throws BadLocationException, IOException, ClassNotFoundException {
		if (functionStyle == null) {
			ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("src/filereader/parser/"
					+ ((Properties) Utils.getFileTypes().get(1).get(Utils.getFileDesc())).get("folder")
					+ "/functions.dat"));
			functions = (ArrayList<Object>) objIn.readObject();
			objIn.close();
			functionStyle = (SimpleAttributeSet) functions.get(0);
			objIn = new ObjectInputStream(new FileInputStream("src/filereader/parser/"
					+ ((Properties) Utils.getFileTypes().get(1).get(Utils.getFileDesc())).get("folder")
					+ "/symbols.dat"));
			symbols = (ArrayList<Object>) objIn.readObject();
			objIn.close();
			symbolStyle = (SimpleAttributeSet) symbols.get(0);
			objIn = new ObjectInputStream(new FileInputStream("src/filereader/parser/"
					+ ((Properties) Utils.getFileTypes().get(1).get(Utils.getFileDesc())).get("folder")
					+ "/comments.dat"));
			comments = (ArrayList<Object>) objIn.readObject();
			objIn.close();
			commentStyle = (SimpleAttributeSet) comments.get(0);
		}
		if (functions.contains(token)) {
			document.setCharacterAttributes(begin, end - begin + 1, functionStyle, true);
		} else {
			document.setCharacterAttributes(begin, end - begin + 1, defaultStyle, true);
		}
	}

	/**
	 * @param outputArea
	 * @param in
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws BadLocationException
	 */
	@SuppressWarnings("unchecked")
	public void parseDocument(JTextPane outputArea, InputStream in)
			throws IOException, ClassNotFoundException, BadLocationException {
		outputArea.setText("");
		StyledDocument document = outputArea.getStyledDocument();
		if (functionStyle == null) {
			ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("src/filereader/parser/"
					+ ((Properties) Utils.getFileTypes().get(1).get(Utils.getFileDesc())).get("folder")
					+ "/functions.dat"));
			functions = (ArrayList<Object>) objIn.readObject();
			objIn.close();
			functionStyle = (SimpleAttributeSet) functions.get(0);
			objIn = new ObjectInputStream(new FileInputStream("src/filereader/parser/"
					+ ((Properties) Utils.getFileTypes().get(1).get(Utils.getFileDesc())).get("folder")
					+ "/symbols.dat"));
			symbols = (ArrayList<Object>) objIn.readObject();
			objIn.close();
			symbolStyle = (SimpleAttributeSet) symbols.get(0);
			objIn = new ObjectInputStream(new FileInputStream("src/filereader/parser/"
					+ ((Properties) Utils.getFileTypes().get(1).get(Utils.getFileDesc())).get("folder")
					+ "/comments.dat"));
			comments = (ArrayList<Object>) objIn.readObject();
			objIn.close();
			commentStyle = (SimpleAttributeSet) comments.get(0);
		}
		int temp, comment = 0, commentq = 0, commentclsq = 0;
		String token = "";
		while ((temp = in.read()) != -1) {
			if (commentq == 1 && temp != '*')
				commentq = 0;
			if (comment == 1 && commentclsq == 1 && temp != ')')
				commentclsq = 0;
			if (temp == '(') {
				commentq = 1;
			} else if (commentq == 1 && comment == 0 && temp == '*') {
				comment = 1;
				if (token.length() > 1)
					document.insertString(document.getLength(), token.substring(0, token.length() - 2), defaultStyle);
				token = "(*";
			} else if (comment == 1 && temp == '*') {
				commentclsq = 1;
			} else if (comment == 1 && commentclsq == 1 && temp == ')') {
				comment = 0;
				commentclsq = 0;
				document.insertString(document.getLength(), token + ")", commentStyle);
				token = "";
				continue;
			}
			if (!(Character.isLetter(temp) || temp == '_') && comment == 0 && !(commentq == 1 && temp == '(')) {
				if (functions.contains(token)) {
					document.insertString(document.getLength(), token, functionStyle);
					document.insertString(document.getLength(), "" + (char) temp, defaultStyle);
				} else {
					document.insertString(document.getLength(), token + (char) temp, defaultStyle);
				}
				token = "";
			} else {
				token += (char) temp;
			}
		}
		document.render(Thread.currentThread());
	}

	/**
	 * Returns a string representation of this object
	 *
	 * @return "Parser " + currentToken
	 */
	@Override
	public String toString() {
		return "Parser " + currentToken;
	}

	/**
	 *
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Parser clone = new Parser();
		clone.currentToken = this.currentToken;
		return clone;
	}
}
