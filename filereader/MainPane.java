package filereader;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class MainPane extends JPanel {
	private static Footer footer;
	private static MainToolbar mainToolbar;
	private static JTextPane textPane;

	public static JTextPane getTextPane() {
		return textPane;
	}

	MainPane() throws IOException, ClassNotFoundException {
		setLayout(new BorderLayout());
		textPane = new JTextPane();
		textPane.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textPane);
		footer = new Footer();
		mainToolbar = new MainToolbar(textPane, footer);

		add(mainToolbar, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
		add(footer, BorderLayout.SOUTH);
	}
}
