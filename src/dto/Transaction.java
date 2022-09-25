package dto;

public class Transaction {
	private Long transactionId;
	private String id;
	private Integer depositAccountId;
	private Integer withdrawAccountId;
	private int transactionClassId;
	private Long transactionAmount;
	private String transactionDate;
	
	private Customer customer;
	
	public Transaction() {}

	public Transaction(Integer depositAccountId, Integer withdrawAccountId, int transactionClassId, Long transactionAmount) {
		this.depositAccountId = depositAccountId;
		this.withdrawAccountId = withdrawAccountId;
		this.transactionClassId = transactionClassId;
		this.transactionAmount = transactionAmount;
	}

	public Transaction(Long transactionId, String id, Integer depositAccountId, Integer withdrawAccountId,
			int transactionClassId, Long transactionAmount, String transactionDate) {
		this(depositAccountId, withdrawAccountId, transactionClassId, transactionAmount);
		this.transactionId = transactionId;
		this.id = id;
		this.transactionDate = transactionDate;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public String getId() {
		return id;
	}

	public int getDepositAccountId() {
		return depositAccountId;
	}

	public int getWithdrawAccountId() {
		return withdrawAccountId;
	}

	public int getTransactionClassId() {
		return transactionClassId;
	}

	public Long getTransactionAmount() {
		return transactionAmount;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
