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
	private static SimpleAttributeSet defaultStyle = new SimpleAttributeSet();
	private static ArrayList<Object> functions, symbols;
	@SuppressWarnings("unused")
	private static SimpleAttributeSet functionStyle, symbolStyle;

	/**
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(Messages.getString("Parser.0"))); //$NON-NLS-1$
		@SuppressWarnings("unchecked")
		ArrayList<Object> functionproperties = (ArrayList<Object>) objIn.readObject();
		objIn.close();

		for (int i = 0; i < functionproperties.size(); i++)
			System.out.flush();
		System.out
				.println(Messages.getString("Parser.1") + functionproperties.contains(Messages.getString("Parser.2"))); //$NON-NLS-1$ //$NON-NLS-2$
	}

	private String currentToken = Messages.getString("Parser.3"); //$NON-NLS-1$

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
			ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(Messages.getString("Parser.4") //$NON-NLS-1$
					+ ((Properties) Utils.getFileTypes().get(1).get(Utils.getFileDesc()))
							.get(Messages.getString("Parser.5")) //$NON-NLS-1$
					+ Messages.getString("Parser.6"))); //$NON-NLS-1$
			functions = (ArrayList<Object>) objIn.readObject();
			objIn.close();
			functionStyle = (SimpleAttributeSet) functions.get(0);
			objIn = new ObjectInputStream(new FileInputStream(Messages.getString("Parser.7") //$NON-NLS-1$
					+ ((Properties) Utils.getFileTypes().get(1).get(Utils.getFileDesc()))
							.get(Messages.getString("Parser.8")) //$NON-NLS-1$
					+ Messages.getString("Parser.9"))); //$NON-NLS-1$
			symbols = (ArrayList<Object>) objIn.readObject();
			objIn.close();
			symbolStyle = (SimpleAttributeSet) symbols.get(0);
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
		StyledDocument document = outputArea.getStyledDocument();
		if (functionStyle == null) {
			ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(Messages.getString("Parser.11") //$NON-NLS-1$
					+ ((Properties) Utils.getFileTypes().get(1).get(Utils.getFileDesc()))
							.get(Messages.getString("Parser.12")) //$NON-NLS-1$
					+ Messages.getString("Parser.13"))); //$NON-NLS-1$
			functions = (ArrayList<Object>) objIn.readObject();
			objIn.close();
			functionStyle = (SimpleAttributeSet) functions.get(0);
			objIn = new ObjectInputStream(new FileInputStream(Messages.getString("Parser.14") //$NON-NLS-1$
					+ ((Properties) Utils.getFileTypes().get(1).get(Utils.getFileDesc()))
							.get(Messages.getString("Parser.15")) //$NON-NLS-1$
					+ Messages.getString("Parser.16"))); //$NON-NLS-1$
			symbols = (ArrayList<Object>) objIn.readObject();
			objIn.close();
			symbolStyle = (SimpleAttributeSet) symbols.get(0);
		}
		int temp;
		String token = Messages.getString("Parser.17"); //$NON-NLS-1$
		while ((temp = in.read()) != -1) {
			if (!(Character.isLetter(temp) || temp == '_')) {
				if (functions.contains(token)) {
					document.insertString(document.getLength(), token, functionStyle);
				} else {
					document.insertString(document.getLength(), token, defaultStyle);
				}
				token = Messages.getString("Parser.19"); //$NON-NLS-1$
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
