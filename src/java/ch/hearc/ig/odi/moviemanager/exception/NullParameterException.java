package ch.hearc.ig.odi.moviemanager.exception;

public class NullParameterException extends Exception{

	public NullParameterException() {
            super();
	}

	/**
	 * 
	 * @param message
	 */
	public NullParameterException(String message) {
            super(message);
	}

	/**
	 * 
	 * @param message
	 * @param cause
	 */
	public NullParameterException(String message, Throwable cause) {
            super(message, cause);
	}

}