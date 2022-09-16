package dto;

import java.util.List;

public class Customer {
	private String id;
	private String password;
	private String name;
	private String signupDate;
	private String UpdateDate;
	private Long totalBalance;
	
	private List<Account> accounts;
	
	public Customer() {}

	public Customer(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public Customer(String id, String password, String name) {
		this(id, password);
		this.name = name;
	}
	
	

	public Customer(String id, String password, String name, String signupDate, String updateDate, Long totalBalance) {
		this(id, password, name);
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

	public String getSignupDate() {
		return signupDate;
	}

	public String getUpdateDate() {
		return UpdateDate;
	}

	public Long getTotalBalance() {
		return totalBalance;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void changePassword(String password) {
		this.password = password;
	}
}
