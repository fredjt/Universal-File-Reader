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

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Fred T
 *
 */
@SuppressWarnings("serial")
public class Footer extends JPanel {
	private static JTextField fileType;

	/**
	 * 
	 */
	public Footer() {
		fileType = new JTextField(20);
		fileType.setEditable(false);
		setLayout(new FlowLayout());
		add(fileType);
	}

	/**
	 * @return
	 */
	public String getText() {
		return fileType.getText();
	}

	/**
	 * @param text
	 */
	public void setText(String text) {
		fileType.setText(text);
	}

	/**
	 * 
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Footer clone = new Footer();
		clone.setText(this.getText());
		clone.accessibleContext = this.accessibleContext;
		clone.listenerList = this.listenerList;
		clone.ui = this.ui;
		return clone;
	}
}
