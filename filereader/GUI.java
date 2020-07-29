package filereader;

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
