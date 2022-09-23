package dto;

public class Transaction {
	private Long transactionId;
	private String id;
	private int depositAccountId;
	private int withdrawAccountId;
	private int transactionClassId;
	private Long transactionAmount;
	private String transactionDate;
	
	private Customer customer;
	
	public Transaction() {}

	public Transaction(int depositAccountId, int withdrawAccountId, int transactionClassId, Long transactionAmount) {
		super();
		this.depositAccountId = depositAccountId;
		this.withdrawAccountId = withdrawAccountId;
		this.transactionClassId = transactionClassId;
		this.transactionAmount = transactionAmount;
	}

	public Transaction(Long transactionId, int depositAccountId, int withdrawAccountId, int transactionClassId,
			Long transactionAmount, String transactionDate) {
		this(depositAccountId, withdrawAccountId, transactionClassId, transactionAmount);
		this.transactionId = transactionId;
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
