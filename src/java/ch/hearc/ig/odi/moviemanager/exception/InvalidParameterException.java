package ch.hearc.ig.odi.moviemanager.exception;

public class InvalidParameterException extends Exception{

	public InvalidParameterException() {
            super();
	}

	/**
	 * 
	 * @param message
	 */
	public InvalidParameterException(String message) {
            super(message);
	}

	/**
	 * 
	 * @param message
	 * @param cause
	 */
	public InvalidParameterException(String message, Throwable cause) {
            super(message, cause);
	}

}