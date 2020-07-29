package filereader;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Footer extends JPanel {
	private static JTextField fileType;

	public Footer() {
		fileType = new JTextField(20);
		fileType.setEditable(false);
		setLayout(new FlowLayout());
		add(fileType);
	}

	public void setText(String text) {
		fileType.setText(text);
		System.out.println(fileType.getText());
	}
}
