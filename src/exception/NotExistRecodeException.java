package exception;

/**
 * DB에 정보가 존재하지 않을 때 발생시킬 익셉션
 * */
public class NotExistRecodeException extends Exception {
	public NotExistRecodeException() {}
	

	public NotExistRecodeException(String message) {
		super(message);
	}
}
