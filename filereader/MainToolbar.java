package filereader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;

import filereader.textreader.TextFileUtils;

@SuppressWarnings("serial")
public class MainToolbar extends JPanel {
	static class OpenFileHandler {
		public static void handle() {
			JFileChooser fileChooser = new JFileChooser();
			int success = fileChooser.showOpenDialog(null);
			if (success == JFileChooser.APPROVE_OPTION) {
				TextFileUtils.setCurrentFile(fileChooser.getSelectedFile());
				pathField.setText(TextFileUtils.getCurrentFile().toString());
				pathField.setColumns(pathField.getText().length());
				try {
					Utils fileOpener = new Utils(outputArea);
					fileOpener.openEditor(TextFileUtils.getCurrentFile());
				} catch (IOException | BadLocationException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static JButton openButton;
	private static JTextPane outputArea;
	private static JTextField pathField;

	MainToolbar(JTextPane textPane) throws IOException {
		MainToolbar.outputArea = textPane;
		openButton = new JButton("Open");
		openButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				OpenFileHandler.handle();
			}
		});
		pathField = new JTextField();
		pathField.setColumns(50);
		pathField.setEditable(false);
		add(openButton);
		add(pathField);
		if (!(GUI.file == null)) {
			if (GUI.file.isFile()) {
				TextFileUtils.setCurrentFile(GUI.file);
				pathField.setText(TextFileUtils.getCurrentFile().toString());
				GUI.file = null;
				try {
					Utils fileOpener = new Utils(textPane);
					fileOpener.openEditor(TextFileUtils.getCurrentFile());
				} catch (IOException | BadLocationException e) {
					e.printStackTrace();
				}
			} else {
				throw new FileNotFoundException("File does not exist!");
			}
		}
	}
}
