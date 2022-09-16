package dto;

import java.util.List;

public class Customer {
	private String id;
	private String password;
	private String name;
	private String tel;
	private String signupDate;
	private String UpdateDate;
	private Long totalBalance;
	
	private Grade grade;
	private List<Account> accounts;
	private List<Transaction> transactions;
	
	public Customer() {}

	public Customer(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public Customer(String id, String password, String name, String tel) {
		this(id, password);
		this.name = name;
		this.tel = tel;
	}

	public Customer(String id, String password, String name, String tel, String signupDate, String updateDate, Long totalBalance) {
		this(id, password, name, tel);
		this.signupDate = signupDate;
		this.UpdateDate = updateDate;
		this.totalBalance = totalBalance;
	}
	
	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}
	
	public String getTel() {
		return tel;
	}

	public String getSignupDate() {
		return signupDate;
	}

	public String getUpdateDate() {
		return UpdateDate;
	}

	public Long getTotalBalance() {
		return totalBalance;
	}
	
	public Grade getGrade() {
		return grade;
	}

	public List<Account> getAccounts() {
		return accounts;
	}
	
	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void changePassword(String password) {
		this.password = password;
	}
}
