package by.grsu.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring boot start class.
 * @author dimav
 *
 */

@SpringBootApplication
public class Application {

	/**
	 * The method that runs application.
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
	
}
