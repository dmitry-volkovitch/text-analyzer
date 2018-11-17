package by.grsu.edu.word_counter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
/**
 * Class that counts and stores the list of top-10 most common words in the file.
 * @author dimav
 *
 */
public class WordCounter {
	private WordReader reader;
	
	private List<WordStorage> wordList;

	private List<WordStorage> result;
	
	public WordCounter(WordReader reader) {
		this.reader = reader;
		wordList = new ArrayList<>();
	}
	
	/**
	 * Count top-10 most common words in the file.
	 * @throws IOException
	 */
	public void count() throws IOException {
		StringBuilder str = null;
		while((str = reader.readWord()) != null) {
			WordStorage storage = new WordStorage(str.toString(), 1);
			if(wordList.contains(storage)) {
				int i = wordList.indexOf(storage);
				storage = wordList.get(i);
				storage.setRepetitionsNumber(storage.getRepetitionsNumber() + 1);
				continue;
			}
			wordList.add(storage);
		}
		
		result = wordList.stream().sorted(new Comparator<WordStorage>() {

			@Override
			public int compare(WordStorage o1, WordStorage o2) {
				
				return o2.getRepetitionsNumber() - o1.getRepetitionsNumber();
			}
			
		}).collect(Collectors.toList()).subList(0, 10);
		
	}
	
	/**
	 * 
	 * @return return the list of top-10 most common words in the file.
	 */
	public List<WordStorage> getResult() {
		return result;
	}
}
