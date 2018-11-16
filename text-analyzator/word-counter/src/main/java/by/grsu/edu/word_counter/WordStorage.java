package by.grsu.edu.word_counter;
/**
 * Class that stores word string and number of repetitions of the word 
 * @author dimav
 *
 */
public class WordStorage {
	private static final String COLON = ":";

	private StringBuilder word;
	private Integer repetitionsNumber;

	public WordStorage(StringBuilder word, Integer repetitionsNumber) {
		this.word = word;
		this.repetitionsNumber = repetitionsNumber;
	}

	public StringBuilder getWord() {
		return word;
	}

	public void setWord(StringBuilder word) {
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
		} else if (!word.toString().equals(other.word.toString()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		word.append(COLON);
		word.append(repetitionsNumber);
		return word.toString();
	}

}
