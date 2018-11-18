package by.grsu.edu.exceptions;

/**
 * The subclass of the class Exception. The class is checked that file has illegal
 * format that was expected.
 * 
 * @author dimav
 *
 */
public class IllegalFileFormatExcepion extends Exception {
	private static final long serialVersionUID = 1L;

	public IllegalFileFormatExcepion() {

	}

	public IllegalFileFormatExcepion(String arg0) {
		super(arg0);
	}

	public IllegalFileFormatExcepion(Throwable arg0) {
		super(arg0);
	}

	public IllegalFileFormatExcepion(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public IllegalFileFormatExcepion(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
