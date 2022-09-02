package dto;

public class Customer {
	private String id;
	private String password;
	private String name;
	private int accountNumber;
	
	public Customer() {}

	public Customer(String id, String password, String name) {
		this.id = id;
		this.password = password;
		this.name = name;
	}

	public Customer(String id, String password, String name, int accountNumber) {
		this(id, password, name);
		this.accountNumber = accountNumber;
	}
}
