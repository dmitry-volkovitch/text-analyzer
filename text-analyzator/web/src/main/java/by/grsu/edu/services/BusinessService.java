package by.grsu.edu.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import by.grsu.edu.brackets_checker.BracketCounter;
import by.grsu.edu.brackets_checker.BracketReader;
import by.grsu.edu.exceptions.IllegalFileFormatExcepion;
import by.grsu.edu.word_counter.WordCounter;
import by.grsu.edu.word_counter.WordReader;
import by.grsu.edu.word_counter.WordStorage;

/**
 * This class contains business logic of application.
 * @author dimav
 *
 */
@Component
public class BusinessService {
	private final String FILE_STORAGE_DIRECTORY = "C://Users//dimav//AppData//Local//Temp//";
	private final String CORRETCT_STR = "Correct";
	private final String INCORRECT_STR = "Incorrect";
	private final String ILLEGAL_FILE_FORMAT_EXCEPTION_MESSAGE = "The file format must be txt!";
	private final String TXT = ".txt";
	private final char DOT = '.';

	/**
	 * The method counts top 10 most commons words in the file.
	 * @param pathToFile
	 * @return top 10 most commons words
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public List<WordStorage> getTop10WordsInTheFile(String pathToFile) throws FileNotFoundException, IOException {
		if (pathToFile == null) {
			throw new FileNotFoundException();
		}
		try (WordReader reader = new WordReader(pathToFile)) {
			WordCounter counter = new WordCounter(reader);
			counter.count();
			return counter.getResult();
		}
	}

	/**
	 * The method checks correctness of the brackets placement.
	 * @param pathToFile
	 * @return correct or incorrect.
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String isValidPlacementOfBrackets(String pathToFile) throws FileNotFoundException, IOException {
		if (pathToFile == null) {
			throw new FileNotFoundException();
		}
		try (BracketReader reader = new BracketReader(pathToFile)) {
			BracketCounter counter = new BracketCounter(reader);
			return counter.isValidBrackets() ? CORRETCT_STR : INCORRECT_STR;
		}
	}

	/**
	 * The method save file in the file system on the server.
	 * @param file
	 * @param newFileName
	 * @return The file on the server.
	 * @throws IllegalFileFormatExcepion
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public File saveTxtFile(MultipartFile file, String newFileName)
			throws IllegalFileFormatExcepion, IllegalStateException, IOException {

		if (file == null || file.getOriginalFilename().lastIndexOf(DOT) == -1) {
			throw new FileNotFoundException();
		}
		String fileExtention = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(DOT));
		if (!fileExtention.equals(TXT)) {
			throw new IllegalFileFormatExcepion(ILLEGAL_FILE_FORMAT_EXCEPTION_MESSAGE);
		}

		String fileName = FILE_STORAGE_DIRECTORY + newFileName;
		File targetFile = new File(fileName);
		file.transferTo(targetFile);
		return targetFile;
	}
}
