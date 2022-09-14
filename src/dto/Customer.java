package dto;

import java.time.LocalDateTime;
import java.util.List;

public class Customer {
	private String id;
	private String password;
	private String name;
	private LocalDateTime signupDate;
	private LocalDateTime UpdateDate;
	
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

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public List<Account> getAccounts() {
		return accounts;
	}
	
	public void changePassword(String password) {
		this.password = password;
	}
}
