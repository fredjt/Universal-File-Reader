package filereader.textreader;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class TextFilePane extends JPanel {
	private JTextPane outputArea;

	public TextFilePane() {
		setLayout(new FlowLayout());
		outputArea = new JTextPane();
		add(outputArea);
	}

	public JTextPane getOutputArea() {
		return outputArea;
	}
}
