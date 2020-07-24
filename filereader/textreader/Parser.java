package filereader.textreader;

import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledDocument;

public class Parser {
	private static int begin, end;
	private static SimpleAttributeSet defaultStyle = new SimpleAttributeSet();
	private static ArrayList<Object> functions;
	private static String stopwords = " (){}+-*/[]|\\<>=~;\n";
	private static SimpleAttributeSet styles;

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		long start = System.currentTimeMillis();
		FileInputStream in = new FileInputStream("test.dat");
		ObjectInputStream objIn = new ObjectInputStream(in);
		@SuppressWarnings("unchecked")
		ArrayList<Object> functionproperties = (ArrayList<Object>) objIn.readObject();
		objIn.close();
		in.close();

		for (int i = 0; i < functionproperties.size(); i++)
			System.out.println(functionproperties.get(i));
		System.out.flush();
		System.out.println(functionproperties.contains("A"));
		System.out.println(System.currentTimeMillis() - start);
	}

	@SuppressWarnings("unchecked")
	public static void parse(StyledDocument document, String token)
			throws BadLocationException, IOException, ClassNotFoundException {
		if (styles == null) {
			FileInputStream in = new FileInputStream("test.dat");
			ObjectInputStream objIn = new ObjectInputStream(in);
			functions = (ArrayList<Object>) objIn.readObject();
			styles = (SimpleAttributeSet) functions.get(0);
			objIn.close();
			in.close();
		}

		if (functions.contains(token)) {
			document.setCharacterAttributes(begin, end - begin + 1, styles, true);
		} else {
			document.setCharacterAttributes(begin, end - begin + 1, defaultStyle, true);
		}
		System.out.println(token + " : " + functions.contains(token));
	}

	private String currentToken = "";

	public void appendText(KeyEvent e, JTextPane textArea)
			throws BadLocationException, ClassNotFoundException, IOException {
		begin = textArea.getCaretPosition() - 1;
		end = textArea.getCaretPosition();
		if (begin > 0) {
			while (!stopwords.contains(textArea.getText(begin, 1))) {
				begin--;
				if (begin == 0) {
					begin = 0;
					break;
				}
			}
		} else {
			begin = 0;
		}
		while (end < textArea.getText().length() && !stopwords.contains(textArea.getText(end, 1))) {
			end++;
		}
		if (begin != 0) {
			begin++;
		}
		end--;
		int i = 0;
		if (e.getKeyChar() == '\b') {
			i = 1;
		}
		currentToken = textArea.getText(begin, end - begin + i);
		if (e.getKeyChar() != '\b') {
			currentToken += e.getKeyChar();
		}
		parse(textArea.getStyledDocument(), currentToken);
	}
}
