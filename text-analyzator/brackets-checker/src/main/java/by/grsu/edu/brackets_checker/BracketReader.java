package by.grsu.edu.brackets_checker;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BracketReader extends FileReader {
	private static final char[] BRACKETS_ARRAY = { '(', ')', '{', '}', '[', ']' };

	public BracketReader(String arg0) throws FileNotFoundException {
		super(arg0);
	}
	
	private boolean isBracket(char symbol) {
		for(char s : BRACKETS_ARRAY) {
			if(s == symbol) {
				return true;
			}
		}
		return false;
	}

	public char readBracket() throws IOException {
		int symbol = -1;
		while((symbol = read()) != -1) {
			char s = (char) symbol;
			if(isBracket(s)) {
				return s;
			}
		}
		return '\0';
	}

}
