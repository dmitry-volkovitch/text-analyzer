package by.grsu.edu.brackets_checker;

import java.io.IOException;
import java.util.Stack;

/**
 * Class that checks the placement of brackets.
 * @author dimav
 *
 */
public class BracketCounter {
	private static final char[] OPENING_BRACKETS_ARRAY = { '(', '{', '[' };
	private static final char CLOSING_ROUND_BRACKET = ')';
	private static final char CLOSING_SQUARE_BRACKET = ']';
	private static final char CLOSING_FIGURED_BRACKET = '}';
	private static final char OPENING_ROUND_BRACKET = '(';
	private static final char OPENING_SQUARE_BRACKET = '[';
	private static final char OPENING_FIGURED_BRACKET = '{';

	private BracketReader reader;

	public BracketCounter(BracketReader reader) {
		this.reader = reader;
	}

	private boolean isOpeningBracket(char bracket) {
		for (char s : OPENING_BRACKETS_ARRAY) {
			if (bracket == s) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isOpeningBracketCorrespondedClosingBracket(char openingBracket, char closingBracket) {
		if(openingBracket == OPENING_ROUND_BRACKET && closingBracket == CLOSING_ROUND_BRACKET) {
			return true;
		}
		if(openingBracket == OPENING_SQUARE_BRACKET && closingBracket == CLOSING_SQUARE_BRACKET) {
			return true;
		}
		if(openingBracket == OPENING_FIGURED_BRACKET && closingBracket == CLOSING_FIGURED_BRACKET) {
			return true;
		}
		return false;
	}

	/**
	 * Check the placement of brackets.
	 * @return true, if the placement is valid, or false, if the placement is invalid.
	 * @throws IOException
	 */
	public boolean isValidBrackets() throws IOException {
		Stack<Character> stack = new Stack<>();
		char bracket = '\0';
		while ((bracket = reader.readBracket()) != '\0') {
			if (isOpeningBracket(bracket)) {
				stack.push(bracket);
			} else {
				if (isOpeningBracketCorrespondedClosingBracket(stack.peek(), bracket)) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return stack.empty();
	}
}
