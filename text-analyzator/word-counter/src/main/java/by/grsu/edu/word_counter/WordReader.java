package by.grsu.edu.word_counter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class is designed to read words from a file.
 * Extends the FileReader class.
 * @author dimav
 */
public class WordReader extends FileReader {
	private static final char BIG_A_LETTER = 'A';
	private static final char BIG_Z_LETTER = 'Z';
	private static final char SMALL_A_LETTER = 'a';
	private static final char SMALL_Z_LETTER = 'z';
	private static final char HYPHEN = '-';

	/**
	 * 
	 * @param fileName - The name of file
	 * @throws FileNotFoundException
	 */
	public WordReader(String fileName) throws FileNotFoundException {
		super(fileName);
	}

	private static boolean isLetter(char symbol) {
		return ((symbol >= BIG_A_LETTER && symbol <= BIG_Z_LETTER)
				|| (symbol >= SMALL_A_LETTER && symbol <= SMALL_Z_LETTER));
	}

	/**
	 * 
	 * @return return the next word in the file, or null if the end of the stream has been reached
	 * @throws IOException
	 */
	public String readWord() throws IOException {
		StringBuilder str = new StringBuilder();
		int symbol = -1;
		char previousSymbol = '\0';
		while ((symbol = read()) != -1) {
			char letter = (char) symbol;

			if (!isLetter(letter)) {
				if (!isLetter(previousSymbol)) {
					continue;
				} else {
					if(letter == HYPHEN) {
						previousSymbol = letter;
						str.append(letter);
						continue;
					}
					return str.toString();
				}
			}

			previousSymbol = letter;
			str.append(letter);
		}
		return null;
	}

}
