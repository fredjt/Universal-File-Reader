package filereader;
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

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

@SuppressWarnings({ "serial" })
public class GUI extends JFrame {
	private static MainPane pane;
	static File file;

	public static void main(String[] args) throws IOException {
		if (args.length > 1)
			throw new IllegalArgumentException("Too many arguments!\nUse: java GUI [filename]");
		if (args.length == 1)
			GUI.file = new File(args[0]);
		pane = new MainPane();
		JFrame frame = new JFrame();
		frame.add(pane);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(1000, 700));
		frame.setLocationByPlatform(true);
		frame.setExtendedState(MAXIMIZED_BOTH);
		frame.setVisible(true);
	}
}
