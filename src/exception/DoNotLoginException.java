package exception;

public class DoNotLoginException extends Exception {
	public DoNotLoginException() {}
	

	public DoNotLoginException(String message) {
		super(message);
	}
}
