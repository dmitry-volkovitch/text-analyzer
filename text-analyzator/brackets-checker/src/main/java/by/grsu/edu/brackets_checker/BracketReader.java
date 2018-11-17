package by.grsu.edu.brackets_checker;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.IOException;

/**
 * This class is designed to read only brackets from a file.
 * Extends the FileReader class.
 * @author dimav
 */
public class BracketReader extends FileReader {
	private static final char[] BRACKETS_ARRAY = { '(', ')', '{', '}', '[', ']' };

	/**
	 * 
	 * @param fileName - The name of file
	 * @throws FileNotFoundException
	 */
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

	/**
	 * 
	 * @return return the next bracket in the file, or \0 if the end of the stream has been reached
	 * @throws IOException
	 */
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
