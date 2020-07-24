package filereader;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextPane;

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
		frame.setExtendedState(MAXIMIZED_BOTH);
		frame.setVisible(true);
	}
}

@SuppressWarnings("serial")
class TextFilePane extends JTextPane {
	private JTextPane outputArea;

	public TextFilePane() {
		outputArea = new JTextPane();

		add(outputArea, BorderLayout.CENTER);
	}

	public JTextPane getOutputArea() {
		return outputArea;
	}
}
