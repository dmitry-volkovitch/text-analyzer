package by.grsu.edu.word_counter;
/**
 * Class that stores word string and number of repetitions of the word 
 * @author dimav
 *
 */
public class WordStorage {
	private static final String COLON = ":";

	private String word;
	private Integer repetitionsNumber;

	public WordStorage(String word, Integer repetitionsNumber) {
		this.word = word;
		this.repetitionsNumber = repetitionsNumber;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Integer getRepetitionsNumber() {
		return repetitionsNumber;
	}

	public void setRepetitionsNumber(Integer repetitionsNumber) {
		this.repetitionsNumber = repetitionsNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WordStorage other = (WordStorage) obj;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder(word);
		str.append(COLON);
		str.append(repetitionsNumber);
		return str.toString();
	}

}
