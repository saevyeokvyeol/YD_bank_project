package exception;

/**
 * DB에 중복되는 레코드가 있을 때 발생시킬 익셉션
 * */
public class DuplicationException extends Exception {
	public DuplicationException() {}
	
	public DuplicationException(String message) {
		super(message);
	}
}
