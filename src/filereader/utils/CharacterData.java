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
# � 2020 GitHub, Inc.                                                            #
##################################################################################
 */

package filereader.utils;

/**
 * @author Fred T
 *
 */
public class CharacterData {
	/**
	 * 
	 */
	private static String textChars = Messages.getString("CharacterData.0"); //$NON-NLS-1$

	/**
	 * @return the textChars
	 */
	public static String getTextChars() {
		return textChars;
	}

	/**
	 * @param c a character
	 * @return true if c is a common text character
	 */
	public static boolean isText(char c) {
		return Character.isJavaIdentifierPart(c) || textChars.contains(Messages.getString("CharacterData.1") + c); //$NON-NLS-1$
	}

	/**
	 * @param textChars the textChars to set
	 */
	public static void setTextChars(String textChars) {
		CharacterData.textChars = textChars;
	}

	/**
	 * 
	 */
	private CharacterData() {
	}
}