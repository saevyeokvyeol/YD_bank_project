package dto;

public class Account {
	private int accountId;
	private String id;
	private int stateId;
	private Long balance;
	private String openDate;
	private String updateDate;
	
	public Account() {}

	public Account(int accountId, String id, int stateId, Long balance, String openDate, String updateDate) {
		super();
		this.accountId = accountId;
		this.id = id;
		this.stateId = stateId;
		this.balance = balance;
		this.openDate = openDate;
		this.updateDate = updateDate;
	}

	public int getAccountId() {
		return accountId;
	}

	public String getId() {
		return id;
	}

	public int getStateId() {
		return stateId;
	}

	public Long getBalance() {
		return balance;
	}

	public String getOpenDate() {
		return openDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}
}