package exception;

/**
 * 로그인하지 않았을 때 발생시킬 익셉션
 * */
public class DoNotLoginException extends Exception {
	public DoNotLoginException() {}
	

	public DoNotLoginException(String message) {
		super(message);
	}
}
