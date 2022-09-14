package dto;

import java.time.LocalDateTime;
import java.util.Random;

public class Account {
	private String accountId;
	private String id;
	private Long balance;
	private Long accountClassId;
	private LocalDateTime openDate;
	
	public Account(String id, Long accountClassId) {
		this.id = id;
		this.accountClassId = accountClassId;
	}

	public String getAccountId() {
		return accountId;
	}
	
	public String getId() {
		return id;
	}
	
	public Long getBalance() {
		return balance;
	}
	
	public Long getAccountClassId() {
		return accountClassId;
	}
	
	public LocalDateTime getOpenDate() {
		return openDate;
	}
	
	public void createAccountId() {
		StringBuffer buffer = new StringBuffer();
		Random random = new Random();
		for(int i = 0; i <= 3; i++) {
			buffer.append(random.nextInt(9));
		}
		this.accountId = buffer.toString();
	}
	
	public void createOpenDate() {
		this.openDate = LocalDateTime.now();
	}
}
