package by.grsu.edu.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import by.grsu.edu.exceptions.IllegalFileFormatExcepion;
import by.grsu.edu.services.BusinessService;

/**
 * Rest controller that accepting requests and sending responses.
 * 
 * @author dimav
 *
 */
@RestController
public class WebController {
	private final String FILE_UPLOADED = "The file uploaded successfully!";
	private final String FILE_NOT_FOUND = "The file not found!";
	private final String FILE = "file";
	private final String EXTENTION_EXCEPTION_MESSAGE = "The file has illegal extention. The Extention must be txt!";

	@Autowired
	private BusinessService service;

	/**
	 * The method sends 10 most common words in the file.
	 * 
	 * @param session
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@GetMapping("top-10-words")
	public Object getTop10Words(HttpSession session) throws FileNotFoundException, IOException {
		return service.getTop10WordsInTheFile((String) session.getAttribute(FILE));
	}

	/**
	 * The method sends the result of brackets validation of the file.
	 * 
	 * @param session
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@GetMapping("brackets-validation")
	public Object getBracketsValidationResult(HttpSession session) throws FileNotFoundException, IOException {
		return service.isValidPlacementOfBrackets((String) session.getAttribute(FILE));
	}

	/**
	 * The method uploads the file on the server.
	 * 
	 * @param file
	 * @param session
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 * @throws IllegalFileFormatExcepion
	 */
	@PostMapping("file")
	public String uploadFile(@RequestBody MultipartFile file, HttpSession session, HttpServletResponse response)
			throws IllegalStateException, IOException, IllegalFileFormatExcepion {

		File targetFile = service.saveTxtFile(file, session.getId());
		session.setAttribute(FILE, targetFile.getAbsolutePath());
		response.sendRedirect("/");
		return FILE_UPLOADED;
	}

	/**
	 * The method hanldes IllegalFileFormatExcepion.
	 * 
	 * @return
	 */
	@ExceptionHandler(IllegalFileFormatExcepion.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Object handleIllegalFileFormatExcepion() {
		return EXTENTION_EXCEPTION_MESSAGE;
	}

	/**
	 * The method hanldes FileNotFoundException.
	 * 
	 * @return
	 */
	@ExceptionHandler(FileNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Object handleFileNotFoundException() {
		return FILE_NOT_FOUND;
	}

	/**
	 * The method hanldes IOException.
	 * 
	 * @return
	 */
	@ExceptionHandler(IOException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Object handleIOException() {
		return HttpStatus.INTERNAL_SERVER_ERROR.name();
	}
}
