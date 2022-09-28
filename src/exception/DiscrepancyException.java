package exception;

/**
 * 입력받은 정보와 DB에 저장된 정보가 일치하지 않을 때 발생시킬 익셉션
 * */
public class DiscrepancyException extends Exception {
	public DiscrepancyException() {}
	

	public DiscrepancyException(String message) {
		super(message);
	}
}
