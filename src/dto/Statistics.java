package dto;

public class Statistics {
	public Customer customer;
	public Long value;
	
	public Statistics() {}

	public Statistics(Customer customer, Long value) {
		super();
		this.customer = customer;
		this.value = value;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Long getValue() {
		return value;
	}
}
