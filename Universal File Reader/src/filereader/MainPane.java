/*
##################################################################################
# MIT License                                                                    #
#                                                                                #
# Copyright (c) 2021 Fred T                                                      #
#                                                                                #
# Permission is hereby granted, free of charge, to any person obtaining a copy   #
# of this software and associated documentation files (the "Software"), to deal  #
# in the Software without restriction, including without limitation the rights   #
# to use, copy, modify, merge, publish, distribute, sublicense, and/or sell      #
# copies of the Software, and to permit persons to whom the Software is          #
# furnished to do so, subject to the following conditions:                       #
#                                                                                #
# The above copyright notice and this permission notice shall be included in all #
# copies or substantial portions of the Software.                                #
#                                                                                #
# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR     #
# IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,       #
# FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE    #
# AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER         #
# LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,  #
# OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE  #
# SOFTWARE.                                                                      #
# � 2021 GitHub, Inc.                                                            #
##################################################################################
 */

package filereader;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

/**
 * @author Fred T
 *
 */
@SuppressWarnings("serial")
public class MainPane extends JPanel {
	private static Footer footer;
	private static MainToolbar mainToolbar;
	private static JTextPane textPane;

	/**
	 * @return the footer
	 */
	public static Footer getFooter() {
		return footer;
	}

	/**
	 * @return the mainToolbar
	 */
	public static MainToolbar getMainToolbar() {
		return mainToolbar;
	}

	/**
	 * @return
	 */
	public static JTextPane getTextPane() {
		return textPane;
	}

	/**
	 * @param footer the footer to set
	 */
	public static void setFooter(Footer footer) {
		MainPane.footer = footer;
	}

	/**
	 * @param mainToolbar the mainToolbar to set
	 */
	public static void setMainToolbar(MainToolbar mainToolbar) {
		MainPane.mainToolbar = mainToolbar;
	}

	/**
	 * @param textPane the textPane to set
	 */
	public static void setTextPane(JTextPane textPane) {
		MainPane.textPane = textPane;
	}

	/**
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public MainPane() throws IOException, ClassNotFoundException {
		setLayout(new BorderLayout());
		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBackground(Color.getHSBColor(0.55f, 0.05f, 1f));
		JScrollPane scrollPane = new JScrollPane(textPane);
		footer = new Footer();
		mainToolbar = new MainToolbar(textPane, footer);

		add(mainToolbar, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
		add(footer, BorderLayout.SOUTH);
	}
}
